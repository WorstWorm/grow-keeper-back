# GrowKeeper Backedn Application

This repository contains the backend code for GrowKeeper application.
GrowKeeper is a plant management system that helps you keep track of your plants and care routines.

**ATTENTION**
this application is not for commercial use and **is not** a precise tool ensuring the proper functioning of the garden.
It is primarily a programming exercise.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)

## Features

- View and manage plant areas (pots, boxes etc.).
- View weather information based on location (based on OpenWeather API; available only via REST API - so far not supported by the frontend application).
- Learn about the characteristics of the plants you have planted in your garden (based on FreePlant API).
- Based on the current weather forecast (updated every 3 hours or after changes in your garden), generate events such as watering or protecting plants from harsh and mark them as completed when they are done.
- Upload plant images and identify plant species (based on PlantNet API; available only via REST API - so far not supported by the frontend application).

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- Apache HttpClient
- MySql
- REST
- Maven
- Lombok
- Jackson JSON

## Getting Started

- Clone the repository to your local machine.
- Open the project in your preferred Java development environment.
- Make sure you have Java and Maven installed on your machine.
- Build and run the application.
- To conveniently use the application, use the frontend application available in a separate repository.

## API Endpoints

The application provides the following API endpoints (available on port 8081 after startup):

### Area Controller
- GET /area - Retrieve a list of all gardening areas stored currently in DB.
- GET /area/{areaId} - Retrieve details of a specific gardening area in DB.
- POST /area - Create a new empty gardening area in DB.
- PUT /area/{areaId} - Update details (insolation, cover, plant) of a specific gardening area in DB.
- DELETE /area/{areaId} - Delete a specific gardening area.

### Event Controller
- GET /event - Retrieve a list of all gardening events stored currently in DB.
- PUT /event/{eventId} - Toggle the completion status of a specific gardening event.

### Location Controller
- GET /location - Retrieve the current garden location.
- POST /location - Change garden location.

### Plant Controller
- GET /plant - Retrieve a list of all plants stored currently in DB.
- GET /plant/{plantName} - Retrieve details of a specific plant by its scientific name from those stored in DB.

### Weather Controller
- GET /weather - Retrieve a list of all weather entries stored currently in DB.

### FreePlantController
- GET /freeplant/{plant} - Retrieve information about a specific plant (using its name) from FreePlant external API and download it to local DB.

### OpenWeather Controller
- GET /openweather/{city} - Update location details in DB based on the city name.
- GET /openweather/{lat}/{lon} - Update weather details in DB based on latitude and longitude coordinates.

### PlantNet Controller
- POST /plantnet/ - Upload an image of a plant and get its scientific name using the PlantNet external API.
