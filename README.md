# Assumption of Business Logic
Each shop has its unique menu items, i.e. `Shop` to `Menu Item` is a bidirectional `OneToMany` relationship.

# Environment Requirement
* Internet connection
* Preferably Linux with Maven, Curl and Java 21 (Compiler and JRE)

# How to Compile and Run
`cd` to this project home directory, where pom.xml is located
* Application starts after executing the file `ShoppingApplication.java`


# Technology used
* Spring Boot with Java 21
* Hibernate 
* Spring JPA
* Maven
* H2 embedded in-memory database with its SQL Dialect for inserting initial data (just for testing purpose).

# REST API Description
* List all shops: `GET http://localhost:8080/shops`
* Add a new shop: `POST http://localhost:8080/shops`
* Get specific shop (by id with all menu items' details listed i.e. list all menu items with a specific shop): `GET http://localhost:8080/shops/full/{id}`
* Update shop details (identified by id): `PUT http://localhost:8080/shops/{id}`
* Delete specific shop (identified by id): `DELETE http://localhost:8080/shops/{id}`
* List all menu items of the Web store: `GET http://localhost:8080/memu-items`
* Basic search by menu item's name (should return all menu items whose name contains the search term): `GET http://localhost:8080/menu-items?name={menu item's name}`
* List all menu items of specific shop: `GET http://localhost:8080/menu-items?shop-id={id}`
* Add new menu item to specific shop: `POST http://localhost:8080/menu-items`
* Get specific menu item details: `GET http://localhost:8080/menu-items/{id}`
* Update menu item details (by menu item id): `PUT http://localhost:8080/menu-items/{id}`
* Delete specific menu item: `DELETE http://localhost:8080/menu-items/{id}`

# Example request body for POST/PUT requests
* Shop : POST/PUT request's request body

`{
"name":"Shop-F",
"city":"Kolkata",
"address":"Sector-2",
"email":"shop5@gmail.com",
"phone":"0707 716 328",
"open_at":"11:00:00",
"close_at":"22:00:00"
}`
* Menu Item : POST/PUT request's request body

`{
 "name":"Milk Shake", 
 "size":"L", 
 "key_ingredients":"Milk, Sugar", 
 "price":10, 
 "shop_id":2
}`

