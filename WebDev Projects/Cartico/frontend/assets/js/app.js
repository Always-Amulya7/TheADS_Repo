// Cartico - Main JavaScript Application
// Handles authentication, cart, products, and checkout

const API_BASE_URL = '/api';

// ==================== AUTHENTICATION ====================

const auth = {
  token: localStorage.getItem('cartico_token'),
  user: JSON.parse(localStorage.getItem('cartico_user') || 'null'),

  isLoggedIn() {
    return !!this.token;
  },

  getUser() {
    return this.user;
  },

  async login(email, password) {
    try {
      const response = await fetch(`${API_BASE_URL}/auth/login`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
      });
      const data = await response.json();
      if (response.ok && data.success) {
        // Handle different response structures
        const token = data.data?.accessToken || data.token;
        const userData = data.data?.user || data.user;
        
        this.token = token;
        this.user = userData;
        localStorage.setItem('cartico_token', token);
        localStorage.setItem('cartico_user', JSON.stringify(userData));
        this.updateUI();
        return { success: true };
      }
      return { success: false, message: data.message || 'Login failed' };
    } catch (error) {
      return { success: false, message: 'Network error' };
    }
  },

  async register(name, email, password, role = 'customer', businessName = '', businessDescription = '') {
    try {
      const response = await fetch(`${API_BASE_URL}/auth/register`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ 
          name, 
          email, 
          password, 
          role,
          businessName,
          businessDescription
        })
      });
      const data = await response.json();
      if (response.ok && data.success) {
        // Handle different response structures
        const token = data.data?.accessToken || data.token;
        const userData = data.data?.user || data.user;
        const message = data.message || 'Registration successful';
        
        this.token = token;
        this.user = userData;
        localStorage.setItem('cartico_token', token);
        localStorage.setItem('cartico_user', JSON.stringify(userData));
        this.updateUI();
        return { success: true, message };
      }
      return { success: false, message: data.message || 'Registration failed' };
    } catch (error) {
      return { success: false, message: 'Network error' };
    }
  },

  logout() {
    this.token = null;
    this.user = null;
    localStorage.removeItem('cartico_token');
    localStorage.removeItem('cartico_user');
    cart.clear();
    this.updateUI();
    window.location.href = '/';
  },

  updateUI() {
    const userBtn = document.getElementById('loginBtn');
    const userNameDisplay = document.getElementById('userNameDisplay');
    const mobileLoginBtn = document.getElementById('mobileLoginBtn');
    
    if (this.isLoggedIn()) {
      if (userBtn) {
        userBtn.innerHTML = `<ion-icon name="person"></ion-icon>`;
        if (userNameDisplay) {
          userNameDisplay.textContent = this.user.name.split(' ')[0];
        }
      }
      if (mobileLoginBtn) {
        mobileLoginBtn.innerHTML = `<ion-icon name="person"></ion-icon>`;
      }
    } else {
      if (userBtn) {
        userBtn.innerHTML = `<ion-icon name="person-outline"></ion-icon>`;
        if (userNameDisplay) userNameDisplay.textContent = '';
      }
      if (mobileLoginBtn) {
        mobileLoginBtn.innerHTML = `<ion-icon name="person-outline"></ion-icon>`;
      }
    }
  },

  async getProfile() {
    try {
      const response = await fetch(`${API_BASE_URL}/auth/profile`, {
        headers: { 'Authorization': `Bearer ${this.token}` }
      });
      return await response.json();
    } catch (error) {
      return null;
    }
  }
};

// ==================== SHOPPING CART ====================

