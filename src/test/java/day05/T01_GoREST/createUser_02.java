package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.getJsonNode;

public class createUser_02 extends goRestBaseUrl {

public static int userId;
    @Test
    void createUser(){

        //prepare payload
        JsonNode payload= getJsonNode("T01_createUser");
        //System.out.println(payload.toPrettyString());

        Response response = given(spec).body(payload).when().post("/users");

        response.prettyPrint();
        response.then().statusCode(201)
                .body("name",equalTo(payload.get("name").asText()),
                "gender",equalTo(payload.get("gender").asText()));

        userId= response.jsonPath().getInt("id");
        System.out.println("userId = " + userId);


    }



}
