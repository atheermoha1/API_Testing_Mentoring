package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class RegresBaseUrl {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setSpec(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .addHeader("x-api-key","reqres-free-v1")
                .setContentType(ContentType.JSON)
                .build();
    }
}
