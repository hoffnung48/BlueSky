# BLUE Sky
API 


# READ ME PLEASE


prerequisites


  - Java 8
  -  Docker(if uses docker to run)


This is the Blue Sky assessment than can be run by


    - Eclipse IDE
    - Executable JAR
    - Docker


Note: for docker and executable jar the commands must be run from projects root directory


# For Eclipse


  - Import the project as Gradle Project 
  - Run as SpringBoot App


# For Executable Jar


  - In command line run
  
    - for Gradle 
    - Gradlew build
    - cd build/libs
    - java - jar [Generated jarName]

	- for Maven
    - mvn Clean install	
    - mvn spring-boot:run

# For Docker  


  - Gradlew build
  - docker build -t bluesky .
  - docker run -p 12000:12000 bluesky


Once the App Starts


We have to URls to test

open http://localhost:12000 to test it

**Welcome to the Blue Sky API**