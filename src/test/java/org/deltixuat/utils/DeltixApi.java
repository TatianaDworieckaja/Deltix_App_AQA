package org.deltixuat.utils;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.deltixuat.models.PostTradeResponse;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DeltixApi {
    public String getToken() {

        Map<String, String> params = new HashMap<>();
        params.put("password", Settings.getPassword());
        params.put("username", Settings.getUserName());
        params.put("grant_type", "password");
        params.put("scope", "deltix.axa.user");
        String token = given().relaxedHTTPSValidation().header("Authorization", "Basic d2ViYXBwOg==")
                .post(Settings.getBaseUrl() + "/oauth/token").then().assertThat()
                .statusCode(HttpStatus.SC_OK).extract().path("access_token");
        System.out.println("Rest assured extracted token " + token);
        return token;
    }

    public PostTradeResponse getAlgoPerformanceGridResponse() {
        return given().relaxedHTTPSValidation().header("Authorization", "bearer" + getToken())
                .contentType(ContentType.JSON)
                .body(new File("src/test/resources/PostTradeOrdersPayload.json"))
                .queryParam("benchmarkType", "Mid")
                .post(Settings.getBaseUrl() + "/api/v1/post-trade/orders/query").then().assertThat()
                .statusCode(HttpStatus.SC_OK).extract().response().as(PostTradeResponse.class);
    }

}
