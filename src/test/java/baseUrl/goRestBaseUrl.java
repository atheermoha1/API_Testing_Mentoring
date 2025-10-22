package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class goRestBaseUrl {
    protected RequestSpecification spec;
    private String token="2415f810a2dfbdf8f452cc6866628d40eb1a70b7172af635b0d5b6a64da01b8a";
    @BeforeMethod
    public void setSpec(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v2")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer "+token)
                .build();
    }
}
