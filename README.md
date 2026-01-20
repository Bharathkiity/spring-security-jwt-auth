# Spring Security – JWT Authentication (Stateless)

<img width="1560" height="760" alt="image" src="https://github.com/user-attachments/assets/8f21a264-638d-4291-8e77-93134fb0c21e" />


## 📖 Overview
This project demonstrates **stateless JWT-based authentication** using **Spring Boot 3.x** and **Spring Security 6.x**, implemented according to **real-time industry practices (2025–2026)**.

Users authenticate using username and password, receive a **signed JWT token**, and access protected REST APIs using **role-based authorization**.  
The application does **not use server-side sessions**, making it suitable for **scalable REST APIs and microservices**.

---

## ⚙️ Features
- Stateless authentication using JWT
- Login API powered by `AuthenticationManager`
- Custom JWT validation filter (`OncePerRequestFilter`)
- Secure token signing using HS256 (256-bit secret key)
- Role-based authorization using `@PreAuthorize`
- No HTTP sessions (fully stateless)
- Modern Spring Security configuration (Spring Security 6)
- Clean separation of authentication and authorization logic

---

## 🧠 Concepts Covered
- Authentication vs Authorization
- Stateless security architecture
- Spring Security filter chain
- `AuthenticationManager` & `UserDetailsService`
- JWT structure (Header, Payload, Signature)
- Token validation and expiration handling
- `SecurityContextHolder`
- Method-level security using annotations

---

## 🛠 Tech Stack
- Java 17+
- Spring Boot 3.x
- Spring Security 6.x
- JSON Web Token (JJWT)
- Maven
- REST APIs
- Postman (for testing)

---

## 🔐 Authentication & Authorization Flow

1. User sends **username and password** to `/auth/login`
2. `AuthenticationManager` validates credentials
3. On success, a **JWT token is generated**
4. Client stores the JWT token
5. For protected APIs, client sends:


Authorization: Bearer <JWT_TOKEN>

6. `JwtFilter` validates the token on every request
7. Authentication is stored in `SecurityContext`
8. Access is granted or denied based on **user roles**

---

## 📌 API Endpoints

| Endpoint | Method | Access |
|--------|--------|--------|
| `/auth/login` | POST | Public |
| `/admin/dashboard` | GET | ADMIN |
| `/user/dashboard` | GET | USER, ADMIN |

---

## 🧪 Testing Using Postman

### 🔹 Login Request

🔹 Authorization Header for Protected APIs
Authorization: Bearer <JWT_TOKEN>

🔹 Expected Responses
200 OK → Authorized access
401 Unauthorized → Invalid or expired token
403 Forbidden → Role not permitted


🎯 Learning Outcome:
Build real-time stateless authentication systems
Understand internal Spring Security execution flow
Implement secure role-based authorization
Gain strong foundation for microservices security
Prepare for JWT, OAuth2, and API security interviews



🚀 Future Enhancements

Database-backed users and roles (JPA + Hibernate)
BCrypt password encoding
Refresh token implementation
Token revocation / logout support
OAuth2 / OpenID Connect integration
API Gateway–level authentication
