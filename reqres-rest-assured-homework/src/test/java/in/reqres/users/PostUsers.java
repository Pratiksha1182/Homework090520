package in.reqres.users;

import in.reqres.UserPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static in.reqres.UserPojo.getRandomString;
import static io.restassured.RestAssured.given;

public class PostUsers extends TestBase {

    String name = "Pratiksha" + getRandomString(2);
    String job = "Patel" + getRandomString(2);
    String email = "pratiksha@reqres.in";
    String password = "abc" +getRandomString(3);

    @Test
    public void postNewUser(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/users");
        response.then().statusCode(201)
                .log().body();

    }
    @Test
    public void registerUserSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");
        userPojo.setPassword(password);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(200)
                .log().body();
    }
    @Test
    public void userRegisterUnsuccessful(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail("eve.holt@reqres.in");


        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/register");
        response.then().statusCode(400)
                .log().body();

    }
    @Test
    public void loginSuccessfull(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email = "eve.holt@reqres.in");
        userPojo.setPassword(password);

        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(200)
                .log().body();
    }
    @Test
    public void loginUnsusscessfull(){
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email);


        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .body(userPojo)
                .post("/login");
        response.then().statusCode(400)
                .log().body();
    }

    }

