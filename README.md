# kotlin-todo-app
todo-app-by-kotlin

## run
```
// (1) 로컬에 디비 컨테이너 실행
$ docker-compose up -d

// (2) 로컬 실행
$ ./gradlew bootRun
```

## http endpoint
* GET 
    * localhost:8080/todos-memory
    * localhost:8080/todos
    * localhost:8080/todos/{id} 
* POST 
    * localhost:8080/todos content-type: Application/json
* PUT 
    * localhost:8080/todos/{id} content-type: Application/json      
* DELETE 
    * localhost:8080/todos/{id}