package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static day05.T01_GoREST.createUser_02.userId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class negativeTest_07 extends goRestBaseUrl {


    @Test
    void negativeUser(){

        //send request
        Response response = given(spec).delete("/users/"+1234);
        response.prettyPrint();

        //do assertion
        response.then().statusCode(404).body("message",equalTo("Resource not found"));



    }
}
