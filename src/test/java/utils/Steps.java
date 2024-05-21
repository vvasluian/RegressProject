package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.core.IsEqual.equalTo;

public class Steps {
    @Step
    public static Response GET(String endpoint) {
        Allure.addAttachment("URL", baseURI + endpoint);
        Response response = get(endpoint);
        Allure.addAttachment("Response body", response.body().prettyPrint());
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));

        return response;
    }

    @Step
    public static void isStatusCodeCorrect(Response response, int expectStatusCode) {
        response.then().assertThat().statusCode(expectStatusCode);
    }

    @Step
    public static Response POST(String body, String endpoint) {
        Allure.addAttachment("URL", baseURI + endpoint);
        Allure.addAttachment("Request body", body);
        Response response = given().body(body).post(endpoint);
        Allure.addAttachment("Status code", String.valueOf(response.statusCode()));
        Allure.addAttachment("Response body", response.body().prettyPrint());
        return response;
    }
    @Step
    public static void isBodyContain(Response response, String field , String expectedField){
        response.then().assertThat().body(field, equalTo(expectedField));
    }
}
