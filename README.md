# Form Yours Technology RestFul API

## Requirements

1. Java - 17
2. Maven - 4.0.0
3. JPA (Java Persistance API)
4. MySQL 8.0.27


## Documentation
Api Documentation already include this project,
[Click here](https://documenter.getpostman.com/view/5740451/2sAYBPnEoE))

| **Description** | **Request**                                                           | 
|-----------------|-----------------------------------------------------------------------|
| login           | curl -X POST http://localhost:8080/api/v1/auth/login                  | 
| create form     | curl -X POST http://localhost:8080/api/v1/form                        |  
| list form       | curl  http://localhost:8080/api/v1/form                               |
| detail form     | curl  http://localhost:8080/api/v1/form/{slug}                        |
| create question | curl -X POST http://localhost:8080/api/v1/form/{slug}/question        |
| delete question | curl -X DELETE http://localhost:8080/api/v1/form/{slug}/question/{id} |
| add answer      | curl -X POST http://localhost:8080/api/v1/form/{slug}/answer          |
| list answer     | curl  http://localhost:8080/api/v1/form/{slug}/answer                 |

## Demo
![Logo](https://devajayantha.github.io/assets/image-your-form/screenshoot_1.png)
![Logo](https://devajayantha.github.io/assets/image-your-form/screenshoot_2.png)
![Logo](https://devajayantha.github.io/assets/image-your-form/screenshoot_3.png)

## Thank You