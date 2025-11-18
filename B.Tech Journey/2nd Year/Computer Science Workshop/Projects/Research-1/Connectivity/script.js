//Integrating MongoDB

document.getElementById("connectButton").addEventListener("click", function () {
  window.location.href = "/public/Instruct.html";
});

document.getElementById("joinButton").addEventListener("click", function () {
  window.location.href = "http://localhost:5000";
});

const webCamElement = document.getElementById("webCam");
const canvasElement = document.getElementById("canvas");

webCamElement.width = 800;
webCamElement.height = 800;

if (navigator.mediaDevices.getUserMedia) {
  navigator.mediaDevices
    .getUserMedia({ video: true })
    .then((stream) => {
      webCamElement.srcObject = stream;
    })
    .catch((error) => {
      console.error("Error Accessing Webcam", error);
    });
} else {
  console.error("GetUserMedia Is Not Supported In This Browser");
}

const userNameInput = document.getElementById("userNameInput");

fetch("/get-username", {
  method: "GET",
  credentials: "same-origin",
})
  .then((response) => {
    if (!response.ok) {
      throw new Error("User Not Logged In");
    }
    return response.json();
  })
  .then((data) => {
    if (data.username) {
      userNameInput.placeholder = data.username;
      console.log("Logged In Username:", data.username);
    } else {
      userNameInput.placeholder = "Your Decent Name";
    }
  })
  .catch((error) => {
    console.error("Error Fetching Username:", error);
    userNameInput.placeholder = "Your Decent Name";
  });

const joinButton = document.getElementById("joinButton");
joinButton.disabled = false;

const voiceCheckCanvas = document.getElementById("voiceCheckCanvas");
const voiceCheckCtx = voiceCheckCanvas.getContext("2d");

voiceCheckCanvas.width = 300;
voiceCheckCanvas.height = 40;

navigator.mediaDevices
  .getUserMedia({ audio: true })
  .then((stream) => {
    const audioContext = new AudioContext();
    const source = audioContext.createMediaStreamSource(stream);
    const analyser = audioContext.createAnalyser();
    source.connect(analyser);

    const dataArray = new Uint8Array(analyser.frequencyBinCount);

    function update() {
      analyser.getByteTimeDomainData(dataArray);

      voiceCheckCtx.clearRect(
        0,
        0,
        voiceCheckCanvas.width,
        voiceCheckCanvas.height
      );

      const barWidth = voiceCheckCanvas.width / dataArray.length;

      for (let i = 0; i < dataArray.length; i++) {
        const barHeight = (dataArray[i] * voiceCheckCanvas.height) / 255;
        voiceCheckCtx.fillStyle = `hsl(${
          (i * 360) / dataArray.length
        }, 100%, 50%)`;
        voiceCheckCtx.fillRect(
          i * barWidth,
          voiceCheckCanvas.height - barHeight,
          barWidth,
          barHeight
        );
      }

      requestAnimationFrame(update);
    }

    update();
  })
  .catch((error) => {
    console.error("Error Accessing Microphone:", error);
  });

const Hold = document.getElementById("joinButton");
document.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    event.preventDefault();
    Hold.click();
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
window.addEventListener('popstate', function () {
  history.pushState(null, null, location.href);
});
window.history.forward();

window.onunload = function () {
    null;
};

//Using Local Cache

// document.getElementById("connectButton").addEventListener("click", function () {
//   window.location.href = "/public/Instruct.html";
// });

// document.getElementById("joinButton").addEventListener("click", function () {
//   window.location.href = "http://10.140.3.82:5000";
// });

// // Set up webcam and canvas
// const webCamElement = document.getElementById("webCam");
// const canvasElement = document.getElementById("canvas");

// // Set the width and height of the webcam video
// webCamElement.width = 800; // Set the desired width
// webCamElement.height = 800; // Set the desired height

// // Check if the browser supports the getUserMedia API
// if (navigator.mediaDevices.getUserMedia) {
//   navigator.mediaDevices
//     .getUserMedia({ video: true })
//     .then((stream) => {
//       webCamElement.srcObject = stream;
//     })
//     .catch((error) => {
//       console.error("Error accessing webcam:", error);
//     });
// } else {
//   console.error("getUserMedia is not supported in this browser.");
// }

// // Set the logged-in username in the placeholder
// const userNameInput = document.getElementById("userNameInput");
// const loggedInUsername = localStorage.getItem("loggedInUsername") || "Your Decent Name";
// userNameInput.placeholder = loggedInUsername;

// // Enable the join button
// const joinButton = document.getElementById("joinButton");
// joinButton.disabled = false;

// // Audio visualizer for the microphone input
// const constraints = { audio: true };
// navigator.mediaDevices
//   .getUserMedia(constraints)
//   .then((stream) => {
//     const audioContext = new AudioContext();
//     const source = audioContext.createMediaStreamSource(stream);
//     const analyser = audioContext.createAnalyser();
//     source.connect(analyser);

//     const microphone = document.createElement("audio");
//     microphone.srcObject = stream;
//     microphone.autoplay = true;
//     microphone.muted = true; // Mute the audio to avoid feedback
//     document.body.appendChild(microphone);

//     const canvas = document.createElement("canvas");
//     canvas.width = 150; // Adjust canvas width as needed
//     canvas.height = 20; // Adjust canvas height as desired
//     const ctx = canvas.getContext("2d");
//     document.body.appendChild(canvas);
//     canvas.style.position = "relative";
//     canvas.style.top = "-18.3vw";
//     canvas.style.left = "69vw";
//     canvas.style.width = "16%";
//     canvas.style.maxWidth = "260px"; // Use maxWidth for better responsiveness
//     canvas.style.height = "45px";

//     const FPS = 30; // Adjust for desired update frequency
//     function update() {
//       const dataArray = new Uint8Array(analyser.frequencyBinCount);
//       analyser.getByteTimeDomainData(dataArray);

//       ctx.clearRect(0, 0, canvas.width, canvas.height);
//       const barWidth = canvas.width / dataArray.length;

//       for (let i = 0; i < dataArray.length; i++) {
//         const barHeight = (dataArray[i] * canvas.height) / 255;
//         ctx.fillStyle = "hsl(" + (i * 360) / dataArray.length + ", 100%, 50%)";
//         ctx.fillRect(
//           i * barWidth,
//           canvas.height - barHeight,
//           barWidth,
//           barHeight
//         );
//       }

//       requestAnimationFrame(update);
//     }

//     update();
//   })
//   .catch((error) => {
//     console.error("Error accessing microphone:", error);
//   });

// // Redirect to instruction page
// document.getElementById("connectButton").addEventListener("click", function () {
//   window.location.href = "/public/Instruct.html";
// });
