package com.studentapp.model.studentinfo;


import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class StudentGetTest extends TestBase {


    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
    }

    @Test
    public void searchStudentWithParameter() {
        Response response =given()
                .param("programme", "Computer Science")
                .param("limit", 2)
                .when()
                .get("/list");
        response.then().statusCode(200);
    }
    @Test
    public void searchaStudentById(){
        Response response =given()
                .param("id","3")
                .when()
                .get("/3");
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
    }
   /* @Test
    public void searchStudentByLastName(){
        Response response =given()
                .param("lastName","Holmes")
                .when()
                .get("/list");
        response.then().statusCode(200);
        System.out.println(response.prettyPrint());
*/
    //}
    @Test
    public void searchStudentByProgramme(){

        given()
                .param("programme","Financial Analysis")
                .when()
                .get("/list")
                .then()
                .body("programme.size()",equalTo(10));

    }



}
