package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class getAllUsers_01 extends goRestBaseUrl {

    @Test
    void allUsers() {
        //send arequest
        Response response = given(spec).contentType(ContentType.JSON).get("/users");
        response.prettyPrint();

        //do assertion

        response.then().statusCode(200).body("[0].id",notNullValue());

    }
}