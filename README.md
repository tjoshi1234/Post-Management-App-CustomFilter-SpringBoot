# Post-Management-App-CustomFilter-SpringBoot
This project is a full-stack web application built with Spring Boot (Java) for the backend and Next.js (React) for the frontend. It demonstrates custom authentication handling, API integration, and a modern UI for creating and viewing posts.

# 📝 Full-Stack Post Management App

This is a simple yet robust full-stack application built using **Spring Boot** for the backend and **Next.js** (React) for the frontend. The app allows users to create and view posts, with authentication handled via a custom HTTP header.

---

## 📌 Features

### 🔐 Authentication
- A custom HTTP header `PinggyAuthHeader` is required for all **POST** requests.
- GET requests (like `/list`) are **publicly accessible** and bypass authentication.
- The backend uses a **Servlet Filter** to intercept and validate requests.
- Auth data is stored in a `ThreadLocal` variable and used in the controller.

### 📬 API Endpoints
| Method | Endpoint     | Description               | Auth Required |
|--------|--------------|---------------------------|---------------|
| POST   | `/post`      | Create a new post         | ✅ Yes        |
| GET    | `/list`      | Get all posts             | ❌ No         |

---

## 🧑‍💻 Tech Stack

### 🔧 Backend (Spring Boot)
- Java 17+
- Spring Boot 3.4.4
- Custom Servlet Filter for auth
- REST API with JSON payloads
- ThreadLocal for per-request data storage

### 🎨 Frontend (Next.js)
- Next.js 14
- React 18
- Axios for HTTP calls
- Tailwind CSS for styling

---

## 🚀 Getting Started

### 📂 Backend Setup (Spring Boot)
1. Clone the repository:
   
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name/backend
   
2. Open the project in your IDE (IntelliJ, VSCode, etc.)

3. Run the application:

./mvnw spring-boot:run

4. API will be live at http://localhost:8080

## 🌐 Frontend Setup (Next.js)

1. Navigate to the frontend directory:
    cd ../frontend
   
2. Install dependencies:
    npm install
   
3. Start the development server:
   npm run dev

4. App will run at http://localhost:3000

## 🧪 Testing

1. Try creating a post:

  POST /post
Content-Type: application/json
PinggyAuthHeader: YOUR_AUTH_CODE

{
  "title": "First Post",
  "body": "This is a test post."
}

2. Try fetching posts:

     GET /list
