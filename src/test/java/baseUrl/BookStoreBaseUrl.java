package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static assignment.day05.T02_BookstoreAPI.token;

public class BookStoreBaseUrl {

   // private String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkpvaG4uMSIsInBhc3N3b3JkIjoiSm9obkRvZTEyKiIsImlhdCI6MTc2MTE1MTI4OX0.S7cwhQodm2zh_CcUwkTtF-vbRgfzOPySw68cNxrPWzY";
    protected RequestSpecification spec;


    @BeforeMethod
    public void setSpec(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://bookstore.demoqa.com")
                .addHeader("Authorization","Bearer "+token)
                .setContentType(ContentType.JSON)
                .build();
    }

}