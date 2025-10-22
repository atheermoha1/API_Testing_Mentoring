package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static day05.T01_GoREST.createUser_02.userId;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.ObjectMapperUtils.getJsonNode;

public class partialUpdateUser_05 extends goRestBaseUrl {

    @Test
    void partialupdate(){

        //update by use new json file
        JsonNode payload =getJsonNode("T01_createUser(partialupdate)");

        //send request
        Response response = given(spec).body(payload).patch("/users/"+userId);
        response.prettyPrint();

        //the rest body from previous file
        JsonNode updatedJson=getJsonNode("T01_createUser");

        //do assertions
        response.then().statusCode(200)
                .body("email",equalTo(payload.get("email").asText()),
                        "status",equalTo(payload.get("status").asText()));
    }


}
