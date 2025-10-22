package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static day05.T01_GoREST.createUser_02.userId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.getJsonNode;

public class updateUser_04 extends goRestBaseUrl {


    @Test
    void updateUser(){

        //update by use new json file
        JsonNode payload =getJsonNode("T01_createUser(updated)");

        //send request
        Response response = given(spec).body(payload).put("/users/"+userId);
        response.prettyPrint();

        //do assertions
        response.then().statusCode(200)
                .body("name",equalTo(payload.get("name").asText()),
                        "gender",equalTo(payload.get("gender").asText()),
                        "email",equalTo(payload.get("email").asText()),
                        "status",equalTo(payload.get("status").asText()));
    }
}
