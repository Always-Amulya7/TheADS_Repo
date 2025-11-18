function Open() {
  window.location.href = "/cart.html";
}

function redirect() {
  window.open(
    "https://a-d-s-datasource.hashnode.dev/project-craveo-why-an-alternative",
    "_blank"
  );
}

const menuBtn = document.getElementById("menu-btn");
const navLinks = document.getElementById("nav-links");
const menuBtnIcon = menuBtn?.querySelector("i");

if (menuBtn && navLinks && menuBtnIcon) {
  menuBtn.addEventListener("click", () => {
    navLinks.classList.toggle("open");
    const isOpen = navLinks.classList.contains("open");
    menuBtnIcon.setAttribute("class", isOpen ? "ri-close-line" : "ri-menu-line");
  });

  navLinks.addEventListener("click", () => {
    navLinks.classList.remove("open");
    menuBtnIcon.setAttribute("class", "ri-menu-line");
  });
}

document.addEventListener("DOMContentLoaded", () => {
  const userID = localStorage.getItem("userId");
  if (!userID) {
    return;
  }

  const badge = document.querySelector(".cart-navbar .cart-badge");
  let totalQuantity = 0;

  const updateBadge = () => {
    badge.textContent = totalQuantity || "";
    badge.style.display = totalQuantity ? "inline-block" : "none";
  };

  const fetchUserCartQty = async () => {
    const res = await fetch(`/api/Carts/${userID}`);
    const items = await res.json();
    totalQuantity = items.reduce((acc, item) => acc + item.quantity, 0);
    updateBadge();
  };

  fetchUserCartQty();

  document.querySelectorAll(".add-to-cart-btn").forEach((btn) => {
    btn.addEventListener("click", async () => {
      const card = btn.closest(".food-card");
      const item = {
        image: card.querySelector("img").src,
        name: card.querySelector(".item-name").textContent,
        price: parseInt(card.querySelector(".item-price").textContent),
        quantity: 1,
        userId: userID,
      };
      await fetch("/api/Carts", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(item),
      });
      totalQuantity++;
      updateBadge();
    });
  });
});

