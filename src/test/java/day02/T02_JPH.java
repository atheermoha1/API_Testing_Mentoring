package day02;

import baseUrl.JPHBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class T02_JPH extends JPHBaseUrl {
//    Given
//    https://jsonplaceholder.typicode.com/todos
//    When
//    I send GET request
//    Then
// 1) Status code = 200
// 2) Print all ids > 190 (10 total)
//            3) Print userIds with ids < 5 (4 total)
//            4) Verify title “quis eius est sint explicabo”
//            5) Find id where title = "quo adipisci enim quam ut ab"
//

    @Test
    void test() {
        Response response = given(spec).get("/todos");
        response.prettyPrint();
        response.then().statusCode(200);

        JsonPath jsonPath= response.jsonPath();

        List<Integer> ids190=jsonPath.getList("findAll{it.id>190}.id");
        System.out.println("ids that greater than 190 = "+ids190);

        List<Integer> ids5=jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("userIds with ids less than 5 = "+ids5);


        System.out.println(jsonPath.getBoolean("find{it.title=='quis eius est sint explicabo'}.title"));

        Integer idForTitle=jsonPath.getInt("find{it.title=='quo adipisci enim quam ut ab'}.id");
        System.out.println("id where title \"quo adipisci enim quam ut ab\" = "+idForTitle);


    }
}
