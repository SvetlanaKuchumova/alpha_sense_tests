package baseTest;

import config.WebConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;

public class BaseApiTest {

    public static RequestSpecification rcRequestSpec;
    public static ResponseSpecification rcResponseSpec;

    @BeforeEach
    public void before(){
        rcRequestSpec = new RequestSpecBuilder()
                .setBaseUri("https://rc.alpha-sense.com/")
                .setBasePath("/services/i/public-document-data/document/")
                .addQueryParam("slop",15)
                .addQueryParam("positiveOnly",false)
                .addQueryParam("negativeOnly", false)
                .addQueryParam("released", "1633003200000")
                .addHeader("accept", "application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new AllureRestAssured())
                .build();

        rcResponseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(HttpStatus.SC_OK)
                .build();

        RestAssured.requestSpecification = rcRequestSpec;
        RestAssured.responseSpecification = rcResponseSpec;
    }
}
