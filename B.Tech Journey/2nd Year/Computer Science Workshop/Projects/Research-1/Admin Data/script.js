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

const Creation=document.getElementById("Creation");

document.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    event.preventDefault();
    Creation.click();
  }
});
