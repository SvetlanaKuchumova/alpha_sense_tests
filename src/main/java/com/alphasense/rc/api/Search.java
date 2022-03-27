package com.alphasense.rc.api;

import com.alphasense.rc.pojo.RcResponse;
import io.qameta.allure.Step;

import static com.alphasense.rc.enums.Documents.ALPHA_SENSE_DOC_API;
import static io.restassured.RestAssured.given;

public class Search extends RcResponse{

    @Step("Enter in text field text: \"{0}\"")
    public RcResponse searchInText(String keyword){
        return given()
                .when()
                .queryParam("keyword", keyword)
                .get(ALPHA_SENSE_DOC_API.getValue())
                .as(RcResponse.class);
    }
}
