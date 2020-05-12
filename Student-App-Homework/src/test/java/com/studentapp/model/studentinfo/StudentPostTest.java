package com.studentapp.model.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.model.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;


public class StudentPostTest extends TestBase {

@Test
public void createNewStudent(){
    StudentPojo studentPojo=new StudentPojo();
    studentPojo.setFirstName("Pratiksha");
    studentPojo.setLastName("Patel");
    studentPojo.setEmail("preet123@gmail.com");
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
            .post();
    response.then().statusCode(201);
    response.prettyPrint();
}
@Test
    public void createNewStudentWithEmptyFirstName(){
    StudentPojo studentPojo=new StudentPojo();
    studentPojo.setFirstName("  ");
    studentPojo.setLastName("Patel");
    studentPojo.setEmail("preet2810@gmail.com");
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
            .post();
    response.then().statusCode(201);
    response.prettyPrint();

}
@Test
    public void createNewRecordWithEmptyLastName(){
    StudentPojo studentPojo=new StudentPojo();
    studentPojo.setFirstName("Apurva");
    studentPojo.setLastName(" ");
    studentPojo.setEmail("apurva2810@gmail.com");
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
            .post();
    response.then().statusCode(201);
    response.prettyPrint();

}
@Test
    public void createNewRecordFirstNameWithNull(){
    StudentPojo studentPojo=new StudentPojo();
    studentPojo.setFirstName("Null");
    studentPojo.setLastName("Om");
    studentPojo.setEmail("apurvaom@gmail.com");
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
            .post();
    response.then().statusCode(201);
    response.prettyPrint();


}
@Test
    public void createRecordWithEmptyFirstNameAndLastName(){
    StudentPojo studentPojo=new StudentPojo();
    studentPojo.setFirstName(" ");
    studentPojo.setLastName(" ");
    studentPojo.setEmail("om123@gmail.com");
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
            .post();
    response.then().statusCode(201);
    response.prettyPrint();



}

}




