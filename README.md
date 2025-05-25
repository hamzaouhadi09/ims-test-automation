# 🧪 IMS Test Automation

This repository contains automated UI tests for the **Inventory Management System (IMS)** built with React.js frontend and Spring Boot backend.  
Automation is implemented using **Java**, **Selenium WebDriver**, and **TestNG**, following the Page Object Model (POM) pattern.

---

## 📌 Project Structure

```
ims-test-automation/
├── src/
│   ├── main/java/com/ims/pages/       # Page Object classes
│   ├── main/java/com/ims/utils/       # Utilities (e.g. config reader)
│   └── test/java/com/ims/tests/       # TestNG test classes
├── resources/config.properties        # Test data and base URL
├── testng.xml                         # TestNG suite configuration
├── pom.xml                            # Maven dependencies
└── README.md
```

---

## 🚀 Tech Stack

| Component       | Tool/Framework         |
|----------------|------------------------|
| Language        | Java 17                |
| Testing         | TestNG                 |
| Browser Driver  | Selenium WebDriver     ||
| Build Tool      | Maven                  |

---

## 🧪 Test Coverage

### ✅ Authentication Tests
- Valid login with correct credentials
- Invalid login and error validation

### ✅ Product Tests
- Add product with valid data (positive test)
- Add product with invalid/missing data (negative test)
- Product listing verification
- Product deletion flow

---

## ⚙️ How to Run

### 1. Prérequisites

- Java 17 installed
- Chrome browser
- Maven installed

### 2. Clone the project

```bash
git clone https://github.com/hamzaouhadi09/ims-test-automation.git
cd ims-test-automation
```

### 3. Configure `config.properties`

Edit the `src/resources/config.properties` to set the app base URL and credentials:

```
base.url=http://localhost:3000
username=admin@email.com
password=admin123
```

### 4. Run tests

```bash
mvn clean test
```