package tests;


import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Steps.*;

public class TestRegress {
    @BeforeSuite
    public void setUp(){
        baseURI ="https://reqres.in/api";
    }

    @Test
    public void testListOf(){
        String url = "/users?page=2";
        Response response = GET(url);
        isStatusCodeCorrect(response,200);

    }
    @Test
    public void getSingleUser(){
        String url = "/users/2";
        Response response = GET(url);
        isStatusCodeCorrect(response,200);

    }
    @Test
    public void testCreate(){
        String url ="/users";

        String body="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = POST(body,url);
        isStatusCodeCorrect(response,201);
        isBodyContain(response,"name","name");

    }
}
