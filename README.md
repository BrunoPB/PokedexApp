# PokedexApp
Simple Pokedex Application to study databases connection and http request response. Using: MySQL, Java, Maven, Spark, Angular
Starting at June, 24, 2021
Ended at July 17, 2021

Steps to install the app:
1. Install Angular CLI, MySQL, Maven and JDK
2. Setup your own MySQL database
3. Download the repository
4. Adapt the /backend/src/main/resources/application.properties to your own database
5. Start the backend at to setup the database tables
6. Stop the backend application (Ctrl + C)
7. Adapt the /pokemonsDatabase/addToDatabase/DAO.java to your own database
8. Set the classpath at /pokemonsDatabase/addToDatabase. Use command: `export CLASSPATH=mysql-connector-java-8.0.25.jar:.`
9. Compile /pokemonsDatabase/addToDatabase/Main.java -> `javac Main.java`
10. Start the /pokemonsDatabase/addToDatabase/Main to add all pokemons to the database -> `java Main`
11. Install frontend dependencies at /frontend -> `npm install` and `ng add @angular/material`
12. Start the backend and frontend
13. Open the browser on localhost:4200
14. Enjoy! :)

To start the frontend: at /frontend -> `ng s`
To start the backend: at /backend -> `mvn spring-boot:run`
