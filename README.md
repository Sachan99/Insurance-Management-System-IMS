# Insurance Management System

Summary
The Insurance Management System is a full-stack, mobile-compatible web app built to help insurance providers manage customers, policies, payments, claims, and agent collections. Developed using Angular, Spring Boot, and MongoDB, it features real-time CRUD operations, advanced search, and data visualization with Chart.js. Designed with a clean, responsive UI, it offers a seamless experience for both desktop and mobile users.

Tech Stack
Frontend: Angular, with HTML, CSS, JavaScript, and Chart.js for interactive visualizations.
Backend: Spring Boot with Java, offering secure RESTful APIs.
Database: MongoDB, a document-based NoSQL database for flexible schema management.
Tools: Postman for API testing, MongoDB Compass for data visualization, Visual Studios for frontend, and IntelliJ IDEA for backend development.

System Overview
The Angular frontend interacts with a Spring Boot backend through REST APIs. Data is stored in MongoDB using a document-based structure. APIs are tested in Postman and documented using Swagger UI for clarity.

Challenges & Solutions
Managing user roles and different data flows for agents vs. customers required thoughtful design. I used modular services in the backend to keep logic clean and separate.
Modeling non-relational data in MongoDB took some trial-and-error, but I designed the schema to avoid deep nesting and improve query performance.
Frontend validations and dynamic routing were handled using Angular Reactive Forms and Router.

UX/UI Considerations
Used Angular Material to maintain a consistent and accessible UI
Dashboards are interactive and optimized for smaller screens
Users can create, edit, and manage policies, customers, and claims directly from the interface

