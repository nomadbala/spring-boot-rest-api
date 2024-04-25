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
git clone https://github.com/nomadbala/spring_for_interview.git
```

2. Go to the project directory:
```
  cd spring_for_interview
```

3. Build the project using Maven:
```
mvn clean install
```

4. Run project
```
mvn spring-boot:run
```
<hr>

# Endpoints
<hr>
## Authentication controller
```
POST /api/v1/auth/register
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
