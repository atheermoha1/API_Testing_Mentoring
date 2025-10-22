package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static day05.T01_GoREST.createUser_02.userId;
import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.getJsonNode;

public class getUser_03 extends goRestBaseUrl {

    @Test
    void getUser(){

        Response response = given(spec).when().get("/users/"+userId);
        response.prettyPrint();

        //do assertion
        response.then().statusCode(200);

    }
}
