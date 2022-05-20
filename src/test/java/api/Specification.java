package api;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static api.Routes.URL;
import static api.Routes.getTOKEN;
import static io.restassured.RestAssured.given;

public class Specification {

    public static RequestSpecification authorisation() {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", getTOKEN())
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }

    public static Response setQuery(Method method, String path) {
        return given(authorisation())
                .baseUri(URL)
                .when()
                .request(method, path)
                .then()
                .log().ifError()
                .extract().response();
    }

    public static Response setQuery(Method method, String url, String path) {
        return given(authorisation())
                .baseUri(url)
                .when()
                .request(method, path)
                .then()
                .log().ifError()
                .extract().response();
    }






}
