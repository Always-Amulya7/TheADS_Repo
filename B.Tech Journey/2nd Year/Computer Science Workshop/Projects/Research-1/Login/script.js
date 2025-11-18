//Integrated With MongoDB
const loginButton = document.getElementById("MyHold");
loginButton.addEventListener("click", async (event) => {
  event.preventDefault();

  const usernameInput = document
    .querySelector("input[type='text'][placeholder='User Name']")
    .value.trim();
  const passwordInput = document
    .querySelector("input[type='password'][placeholder='Password']")
    .value.trim();

  if (usernameInput && passwordInput) {
    try {
      const response = await fetch("/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          username: usernameInput,
          password: passwordInput,
        }),
      });

      const data = await response.json();

      if (response.ok) {
        alert(data.message || "Login Successful");
        window.location.href = "/Connectivity/index.html";
      } else {
        alert(data.error || "Invalid Username Or Password");
      }
    } catch (error) {
      console.error("Error During Login:", error);
      alert("An Error Occurred Try Again Later");
    }
  } else {
    alert("Please Enter Both Username And Password");
  }
});
const myHold = document.getElementById("MyHold");
document.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    event.preventDefault();
    myHold.click();
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

// const usernameInput = document.querySelector(
//   "input[type='text'][placeholder='User Name']"
// );
// const passwordInput = document.querySelector(
//   "input[type='password'][placeholder='Password']"
// );
// const button = document.getElementById("MyHold");

// button.addEventListener("click", () => {
//   const username = usernameInput.value.trim().toLowerCase();
//   const password = passwordInput.value.trim();

//   // Retrieve user data from localStorage
//   const storedData = localStorage.getItem("userData");
//   let userData = {};

//   if (storedData) {
//     userData = JSON.parse(storedData);
//   }

//   // Check if the entered credentials match the stored ones
//   if (username === userData.username.toLowerCase() && password === userData.password) {
//     alert("Login Successful");
//     localStorage.setItem("loggedInUsername", userData.username); // Store the logged-in username
//     window.location.href = "/Connectivity/index.html";
//   } else {
//     alert("Invalid username or password.");
//     window.location.href = "/Login/index.html";
//   }
// });
