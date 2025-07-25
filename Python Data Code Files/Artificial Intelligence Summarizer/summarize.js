/**
 * The function `summarizeText` uses the Hugging Face API to summarize text input based on specified
 * parameters.
 * @param text - The `summarizeText` function you provided is using the Hugging Face model
 * `facebook/bart-large-cnn` to summarize text. The function takes a `text` parameter as input, which
 * is the text that you want to summarize.
 * @returns The `summarizeText` function is being exported, which takes a `text` input, sends a POST
 * request to the Hugging Face API endpoint specified by `HF_API_URL`, with the provided `text` input
 * and parameters for summarization. It then returns the summarized text extracted from the response
 * data. If an error occurs during the API request, it will log the error message and return
 */
const axios = require('axios');
require('dotenv').config(); // use dotenv for local .env file

const HF_API_URL = 'https://api-inference.huggingface.co/models/facebook/bart-large-cnn';
const HF_API_TOKEN = process.env.HF_API_TOKEN;

async function summarizeText(text) {
  const data = {
    inputs: text,
    parameters: {
      max_length: 100,
      min_length: 30
    }
  };

  const config = {
    method: 'post',
    url: HF_API_URL,
    headers: {
      'Authorization': `Bearer ${HF_API_TOKEN}`,
      'Content-Type': 'application/json'
    },
    data
  };

  try {
    const response = await axios(config);
    return response.data[0].summary_text;
  } catch (error) {
    console.error(error.response?.data || error.message);
    return null;
  }
}

module.exports = summarizeText;
