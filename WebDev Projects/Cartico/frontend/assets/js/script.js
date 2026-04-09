"use strict";

// modal variables
const modal = document.querySelectorAll("[data-modal]");
const modalCloseBtn = document.querySelectorAll("[data-modal-close]");
const modalCloseOverlay = document.querySelectorAll("[data-modal-overlay]");

// modal function
const modalCloseFunc = function () {
  modal.forEach(m => m.classList.remove("active"));
  const overlay = document.querySelector(".overlay");
  if (overlay) overlay.classList.remove("active");
  document.body.style.overflow = "auto";
};

// modal eventListener
modalCloseOverlay.forEach(overlay => {
  overlay.addEventListener("click", modalCloseFunc);
});
modalCloseBtn.forEach(btn => {
  btn.addEventListener("click", modalCloseFunc);
});

// notification toast variables
const notificationToast = document.querySelector("[data-toast]");
const toastCloseBtn = document.querySelector("[data-toast-close]");

// notification toast eventListener
if (toastCloseBtn && notificationToast) {
  toastCloseBtn.addEventListener("click", function () {
    notificationToast.classList.add("closed");
  });
}

// mobile menu variables
const mobileMenuOpenBtn = document.querySelectorAll(
  "[data-mobile-menu-open-btn]"
);
const mobileMenu = document.querySelectorAll("[data-mobile-menu]");
const mobileMenuCloseBtn = document.querySelectorAll(
  "[data-mobile-menu-close-btn]"
);
const overlay = document.querySelector("[data-overlay]");

// mobile menu functions
const mobileMenuCloseFunc = function () {
  mobileMenu.forEach(menu => menu.classList.remove("active"));
  overlay.classList.remove("active");
};

// Open menu logic
for (let i = 0; i < mobileMenuOpenBtn.length; i++) {
  mobileMenuOpenBtn[i].addEventListener("click", function () {
    // If there's a corresponding menu, open it. If not, just open the first one.
    const menuToOpen = mobileMenu[i] || mobileMenu[0];
    if (menuToOpen) {
      menuToOpen.classList.add("active");
      overlay.classList.add("active");
    }
  });
}

// Close menu logic
for (let i = 0; i < mobileMenuCloseBtn.length; i++) {
  mobileMenuCloseBtn[i].addEventListener("click", mobileMenuCloseFunc);
}

// Overlay click to close
if (overlay) {
  overlay.addEventListener("click", mobileMenuCloseFunc);
}

// accordion variables
const accordionBtn = document.querySelectorAll("[data-accordion-btn]");
const accordion = document.querySelectorAll("[data-accordion]");

for (let i = 0; i < accordionBtn.length; i++) {
  accordionBtn[i].addEventListener("click", function () {
    const clickedBtn = this.nextElementSibling.classList.contains("active");

    for (let j = 0; j < accordion.length; j++) {
      if (clickedBtn) break;

      if (accordion[j].classList.contains("active")) {
        accordion[j].classList.remove("active");
        accordionBtn[j].classList.remove("active");
      }
    }

    this.nextElementSibling.classList.toggle("active");
    this.classList.toggle("active");
  });
}
