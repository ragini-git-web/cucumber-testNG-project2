Naaptol Automation Project bu Using Cucumber testNG Framework


*Introduction
This project demonstrates automated testing of the "Beauty & Wellness" category on the Naaptol website using Selenium WebDriver. 
The script navigates through the category, interacts with elements, and verifies expected outcomes.

*Project Type
Backend

*Deplolyed App
Naptol 
URL- https://www.naaptol.com/ 

*Directory Structure
naaptol-automation/  
├── src  
│   └── test  
│       └── java  
│           └── runner
│           |    └──  BeautyRunner.java
│           |    └──   HealthCareRunner.java
|           |     └── HealthSupplimentsRunner.java
|           |     └── OralCareRunner.java
|           |     └── PainRelieversRunner.java 
|           | 
|           |
|            └──Steps
|                   └──Beauty.java
|                   └──HealthCare.java
|                   └── Healthsuppliments.java
|                   └──Oralcare.java
|                   └──PainRelievers.java
├── src  
│   └── test  
│       └── resources
|            └── FeatureFile
|                  └── Beauty.feature
|                  └── Healthcare.feature
|                  └── Healthsuppliments.feature
|                  └── OralCare.feature
|                  └── PainRelievers.feature
|
|
|── screenshots 
|
|
├── pom.xml

*Video Walkthrough of the project
https://youtu.be/tHeH26q-5t0

*Features
-Navigates to the "Beauty & Wellness" category on Naaptol.
-Interacts with product listings, filters, and sorting options.
-Verifies expected content and functionality.
-Takes screenshots for documentation.
-Generates an Extent Report for detailed test results.


*Design Decisions & Assumptions
-The project uses Cucumber framework for test automation.
-Selenium WebDriver is used for browser interaction.
-Java is the programming language for script development.
-The project assumes a stable internet connection and access to the Naaptol website.


*Installation & Getting Started
-Install Java: Ensure you have Java Development Kit (JDK) installed on your system.
-Install Maven: Download and install Apache Maven from https://maven.apache.org/.
-Clone the Repository: Clone this repository to your local machine.
-Build the Project: Open a terminal or command prompt, navigate to the project directory, and run mvn clean install.
-Run Tests: Execute the tests using mvn test.


Usage
The project is configured to run automated tests using Cucumber. The test scenarios are defined in feature files within the src/test/resources/features directory. 
To run specific scenarios, modify the TestRunner.java file to include the desired feature files.


*Technology Stack
-Java
-Selenium WebDriver
-Cucumber
-Maven
-Extent Reports



