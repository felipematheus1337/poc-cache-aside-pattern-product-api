
# Cache Aside Pattern with Redis — Spring Boot (Clean Architecture)

## Overview
This project is a **Proof of Concept (POC)** demonstrating the **Cache Aside Pattern** using **Redis** in a **Spring Boot** application designed with **Clean Architecture**.

The goal is to show how to improve performance when reading frequently accessed data by introducing a cache layer between the application and the database.

The example domain is intentionally simple:

- **Product**
- **Category**

The endpoint **`/categories/featured`** is cached using Redis.

This repository focuses on:

- Clean Architecture separation
- Cache Aside strategy
- Redis integration
- PostgreSQL persistence
- Unit tests for domain and application layers

---

# Architecture

The project follows **Clean Architecture** principles.

```
controller (entrypoints)
        │
        ▼
application (use cases)
        │
        ▼
domain (entities + business rules)
        │
        ▼
infrastructure (database, redis, repositories)
```

### Layers

**Domain**
- Entities
- Business rules
- Repository interfaces

**Application**
- Use cases
- DTOs
- Application services

**Infrastructure**
- JPA repositories
- Redis cache implementation
- Database configuration

**Entrypoints**
- REST Controllers

---

# Cache Aside Pattern

This POC implements the **Cache Aside strategy**.

Flow:

1. Client requests `/categories/featured`
2. Application checks Redis cache
3. If data exists → return cached value
4. If cache miss:
    - Query PostgreSQL
    - Store result in Redis
    - Return response

### Flow Diagram

```
Client
  │
  ▼
Spring API
  │
  ├── Check Redis
  │       │
  │       ├── HIT → return cached response
  │       │
  │       └── MISS
  │             │
  ▼             ▼
PostgreSQL   Save in Redis
  │
  ▼
Return response
```

---

# Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Redis
- PostgreSQL
- Testcontainers / Mockito / JUnit
- Docker

---

# Domain

## Product

Represents a product belonging to a category.

Fields:

- id
- name
- price
- categoryId

## Category

Represents a product category.

Fields:

- id
- name
- featured

---

# Endpoint

## Get Featured Categories

```
GET /categories/featured
```

Response:

```json
[
  {
    "id": 1,
    "name": "Electronics"
  },
  {
    "id": 2,
    "name": "Books"
  }
]
```

### Cache Behavior

- Redis key: `featured_categories`
- TTL: configurable

---

# Project Structure

```
src/main/java
│
├── domain
│   ├── model
│   └── repository
│
├── application
│   ├── usecase
│   └── service
│
├── infrastructure
│   ├── persistence
│   ├── cache
│   └── config
│
└── entrypoint
    └── controller
```

---

# Running the Project

## Requirements

- Docker
- Java 21
- Maven or Gradle

---

## Start Infrastructure

```
docker-compose up -d
```

Services:

- PostgreSQL
- Redis

---

## Run Application

```
./mvnw spring-boot:run
```

or

```
./gradlew bootRun
```

---

# Unit Tests

The project includes tests for:

- Use Cases
- Services
- Cache behavior

Technologies used:

- JUnit
- Mockito

Run tests:

```
./mvnw test
```

---

# Example Cache Implementation

Pseudo logic used:

```
CategoryCacheRepository

findFeaturedCategories():

    cached = redis.get("featured_categories")

    if cached exists:
        return cached

    categories = database.findFeatured()

    redis.set("featured_categories", categories)

    return categories
```

---

# Redis Keys

| Key | Description |
|----|----|
| featured_categories | cached featured categories |

---

# Future Improvements

Possible extensions:

- Cache eviction strategy
- Cache invalidation when categories update
- Metrics with Micrometer
- Distributed tracing
- Integration tests with Testcontainers

---

# Purpose of this POC

This repository is intended for:

- Learning Redis caching strategies
- Demonstrating the Cache Aside Pattern
- Studying Clean Architecture in Spring applications

---

# Author

Felipe Matheus
