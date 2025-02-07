# Loan Approval System

## Overview
The **Loan Approval System** is designed to help a bank evaluate loan requests based on specific financial criteria. The system considers the user's **credit score, income, and existing debts** to determine whether a loan should be approved or rejected. The evaluation process is handled using **multithreading**, allowing multiple loan applications to be processed simultaneously.

## Features
### 1. Users & Loan Requests
- A user can request a loan by specifying the **loan amount** and the **repayment period**
- Each loan request is stored using a **List** or **Map** for easy retrieval and processing
- **Extra Features**: Ability to find a user by id and to Forgive Loans to any user.

### 2. Loan Approval Criteria
- If a user's **credit score is below 600**, the loan is **automatically rejected**
- If the **loan amount exceeds 5 times** the user’s **monthly income**, it is **rejected**
- If the user has **existing unpaid loans**, their approval rating is **reduced**

### 3. Multithreading for Loan Processing
- The system **uses threads** to evaluate multiple loan applications **simultaneously**
- Each loan request is processed in a **separate thread**, simulating **real-time processing**

---

## Project Structure
The project is divided among three team members, each handling a specific module:

### 1. Michael Dokychuk - User & Loan Request Management
- Handles user **registration** and **loan application submissions**
- Stores loan requests in a **List or Map** for further processing

### 2. Alejandro Hernandez Ontoria - Loan Evaluation System
- Implements **approval logic** based on **income, credit score, and existing debts**
- Determines whether a loan is **approved or rejected**

### 3. Andrii Nahornyi - Parallel Processing System
- Uses **multithreading** to process loan applications **concurrently**
- Ensures each request is evaluated **independently and efficiently**

---

## Technologies Used
- **Java Spring** (Framework for backend development)
- **Java Collections (List, Map)** (Data storage)
- **Multithreading** (For parallel processing)
---

## How to Run the Project
### Prerequisites
- **JDK 8+** installed
- A Java IDE (e.g., **IntelliJ IDEA, Eclipse, VS Code**) or a terminal

### Steps to Run
1. **Clone the repository**:
   ```sh
   git clone https://github.com/YOUR_TEAM_REPO/loan-approval-system.git
   ```
2. **Navigate to the project directory**:
   ```sh
   cd loan-approval-system
   ```
3. **Compile the project**:
   ```sh
   javac Main.java
   ```
4. **Run the application**:
   ```sh
   java Main
   ```

---
## API Endpoints
### Create User
```
POST /api/users
```
### Get All Users
```
GET /api/users
```
### Request A Loan
```
POST /api/loans
```
### Get All Loans
```
GET /api/loans
```
### Forgive Loans For A User
```
GET /api/forgiveLoans/{userId}
```
### Get User By Id
```
GET /api/users/{id}
```

## Example Usage
### Submitting a Loan Request
1. Use an API testing tool like Postman or cURL to submit a loan request.
2. Send a POST request to /api/users with the following JSON body to create a user
```
{
    "name": "John Doe",
    "creditScore": 650,
    "monthlyIncome": 5000.0,
    "hasUnpaidLoans": false
}
```
3. Send a POST request to /api/loans with the following JSON body
```
{
    "userId": 1,
    "amount": 10000,
    "repaymentPeriod": 12
}
```
4. The response will confirm the receipt of the loan request:
```
"Loan request received"
```
### Expected Output
- Loan Request Processing:
```
✅ Loan APPROVED for user: 1
❌ Loan REJECTED for user: 2
```
- Fetching All Loans:
```
[
    {
        "userId": 1,
        "amount": 10000,
        "repaymentPeriod": 12,
        "isApproved": true
    },
    {
        "userId": 2,
        "amount": 5000,
        "repaymentPeriod": 6,
        "isApproved": false
    }
]
```

## Future Enhancements
- Implement a **database** instead of using List/Map
- Add a **graphical user interface (GUI)**
- Introduce **notification emails** for loan status updates

---

## Contributors
- **[Michael Dokychuk]** - User & Loan Request Management
- **[Alejandro Hernandez Ontoria ]** - Loan Evaluation System
- **[Andrii Nahornyi]** - Parallel Processing System

---

Happy Coding! 🚀
