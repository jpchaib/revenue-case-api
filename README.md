# Revenue Case API

## Project Overview

The **Revenue Case API** is a Spring Boot backend service designed to support a case management workflow similar to those used in government revenue or compliance systems.

It provides RESTful APIs for managing customer cases, including:

* Creating cases
* Retrieving case information
* Updating case status
* Adding case notes
* Tracking audit logs

The project was created as part of preparation for a senior full-stack developer role and demonstrates modern backend development practices including RESTful APIs, NoSQL persistence, containerised development environments, and automated testing.

The API is intended to be consumed by a React frontend application that provides the user interface for case management operations.

---

# Tech Stack

### Backend

* **Java 21**
* **Spring Boot 4**
* **Spring Web (REST APIs)**
* **Spring Data MongoDB**
* **Spring Security**
* **Lombok**

### Database

* **MongoDB**

### Infrastructure / Dev Environment

* **Docker**
* **Docker Compose**
* **Spring Boot Docker Compose Integration**

### Build Tool

* **Maven**

### Testing

* **JUnit 5**
* **Spring Boot Test**
* **Testcontainers (MongoDB)**

---

# Architecture

The application follows a layered architecture typical of Spring Boot services.

```
Controller Layer
    |
Service Layer
    |
Repository Layer
    |
MongoDB Database
```

### Controller Layer

Handles HTTP requests and responses and exposes REST endpoints.

### Service Layer

Contains business logic and orchestrates repository operations.

### Repository Layer

Uses Spring Data MongoDB to persist and query documents from MongoDB.

### Database

MongoDB stores case documents and audit logs using a document-based schema.

### Key Domain Objects

* **CaseRecord**
* **CaseNote**
* **AuditLog**

---

# Setup Instructions

## 1. Prerequisites

Install the following tools:

* Java 21
* Maven
* Docker
* Node.js (for the frontend project)

Verify installations:

```
java -version
mvn -version
docker --version
```

---

## 2. Clone the Repository

```
git clone <repository-url>
cd revenue-case-api
```

---

## 3. Run the Application

The application automatically starts MongoDB using Docker Compose.

```
./mvnw spring-boot:run
```

Spring Boot will:

1. Start MongoDB via Docker Compose
2. Wait until the container is healthy
3. Launch the API server

The API will be available at:

```
http://localhost:8080
```

---

## 4. Verify the API

Open in browser or Postman:

```
http://localhost:8080/api/cases
```

Expected response:

```
[]
```

---

# API Endpoints

## Cases

### Get all cases

```
GET /api/cases
```

Returns a list of all case records.

---

### Create a case

```
POST /api/cases
```

Example request body:

```json
{
  "title": "Unpaid Fine Review",
  "customerName": "Jane Citizen",
  "type": "Fine",
  "status": "OPEN",
  "priority": "HIGH"
}
```

---

### Get case by ID

```
GET /api/cases/{id}
```

Returns a specific case.

---

### Update case status

```
PATCH /api/cases/{id}/status
```

Example body:

```json
{
  "status": "RESOLVED",
  "actor": "admin"
}
```

---

### Add note to case

```
POST /api/cases/{id}/notes
```

Example body:

```json
{
  "author": "case_worker",
  "message": "Customer contacted support."
}
```

---

### Retrieve audit history

```
GET /api/cases/{id}/audit
```

Returns audit events for the case.

---

# Database Schema (MongoDB)

### cases collection

Example document:

```json
{
  "_id": "12345",
  "title": "Unpaid Fine Review",
  "customerName": "Jane Citizen",
  "type": "Fine",
  "status": "OPEN",
  "priority": "HIGH",
  "createdAt": "2026-03-10T21:00:00Z",
  "updatedAt": "2026-03-10T21:00:00Z",
  "notes": []
}
```

---

### audit_logs collection

Example document:

```json
{
  "_id": "67890",
  "caseId": "12345",
  "action": "CASE_CREATED",
  "actor": "system",
  "timestamp": "2026-03-10T21:00:00Z"
}
```

---

# Testing

Run all tests:

```
./mvnw test
```

Tests include:

* Spring Boot context loading
* Repository integration tests
* MongoDB tests using Testcontainers

Testcontainers automatically starts a temporary MongoDB instance during testing.

---

# Development Tools

Recommended tools:

* **VS Code**
* **MongoDB Compass**
* **Thunder Client or Postman**
* **Docker Desktop**

---

# Future Improvements

### Security

* Implement JWT authentication
* Integrate with OAuth or AWS Cognito
* Role-based access control

### Architecture

* Split the service into microservices
* Introduce API Gateway
* Add event-driven architecture using Kafka or SNS/SQS

### Cloud Deployment

* Deploy backend using AWS ECS or Kubernetes
* Store infrastructure definitions using Terraform
* Deploy frontend via S3 + CloudFront

### Observability

* Add structured logging
* Integrate metrics with Prometheus
* Add distributed tracing

### API Documentation

* Add OpenAPI / Swagger documentation
* Generate API client SDKs

### CI/CD

* Add GitHub Actions or GitLab CI pipelines
* Automated builds, tests, and deployments

---

# Author

João Pedro Chaib

Senior Developer Interview Preparation Project
