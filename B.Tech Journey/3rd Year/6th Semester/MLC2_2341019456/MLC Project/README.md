# ✍️ Handwritten Digit Recognition using Deep Learning

A Python-based Deep Learning project that recognizes handwritten digits from images using a Convolutional Neural Network (CNN).  

The project supports:

✅ Single digit recognition  
✅ Multiple handwritten digit detection  
✅ Image upload prediction system  
✅ Web application using Flask  
✅ Real-time digit segmentation using OpenCV  

---

# 📌 Project Overview

This project is designed to recognize handwritten numbers from images using Machine Learning and Computer Vision techniques.

The model is trained on the famous MNIST dataset and can predict:
- Single handwritten digits
- Multiple handwritten digits from one image

The project is divided into two phases:

| Phase | Description |
|------|-------------|
| Phase 1 | Python-based digit recognition |
| Phase 2 | Flask web application for image upload and prediction |

---

# 🚀 Features

- Deep Learning based CNN model
- Handwritten digit recognition
- Multi-digit detection support
- OpenCV image preprocessing
- Flask web application
- User-friendly structure
- Easy to extend and deploy

---

# 🛠️ Technologies Used

- Python
- TensorFlow / Keras
- OpenCV
- NumPy
- Flask

---

# 📂 Project Structure

```bash
HandwrittenDigitRecognition/
│
├── Model/
│   └── Digit_Model.keras
│
├── Static/
│   └── Uploads/
│
├── Templates/
│   └── index.html
│
├── venv/
│
├── Model.ipynb
├── README.md
└── Requirements.txt
```

# 🧠 How the Project Works

## Step 1: Dataset Loading
The MNIST dataset is loaded using TensorFlow/Keras.

## Step 2: Model Training
A CNN (Convolutional Neural Network) is trained on handwritten digit images.

## Step 3: Image Preprocessing
Using OpenCV:

- Convert image to grayscale
- Apply thresholding
- Detect contours
- Segment digits

## Step 4: Prediction
Each segmented digit is passed to the trained model for prediction.

## Step 5: Final Output
Detected digits are combined and displayed as the final number.

---

# 📦 Install Dependencies

```bash
pip install -r requirements.txt
```

---

# ▶️ Run the Project

## Train the Model

```bash
Run Code Section-1 in Model.ipynb
```

This creates:

```bash
Model/Digit_Model.keras
```

---

## Predict Digits Using Python Script

```bash
Run Code Section-2 in Model.ipynb
```

Enter image path when prompted.

Example:

```bash
Enter image path: sample.png
```

Output:

```bash
Final Detected Number: 507
```

---

# 🌐 Run the Flask Web App

```bash
Run the last code section in Model.ipynb
```

Open browser:

```bash
http://127.0.0.1:5000
```

Upload handwritten image and get predictions instantly.

---

# 🖼️ Supported Input

The system supports:

- Single digit images
- Multiple handwritten digits
- White background preferred
- Dark handwritten text preferred

Examples:

```text
123
507
90876
```

---

# 📊 Model Information

| Parameter | Value |
|-----------|------|
| Dataset | MNIST |
| Model Type | CNN |
| Epochs | 5 |
| Framework | TensorFlow/Keras |
| Accuracy | ~98% |

---

## Web App Home
Upload handwritten digit image using Flask UI.

## Prediction Result
Displays detected digits from uploaded image.

---

# 🔍 Future Improvements

- Real-time webcam digit recognition
- Better segmentation for connected digits
- Streamlit deployment
- Mobile application support
- Deploy on AWS/Render/Heroku
- Improve model using custom dataset

---

# 🧪 Sample Workflow

```text
Upload Image
      ↓
Image Preprocessing
      ↓
Digit Segmentation
      ↓
CNN Prediction
      ↓
Final Number Output
```

---

# 📄 Requirements

```txt
tensorflow
opencv-python
numpy
flask
Jupyter
```

---

# 💡 Learning Outcomes

Through this project, you will learn:

- Deep Learning basics
- CNN architecture
- Image preprocessing
- OpenCV contour detection
- Flask integration
- End-to-end AI project building

---

# 👨‍💻 Author

Developed by: MLC2 Group-12 Project

---

# ⭐ Conclusion

This project demonstrates how Deep Learning and Computer Vision can be combined to recognize handwritten digits effectively.

It is a beginner-to-intermediate level AI project that can be enhanced further for real-world applications such as:

- Bank cheque processing
- Postal code recognition
- Form digitization
- OCR systems

---

# 📜 License

This project is open-source and available under the MIT License.