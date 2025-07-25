# 🧠 AI Agent using MCP + Groq + LangChain

A modular, memory-enabled AI agent that thinks, searches, automates, and acts


---

## 🚀 Features

- ✅ Modular backend integration using MCP servers  
- 🔍 Real-time web search with DuckDuckGo  
- 🏡 Airbnb listing querying via custom MCP server  
- 🖱️ Web automation using Playwright (headless browser)  
- 🧠 Conversational memory across chat turns  
- ⚡️ Ultra-fast LLaMA 3 (8B) inference via **Groq API**  
- 🛠️ Easily extendable and scriptable in Python  

---


## 📂 Project Structure

```
.
├── browser_mcp.json       # MCP server config
├── mcp_use.py             # Core agent class wrapper
├── main.py                # Entry point for interactive CLI
├── .env                   # Store your GROQ_API_KEY here
├── requirements.txt
└── README.md
```

---

## ⚙️ Installation

> Requires Python 3.9+

```bash
# Clone the repo
git clone https://github.com/GeneralSubhra/AI-Agent-using-MCP.git
cd AI-Agent-using-MCP

# Create virtual environment (recommended)
python -m venv venv
source venv/bin/activate  # or venv\Scripts\activate on Windows

# Install dependencies
pip install -r requirements.txt
```

---

## 🔑 Environment Setup

Create a `.env` file in the root with your **Groq API key**:

```
GROQ_API_KEY=your_groq_api_key_here
```

---

## 🧪 Running the Agent

Run the memory-enabled interactive CLI chat:

```bash
python main.py
```

Commands during chat:
- `exit` or `quit`: ends the session
- `clear`: clears conversation history

---

## 🔌 MCP Server Config

Example `browser_mcp.json`:

```json
{
  "mcpServers": {
    "playwright": {
      "command": "npx",
      "args": ["@playwright/mcp@latest"]
    },
    "airbnb": {
      "command": "npx",
      "args": ["-y", "@openbnb/mcp-server-airbnb"]
    },
    "duckduckgo-search": {
      "command": "npx",
      "args": ["-y", "duckduckgo-mcp-server"]
    }
  }
}
```

---

## 🌐 Technologies Used

- [MCP](https://github.com/openai/mcp)  
- [Groq API](https://console.groq.com/)  
- [LangChain](https://www.langchain.com/)  
- [Python](https://www.python.org/)  
- [Playwright](https://playwright.dev/)  
- DuckDuckGo MCP Server  
- Airbnb MCP Server (custom)  

---

## 📌 Roadmap

- [ ] Add Web UI (Next.js or Streamlit)  
- [ ] Add more MCP tools (PDF parser, code interpreter, etc.)  
- [ ] Deploy on cloud with persistent memory  

---

## 🤝 Contributing

PRs, forks, and feedback are welcome! Open an issue or reach out.

---

## ⭐️ Support

If you find this project useful, please consider giving it a ⭐️ on GitHub and sharing it with others!
