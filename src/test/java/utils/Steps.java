package utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;

public class Steps {
    public static Response GET(String endpoint){
        Allure.addAttachment("URL", baseURI + endpoint);
        Response response = get(endpoint);
        Allure.addAttachment("Response body", response.body().prettyPrint());
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));

        return response;
    }
}
