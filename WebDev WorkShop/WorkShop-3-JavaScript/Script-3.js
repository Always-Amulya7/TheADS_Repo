if (localStorage.getItem("Name"))
{
    let a=localStorage.getItem("Name")
    document.write("Welcome "+a)
}
else
{
    let a=prompt("Enter The Name")
    localStorage.setItem("Name",a)
    document.write("Welcome "+a)
}
/* console.log("Hello World") */

/* if (localStorage.getItem("Name")) {
  let a = localStorage.getItem("Name");
  let welcomeMessage = document.createElement("span");
  welcomeMessage.textContent = "Welcome " + a;
  welcomeMessage.style.color = "green";
  document.body.appendChild(welcomeMessage);
} else {
  let a = prompt("Enter The Name");
  localStorage.setItem("Name", a);
  let welcomeMessage = document.createElement("span");
  welcomeMessage.textContent = "Welcome " + a;
  welcomeMessage.style.color = "green";
  document.body.appendChild(welcomeMessage);
} */