package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class StudentDeleteTest extends TestBase {
    @Test
    public void deleteStudentById(){
        StudentPojo studentPojo = new StudentPojo();

        Response response = given()
                .header("Content-Type", "application/json")
                .log().headers()
                .body(studentPojo)
                .delete("/109");
        response.then().statusCode(204);
        System.out.println(response.prettyPrint());


    }
}
