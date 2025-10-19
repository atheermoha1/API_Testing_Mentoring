package day02;

import baseUrl.EmployeeBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class T03_Employees extends EmployeeBaseUrl {
    //    Given
//    https://dummy.restapiexample.com/api/v1/employees
//    When
//    User sends GET request
//    Then
//    Status code is 200
//    And
//    There are 24 employees
//            And
//"Tiger Nixon" and "Garrett Winters" are among them
//            And
//    Highest age = 66
//    And
//            Youngest = "Tatyana Fitzpatrick"
//    And
//    Total salary = 6,644,770


    @Test
    void test(){
        Response response= given(spec).get("/api/v1/employees");

        response.prettyPrint();
        response.then().statusCode(200);

        JsonPath jsonPath=response.jsonPath();
//    There are 24 employees
        int employee=jsonPath.getList("data.id").size();
        System.out.println("Employee count = "+employee);
//    "Tiger Nixon" and "Garrett Winters" are among them
        Boolean contanNames= jsonPath.getList("data.employee_name").containsAll(java.util.Arrays.asList("Tiger Nixon","Garrett Winters"));
        System.out.println("Contain names = "+contanNames);
//    Highest age = 66
        int age= jsonPath.getInt("data.max{it.employee_age.toInteger()}.employee_age");
        System.out.println("Highest age = "+age);
//   Youngest = "Tatyana Fitzpatrick"
        String youngestName= jsonPath.getString("data.min{it.employee_age.toInteger()}.employee_name");
        System.out.println("youngest name's person = "+youngestName);
//    Total salary = 6,644,770
        int totalSalary = jsonPath.getInt("data.collect{it.employee_salary.toInteger()}.sum()");
        System.out.println("Total salary = "+totalSalary);
        Assert.assertEquals(totalSalary,6644770);




    }
}
