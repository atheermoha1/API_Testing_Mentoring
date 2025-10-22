package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static day05.T01_GoREST.createUser_02.userId;
import static io.restassured.RestAssured.given;
import static utilities.ObjectMapperUtils.getJsonNode;

public class deleteUser_06 extends goRestBaseUrl {

    @Test
    void deleteUser(){


        //send request
        Response response = given(spec).delete("/users/"+userId);
        response.prettyPrint();

        response.then().statusCode(204);



    }
}
