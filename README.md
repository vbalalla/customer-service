# Customer Service

## Overview

Customer Service is a Spring Boot application that manages customer information. It provides RESTful APIs to perform CRUD operations on customer data.

## Features

- Create, Read, Update, and Delete (CRUD) operations for customer data
- Dockerized application
- Kubernetes deployment configuration
- Actuator endpoints for health checks and metrics (Observability)

## Technologies Used

- Java 23
- Spring Boot
- Maven
- Docker
- Kubernetes

## Prerequisites

- Java 23
- Maven
- Docker
- Kubernetes

## Getting Started

### Clone the repository

```sh
git clone https://github.com/vbalalla/customer-service.git
cd customer-service
```

### Build the project

```sh
mvn clean install
```

### Run the application

```sh
mvn spring-boot:run
```

### Dockerize the application

1. Build the Docker image:

    ```sh
    docker build -t vbalalla/customer-service:latest .
    ```

2. Run the Docker container:

    ```sh
    docker run -p 8080:8080 vbalalla/customer-service:latest
    ```

### Deploy to Kubernetes

1. Apply the Kubernetes configuration:

    ```sh
    kubectl apply -f customer-service-kubernetes.yaml
    ```

2. Check the status of the deployment:

    ```sh
   kubectl get deployments
   kubectl get pods 
    kubectl get svc
    ```

3. Run using minikube locally:

    ```sh
   minikube service customer-service
    ```

## API Endpoints

- `GET /customers` - Retrieve all customers
- `GET /customers/{id}` - Retrieve a customer by ID
- `POST /customers` - Add a new customer
- `PUT /customers` - Update an existing customer
- `DELETE /customers/{id}` - Delete a customer by ID

## Sample JSON Payload

```json
{
  "firstName": "John",
  "middleName": "A.",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "phone": "123-456-7890"
}
```

## Actuator Endpoints

- `GET /actuator/health` - Health check
- `GET /actuator/metrics` - Metrics

