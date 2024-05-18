package tests;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static utils.Steps.GET;

public class TestRegress {
    @BeforeSuite
    public void setUp(){
        baseURI ="https://reqres.in/api";
    }

    @Test
    public void testListOf(){
        String url = "/users?page=2";
        Response response = GET(url);
        response.then().assertThat().statusCode(200);

    }
    @Test
    public void getSingleUser(){
        String url = "/users/2";
        Response response = GET(url);
        response.then().assertThat().statusCode(200);

    }
}
