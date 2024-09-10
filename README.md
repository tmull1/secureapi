SecureAPI - Spring Boot Project
This is a Spring Boot project that implements security measures for APIs using both JWT (JSON Web Tokens) and OAuth2. The project secures APIs through authentication and role-based access control (RBAC) and includes endpoints for user registration, login, and token generation.

Features
JWT Authentication: Secure API endpoints using JWT tokens for authentication and authorization.
OAuth2 Integration: Setup for OAuth2 login with external providers (Google, GitHub, etc.).
Role-Based Access Control (RBAC): Enforced method-level security for users with different roles (USER, ADMIN).
Endpoints:
/api/register: User registration.
/api/login: User login and JWT token generation.
/api/token: Token generation after authentication.
/api/admin: Admin-only access.
/api/user: User-only access.

Testing the API with Postman
Use the following steps to test the API endpoints using Postman:

Register a User:

Method: POST
URL: http://localhost:8080/api/register
Body (JSON):
json
Copy code
{
  "username": "user",
  "password": "password"
}


Login and Generate JWT Token:

Method: POST
URL: http://localhost:8080/api/login
Body (JSON):
json
Copy code
{
  "username": "user",
  "password": "password"
}

{
  "token": "<your-jwt-token>"
}

Access Secured Endpoints:

Use the generated JWT token to access secured endpoints by adding the Authorization header in Postman:
Key: Authorization
Value: Bearer <your-jwt-token>
Access Admin Endpoint:

Method: GET
URL: http://localhost:8080/api/admin
Headers: Add the Authorization header with your JWT token.

Access User Endpoint:

Method: GET
URL: http://localhost:8080/api/user
Headers: Add the Authorization header with your JWT token.