const cart = {
  items: [],
  totalPrice: 0,
  itemsPrice: 0,
  shippingPrice: 0,
  taxPrice: 0,

  async load() {
    if (!auth.isLoggedIn()) return;
    
    try {
      const response = await fetch(`${API_BASE_URL}/users/cart`, {
        headers: { 'Authorization': `Bearer ${auth.token}` }
      });
      const result = await response.json();
      // Handle { success: true, data: { items: [...] } } response
      const data = result.data || result;
      this.items = data.items || [];
      this.totalPrice = data.totalPrice || 0;
      this.itemsPrice = data.itemsPrice || 0;
      this.shippingPrice = data.shippingPrice || 0;
      this.taxPrice = data.taxPrice || 0;
      this.updateUI();
    } catch (error) {
      console.error('Error loading cart:', error);
    }
  },

  async addItem(product, quantity = 1) {
    if (!auth.isLoggedIn()) {
      showModal('loginModal');
      return;
    }

    try {
      const response = await fetch(`${API_BASE_URL}/cart/add`, {
        method: 'POST',
        headers: { 
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${auth.token}`
        },
        body: JSON.stringify({
          productId: product._id,
          quantity
        })
      });
      const result = await response.json();
      // Handle { success: true, data: { items: [...] } } response
      const data = result.data || result;
      this.items = data.items || [];
      this.totalPrice = data.totalPrice || 0;
      this.itemsPrice = data.itemsPrice || 0;
      this.shippingPrice = data.shippingPrice || 0;
      this.taxPrice = data.taxPrice || 0;
      this.updateUI();
      showToast(`${product.name} added to cart!`);
      updateCartCount();
    } catch (error) {
      console.error('Error adding to cart:', error);
    }
  },

  async updateQuantity(productId, quantity, color = null, size = null) {
    try {
      const response = await fetch(`${API_BASE_URL}/cart/item`, {
        method: 'PUT',
        headers: { 
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${auth.token}`
        },
        body: JSON.stringify({ productId, quantity, color, size })
      });
      const result = await response.json();
      const data = result.data || result;
      this.items = data.items || [];
      this.totalPrice = data.totalPrice || 0;
      this.itemsPrice = data.itemsPrice || 0;
      this.shippingPrice = data.shippingPrice || 0;
      this.taxPrice = data.taxPrice || 0;
      this.updateUI();
    } catch (error) {
      console.error('Error updating cart:', error);
    }
  },

  async removeItem(productId, color = null, size = null) {
    try {
      const response = await fetch(`${API_BASE_URL}/cart/item/${productId}?color=${color || ''}&size=${size || ''}`, {
        method: 'DELETE',
        headers: { 'Authorization': `Bearer ${auth.token}` }
      });
      const result = await response.json();
      const data = result.data || result;
      this.items = data.items || [];
      this.totalPrice = data.totalPrice || 0;
      this.itemsPrice = data.itemsPrice || 0;
      this.shippingPrice = data.shippingPrice || 0;
      this.taxPrice = data.taxPrice || 0;
      this.updateUI();
    } catch (error) {
      console.error('Error removing from cart:', error);
    }
  },

  async clear() {
    if (!auth.isLoggedIn()) {
      this.items = [];
      this.totalPrice = 0;
      this.updateUI();
      return;
    }
    
    try {
      await fetch(`${API_BASE_URL}/cart/clear`, {
        method: 'DELETE',
        headers: { 'Authorization': `Bearer ${auth.token}` }
      });
      this.items = [];
      this.totalPrice = 0;
      this.updateUI();
    } catch (error) {
      console.error('Error clearing cart:', error);
    }
  },

  getCount() {
    return this.items.reduce((sum, item) => sum + item.quantity, 0);
  },

  updateUI() {
    const cartCount = document.querySelectorAll('.header-user-actions .action-btn .count');
    const count = this.getCount();
    cartCount.forEach(el => el.textContent = count);
    
    // Update cart badge visibility
    cartCount.forEach(el => {
      el.style.display = count > 0 ? 'block' : 'none';
    });
  }
};

// ==================== PRODUCTS ====================

const products = {
  async loadFeatured() {
    try {
      const response = await fetch(`${API_BASE_URL}/products/featured`);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error loading products:', error);
      return [];
    }
  },

  async loadAll(query = {}) {
    try {
      const params = new URLSearchParams(query);
      const response = await fetch(`${API_BASE_URL}/products?${params}`);
      const data = await response.json();
      return data;
    } catch (error) {
      console.error('Error loading products:', error);
      return { products: [], totalPages: 0 };
    }
  },

  async getById(id) {
    try {
      const response = await fetch(`${API_BASE_URL}/products/${id}`);
      return await response.json();
    } catch (error) {
      console.error('Error loading product:', error);
      return null;
    }
  }
};

// ==================== ORDERS ====================

