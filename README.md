# TestAutomation
This project contains test-script for executing a test-scenario for the coding challenge 
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing purpose. 
### Prerequisites

1. Install Java, make sure jdk is installed too. 
2. Set “JAVA_HOME” variable as Windows environment variable
3. Install Apache Maven: Go to "http://maven.apache.org/download.cgi" and download "apache-maven-3.2.2-bin.zip".
4. Unzip "apache-maven-3.2.2-bin.zip" to "C:\Program Files\" (You can unzip it to any folder you want to)
5. Add both M2_HOME and MAVEN_HOME variables in the Windows environment, and point it to your Maven folder
   Eg: M2_HOME : C:\Program Files\apache-maven-3.5.4
       MAVEN_HOME : C:\Program Files\apache-maven-3.5.4
       Path : C:\Program Files\apache-maven-3.5.4\bin
6. To check for mvn version, go to command prompt and type mvn -version
7. Install git to clone project
### Steps to clone project
1. Copy url from git repository Eg: Here copy Url "https://github.com/twinklejoshi/TestAutomation.git"
2. Open Git Bash and enter following command
```
$ git clone https://github.com/twinklejoshi/TestAutomation.git
```
3. Make sure project is cloned successfully
### Steps to execute test
1. Open Command prompt
2. Make it point to the test project that we just cloned from git. Eg: My test project is RealtorTestAutomation which is in TestAutomation Repository. PS: It should point to project not just till repository
```
$ cd C:\Users\twink\TestAutomation\RealtorTestAutomation
$ C:\Users\twink\TestAutomation\RealtorTestAutomation>
```
3. Now enter following command
```
$ mvn clean install
```
