package assignment.day03;

import baseUrl.CrudBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.crudOperationsAssignment.postPojo;

import static io.restassured.RestAssured.given;

public class T03_CrudOperation extends CrudBaseUrl
{

/*
Task: Write code that performs all CRUD operations on "activities"
using the Fake REST API at https://fakerestapi.azurewebsites.net
Requirements:
1. Use POJO classes for all operations
2. Implement CREATE (POST) - Add new activity
3. Implement READ (GET) - Retrieve activity details
4. Implement UPDATE (PUT) - Modify existing activity
5. Implement DELETE - Remove activity
6. Add appropriate assertions for each operation
*/
    @Test
    void activityOperations() {

        //1. CREATE (POST) - Add new activity
        postPojo payload = new postPojo(
                0,
                "New Activity",
                "2024-12-31T00:00:00Z",
                true);
        Response response = given(spec)
                .body(payload)
                .when()
                .post("/api/v1/Activities");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        postPojo createdActivity = response.as(postPojo.class);
        Assert.assertEquals(createdActivity.getDueDate(),payload.getDueDate());
        System.out.println("========================================");

        //2. READ (GET) - Retrieve activity details
        response = given(spec)
                .when()
                .get("/api/v1/Activities/7");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        postPojo getActivity= response.as(postPojo.class);
        Assert.assertEquals(getActivity.getCompleted(),false);
        System.out.println("========================================");

         //3. UPDATE (PUT) - Modify existing activity
        getActivity.setCompleted(true);
        response = given(spec)
                .body(getActivity)
                .when()
                .put("/api/v1/Activities/" +createdActivity.getId());
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        postPojo updateActivity=response.as(postPojo.class);
        System.out.println("========================================");


         //4. DELETE - Remove activity
        response = given(spec)
                .when()
                .delete("/api/v1/Activities/" +  createdActivity.getId());
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);

        given(spec).when().get("/api/v1/Activities/" +  createdActivity.getId())
                .then()
                .statusCode(404);
        System.out.println("========================================");

    }
}
