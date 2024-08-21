# Course Management System

This Course Management System is a Spring Boot-based application designed to manage courses and their delivery instances. The system provides a set of RESTful APIs that allow you to create, retrieve, and delete courses and their corresponding delivery instances. The application ensures that all course data is properly managed and offers exception handling to maintain data integrity, particularly when attempting to delete courses with existing delivery instances.

## Features

- Create new courses and instances of course deliveries.
- Retrieve detailed information about existing courses and their instances.
- You can't delete a course before deleting a delivery instance. However, I have added an exception to handle it so it can't cause an error.

## Docker Integration

Here is the Docker Hub account https://hub.docker.com/u/ashutoshrajput81. The Docker images for both the backend and frontend of this application are available on Docker Hub.

- **Backend (Spring Boot)**: `ashutoshrajput81/course_springboot`
- **Frontend (React)**: `ashutoshrajput81/course_react`

### Running the Application

1. Clone this repository to your local machine.
2. Ensure Docker is installed and running.
3. Use Docker Compose to build and run the containers.