document.addEventListener("DOMContentLoaded", () => {
  const userID = "Amulya";
  const badge = document.querySelector(".cart-navbar .cart-badge");
  let totalQuantity = 0;

  const updateBadge = () => {
    badge.textContent = totalQuantity || "";
    badge.style.display = totalQuantity ? "inline-block" : "none";
  };

  const postToCart = async (image, name, price, qty) => {
    const res = await fetch("/api/Carts", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId: userID, image, name, price, quantity: qty }),
    });
    const data = await res.json();
    return data.item._id;
  };

  const updateQuantity = async (id, qty) => {
    if (qty <= 0) {
      await deleteItem(id);
    } else {
      await fetch(`/api/Carts/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ quantity: qty }),
      });
      renderCartItems();
    }
  };

  const deleteItem = async (id) => {
    await fetch(`/api/Carts/${id}`, { method: "DELETE" });
    renderCartItems();
  };

  const clearCart = async () => {
    await fetch(`/api/Carts/clear/${userID}`, { method: "DELETE" });
    renderCartItems();
  };

  // Simulated payment verification trigger
  const verifyPayment = async () => {
    // Simulate verification success
    const success = true;

    if (success) {
      await clearCart();
      alert("Payment verified. Your cart has been cleared.");
      window.location.href = "/success.html"; // Redirect to a thank-you page if needed
    }
  };

  window.verifyPayment = verifyPayment;

  document.querySelectorAll(".special__card").forEach((card) => {
    const btn = card.querySelector(".cart");
    const img = card.querySelector("img").src;
    const nm = card.querySelector("h4").textContent.trim();
    const pr = parseFloat(card.querySelector(".price").textContent.replace("Rs.", "").trim());

    btn.addEventListener("click", async () => {
      btn.style.display = "none";

      const ctrl = document.createElement("div");
      ctrl.className = "quantity-controls";
      const minus = document.createElement("button");
      minus.className = "quantity-btn";
      minus.textContent = "–";
      const qtyDisplay = document.createElement("span");
      qtyDisplay.className = "quantity-number";
      qtyDisplay.textContent = "1";
      const plus = document.createElement("button");
      plus.className = "quantity-btn";
      plus.textContent = "+";

      ctrl.append(minus, qtyDisplay, plus);
      card.querySelector(".special__footer").appendChild(ctrl);

      let qty = 1;
      totalQuantity++;
      updateBadge();

      const itemId = await postToCart(img, nm, pr, qty);

      plus.onclick = async () => {
        qty++;
        qtyDisplay.textContent = qty;
        totalQuantity++;
        updateBadge();
        await updateQuantity(itemId, qty);
      };

      minus.onclick = async () => {
        qty--;
        totalQuantity--;
        if (qty > 0) {
          qtyDisplay.textContent = qty;
          updateBadge();
          await updateQuantity(itemId, qty);
        } else {
          ctrl.remove();
          btn.style.display = "inline-block";
          updateBadge();
          await deleteItem(itemId);
        }
      };
    });
  });

  const renderCartItems = () => {
    fetch(`/api/Carts/${userID}`)
      .then((r) => r.json())
      .then((items) => {
        const container = document.getElementById("cart-items");
        const totalEl = document.getElementById("total");
        container.innerHTML = "";
        totalQuantity = 0;
        let total = 0;

        if (!items.length) {
          container.innerHTML = `
            <div class="empty-cart-card">
              <img src="/assets/Cart Image.png" alt="Empty" />
              <h3>Your Cart Is Empty!</h3>
              <p>Add something tasty!</p>
              <button onclick="window.location.href='index.html'">+</button>
            </div>`;
          totalEl.textContent = "Total - ₹ 0";
          return;
        }

        items.forEach((it) => {
          total += it.price * it.quantity;
          totalQuantity += it.quantity;

          const div = document.createElement("div");
          div.className = "cart-card";
          div.innerHTML = `
            <span class="delete-btn" data-id="${it._id}">×</span>
            <img src="${it.image}" alt="${it.name}">
            <h4>${it.name}</h4>
            <p>Rs. ${it.price}</p>
            <p>Quantity: <span>${it.quantity}</span></p>
            <div class="cart-controls">
              <button class="increase">+</button>
              <button class="decrease">−</button>
            </div>`;
          container.appendChild(div);

          div.querySelector(".delete-btn").onclick = () => deleteItem(it._id);
          div.querySelector(".increase").onclick = () =>
            updateQuantity(it._id, it.quantity + 1);
          div.querySelector(".decrease").onclick = () =>
            updateQuantity(it._id, it.quantity - 1);
        });

        totalEl.textContent = `Total - ₹ ${total}`;
        updateBadge();
      });
  };
  renderCartItems();
  updateBadge();
});

const scrollRevealOption = {
  distance: "50px",
  origin: "bottom",
  duration: 1000,
};

const sr = ScrollReveal();

sr.reveal(".header__image img", {
  ...scrollRevealOption,
  origin: "right",
});
sr.reveal(".header__content h1", {
  ...scrollRevealOption,
  delay: 500,
});
sr.reveal(".header__content .section__description", {
  ...scrollRevealOption,
  delay: 1000,
});
sr.reveal(".header__content .header__btn", {
  ...scrollRevealOption,
  delay: 1500,
});

sr.reveal(".explore__image img", {
  ...scrollRevealOption,
  origin: "left",
});
sr.reveal(".explore__content .section__header", {
  ...scrollRevealOption,
  delay: 500,
});
sr.reveal(".explore__content .section__description", {
  ...scrollRevealOption,
  delay: 1000,
});
sr.reveal(".explore__content .explore__btn", {
  ...scrollRevealOption,
  delay: 1500,
});

sr.reveal(".banner__card", {
  ...scrollRevealOption,
  interval: 500,
});

sr.reveal(".chef__image img", {
  ...scrollRevealOption,
  origin: "right",
});
sr.reveal(".chef__content .section__header", {
  ...scrollRevealOption,
  delay: 500,
});
sr.reveal(".chef__content .section__description", {
  ...scrollRevealOption,
  delay: 1000,
});
sr.reveal(".chef__list li", {
  ...scrollRevealOption,
  delay: 1500,
  interval: 500,
});

const swiper = new Swiper(".swiper", {
  loop: true,
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});

$(document).ready(function () {
  $(".pop").click(function () {
    if ($(".popup-overlay").length === 0) {
      $("body").append('<div class="popup-overlay"></div>');
    }
    $("body > *:not(.DineInForm):not(.popup-overlay)").css("filter", "blur(5px)");
    $(".popup-overlay")
      .css({
        position: "fixed",
        top: 0,
        left: 0,
        width: "100%",
        height: "100%",
        "background-color": "rgba(0,0,0,0.5)",
        "z-index": 999,
      })
      .show();
    $(".DineInForm")
      .css({
        display: "block",
        position: "fixed",
        "z-index": 1000,
        filter: "none",
        background: "white",
        padding: "30px",
        "border-radius": "10px",
        "box-shadow": "0 0 20px rgba(0,0,0,0.3)",
      })
      .fadeIn(300);
  });

  $(document).on("click", ".popup-overlay", function () {
    $("body > *").css("filter", "");
    $(".popup-overlay").remove();
    $(".DineInForm").hide();
  });

  $(document).keyup(function (e) {
    if (e.key === "Escape") {
      $("body > *").css("filter", "");
      $(".popup-overlay").remove();
      $(".DineInForm").hide();
    }
  });
});
