# 💬 Multi-Client Chat Application

A simple **real-time multi-client chat application built with Java Socket Programming**. This project demonstrates client-server communication, TCP sockets, and multithreading.

## ✨ Features

- 💬 Real-time messaging between multiple clients
- 👥 Multiple clients supported simultaneously
- 👤 Username-based chat
- 🔔 Join and leave notifications
- 🧵 Multithreaded client handling
- 🔌 TCP socket communication

## 🛠️ Tech Stack

- ☕ Java
- 🔌 Socket Programming
- 🌐 TCP/IP
- 🧵 Multithreading
- 💻 VS Code

## 📂 Project Structure

```text
Multi-Client-Chat-Application/
├── ChatServer.java
├── ChatClient.java
├── README.md
└── .Gi ignore
```
## ⚙️ How It Works

```text
👤 Client 1 ──┐
👤 Client 2 ──┼──> 🖥️ Chat Server ──> 💬 Broadcast Messages
👤 Client 3 ──┘
```
The server runs on **port 5000** and creates a separate thread for each connected client.

## 🚀 How to Run

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Tanishkaa2/Multi-Client-Chat-Application.git
cd Multi-Client-Chat-Application
```
### 2️⃣ Compile the Project

```bash
javac ChatServer.java ChatClient.java
```

###  3️⃣ Start the Server

```markdown

```bash
java ChatServer
```

### 4️⃣ Start the Clients

```markdown
Open separate terminals and run:

```bash
java ChatClient
```

### 5️⃣  Example

```markdown
## 💬 Example

```text
Tan: Hello everyone!
Alice: Hi Tan!
Bob: Hey everyone!
```
###  6️⃣ Configuration

```markdown
## 🔧 Configuration

The client connects to the server using:

```java
String serverAddress = "127.0.0.1";
int port = 5000;
```

### 7️⃣ Future Improvements

```markdown
## 🔮 Future Improvements

- 🎨 Graphical User Interface
- 🔐 User Authentication
- 💌 Private Messaging
- 💾 Chat History
- 📁 File Sharing
- 🔒 Message Encryption
```

## 👩‍💻 Author

**Tanishkaa2**

🔗 GitHub: https://github.com/Tanishkaa2

---

⭐ If you found this project useful, consider starring the repository!
