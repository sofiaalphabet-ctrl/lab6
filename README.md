# Event Registration Console Application

## Description
This is a Java console application for managing event registrations. It allows users to add, view, search, filter, and delete registrations.

## Requirements
- JDK 17 or later
- Gradle Wrapper

## How to Run
1. Open the project folder in Visual Studio Code.
2. Open the terminal in the project directory.
3. Run the application using:

   `.\gradlew.bat run`

4. To build the project, run:

   `.\gradlew.bat build`

## Classes
- **Registration.java** — stores registration information: ID, full name, email, student group, and event title.
- **RegistrationManager.java** — manages registrations, validates input data, searches by ID, filters by event, and deletes registrations.
- **Main.java** — displays the menu and handles user input.

## Available Events
- Web Design Workshop
- JavaScript Quiz
- IT Career Talk

## Data Storage
Registration data is stored in an `ArrayList` in memory. Data is not saved after the application is closed.