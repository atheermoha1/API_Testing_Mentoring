package day05.T01_GoREST;

import baseUrl.goRestBaseUrl;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.Test;

import static utilities.ObjectMapperUtils.getJsonNode;

public class createUser_02 extends goRestBaseUrl {

    @Test
    void createUser(){

        //prepare payload
        JsonNode payload= getJsonNode("T01_createUser");
        System.out.println(payload.toPrettyString());

    }



}
