# Description
This is Spring boot application for my interview. This project is an example of a simple user authentication service.

# How to run
## Requirements
* Java 8 or higher
* Maven
* Docker (optional)

<hr>

1. Clone the repository to your local computer:
```
git clone https://github.com/nomadbala/spring-boot-rest-api.git
```

2. Build and run the project using Docker:
```
docker-compose up
```

# Endpoints

<hr>

## Authentication controller
```
POST /api/v1/auth/
```

## User authentication
```
POST /api/v1/auth/register
```

## User login
```
POST /api/v1/auth/login
```

<hr>

## News controller
```
/api/v1/news
```

##  Get all news
```
GET /api/v1/news
```

<hr>

## Request controller
```
/api/v1/requests
```

## Get all requests
```
GET /api/v1/requests
```

## Save request
```
POST /api/v1/requests/save_request
```

## Delete request
```
DELETE /api/v1/requests/delete_request/{id}
```

## Update request
```
PUT /api/v1/requests/update_request
```

## Get request by id
```
GET /api/v1/requests/{id}
```

<hr>

## User controller
```
/api/v1/users
```

## Get all users
```
GET /api/v1/users
```

## Save user
```
POST /api/v1/users/save_uesr
```

## Delete user
```
DELETE /api/v1/users/delete_user/{email}
```

## Get user by login
```
GET /api/v1/users/{login}
```

<hr>
# API Documentation
The API documentation is available at http://localhost:8080/swagger-ui.html after running the application.

<hr>
# License
This project is licensed under the APGL-3.0 license - see the LICENSE file for details.
