package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class StudentPutTest extends TestBase {
    @Test
    public void studentNameUpdateById(){
        StudentPojo studentPojo=new StudentPojo();
        studentPojo.setFirstName("Pratiksha");
        studentPojo.setLastName("Patel");
        studentPojo.setEmail("preet12@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        List<String>course=new ArrayList<>();
        course.add("Selenium");
        course.add("Java");
        course.add("Api Testing");
        studentPojo.setCources(course);
        Response response=given()
                .header("Content-Type","application/json")
                .log().headers()
                .when()
                .body(studentPojo)
                .put("/99");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
