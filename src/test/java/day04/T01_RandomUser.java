package day04;

import baseUrl.RandomUserBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.randomUser.RandomUser;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class T01_RandomUser extends RandomUserBaseUrl {
    /*
    Task 1: Random User API - GET Request with POJO Deserialization
Objective: Write an automation test that validates user data from a random user API endpoint.
Requirements:
Send a GET request to https://randomuser.me/api
The response will contain random user information in nested JSON structure
Deserialize the response into a POJO class
Assert that the following fields are NOT null:
Email
Username
Password
Medium picture URL
     */

    @Test
    void randomUserPojo(){
        //send request
        Response response= given(spec).get("/api");
        response.prettyPrint();

        //prepare payload
        RandomUser actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),RandomUser.class);

        //do assertion
        Assert.assertNotNull(actualData.getResults().get(0).getEmail());
        Assert.assertNotNull(actualData.getResults().get(0).getLogin().getUsername());
        Assert.assertNotNull(actualData.getResults().get(0).getLogin().getPassword());
        Assert.assertNotNull(actualData.getResults().get(0).getPicture().getMedium());



    }
}
