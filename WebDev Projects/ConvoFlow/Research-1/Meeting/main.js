const APP_ID = "Your Token Id";
const TOKEN ="Your Token";
const CHANNEL = "Auto Talk Meeting";
const API_URL = "http://localhost:5000/api/participants";






















const client = AgoraRTC.createClient({ mode: "rtc", codec: "vp8" });
let localTracks = [null, null];
let remoteUsers = {};
let userName = "";
let roomNumber = "";
let UID = "";

window.onload = async () => {
  alert(
    "Information - To Maintain Privacy You Are Required To Enter A Random (But Relevant) Name For Entry In The Meeting - Amulya Shrivastava (Developer)"
  );
  userName = prompt("Enter Your Room Name");
  roomNumber = prompt("Enter The Room Number");

  if (userName && roomNumber === "ADS10") {
    UID = await client.join(APP_ID, CHANNEL, TOKEN, null);
    await saveParticipantToDatabase(userName, roomNumber, UID);
    await joinStream();
    displayConnectionDetails();
    window.addEventListener("beforeunload", removeParticipantFromDatabase);
  } else {
    document.body.style.display = "none";
    alert("Room Not Available");
  }
};

async function saveParticipantToDatabase(name, roomNumber, uid) {
  try {
    const response = await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, roomNumber, uid }),
    });

    if (!response.ok) {
      const errorData = await response.json();
      throw new Error(errorData.error || "Failed To Save Participant");
    }

    console.log("Participant Information Saved Successfully");
  } catch (error) {
    console.error("Error Saving Participant:", error);
  }
}

async function fetchUserNameFromDatabase(uid) {
  try {
    const response = await fetch(
      `http://localhost:5000/api/participant/${uid}`
    );
    if (!response.ok) return `User ${uid}`;
    const data = await response.json();
    return data.name;
  } catch (error) {
    console.error("Error Fetching User Name:", error);
    return `User ${uid}`;
  }
}

async function removeParticipantFromDatabase() {
  try {
    await fetch(`http://localhost:5000/api/participants/${UID}`, {
      method: "DELETE",
    });
    console.log("Participant Removed Successfully");
  } catch (error) {
    console.error("Error Removing Participant:", error);
  }
}

async function joinStream() {
  client.on("user-published", handleUserJoined);
  client.on("user-left", handleUserLeft);

  localTracks = await AgoraRTC.createMicrophoneAndCameraTracks();
  const player = `<div class="video-container" id="user-container-${UID}">
                        <div class="video-player" id="user-${UID}"></div>
                        <div class="user-name">${userName}</div>
                    </div>`;
  document.getElementById("Video-Grid").insertAdjacentHTML("beforeend", player);
  localTracks[1].play(`user-${UID}`);
  await client.publish(localTracks);
}

const processedUsers = new Set();

async function handleUserJoined(user, mediaType) {
  remoteUsers[user.uid] = user;
  await client.subscribe(user, mediaType);

  const userName = await fetchUserNameFromDatabase(user.uid);

  if (mediaType === "video") {
    if (!document.getElementById(`user-container-${user.uid}`)) {
      const player = `<div class="video-container" id="user-container-${user.uid}">
                                <div class="video-player" id="user-${user.uid}"></div>
                                <div class="user-name">${userName}</div>
                            </div>`;
      document
        .getElementById("Video-Grid")
        .insertAdjacentHTML("beforeend", player);
      user.videoTrack.play(`user-${user.uid}`);
    }
  }

  if (mediaType === "audio") {
    user.audioTrack.play();
  }

  if (!processedUsers.has(user.uid)) {
    processedUsers.add(user.uid);
    updateChatBox(`${userName} Has Joined The Room.`);
  }
}

function handleUserLeft(user) {
  const userName = remoteUsers[user.uid]?.name || `User ${user.uid}`;
  delete remoteUsers[user.uid];
  document.getElementById(`user-container-${user.uid}`).remove();
}

function displayConnectionDetails() {
  const chatDisplay = document.getElementById("chat-display");
  const userDetails = `<p><strong>Welcome, ${userName}</strong></p>
                         <p>Room Number: ${roomNumber}</p>`;
  chatDisplay.innerHTML = userDetails + chatDisplay.innerHTML;
}

function updateChatBox(message) {
  const chatDisplay = document.getElementById("chat-display");
  const messageElement = document.createElement("div");
  messageElement.textContent = message;
  chatDisplay.appendChild(messageElement);
}

document.getElementById("send-chat").addEventListener("click", sendMessage);
document.getElementById("chat-input").addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    sendMessage();
  }
});

function sendMessage() {
  const message = document.getElementById("chat-input").value;
  if (message) {
    updateChatBox(`${userName}: ${message}`);
    document.getElementById("chat-input").value = "";
  }
}

document.getElementById("Quit").addEventListener("click", async () => {
  await removeParticipantFromDatabase();
  if (localTracks[0]) localTracks[0].stop();
  if (localTracks[1]) localTracks[1].stop();
  await client.leave();
  window.document.body.style.display = "none";
  document.getElementById("Controls").style.display = "none";
  document.getElementById("Video-Grid").innerHTML = "";
  alert("You Have Left The Room.");
});

document.getElementById("Speak").addEventListener("click", toggleMic);
document.getElementById("Video").addEventListener("click", toggleCamera);

async function toggleMic(e) {
  if (localTracks[0]) {
    if (localTracks[0].enabled) {
      await localTracks[0].setEnabled(false);
      e.target.innerText = "Mic Off";
    } else {
      await localTracks[0].setEnabled(true);
      e.target.innerText = "Mic On";
    }
  }
}

async function toggleCamera(e) {
  if (localTracks[1]) {
    if (localTracks[1].enabled) {
      await localTracks[1].setEnabled(false);
      e.target.innerText = "Camera Off";
    } else {
      await localTracks[1].setEnabled(true);
      e.target.innerText = "Camera On";
    }
  }
}

document.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    event.preventDefault();
    myHold1.click();
  }
});
document.addEventListener("contextmenu", function (e) {
  e.preventDefault();
});
document.addEventListener("keydown", function (e) {
  if (e.key === "F12") {
    e.preventDefault();
  }
});
history.pushState(null, null, location.href);
window.addEventListener("popstate", function () {
  history.pushState(null, null, location.href);
});
window.history.forward();

window.onunload = function () {
  null;
};
