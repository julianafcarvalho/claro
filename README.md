# Selenium Automation for Claro Broadband Form Submission

## Overview
This project automates the process of navigating the Claro website, interacting with the submenu, accessing the "Broadband" page, scrolling to the contact form, filling in the fields, and submitting the form.

## Prerequisites
Before running the script, ensure you have the following installed:

- Java 8 or later
- Maven (optional but recommended for dependency management)
- Chrome browser (latest version)
- ChromeDriver (compatible with your Chrome version)
- Selenium WebDriver

## Setup Instructions

### 1. Install Dependencies
Download and set up ChromeDriver:
- Visit [ChromeDriver](https://sites.google.com/chromium.org/driver/)
- Download the version matching your Chrome browser
- Place the `chromedriver.exe` in the `libs/` directory

### 2. Configure the Project
- Ensure `chromedriver.exe` is correctly referenced in the script:
```java
System.setProperty("webdriver.chrome.driver", "libs/chromedriver.exe");
```

### 3. Run the Script
Compile and execute the script using:
```sh
javac ClaroAutomation.java
java ClaroAutomation
```
If using Maven, ensure you have `pom.xml` with Selenium dependencies and run:
```sh
mvn clean install
mvn exec:java -Dexec.mainClass="ClaroAutomation"
```

## Automation Flow
1. Navigate to `https://www.usclaro.com/`
2. Accept cookies if prompted
3. Hover over the "Solutions" menu
4. Click on "Broadband" in the submenu
5. Scroll to the contact form
6. Fill in the form fields using their `name` attributes
7. Submit the form
8. Handle potential errors (e.g., CAPTCHA validation)

## Troubleshooting
- **Form not found?** Verify the `name` attributes of the input fields.
- **Not scrolling?** Ensure JavaScript execution is enabled.
- **ChromeDriver issues?** Update `chromedriver.exe` to match your Chrome version.
- **Slow loading?** Increase the timeout in `WebDriverWait`.

## Future Enhancements
- Implement CAPTCHA bypass using third-party services
- Add support for running in headless mode
- Integrate logging for better debugging


## Project Structure
```
ClaroAutomation/
│── libs/                  # Directory containing ChromeDriver
│── ClaroAutomation.java   # Main Java automation script
│── ClaroAutomation.class  # Compiled Java class
│── README.md              # Project documentation
```

## License
This project is open-source and available for modification and distribution.





























## License
This project is open-source and available for modification and distribution.

