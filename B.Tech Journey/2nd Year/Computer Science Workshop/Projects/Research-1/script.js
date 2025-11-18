//Integrating MongoDB

const signupForm = document.getElementById("signupForm");
const myHold1 = document.getElementById("MyHold1");
signupForm.addEventListener("submit", async (event) => {
  event.preventDefault();

  const username = document.getElementById("username").value.trim();
  const password = document.getElementById("password").value.trim();

  if (username && password) {
    const response = await fetch("/signup", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    });

    const data = await response.json();
    if (response.ok) {
      alert(data.message);
      window.location.href = "/Login/index.html";
    } else {
      alert(data.error || "Error Signing Up");
    }
  } else {
    alert("Please Enter Both Username And Password");
  }
});
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
window.addEventListener('popstate', function () {
  history.pushState(null, null, location.href);
});
window.history.forward();

window.onunload = function () {
    null;
};

//Using Local Cache

// const signupForm = document.getElementById("signupForm");
// signupForm.addEventListener("submit", (event) => {
//   event.preventDefault(); // Prevents the default form submission
//   const username = document.getElementById("username").value.trim();
//   const password = document.getElementById("password").value.trim();

//   if (username !== "" && password !== "") {
//     const userData = {
//       username,
//       password,
//     };
//     // Store the user data in localStorage
//     localStorage.setItem("userData", JSON.stringify(userData));

//     // Store username separately for quick access
//     localStorage.setItem("loggedInUsername", username);

//     // Redirect to the login page
//     window.location.href = "/Login/index.html";
//   } else {
//     alert("Please Enter Both Username And Password.");
//   }
// });

//Experiment-1

// const signupForm = document.getElementById('signupForm');

// signupForm.addEventListener('submit', async (event) => {
//   event.preventDefault(); // Prevent default form submission

//   const username = document.getElementById('username').value.trim();
//   const password = document.getElementById('password').value.trim();

//   if (username && password) {
//     try {
//       const response = await fetch('/signup', {
//         method: 'POST',
//         headers: { 'Content-Type': 'application/json' },
//         body: JSON.stringify({ username, password }),
//       });

//       const result = await response.json();

//       if (response.ok) {
//         alert(result.message);
//         window.location.href = '/Login/index.html'; // Redirect to login
//       } else {
//         alert(result.message); // Show error message
//       }
//     } catch (error) {
//       alert('Error submitting the form. Please try again later.');
//     }
//   } else {
//     alert('Please enter both username and password.');
//   }
// });