const orders = {
  async create(shippingAddress, paymentMethod) {
    try {
      const response = await fetch(`${API_BASE_URL}/orders`, {
        method: 'POST',
        headers: { 
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${auth.token}`
        },
        body: JSON.stringify({ shippingAddress, paymentMethod })
      });
      const data = await response.json();
      if (response.ok) {
        return { success: true, order: data };
      }
      return { success: false, message: data.message };
    } catch (error) {
      return { success: false, message: 'Network error' };
    }
  },

  async getMyOrders() {
    try {
      const response = await fetch(`${API_BASE_URL}/orders/my-orders`, {
        headers: { 'Authorization': `Bearer ${auth.token}` }
      });
      return await response.json();
    } catch (error) {
      return [];
    }
  }
};

// ==================== UI HELPERS ====================

function showModal(modalId) {
  const modal = document.getElementById(modalId);
  const overlay = document.querySelector('.overlay');
  
  if (modal) {
    // Hide all other modals first
    document.querySelectorAll('.modal.active').forEach(m => m.classList.remove('active'));
    
    modal.classList.add('active');
    document.body.style.overflow = 'hidden';
  }
  if (overlay) {
    overlay.classList.add('active');
  }
}

function hideModal(modalId) {
  const modal = document.getElementById(modalId);
  const overlay = document.querySelector('.overlay');
  
  if (modal) {
    modal.classList.remove('active');
  }
  
  const activeModals = document.querySelectorAll('.modal.active');
  if (activeModals.length === 0) {
    if (overlay) overlay.classList.remove('active');
    document.body.style.overflow = 'auto';
  }
}

// Guard to prevent duplicate concurrent toasts
let lastToastMessage = '';
let lastToastTime = 0;

function showToast(message, type = 'success') {
  const now = Date.now();
  // Prevent same message within 2 seconds
  if (message === lastToastMessage && now - lastToastTime < 2000) {
    return;
  }
  
  lastToastMessage = message;
  lastToastTime = now;

  // Remove any existing dynamic toasts first
  document.querySelectorAll('.notification-toast.dynamic-toast').forEach(t => t.remove());
  
  const toast = document.createElement('div');
  toast.className = `notification-toast dynamic-toast ${type}`;
  toast.innerHTML = `
    <button class="toast-close-btn" onclick="this.parentElement.remove()">
      <ion-icon name="close-outline"></ion-icon>
    </button>
    <div class="toast-icon">
      <ion-icon name="${type === 'success' ? 'checkmark-circle' : type === 'error' ? 'alert-circle' : 'information-circle'}"></ion-icon>
    </div>
    <div class="toast-detail">
      <p class="toast-message">${message}</p>
    </div>
  `;
  document.body.appendChild(toast);
  
  // Trigger animation
  setTimeout(() => toast.classList.add('show'), 10);
  
  // Auto remove after 4 seconds
  setTimeout(() => {
    toast.classList.remove('show');
    setTimeout(() => toast.remove(), 400);
  }, 4000);
}

function switchAuthTab(tabName) {
  const tabs = document.querySelectorAll('.auth-tab');
  const forms = document.querySelectorAll('.auth-form');
  
  tabs.forEach(tab => {
    tab.classList.remove('active');
    if (tab.dataset.tab === tabName) {
      tab.classList.add('active');
    }
  });
  
  forms.forEach(form => {
    form.classList.remove('active');
    if (form.id === tabName + 'Form') {
      form.classList.add('active');
    }
  });
}

// Show loading on button
function setButtonLoading(button, isLoading) {
  if (isLoading) {
    button.classList.add('loading');
    button.disabled = true;
  } else {
    button.classList.remove('loading');
    button.disabled = false;
  }
}

// ==================== CHECKOUT ====================

async function proceedToCheckout() {
  if (!auth.isLoggedIn()) {
    showModal('loginModal');
    return;
  }

  if (cart.items.length === 0) {
    showToast('Your cart is empty!');
    return;
  }

  // Redirect to checkout page
  window.location.href = '/checkout.html';
}

// ==================== PRODUCT MANAGEMENT ====================

// ==================== CATEGORIES ====================

// Load categories from API and update homepage
async function loadCategoriesFromAPI() {
  try {
    // Use tree endpoint for hierarchical categories
    const response = await fetch(`${API_BASE_URL}/categories/tree`);
    if (!response.ok) return;
    
    const data = await response.json();
    if (!data.data || data.data.length === 0) return;
    
    const categories = data.data;
    
    // Update top category bar
    const categoryItemContainer = document.querySelector('.category-item-container');
    if (categoryItemContainer) {
      const categoryItems = categoryItemContainer.querySelectorAll('.category-item');
      
      categories.forEach((category, index) => {
        if (index >= categoryItems.length) return;
        
        const item = categoryItems[index];
        const title = item.querySelector('.category-item-title');
        const count = item.querySelector('.category-item-amount');
        const btn = item.querySelector('.category-btn');
        
        if (title) title.textContent = category.name;
        if (count) count.textContent = `(${category.productCount || 0})`;
        if (btn) btn.href = `/products.html?category=${category.slug}`;
        
        // Update icon based on category
        const img = item.querySelector('.category-img-box img');
        if (img && category.icon) {
          img.src = category.icon;
        }
      });
    }
    
    // Update sidebar categories
    updateSidebarCategories(categories);
    
    console.log('Categories loaded from API:', categories.length);
  } catch (error) {
    console.error('Error loading categories:', error);
  }
}

// Update sidebar category list
function updateSidebarCategories(categories) {
  const sidebarCategoryList = document.querySelector('.sidebar-menu-category-list');
  if (!sidebarCategoryList) return;
  
  // Build sidebar HTML dynamically
  let html = '';
  categories.slice(0, 8).forEach(category => {
    html += `
      <li class="sidebar-menu-category">
        <button class="accordion-menu" data-accordion-btn>
          <p class="menu-title">${category.name}</p>
          <div>
            <ion-icon name="add-outline" class="add-icon"></ion-icon>
            <ion-icon name="remove-outline" class="remove-icon"></ion-icon>
          </div>
        </button>
        <div class="sidebar-submenu-category-list" data-accordion>
          ${category.subcategories ? category.subcategories.map(sub => `
            <li class="sidebar-submenu-category">
              <a href="/products.html?category=${category.slug}&subcategory=${sub.slug}" class="sidebar-submenu-title">
                <p class="product-name">${sub.name}</p>
                <data value="${sub.productCount || 0}" class="stock" title="Available Stock">${sub.productCount || 0}</data>
              </a>
            </li>
          `).join('') : ''}
        </div>
      </li>
    `;
  });
  
  sidebarCategoryList.innerHTML = html;
}

// Make functions globally available
window.loadCategoriesFromAPI = loadCategoriesFromAPI;

// ==================== MOBILE NAVIGATION ====================

function setupMobileNavigation() {
  // Mobile bottom navigation buttons
  const mobileBottomBtns = document.querySelectorAll('.mobile-bottom-navigation .action-btn');
  
  mobileBottomBtns.forEach((btn, index) => {
    btn.addEventListener('click', () => {
      const icon = btn.querySelector('ion-icon');
      if (!icon) return;
      
      const iconName = icon.getAttribute('name');
      
      switch (iconName) {
        case 'menu-outline':
          // Open mobile menu
          const mobileMenu = document.querySelector('[data-mobile-menu]');
          const overlay = document.querySelector('.overlay');
          if (mobileMenu) {
            mobileMenu.classList.add('active');
            if (overlay) overlay.classList.add('active');
          }
          break;
        case 'bag-handle-outline':
          if (auth.isLoggedIn()) {
            window.location.href = '/cart.html';
          } else {
            showModal('loginModal');
          }
          break;
        case 'home-outline':
          window.location.href = '/';
          break;
        case 'heart-outline':
          if (auth.isLoggedIn()) {
            window.location.href = '/wishlist.html';
          } else {
            showModal('loginModal');
          }
          break;
        case 'grid-outline':
          // Open mobile menu
          const menu = document.querySelector('[data-mobile-menu]');
          const ov = document.querySelector('.overlay');
          if (menu) {
            menu.classList.add('active');
            if (ov) ov.classList.add('active');
          }
          break;
      }
    });
  });
}

// ==================== CART COUNT ====================

function updateCartCount() {
  // Get all cart count elements
  const cartCounts = document.querySelectorAll('.action-btn ion-icon[name="bag-handle-outline"] ~ .count, .mobile-bottom-navigation .action-btn ion-icon[name="bag-handle-outline"] ~ .count');
  
  if (cartCounts.length === 0) return;
  
  if (!auth.isLoggedIn()) {
    cartCounts.forEach(count => count.textContent = '0');
    return;
  }
  
  fetch(`${API_BASE_URL}/cart`, {
    headers: { 'Authorization': `Bearer ${auth.token}` }
  })
    .then(res => res.json())
    .then(data => {
      const items = data.data?.items || data.items || [];
      const count = items.reduce((sum, item) => sum + item.quantity, 0);
      cartCounts.forEach(c => c.textContent = count.toString());
    })
    .catch(() => {
      cartCounts.forEach(c => c.textContent = '0');
    });
}

// ==================== WISHLIST COUNT ====================

function updateWishlistCount() {
  const wishlistCounts = document.querySelectorAll('.action-btn ion-icon[name="heart-outline"] ~ .count, .mobile-bottom-navigation .action-btn ion-icon[name="heart-outline"] ~ .count');
  
  if (wishlistCounts.length === 0) return;
  
  if (!auth.isLoggedIn()) {
    wishlistCounts.forEach(count => count.textContent = '0');
    return;
  }
  
  fetch(`${API_BASE_URL}/wishlist`, {
    headers: { 'Authorization': `Bearer ${auth.token}` }
  })
    .then(res => res.json())
    .then(data => {
      const items = data.data || [];
      wishlistCounts.forEach(c => c.textContent = items.length.toString());
    })
    .catch(() => {
      wishlistCounts.forEach(c => c.textContent = '0');
    });
}

// Make these functions globally available
window.updateCartCount = updateCartCount;
window.updateWishlistCount = updateWishlistCount;
window.setupMobileNavigation = setupMobileNavigation;
window.showModal = showModal;
window.hideModal = hideModal;
window.switchAuthTab = switchAuthTab;
window.showToast = showToast;

// Load products from API and update homepage showcases
async function loadProductsFromAPI() {
  try {
    const response = await fetch(`${API_BASE_URL}/products`);
    if (!response.ok) return;
    
    const data = await response.json();
    if (!data.data || !data.data.products || data.data.products.length === 0) return;
    
    const products = data.data.products;
    
    // Find the product grid container
    const productGrid = document.querySelector('.product-grid');
    if (!productGrid) return;
    
    // Find showcase banners and replace them with dynamic products
    const showcaseBanners = productGrid.querySelectorAll('.showcase-banner');
    
    // Update first few showcases with real products
    let productIndex = 0;
    showcaseBanners.forEach((banner, index) => {
      if (productIndex >= products.length) {
        productIndex = 0; // Loop products
      }
      
      const product = products[productIndex];
      const price = product.price || 0;
      const originalPrice = product.originalPrice || price * 1.2;
      const discount = Math.round((1 - price / originalPrice) * 100);
      let image = product.images && product.images[0] ? product.images[0].url : './assets/images/products/1.jpg';
      
      // FALLBACK MAPPING for standard products
      const imageMapping = {
        "Mens Winter Leathers Jackets": "./assets/images/products/jacket-3.jpg",
        "Pure Garment Dyed Cotton Shirt": "./assets/images/products/shirt-1.jpg",
        "MEN Yarn Fleece Full-Zip Jacket": "./assets/images/products/jacket-5.jpg",
        "Black Floral Wrap Midi Skirt": "./assets/images/products/clothes-3.jpg",
        "Casual Denim Shirt": "./assets/images/products/shirt-1.jpg",
        "Premium Wireless Headphones": "./assets/images/products/watch-1.jpg", // placeholder
        "Classic Men's Watch": "./assets/images/products/watch-1.jpg",
        "Running Shoes Pro": "./assets/images/products/shoe-1.jpg",
        "Designer Women's Dress": "./assets/images/products/clothes-1.jpg",
        "Leather Jacket": "./assets/images/products/jacket-1.jpg",
        "Rose Gold Earrings": "./assets/images/products/jewellery-1.jpg",
        "Luxury Perfume": "./assets/images/products/perfume.jpg"
      };

      if (imageMapping[product.name]) {
        image = imageMapping[product.name];
      } else if (image && !image.startsWith('http') && !image.startsWith('.')) {
        if (image.startsWith('uploads/')) {
          image = '/' + image;
        } else if (!image.startsWith('/')) {
          image = './assets/images/products/' + image;
        }
      }
      
      // Create product HTML
      banner.innerHTML = `
        <a href="#" class="showcase-img-box" onclick="event.preventDefault(); productModal.show(${JSON.stringify(product).replace(/"/g, '&quot;')})">
          <img src="${image}" alt="${product.name}" width="300" class="showcase-img">
        </a>
        <div class="showcase-content">
          <a href="#" class="showcase-category">${product.category || 'Product'}</a>
          <a href="#">
            <h3 class="showcase-title">${product.name}</h3>
          </a>
          <div class="showcase-rating">
            <ion-icon name="star"></ion-icon>
            <ion-icon name="star"></ion-icon>
            <ion-icon name="star"></ion-icon>
            <ion-icon name="star-outline"></ion-icon>
            <ion-icon name="star-outline"></ion-icon>
          </div>
          <div class="price-box">
            <p class="price">${price.toFixed(2)}</p>
            <del>${originalPrice.toFixed(2)}</del>
          </div>
          <button class="btn btn-primary" onclick='addToCartFromAPI("${product._id}")'>Add to Cart</button>
        </div>
      `;
      
      productIndex++;
    });
    
    console.log('Products loaded from API:', products.length);
  } catch (error) {
    console.error('Error loading products:', error);
  }
}

// Add to cart from API
async function addToCartFromAPI(productId) {
  if (!auth.isLoggedIn()) {
    showModal('loginModal');
    return;
  }
  
  try {
    const response = await fetch(`${API_BASE_URL}/cart/add`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${auth.token}`
      },
      body: JSON.stringify({
        productId: productId,
        quantity: 1
      })
    });
    
    if (response.ok) {
      showToast('Product added to cart!', 'success');
      updateCartCount();
      cart.load();
    } else {
      const data = await response.json();
      showToast(data.message || 'Error adding to cart', 'error');
    }
  } catch (error) {
    console.error('Error:', error);
    showToast('Error adding to cart', 'error');
  }
}

