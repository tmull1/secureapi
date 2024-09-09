SecureAPI - Spring Boot Project
This is a Spring Boot project that implements security measures for APIs using both JWT (JSON Web Tokens) and OAuth2. The project secures APIs through authentication and role-based access control (RBAC) and includes endpoints for user registration, login, and token generation.

Features
JWT Authentication: Secure API endpoints using JWT tokens for authentication and authorization.
OAuth2 Integration: Setup for OAuth2 login with external providers (Google, GitHub, etc.).
Role-Based Access Control (RBAC): Enforced method-level security for users with different roles (USER, ADMIN).
Endpoints:
/api/register: User registration.
/api/login: User login and JWT token generation.
/api/token: (Optional) Token generation after authentication.
/api/admin: Admin-only access.
/api/user: User-only access.