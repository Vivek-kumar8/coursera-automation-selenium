# Coursera Website Automation

A Selenium WebDriver automation framework in Java for testing the Coursera website, with TestNG for structured test execution and reporting.

## What it tests

- Login
- Course search
- Navigation

## Tech stack

- Java
- Selenium WebDriver 4.43.0
- TestNG 7.12.0
- Extent Reports 5.1.2
- Allure TestNG 2.27.0
- Maven

The test code lives in `Final-Project-master/` (`pom.xml`, `testng.xml`, `src/`).

## Project structure

```
.
└── Final-Project-master/
    ├── pom.xml
    ├── testng.xml
    └── src/
```

## How to run

Prerequisites: JDK, Maven, and Chrome (Selenium Manager handles the browser driver).

```bash
cd Final-Project-master
mvn test
```

TestNG suites are configured in `testng.xml`. Extent and Allure reports are generated from the test run.

## Author

Vivek Kumar — [GitHub](https://github.com/Vivek-kumar8) · [Portfolio](https://vivek-kumar8.github.io/my-portfolio)
