# AI Agents using Spring AI & Thymeleaf

A fully functional, interactive AI Agent system built using **Spring Boot 3.4+ / 4.0**, **Spring AI (version 2.0.0)**, and **Thymeleaf**. 
This project showcases how to build AI Agents capable of dynamic function calling (tool execution) to resolve user travel queries (flights, hotels, weather) and e-commerce customer support tasks (order status, canceling orders, inventory checks).

---

## 🌟 Features

- **Multi-domain AI Agent**: 
  - **Travel Assistant**: Search flights, hotels, and retrieve weather forecasts.
  - **Customer Support Agent**: Cancel orders, check order status, view inventory, and check item availability.
- **Function Calling / Agentic Tools**: Uses Spring AI's `@Tool` annotations to register Java methods as executable agent tools dynamically parsed by OpenAI's chat model.
- **Conversational Memory**: Utilizes `MessageWindowChatMemory` with custom `Conversation-Id` headers to maintain context across multiple turns.
- **Modern UI**: Styled with Tailwind CSS (v4) featuring light/dark mode, real-time Markdown parsing for AI responses, chat-history cleaning, and instant suggestion templates.

---

## 📂 Project Structure

```text
├── README.md                          # Project overview & running instructions
├── .gitignore                         # Project-wide Git ignore rules (ignores .vscode, .env)
├── docs/
│   ├── prompt.md                      # Example evaluation prompts
│   └── understand.excalidraw          # Architectural flow/diagram
└── ai-agent-backend/                  # Spring Boot application
    ├── pom.xml                        # Maven configuration (Spring AI dependencies)
    ├── mvnw / mvnw.cmd                # Maven Wrapper
    ├── src/
    │   ├── main/
    │   │   ├── java/.../backend/
    │   │   │   ├── AiAgentBackendApplication.java
    │   │   │   ├── config/
    │   │   │   │   └── AiConfig.java   # ChatClient builder & tool registration
    │   │   │   ├── controller/
    │   │   │   │   ├── ChatController.java  # POST Endpoint for chat messages
    │   │   │   │   └── ViewController.java  # Renders the Thymeleaf web interface
    │   │   │   ├── model/                 # Data objects (Flight, Hotel, User)
    │   │   │   ├── service/
    │   │   │   │   └── ChatService.java   # Business logic invoking ChatClient
    │   │   │   └── tools/                 # Custom Agentic Tools
    │   │   │       ├── FlightTools.java
    │   │   │       ├── HotelTools.java
    │   │   │       ├── InventoryTools.java
    │   │   │       ├── OrderTools.java
    │   │   │       └── WeatherTools.java
    │   │   └── resources/
    │   │       ├── templates/
    │   │       │   └── chat.html      # Thymeleaf UI template styled with Tailwind CSS
    │   │       ├── application.yml    # Configuration properties (OpenAI settings)
    │   │       └── application.properties
```

---

## 🛠️ Tech Stack

- **Backend**: Spring Boot, Spring Web, Spring AI, Lombok
- **AI Integration**: Spring AI Starter for OpenAI (utilizing `gpt-4o-mini` by default)
- **Frontend**: Thymeleaf, Tailwind CSS (Browser runtime), Marked.js (Markdown renderer)
- **Language**: Java 21+

---

## ⚙️ Configuration & Setup

1. **Prerequisites**:
   - **Java 21** or higher.
   - **Maven** (or use the included Maven Wrapper `./mvnw`).
   - An **OpenAI API Key**.

2. **Environment Variables**:
   Create a `.env` file in the project root directory or export the following variables in your terminal:
   ```bash
   export OPENAI_API_KEY="your-openai-api-key"
   export CHAT_MODEL="gpt-4o-mini"
   ```

3. **Application Properties** (`application.yml`):
   ```yaml
   server:
     port: 8081

   spring:
     application:
       name: ai-agent-backend
     ai:
       openai:
         api-key: ${OPENAI_API_KEY:default-key}
         chat:
           model: ${CHAT_MODEL:gpt-4o-mini}
   ```

---

## 🚀 Running the Application

Navigate to the `ai-agent-backend` directory and start the server:

```bash
cd ai-agent-backend
./mvnw spring-boot:run
```

Once the application starts successfully, open your browser and navigate to:
👉 **[http://localhost:8081/](http://localhost:8081/)**

---

## 🤖 Registered Agent Tools

The agent can call the following Java tools automatically depending on your input:

| Tool Class | Method Name | Description |
| :--- | :--- | :--- |
| `FlightTools` | `searchFlight` | Searches flights by source, destination, and date. |
| `HotelTools` | `searchHotel` | Finds hotels matching a city and max budget per night. |
| `WeatherTools` | `getForecast` | Retrieves weather conditions (temp, status) for a city. |
| `OrderTools` | `getOrderStatus` | Finds order dispatch status by its numeric ID (e.g. `1042`). |
| `OrderTools` | `cancelOrder` | Cancels an active order using the order ID. |
| `OrderTools` | `getOrderCount` | Fetches the total count of mock orders. |
| `InventoryTools` | `checkStock` | Checks item availability by product name. |
| `InventoryTools` | `getAllProductsInStock` | Returns all available products in stock. |

---

## 💡 Example Prompt for Testing

Try pasting this prompt into the Chat UI to watch the agent perform multi-tool reasoning:

> *"Plan a trip from Delhi to Goa on 2026-08-21. My total budget for flight + one night hotel is ₹7000. What should I book, and what's the weather going to be like?"*

The agent will:
1. Search flights from Delhi to Goa on `2026-08-21`.
2. Check for hotels in Goa.
3. Fetch the weather forecast for Goa on `2026-08-21`.
4. Calculate options that fit within your budget limit of `₹7000` and return a tailored plan!


## ScreenShots
<img width="1312" height="1199" alt="AI Goa Travel Itinerary Demo" src="https://github.com/user-attachments/assets/ae715874-9f4f-41af-8e8d-8831ce44cd33" />

