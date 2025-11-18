const API_URL = "http://localhost:10745/api/participants";
const participantsList = document.getElementById("participants-list");
const toggleVideoButton = document.getElementById("toggle-video");
const toggleVoiceButton = document.getElementById("toggle-voice");

let globalVideoState = true;
let globalVoiceState = true;

async function fetchParticipants() {
  try {
    const response = await fetch(API_URL);
    if (!response.ok) throw new Error("Failed to fetch participants");
    const participants = await response.json();

    if (!Array.isArray(participants)) throw new Error("Unexpected data format");
    renderParticipants(participants);
  } catch (error) {
    console.error("Error fetching participants:", error.message);
  }
}

function renderParticipants(participants) {
  participantsList.innerHTML = "";

  if (participants.length === 0) {
    participantsList.innerHTML =
      "<tr><td colspan='4'>No Participants Found</td></tr>";
    return;
  }

  participants.forEach((participant) => {
    const row = document.createElement("tr");

    row.innerHTML = `
            <td>${participant.name || "N/A"}</td>
            <td>${participant.roomNumber || "N/A"}</td>
            <td>${participant.uid || "N/A"}</td>
            <td>
                <button class="kick" onclick="kickParticipant('${
                  participant.uid
                }')">Kick</button>
                <button class="block" onclick="blockParticipant('${
                  participant.uid
                }')">Block</button>
            </td>
        `;

    participantsList.appendChild(row);
  });
}

toggleVideoButton.addEventListener("click", async () => {
  globalVideoState = !globalVideoState;
  alert(
    globalVideoState
      ? "Video Enabled for All Participants"
      : "Video Disabled for All Participants"
  );

  try {
    await fetch(`${API_URL}/control`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ videoEnabled: globalVideoState }),
    });
  } catch (error) {
    console.error("Error toggling video:", error);
  }
});

toggleVoiceButton.addEventListener("click", async () => {
  globalVoiceState = !globalVoiceState;
  alert(
    globalVoiceState
      ? "Microphone Enabled for All Participants"
      : "Microphone Disabled for All Participants"
  );

  try {
    await fetch(`${API_URL}/control`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ audioEnabled: globalVoiceState }),
    });
  } catch (error) {
    console.error("Error toggling voice:", error);
  }
});

async function kickParticipant(uid) {
  try {
    const response = await fetch(`${API_URL}/${uid}`, { method: "DELETE" });
    if (response.ok) {
      alert("Participant Kicked Successfully");
      fetchParticipants();
    } else {
      alert("Error Kicking Participant");
    }
  } catch (error) {
    console.error("Error kicking participant:", error.message);
  }
}

async function blockParticipant(uid) {
  try {
    const response = await fetch(`${API_URL}/block/${uid}`, { method: "PUT" });
    if (response.ok) {
      alert("Participant Blocked Successfully");
      fetchParticipants();
    } else {
      alert("Error Blocking Participant");
    }
  } catch (error) {
    console.error("Error blocking participant:", error.message);
  }
}

fetchParticipants();

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
