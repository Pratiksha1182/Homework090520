package in.reqres.users;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUsers extends TestBase {

@Test
public void getListOfUsers(){
    Response response = given()
            .param("page", 2)
            .when()
            .get("/list");
    response.then().statusCode(200)
            .log().body()
            .body("data.size()",equalTo(6));

}
@Test
public void getSingleUser(){
    Response response = given()
            .when()
            .get("/users/2");
    response.then().statusCode(200)
            .log().body()
            .body("data.first_name", equalTo("Janet"));

}
@Test
public void getSingleUserNotFound(){
    Response response = given()
            .when()
            .get("/users/23");
    response.then().statusCode(404);
}
}
