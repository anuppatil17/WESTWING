# WESTWING

- Verify When Wishlist Product added and delete successfully.

#Overview :

- I have follow POM to define Web elements and Step definition as per West Wing pages.

- And follow BDD Cucumber Framework.

- Use Docker environment to Run scripts in Chrome and Firefox browsers. 

- For dependencies management use MAVEN framework.


Tools : Selenium ,Cucumber , Maven , Junit , Docker.

Prerequisite : System should have 
- Docker install 
- Maven Plugin
- JAVA

# Execution Steps:

- **Step 1:** Run Docker compose file from WESTWING directory

Run this command from src directory : ` docker-compose -f docker-compose.yml up -d`

- **Step 2:** Then run scripts using below command to triggered Test

Run this command from src directory : `mvn test`


For Test Summary We can find Screen Shots inside  `src/ScreenShots`