// Make functions globally available
window.addToCartFromAPI = addToCartFromAPI;
window.loadProductsFromAPI = loadProductsFromAPI;

// ==================== PRODUCT MODAL ====================

const productModal = {
  show(product) {
    if (!product) return;
    
    // Create modal if not exists
    let modal = document.getElementById('productModal');
    if (!modal) {
      modal = document.createElement('div');
      modal.id = 'productModal';
      modal.className = 'modal product-modal';
      document.body.appendChild(modal);
    }
    
    const image = product.images && product.images[0] ? product.images[0].url : './assets/images/products/1.jpg';
    const price = product.price || 0;
    const originalPrice = product.originalPrice || price * 1.2;
    const discount = Math.round((1 - price / originalPrice) * 100);
    
    modal.innerHTML = `
      <div class="modal-close-overlay" onclick="productModal.close()"></div>
      <div class="modal-content product-modal-content">
        <button class="modal-close-btn" onclick="productModal.close()">
          <ion-icon name="close-outline"></ion-icon>
        </button>
        <div class="product-modal-grid">
          <div class="product-modal-image">
            <img src="${image}" alt="${product.name}" width="400" height="400">
          </div>
          <div class="product-modal-details">
            <span class="product-category">${product.category?.name || 'Product'}</span>
            <h2 class="product-title">${product.name}</h2>
            <div class="product-rating">
              <ion-icon name="star"></ion-icon>
              <ion-icon name="star"></ion-icon>
              <ion-icon name="star"></ion-icon>
              <ion-icon name="star"></ion-icon>
              <ion-icon name="star-outline"></ion-icon>
            </div>
            <div class="product-price-box">
              <p class="price">${formatPrice(price)}</p>
              ${originalPrice > price ? `<del>${formatPrice(originalPrice)}</del><span class="discount">-${discount}%</span>` : ''}
            </div>
            <p class="product-description">${product.description || product.shortDescription || 'No description available.'}</p>
            <div class="product-stock">
              <span>Stock: </span>
              <span class="${product.stock > 0 ? 'in-stock' : 'out-of-stock'}">${product.stock > 0 ? product.stock + ' available' : 'Out of stock'}</span>
            </div>
            ${product.stock > 0 ? `
            <div class="product-actions">
              <button class="btn-add-cart" onclick="productModal.addToCart('${product._id}')">
                <ion-icon name="bag-add-outline"></ion-icon> Add to Cart
              </button>
            </div>
            ` : ''}
          </div>
        </div>
      </div>
    `;
    
    modal.classList.add('active');
    document.body.style.overflow = 'hidden';
    
    // Add overlay
    const overlay = document.querySelector('.overlay');
    if (overlay) overlay.classList.add('active');
  },
  
  close() {
    const modal = document.getElementById('productModal');
    if (modal) modal.classList.remove('active');
    document.body.style.overflow = 'auto';
    
    const overlay = document.querySelector('.overlay');
    if (overlay) overlay.classList.remove('active');
  },
  
  async addToCart(productId) {
    await addToCartFromAPI(productId);
    this.close();
  }
};

