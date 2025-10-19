package day02;

import baseUrl.BookersBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class T01_Booker extends BookersBaseUrl {

//    Example 1
//    Given
//    https://restful-booker.herokuapp.com/booking/32
//    When User sends GET request
//    Then Status Code: 200
//    And Content Type: application/json
//    And
//    firstname: "Josh"
//    lastname: "Allen"
//    totalprice: 111

    @Test
    public void getRequest() {
        Response response = given(spec).get("booking/32");

        response.prettyPrint();
        response.then()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("John"))
                .body("lastname", equalTo("Smith"))
                .body("totalprice", equalTo(111));
        ;
    }
}
