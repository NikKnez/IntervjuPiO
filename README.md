# IntervjuPiO

Welcome to the IntervjuPiO project! This project is a web application designed for interview learning through downloading documents in docx format.
*Read this in other languages: [Srpski](README.sr.md)

## Contents

- [Description](#description)
- [Technologies](#technologies)
- [Installation](#installation)
- [Running the Application](#running)
- [Usage](#usage)
- [Contributions](#contributions)

## Description

IntervjuPiO is an application that allows viewing and downloading documents with interview questions and answers. The application consists of a Spring Boot backend, a React frontend, and a MongoDB database.
## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot): A backend framework for Java applications.
- [React](https://reactjs.org/): A library for building interactive web applications.
- [MongoDB](https://www.mongodb.com/): A NoSQL database for storing documents.

## Installation

To install the project, follow these steps:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/NikKnez/intervjupio.git
    ```

2. **Navigate to the project directory:**
    ```bash
    cd intervjupio
    ```

3. **Install dependencies:**
    - For the backend:
        ```bash
        cd backend
        mvn clean install
        ```
    - For the frontend:
        ```bash
        cd frontend
        npm install
        ```

4. **Configure MongoDB:**
    - Set up the MongoDB database using MongoDB Atlas or another service.
    - Update `application.properties` in the `backend` directory with your database details.

## Running the Application

After installing the application, you can run it:

- **Start the backend:**
    ```bash
    cd backend
    mvn spring-boot:run
    ```

- **Start the frontend:**
    ```bash
    cd frontend
    npm start
    ```

After these steps, the application will be available at [http://localhost:3000](http://localhost:3000).

## Usage

- The application displays a list of available documents.
- By clicking on a document, you can download it in docx format.

## Live Demo

[Check out the live demo](https://intervjupio.netlify.app) IntervjuPiO.

## Contributions

We invite you to contribute to this project! Please fork the repository and create a pull request for any improvements or bug fixes.
**Developed by [NikKnez](https://github.com/NikKnez)**
