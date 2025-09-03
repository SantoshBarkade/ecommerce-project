🛒 E-commerce Project
📌 Overview

This is a full-stack e-commerce application built using Spring Boot (Java) for the backend and React for the frontend.
It provides APIs for managing products and integrates with a modern UI for a smooth shopping experience.

⚙️ Tech Stack

Backend: Spring Boot, Java, Maven

Frontend: React, JavaScript, HTML, CSS

Database:  H2 for testing

Tools: Git, IntelliJ IDEA, VS Code

🚀 Features

🔐 User Authentication & Security (Spring Security)

📦 Product Management (Add, update, delete, list products)

🛒 Shopping Cart integration

💳 Checkout & Order Processing (basic flow)

🌐 REST APIs for frontend-backend communication

📱 Responsive React UI

🏗️ Project Structure
ecommerce-project/
│── ecom-proj/              # Spring Boot backend
│   ├── src/main/java/...   # Controllers, Services, Models, Config
│   ├── src/main/resources/ # application.properties, SQL scripts
│   └── pom.xml             # Maven dependencies
│

🔧 Setup & Installation
1️⃣ Backend (Spring Boot)
cd ecom-proj
mvn spring-boot:run

2️⃣ Frontend (React)
cd ecom-frontend
npm install
npm start

🌐 API Endpoints (Sample)
Method	Endpoint	Description
GET	/api/products	Get all products
GET	/api/products/{id}	Get product by ID
POST	/api/products	Add new product
PUT	/api/products/{id}	Update product
DELETE	/api/products/{id}	Delete product

👨‍💻 Author

Santosh Barkade
GitHub: @SantoshBarkade

