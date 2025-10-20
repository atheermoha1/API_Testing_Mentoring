package day03;

import baseUrl.PetStoreUserBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.petStore;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class T02_petStore extends PetStoreUserBaseUrl {
/*
    Task: Write an automation test that creates a 'user' using the
    Petstore API at https://petstore.swagger.io/
    Requirements:
    Review the Petstore API documentation
    Identify the endpoint for creating users (/user)
    Create User POJO with all required fields
    Implement POST request to create user
    Validate successful creation with assertions
*/
    @Test
    void createUserTest(){

       petStore payload= new petStore(
               20,
               "JohnDoe",
               "John",
               "Doe",
               "john1@yahoo.com",
               "john123Doe",
               "0533412096",
               0);

        Response response= given(spec).body(payload).when().post("/user");
        response.prettyPrint();


        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("code",200);
        expectedData.put("type","unknown");
        expectedData.put("message","20");

        Map<String,Object> actualData=new HashMap<>();
        actualData=response.as(HashMap.class);

        assertEquals(actualData.get("code"),expectedData.get("code"));
        assertEquals(actualData.get("type"),expectedData.get("type"));
        assertEquals(actualData.get("message"),expectedData.get("message"));
        assertEquals(response.statusCode(), 200);

    }
}
