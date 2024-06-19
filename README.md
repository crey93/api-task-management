# api-task-management

## Description
API for task management, create and read all the tasks.

## Getting Started

### By IDE bulding and running:
```bash
./gradlew clean build
```

```bash
./gradlew bootRun
```

NOTE: You should have a mongo db instance running on your machine, the next
option creates a mongo db instance for you.

### By using docker compose
```bash
docker-compose up -d
```

## You will see the API working on http://localhost:8080

## API Documentation
You can see the API documentation on http://localhost:8080/swagger-ui.html

## Request examples

### Create a task
```bash
curl --location 'localhost:8080/api/v1/task/create' \
--header 'Content-Type: application/json' \
--data '{
    "title":"Task1",
    "description":"the description",
    "dueDate":"2024-06-26",
    "tags":["a","b", "c"]
}'
```

### Get all tasks
```bash
curl --location 'localhost:8080/api/v1/task/get-all'
```

