# spring-rest-app
This app is to Demonstrate Spring Rest Api using the following technologies

Spring 4
Hibernate 4
MySql
Swagger


Instructions

1) Execute the build.sql present in spring-rest-app/src/main/resources/build.sql

The details of the MySql database are

jdbc.url = jdbc:mysql://localhost:3306/test
jdbc.username = root
jdbc.password =

2) Build the application using maven and deploy in Tomcat 7.2
mvn install 
In the target folder you will be having the spring-rest-app.war

Just copy to webapps folder in tomcat and start tomcat.


3) Test cases

Swagger Api Docs Link :http://localhost:8080/api-docs

a) Find all Users in the database

http://localhost:8080/users/all

Output: Lists all users in the Db.

[
{
id: 1,
firstName: "Allyn",
lastName: "Smith",
email: "allyn@gmail.com",
username: "allyn",
currentCity: "Los angeles",
profession: "Software Engineer",
gender: "M",
companyName: "MGO"
},
{
id: 2,
firstName: "John",
lastName: "Smith",
email: "john@gmail.com",
username: "john",
currentCity: "NewYork",
profession: "Software Engineer",
gender: "M",
companyName: "Hulu"
},
{
id: 3,
firstName: "Keanu",
lastName: "Smith",
email: "keanu@gmail.com",
username: "keanu",
currentCity: "CulverCity",
profession: "Software Engineer",
gender: "M",
companyName: "NBC Studios"
},
{
id: 4,
firstName: "David",
lastName: "Tinsley",
email: "david@gmail.com",
username: "david",
currentCity: "Westwood",
profession: "Software Engineer",
gender: "M",
companyName: "Netflix"
}
]

b) Find the status of DB

http://localhost:8080/users/status

Output:

DB is up

c)Filter User by city 

http://localhost:8080/users/filter/city/NewYork

http://localhost:8080/users/filter/city/westwood
Output:
[
  {
    "id": 4,
    "firstName": "David",
    "lastName": "Tinsley",
    "email": "david@gmail.com",
    "username": "david",
    "currentCity": "Westwood",
    "profession": "Software Engineer",
    "gender": "M",
    "companyName": "Netflix"
  }
]

d) Filter User By Company Name

http://localhost:8080/users/filter/company/Hulu

http://localhost:8080/users/filter/company/MGO

e) Authentication of User

curl -H "Content-Type: application/json" -X POST -d '{"username":"allyn","password":"password"}' http://localhost:8080/users/login

MacBook-Pro:Applications srinathmedala$ curl -H "Content-Type: application/json" -X POST -d '{"username":"allyn","password":"password"}' http://localhost:8080/users/login
success

MacBook-Pro:Applications srinathmedala$ curl -H "Content-Type: application/json" -X POST -d '{"username":"allyn","password":"pd"}' http://localhost:8080/users/login
failure

