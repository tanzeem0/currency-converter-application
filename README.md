# Currency Converter (Spring Boot MVC)
<img width="1911" height="955" alt="image" src="https://github.com/user-attachments/assets/f6da4b74-aa35-4e64-a0c7-0807b214d0e2" />


Spring Boot MVC service exposing REST endpoints for currency conversion and metadata. Uses RestClient for external HTTP calls, Lombok for DTOs, Swagger UI for API docs, and Actuator for health/metrics. API key is supplied via environment variable and never committed.

## Endpoints
- GET /convertCurrency/status
  - Returns remaining API quota for the month.
- GET /convertCurrency/latestConversionRate
  - Returns latest conversion rate (e.g., for requested currency pair via query params).
- GET /convertCurrency/currencies
  - Returns supported currencies.

## Tech Stack
- Java 17+, Spring Boot (Web, Actuator)
- RestClient, Jackson
- Lombok
- springdoc‑openapi (Swagger UI)
- Maven Wrapper

## Configuration
application.properties:
- freecurrency.api.key=${FREECURRENCY_API_KEY}

RestClient bean (example):
- Base URL: https://api.freecurrencyapi.com/v1
- Default header: apikey set from property/env

## Environment Variables
Set your API key before running:
- macOS/Linux:
  export FREECURRENCY_API_KEY=your-real-key
- Windows PowerShell:
  $env:FREECURRENCY_API_KEY="your-real-key"

Keep application.properties in Git, but reference the env var (do not hardcode secrets).

## Build & Run
- Build: ./mvnw clean package
- Run (dev): FREECURRENCY_API_KEY=your-real-key ./mvnw spring-boot:run
- Run (jar): FREECURRENCY_API_KEY=your-real-key java -jar target/*.jar

## Swagger/OpenAPI
- Dependency: springdoc-openapi-starter-webmvc-ui
- Swagger UI: /swagger-ui.html or /swagger-ui/index.html

## Logging
- Use SLF4J (e.g., Lombok @Slf4j) for structured logs.
- Never log API keys; mask sensitive headers.

