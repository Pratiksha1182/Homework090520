package com.studentapp.model.loggingrequestresponse;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class LoggingResponseDetails extends TestBase {


    /**
     * This test will print out all the Response Headers
     */
    @Test
    public void test001() {
        System.out.println("---------------Printing Response Headers------------------");
        //home work
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200)
                .log().headers();

    }


    /**
     * This test will print the Response Status Line
     */
    @Test
    public void test002() {
        System.out.println("---------------Printing Response Status Line------------------");
        //home work
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200)
                .log().status();

    }


    /**
     * This test will print the Response Body
     */
    @Test
    public void test003() {
        System.out.println("---------------Printing Response Body------------------");
        //home work
        Response response = given()
                .when()
                .get("/99");
        response.then().statusCode(200)
                .log().body();

    }

    /**
     * This test will print the Response in case of an error
     */
    @Test
    public void test004() {
        System.out.println("---------------Printing Response Body in case of an error------------------");
        //home work
        StudentPojo studentPojo = new StudentPojo();

        studentPojo.setEmail("ompratiksha@gmail.com");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .patch("/100");
        response.then().log().body().statusCode(200);

    }

}
