package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class goRestBaseUrl {
    protected RequestSpecification spec;
    private String token="2fbcba417ada092d23ba7ea4820cd2ff0825a31ae3ef905f7a3c10e0f534f54b";
    @BeforeMethod
    public void setSpec(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v2")
                .addHeader("Authorization","token="+token)
                .build();
    }
}
