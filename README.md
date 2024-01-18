# Kirana Transaction Management System 

## Overview

The Kirana Transaction Management System is a Spring Boot application designed to streamline the recording and tracking of daily transactions for Kirana stores. It provides a RESTful API for managing transactions, generating reports, and maintaining accurate financial records.

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Swagger Documentation](#swagger-documentation)
- [Contributing](#contributing)
- [License](#license)

## Features

- Record daily transactions with details such as items purchased, amount, currency, and transaction type.
- Retrieve a list of all transactions and view comprehensive reports.
- Database storage using MySQL with JPA for data persistence.
- Liquibase integration for database version control.
- Developer-friendly codebase with Lombok for reduced boilerplate code.

## Technology Stack

- Java
- Spring Boot
- MySQL
- JPA
- Liquibase
- Lombok

## Getting Started

1. **Clone the Repository:**

**1.** Clone this project:
```bash
git clone https://github.com/workwithgurunath/kirana-store.git
```

**1.** Api Signitures:
```bash
1.Record a Transaction

Method: POST
URL: /api/v1/transaction
Request:
{
  "itemsPurchased": ["Item1", "Item2", "Item3"],
  "amount": 100.50,
  "currency": "USD",
  "transactionType": "Credit"
}
Response:
{
  "transactionId": 5,
  "message": "Transaction recorded successfully"
}
```
```bash
2.Get All Transactions

Method: GET
URL: /api/v1/transactions
Response:
[
  {
    "id": 4,
    "itemsPurchased": ["Item1", "Item2", "Item3"],
    "amount": 100.50,
    "currency": "USD",
    "transactionType": "Credit",
    "transactionDate": "2024-01-18T10:53:45"
  },
  {
    "id": 5,
    "itemsPurchased": ["Item1", "Item2", "Item3"],
    "amount": 10.00,
    "currency": "USD",
    "transactionType": "Debit",
    "transactionDate": "2024-01-18T10:54:16"
  }
]
```
```bash
3.Get Daily Report

Method: GET
URL: /api/v1/transactions/daily-report/?date=2024-01-18
Response:
[
  {
    "id": 4,
    "itemsPurchased": ["Item1", "Item2", "Item3"],
    "amount": 100.50,
    "currency": "USD",
    "transactionType": "Credit",
    "transactionDate": "2024-01-18T10:53:45"
  },
  {
    "id": 5,
    "itemsPurchased": ["Item1", "Item2", "Item3"],
    "amount": 10.00,
    "currency": "USD",
    "transactionType": "Debit",
    "transactionDate": "2024-01-18T10:54:16"
  }
]
```
```bash
// Swagger Documentation

Explore and interact with the API using Swagger UI. Access the Swagger documentation at:

http://localhost:8080/swagger-ui.html
i Have attached the Screenshots below
```



<img width="1440" alt="Screenshot 2024-01-18 at 7 01 03 PM" src="https://github.com/workwithgurunath/kirana-store/assets/156908101/58f1ef60-8eb0-41f2-9979-f2ad3770fb34">

<img width="981" alt="Screenshot 2024-01-18 at 7 03 47 PM" src="https://github.com/workwithgurunath/kirana-store/assets/156908101/1a665554-08b8-47f6-9ef7-08b2fc6e4ff1">


<img width="1066" alt="Screenshot 2024-01-18 at 7 04 00 PM" src="https://github.com/workwithgurunath/kirana-store/assets/156908101/0a2e63c0-8981-4a2d-ab73-d17ed5814ed1">

<img width="998" alt="Screenshot 2024-01-18 at 7 04 
48 PM" src="https://github.com/workwithgurunath/kirana-store/assets/156908101/084e16a8-ee48-466b-a141-e278fa229645">
