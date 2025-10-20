package assignment.day02;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T03_RestAssuredAPIResponseValidation {

        @Test
        void validateAPIResponse() {
            Response response = RestAssured.get("https://fakerestapi.azurewebsites.net/api/v1/Users");

            System.out.println("response statusCode = " + response.statusCode());
            System.out.println("response Headers = " + response.getHeaders());
            System.out.println("response.getHeader(Server) = " + response.getHeader("Server"));
            System.out.println("response.getHeader(Transfer-Encoding) = " + response.getHeader("Transfer-Encoding"));

            //validate
            Assert.assertEquals(response.statusCode(),200);
            Assert.assertTrue(response.getContentType().contains("application/json"));
            Assert.assertTrue(response.getHeader("Server").contains("Kestrel"));
            Assert.assertEquals(response.getHeader("Transfer-Encoding"),"chunked");
        }
    }

