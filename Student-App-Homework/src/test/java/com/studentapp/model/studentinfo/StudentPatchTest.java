package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class StudentPatchTest extends TestBase {
    @Test
    public void studentNameUpdateByEmailId(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Pratiksha");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("ompratiksha@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        List<String> course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCources(course);
        Response response = given()
                .header("Content-Type", "application/json")
                .log().body()
                .body(studentPojo)
                .patch("/99");
        response.then().statusCode(200);
        response.prettyPrint();


        given()
                .header("Content-Type","application/json")
                .body(studentPojo)
                .patch("/99")
                .then();
        get("/list").then().body("[98].email",equalTo("ompratiksha@gmail.com"));


    }
}
