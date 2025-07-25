let equationChart = null;
let dataChart = null;
let lastEncrypted = "";
let lastDecrypted = "";
window.onload = () => {
  setTimeout(() => {
    drawDemoEquationGraph();
    drawDemoDataGraph();
  }, 100);
};
document.addEventListener("DOMContentLoaded", function () {
  const fileInput = document.querySelector(".file-input");
  const uploadText = document.querySelector(".upload-instruction");
  fileInput.addEventListener("change", function () {
    if (fileInput.files.length > 0) {
      uploadText.textContent = "Upload Successful";
      uploadText.style.color = "green";
    } else {
      uploadText.textContent = "Click To Browse Or Drag Files Here To Start Sharing";
      uploadText.style.color = "#555";
    }
  });
});
function caesarCipher(text, shift) {
  return text.split("").map((char) => {
    const code = char.charCodeAt(0);
    if (code >= 65 && code <= 90) {
      return String.fromCharCode(((((code - 65 + shift) % 26) + 26) % 26) + 65);
    } else if (code >= 97 && code <= 122) {
      return String.fromCharCode(((((code - 97 + shift) % 26) + 26) % 26) + 97);
    }
    return char;
  }).join("");
}

function strToUint8(str) {
  return new TextEncoder().encode(str);
}

function uint8ToStr(uint8) {
  return new TextDecoder().decode(uint8);
}
function base64Encode(buffer) {
  return btoa(String.fromCharCode(...new Uint8Array(buffer)));
}
function base64Decode(base64) {
  return Uint8Array.from(atob(base64), (c) => c.charCodeAt(0));
}
async function vigenereCipher(text, key, encrypt = true) {
  const iv = crypto.getRandomValues(new Uint8Array(12));
  const cryptoKey = await crypto.subtle.importKey(
    "raw",
    strToUint8(key.padEnd(32, "0").slice(0, 32)),
    { name: "AES-GCM" },
    false,
    [encrypt ? "encrypt" : "decrypt"]
  );
  if (encrypt) {
    const encrypted = await crypto.subtle.encrypt(
      { name: "AES-GCM", iv },
      cryptoKey,
      strToUint8(text)
    );
    return `${base64Encode(iv)}:${base64Encode(encrypted)}`;
  } else {
    const [ivBase64, encryptedBase64] = text.split(":");
    if (!ivBase64 || !encryptedBase64) {
      alert("Invalid encrypted format. Must be IV:Data.");
      return "";
    }
    const decrypted = await crypto.subtle.decrypt(
      { name: "AES-GCM", iv: base64Decode(ivBase64) },
      cryptoKey,
      base64Decode(encryptedBase64)
    );
    return uint8ToStr(decrypted);
  }
}
function xorCipher(text, key) {
  const result = text.split("").map((char, i) => {
    const keyChar = key.charCodeAt(i % key.length);
    return String.fromCharCode(char.charCodeAt(0) ^ keyChar);
  }).join("");
  return btoa(result);
}
function xorDecipher(base64Text, key) {
  const decoded = atob(base64Text);
  return decoded.split("").map((char, i) => {
    const keyChar = key.charCodeAt(i % key.length);
    return String.fromCharCode(char.charCodeAt(0) ^ keyChar);
  }).join("");
}
document.getElementById("Work").addEventListener("click", async () => {
  const fileInput = document.querySelector(".file-input");
  const action = document.getElementById("File").value;
  const method = document.getElementById("method-select").value;
  const key = document.getElementById("key-input").value.trim();
  if (!fileInput.files.length) return alert("Please Select A .txt File.");
  if (!key) return alert("Please Enter A Key.");
  const file = fileInput.files[0];
  if (file.type !== "text/plain") return alert("Only .txt Files Are Supported.");
  const reader = new FileReader();
  reader.onload = async function (e) {
    const textContent = e.target.result;
    let output = "";
    if (action === "Encrypt") {
      if (method === "caesar") output = caesarCipher(textContent, parseInt(key) || 3);
      else if (method === "vigenere") output = await vigenereCipher(textContent, key, true);
      else if (method === "xor") output = xorCipher(textContent, key);
    } else if (action === "Decrypt") {
      if (method === "caesar") output = caesarCipher(textContent, -(parseInt(key) || 3));
      else if (method === "vigenere") output = await vigenereCipher(textContent, key, false);
      else if (method === "xor") output = xorDecipher(textContent, key);
    } else {
      return alert("Invalid action.");
    }
    const blob = new Blob([output], { type: "text/plain" });
    const link = document.createElement("a");
    link.href = URL.createObjectURL(blob);
    const prefix = action === "Encrypt" ? "Encrypted_" : "Decrypted_";
    link.download = prefix + file.name;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  };
  reader.readAsText(file);
});
async function encryptText() {
  const text = document.getElementById("encrypt-text").value;
  const key = document.getElementById("encrypt-key").value;
  const method = document.getElementById("encrypt-method").value;
  let result = "";
  if (!text || !key) return alert("Please Provide Both Text And Key.");
  if (method === "caesar") result = caesarCipher(text, parseInt(key) || 3);
  else if (method === "vigenere") result = await vigenereCipher(text, key, true);
  else if (method === "xor") result = xorCipher(text, key);
  lastEncrypted = result;
  document.getElementById("encrypt-result").innerHTML = `
    <span>Encrypted Click -></span>
    <span class="info-icon" onclick="showPopup('encrypt')">ℹ️</span>
  `;
}
async function decryptText() {
  const text = document.getElementById("decrypt-text").value;
  const key = document.getElementById("decrypt-key").value;
  const method = document.getElementById("decrypt-method").value;
  let result = "";
  if (!text || !key) return alert("Please Provide Both Text And Key.");
  if (method === "caesar") result = caesarCipher(text, -(parseInt(key) || 3));
  else if (method === "vigenere") result = await vigenereCipher(text, key, false);
  else if (method === "xor") result = xorDecipher(text, key);
  lastDecrypted = result;
  document.getElementById("decrypt-result").innerHTML = `
    <span>Decrypted Click -></span>
    <span class="info-icon" onclick="showPopup('decrypt')">ℹ️</span>
  `;
}
function showPopup(type) {
  const message = type === "encrypt" ? lastEncrypted : lastDecrypted;
  const label = type === "encrypt" ? "Encrypted Message:" : "Decrypted Message:";
  document.getElementById("popup-text").textContent = `${label}\n${message}`;
  document.getElementById("popup").style.display = "flex";
}
function closePopup() {
  document.getElementById("popup").style.display = "none";
}
function evaluateExpression(expression, xValue) {
  const sanitizedExpression = expression
    .replace(/Math\.PI/g, Math.PI)
    .replace(/Math\.E/g, Math.E)
    .replace(/\b(sin|cos|tan|log|exp|sqrt|abs|floor|ceil|round)\b/g, "Math.$1")
    .replace(/[^-()\d/*+x.**\s.Mathpow]/g, "");

  try {
    const exprWithPow = sanitizedExpression.replace(/(\([^)]+\)|[a-zA-Z0-9.]+)\s*\^\s*([a-zA-Z0-9.]+)/g, "Math.pow($1,$2)");
    const func = new Function("x", `return ${exprWithPow.replace(/\bx\b/g, `(${xValue})`)};`);
    return func(xValue);
  } catch (e) {
    console.error("Expression evaluation error:", e);
    return NaN;
  }
}
function plotEquation() {
  const equationInput = document.getElementById("equation-input").value.trim();
  const rangeInput = document.getElementById("x-range").value.trim();
  if (!equationInput) return alert("Please Enter An Equation.");
  if (!rangeInput.includes(",")) return alert("Enter Range Like: -10,10");
  const [xMin, xMax] = rangeInput.split(",").map(Number);
  if (isNaN(xMin) || isNaN(xMax) || xMin >= xMax)
    return alert("Invalid Range: Use Format Min,Max Where Min < Max");
  const labels = [], data = [];
  const numPoints = 200;
  const step = (xMax - xMin) / (numPoints - 1);
  let hasError = false;
  for (let i = 0; i < numPoints; i++) {
    const x = xMin + i * step;
    const y = evaluateExpression(equationInput, x);
    labels.push(x.toFixed(2));
    data.push(Number.isFinite(y) ? y : null);
  }
  if (equationChart) equationChart.destroy();
  const ctx = document.getElementById("equation-chart").getContext("2d");
  equationChart = new Chart(ctx, {
    type: "line",
    data: {
      labels,
      datasets: [{
        label: `y = ${equationInput}`,
        data,
        borderColor: "blue",
        borderWidth: 2,
        tension: 0.1,
        pointRadius: 0,
        spanGaps: true
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: false,
      scales: {
        x: { title: { display: true, text: "x" } },
        y: { title: { display: true, text: "y" } }
      },
      plugins: {
        tooltip: { mode: "index", intersect: false }
      }
    }
  });
}
function plotData() {
  const dataInput = document.getElementById("data-input").value;
  const graphType = document.getElementById("graph-type").value;
  const points = dataInput.trim().split("\n").map((line) => {
    const [x, y] = line.split(",").map(Number);
    return { x, y };
  }).filter((p) => !isNaN(p.x) && !isNaN(p.y));
  if (!points.length) return alert("Invalid Data Points. Enter x,y pairs per line.");
  if (dataChart) dataChart.destroy();
  const ctx = document.getElementById("data-chart").getContext("2d");
  dataChart = new Chart(ctx, {
    type: graphType,
    data: {
      datasets: [{
        label: "Data Points",
        data: points,
        borderColor: "coral",
        backgroundColor: "rgba(255, 99, 132, 0.5)",
        showLine: graphType === "line",
        pointRadius: graphType === "scatter" ? 3 : 0,
        parsing: { xAxisKey: "x", yAxisKey: "y" },
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: false,
      scales: {
        x: {
          type: graphType === "scatter" || graphType === "line" ? "linear" : "category",
          title: { display: true, text: "x" }
        },
        y: { title: { display: true, text: "y" } }
      },
      plugins: {
        tooltip: { mode: "index", intersect: false }
      }
    }
  });
}
function drawDemoEquationGraph() {
  const ctx = document.getElementById("equation-chart").getContext("2d");
  if (equationChart) equationChart.destroy();
  const labels = Array.from({ length: 21 }, (_, i) => (i - 10).toFixed(2));
  const data = Array.from({ length: 21 }, (_, i) => evaluateExpression("x^2 + 2", i - 10));
  equationChart = new Chart(ctx, {
    type: "line",
    data: {
      labels,
      datasets: [{
        label: "Graph - x^2 + 2",
        data,
        borderColor: "blue",
        borderWidth: 2,
        tension: 0.1,
        pointRadius: 0,
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: false,
      scales: {
        x: { title: { display: true, text: "x" } },
        y: { title: { display: true, text: "y" } }
      }
    }
  });
}
function drawDemoDataGraph() {
  const ctx = document.getElementById("data-chart").getContext("2d");
  if (dataChart) dataChart.destroy();
  dataChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: ["A", "B", "C", "D"],
      datasets: [{
        label: "Demo Bars",
        data: [12, 19, 3, 5],
        backgroundColor: "rgba(255, 159, 64, 0.6)",
        borderColor: "rgba(255, 159, 64, 1)",
        borderWidth: 1
      }]
    },
    options: {
      responsive: true,
      maintainAspectRatio: false,
      scales: {
        x: { title: { display: true, text: "Category" } },
        y: { beginAtZero: true, title: { display: true, text: "Value" } }
      }
    }
  });
}