window.productModal = productModal;

// ==================== INITIALIZATION ====================

// Show toast notification on page load (after a slight delay)
function showWelcomeNotification() {
  // Check if user has visited before (using session storage)
  const hasVisited = sessionStorage.getItem('cartico_visited');
  
  if (!hasVisited) {
    // First visit - show welcome notification
    setTimeout(() => {
      showToast('Welcome to Cartico! 🎉 Find amazing deals on our products.', 'success');
      sessionStorage.setItem('cartico_visited', 'true');
    }, 1500);
  }
}

let isAppInitialized = false;

document.addEventListener('DOMContentLoaded', () => {
  if (isAppInitialized) return;
  isAppInitialized = true;

  console.log('Cartico App Initializing...');
  
  // Show welcome notification on first page load
  if (!sessionStorage.getItem('cartico_visited')) {
    showWelcomeNotification();
  }
  
  // Load products from API
  loadProductsFromAPI();
  
  // Load categories from API
  loadCategoriesFromAPI();
  
  // Update auth UI
  auth.updateUI();

  // Setup mobile bottom navigation
  setupMobileNavigation();

  // Update cart count display
  updateCartCount();

  // Update wishlist count display
  updateWishlistCount();
  
  // Load cart if logged in
  if (auth.isLoggedIn()) {
    cart.load();
  }

  // Login form handler
  const loginForm = document.getElementById('loginForm');
  if (loginForm) {
    loginForm.addEventListener('submit', async (e) => {
      e.preventDefault();
      const email = document.getElementById('loginEmail').value;
      const password = document.getElementById('loginPassword').value;
      const btn = loginForm.querySelector('.btn-auth');
      
      setButtonLoading(btn, true);
      const result = await auth.login(email, password);
      setButtonLoading(btn, false);
      
      if (result.success) {
        hideModal('loginModal');
        showToast(`Welcome back, ${auth.user.name}!`);
        cart.load();
      } else {
        console.error('Login failed:', result.message);
        alert('Login Failed: ' + result.message);
        showToast(result.message, 'error');
        // Provide visual feedback in modal
        const desc = loginForm.querySelector('.auth-desc');
        if (desc) {
          desc.textContent = result.message;
          desc.style.color = 'var(--bittersweet)';
        }
      }
    });
  }

  // Register form - show/hide business name based on role
  const registerRole = document.getElementById('registerRole');
  const businessNameField = document.getElementById('businessNameField');
  if (registerRole && businessNameField) {
    registerRole.addEventListener('change', () => {
      if (registerRole.value === 'seller') {
        businessNameField.style.display = 'block';
      } else {
        businessNameField.style.display = 'none';
      }
    });
  }

  // Register form handler
  const registerForm = document.getElementById('registerForm');
  if (registerForm) {
    registerForm.addEventListener('submit', async (e) => {
      e.preventDefault();
      const name = document.getElementById('registerName').value;
      const email = document.getElementById('registerEmail').value;
      const password = document.getElementById('registerPassword').value;
      const role = document.getElementById('registerRole')?.value || 'customer';
      const businessName = document.getElementById('businessName')?.value;
      const businessDescription = document.getElementById('businessDescription')?.value;
      const btn = registerForm.querySelector('.btn-auth');
      
      setButtonLoading(btn, true);
      const result = await auth.register(name, email, password, role, businessName, businessDescription);
      setButtonLoading(btn, false);
      
      if (result.success) {
        hideModal('loginModal');
        // Show appropriate message based on role and verification status
        if (role === 'seller') {
          showToast('Your seller account is pending approval by admin. You can login once verified.', 'success');
        } else {
          showToast(`Welcome to Cartico, ${auth.user.name}!`, 'success');
        }
        cart.load();
      } else {
        showToast(result.message, 'error');
      }
    });
  }

  // Search button handler
  const searchBtn = document.querySelector('.search-btn');
  const searchField = document.querySelector('.search-field');
  if (searchBtn && searchField) {
    searchBtn.addEventListener('click', () => {
      const query = searchField.value.trim();
      if (query) {
        window.location.href = `/products.html?search=${encodeURIComponent(query)}`;
      }
    });
    searchField.addEventListener('keypress', (e) => {
      if (e.key === 'Enter') {
        const query = searchField.value.trim();
        if (query) {
          window.location.href = `/products.html?search=${encodeURIComponent(query)}`;
        }
      }
    });
  }

  // Wishlist button handler
  const wishlistBtn = document.querySelector('[name="heart-outline"]')?.closest('.action-btn');
  if (wishlistBtn) {
    wishlistBtn.addEventListener('click', () => {
      if (auth.isLoggedIn()) {
        window.location.href = '/wishlist.html';
      } else {
        showModal('loginModal');
      }
    });
  }

    // Logo handler - go to home
  const logoLink = document.querySelector('.header-logo');
  if (logoLink) {
    logoLink.addEventListener('click', (e) => {
      e.preventDefault();
      window.location.href = '/';
    });
  }

  // Home link handler
  const homeLink = document.querySelector('.menu-title');
  if (homeLink && homeLink.textContent.trim() === 'Home') {
    homeLink.addEventListener('click', (e) => {
      e.preventDefault();
      window.location.href = '/';
    });
  }

  // Cart button handler
  const cartBtn = document.querySelector('[name="bag-handle-outline"]')?.closest('.action-btn');
  if (cartBtn) {
    cartBtn.addEventListener('click', () => {
      if (auth.isLoggedIn()) {
        window.location.href = '/cart.html';
      } else {
        showModal('loginModal');
      }
    });
  }

  // Person icon for login - make sure it's clickable
  const personBtn = document.querySelector('.header-user-actions .action-btn');
  if (personBtn) {
    personBtn.addEventListener('click', () => {
      if (!auth.isLoggedIn()) {
        showModal('loginModal');
      }
    });
  }

  // Also add handler for mobile person button
  const mobilePersonBtn = document.querySelector('.mobile-bottom-navigation .action-btn:first-child');
  if (mobilePersonBtn) {
    mobilePersonBtn.addEventListener('click', () => {
      if (!auth.isLoggedIn()) {
        showModal('loginModal');
      }
    });
  }

  // Modal close handlers
  document.querySelectorAll('[data-modal-close]').forEach(btn => {
    btn.addEventListener('click', () => {
      const modal = btn.closest('.modal');
      if (modal) {
        modal.classList.remove('active');
        const overlay = document.querySelector('.overlay');
        if (overlay) overlay.classList.remove('active');
        document.body.style.overflow = 'auto';
      }
    });
  });

  document.querySelectorAll('.modal-close-overlay').forEach(overlay => {
    overlay.addEventListener('click', () => {
      const modal = overlay.closest('.modal');
      if (modal) {
        modal.classList.remove('active');
        overlay.classList.remove('active');
        const globalOverlay = document.querySelector('.overlay');
        if (globalOverlay) globalOverlay.classList.remove('active');
        document.body.style.overflow = 'auto';
      }
    });
  });
});
