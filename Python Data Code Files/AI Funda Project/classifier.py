from transformers import BertTokenizer, BertForSequenceClassification, Trainer, TrainingArguments
from datasets import load_dataset
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, precision_recall_fscore_support
import pandas as pd
import torch

# Load the dataset
data = pd.read_csv('data.csv')  # Assuming your dataset is in a CSV file
data = data.reset_index(drop=True)  # Reset the index to be continuous
data.columns = ['text', 'label']  # Ensure the correct column names
data['label'] = data['label'].astype(int)  # Ensure the labels are integers (0 or 1)

# Split into train and test
train_texts, test_texts, train_labels, test_labels = train_test_split(data['text'], data['label'], test_size=0.2)

# Load pre-trained BERT tokenizer
tokenizer = BertTokenizer.from_pretrained('bert-base-uncased')

# Tokenize the data
train_encodings = tokenizer(list(train_texts), truncation=True, padding=True)
test_encodings = tokenizer(list(test_texts), truncation=True, padding=True)

# Convert to torch datasets
class NewsFactDataset(torch.utils.data.Dataset):
    def __init__(self, encodings, labels):
        self.encodings = encodings
        self.labels = labels

    def __getitem__(self, idx):
        item = {key: torch.tensor(val[idx]) for key, val in self.encodings.items()}
        item['labels'] = torch.tensor(self.labels[idx])
        return item

    def __len__(self):
        return len(self.labels)
    
train_labels = train_labels.reset_index(drop=True)
test_labels = test_labels.reset_index(drop=True)

train_dataset = NewsFactDataset(train_encodings, train_labels)
test_dataset = NewsFactDataset(test_encodings, test_labels)

# Load pre-trained BERT model for sequence classification
model = BertForSequenceClassification.from_pretrained('bert-base-uncased', num_labels=2)

# Define training arguments
training_args = TrainingArguments(
    output_dir='./results',          # output directory
    num_train_epochs=3,              # number of training epochs
    per_device_train_batch_size=8,   # batch size for training
    per_device_eval_batch_size=8,    # batch size for evaluation
    warmup_steps=500,                # number of warmup steps for learning rate scheduler
    weight_decay=0.01,               # strength of weight decay
    logging_dir='./logs',            # directory for storing logs
    logging_steps=10,
)

# Define the trainer
def compute_metrics(pred):
    labels = pred.label_ids
    preds = pred.predictions.argmax(-1)
    accuracy = accuracy_score(labels, preds)
    precision, recall, f1, _ = precision_recall_fscore_support(labels, preds, average='binary')
    return {
        'accuracy': accuracy,
        'precision': precision,
        'recall': recall,
        'f1': f1
    }

trainer = Trainer(
    model=model,                         # the model to train
    args=training_args,                  # training arguments, defined above
    train_dataset=train_dataset,         # training dataset
    eval_dataset=test_dataset,           # evaluation dataset
    compute_metrics=compute_metrics      # function to compute metrics
)

# Train the model
trainer.train()

# Save the trained model and tokenizer for later use
model.save_pretrained('./trained_model')
tokenizer.save_pretrained('./trained_model')

# Evaluate the model
trainer.evaluate()

# Example prediction
inputs = tokenizer("Vijay is leader of DMK party", return_tensors="pt", padding=True, truncation=True)
outputs = model(**inputs)
prediction = torch.argmax(outputs.logits)
print(f'Prediction: {prediction.item()}')  # 0 or 1

# from transformers import BertTokenizer, BertForSequenceClassification
# import torch

# # Load the saved tokenizer and model
# model = BertForSequenceClassification.from_pretrained('./trained_model')
# tokenizer = BertTokenizer.from_pretrained('bert-base-uncased')

# inputs = tokenizer("Vijay is the leader of the DMK party", return_tensors="pt", padding=True, truncation=True)

# # Get the model's output logits
# outputs = model(**inputs)

# # Convert logits to predicted class (0 or 1)
# prediction = torch.argmax(outputs.logits, dim=-1)

# # Print the prediction
# if prediction.item() == 0:
#     print("Prediction: Fact")
# else:
#     print("Prediction: News")
