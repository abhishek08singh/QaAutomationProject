# QA Automation Framework

## 🚀 Overview
A highly scalable **QA Automation Framework** built using **Selenium, Java, TestNG, Maven, and RestAssured**. This framework supports **cross-browser testing, parallel execution, API testing, test data management, and reporting integration**.

## 🛠️ Features
- **Modular Test Execution** – Follows the Page Object Model (POM) for maintainability.
- **Cross-Browser Testing** – Supports Chrome, Firefox, and Edge.
- **Parallel Execution** – Runs tests simultaneously using TestNG.
- **API Testing Support** – Uses RestAssured and Postman for API validation.
- **Test Data Management** – Reads data from **CSV, JSON, YAML, and Excel**.
- **Logging and Reporting** – Integrated with Log4j2 and Extent Reports.
- **Jenkins Integration** – Supports CI/CD pipeline execution.
- **Email Notifications** – Sends execution reports via Gmail.

## 📂 Project Structure
```
QA_Automation_Framework/
│-- src/
│   ├── test/java/com/automation/base/      # BaseTest for WebDriver setup
│   ├── test/java/com/automation/pages/     # Page Object classes
│   ├── test/java/com/automation/tests/     # Test Cases
│   ├── test/java/com/automation/utils/     # Utility classes (data readers, screenshot, etc.)
│   ├── test/resources/                     # Config files and test data
│-- pom.xml                                 # Maven dependencies
│-- .gitignore                              # Ignored files
│-- LICENSE                                 # MIT License
│-- README.md                               # Project Documentation
```

## 🛠️ Setup Instructions
1. **Clone the Repository**
   ```sh
   git clone https://github.com/abhishek08singh/QaAutomationProject.git
   cd QaAutomationProject
   ```

2. **Install Dependencies**
   - Install **Java 11 or later**
   - Install **Maven** (`mvn -version` to check)
   - Set up **IntelliJ IDEA / Eclipse**

3. **Configure WebDriver**
   - Place the **ChromeDriver, GeckoDriver, and EdgeDriver** in the correct path.
   - Update `config.properties` with browser settings.

4. **Run Tests**
   - Execute all tests:
     ```sh
     mvn test
     ```
   - Run a specific test:
     ```sh
     mvn test -Dtest=LoginTest
     ```

## 📝 Usage
- Modify `config.properties` to change the test environment.
- Add test cases inside `src/test/java/com/automation/tests/`.
- Use `ScreenshotUtil` to capture test failures.

## 🖥️ Technology Stack
- **UI Automation**: Selenium, Java, TestNG
- **API Automation**: RestAssured, Postman
- **Build Tool**: Maven
- **Logging**: Log4j2
- **Test Data Management**: CSV, JSON, YAML, Excel
- **Reporting**: Extent Reports
- **CI/CD**: Jenkins

## 📜 License
This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.

## 🤝 Contribution
Contributions are welcome! If you want to improve this project, please fork the repository and submit a pull request.

## 📧 Contact
For any queries, feel free to reach out via **LinkedIn** or **GitHub Issues**.

