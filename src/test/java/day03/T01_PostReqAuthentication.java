package day03;

import baseUrl.RegresBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.users;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class T01_PostReqAuthentication extends RegresBaseUrl {
    /*
Given: Base URL: https://reqres.in/api/users
Request Body:
{
"name": "morpheus",
"job": "leader"
}
When: Send a POST request to the URL
Then: Assert the status code is 201
Verify the response body matches the structure:
{
"name": "morpheus",
"job": "leader",
"id": "496",
"createdAt": "2022-10-04T15:18:56.372Z"
}
*/

    @Test
    void postReqAuthenticationPojo(){

        spec.pathParam("first","users");

        users payload= new users("morpheus","leader");

        Response response =given(spec)
                .body(payload)
                .when()
                .post("/{first}");
                response.prettyPrint();

        users actualData= response.as(users.class);
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(actualData.getName(),payload.getName());
        Assert.assertEquals(actualData.getJob(),payload.getJob());
    }

    @Test
    void postReqAuthenticationMap(){
        spec.pathParam("first","users");

        Map<String,String> payload= new HashMap<>();
        payload.put("name","morpheus");
        payload.put("job","leader");

        Response response = given(spec).body(payload).when().post("/{first}");
        response.prettyPrint();

        Map<String,String> actualData= response.as(HashMap.class);
        Assert.assertEquals(response.statusCode(),201);
        // actualData.get("the actual field appears in the body")
        Assert.assertEquals(actualData.get("name"),payload.get("name"));
        Assert.assertEquals(actualData.get("job"),payload.get("job"));


    }
}
