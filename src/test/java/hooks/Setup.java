package hooks;

import io.cucumber.java.AfterAll;
//import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static api.Routes.TRASH_URL;
import static api.Specification.setQuery;
import static api.Waiter.waitStatusCode;
import static io.restassured.http.Method.DELETE;

public class Setup {
    @AfterAll
    public static void clearTrash() {
        Response response = setQuery(DELETE, TRASH_URL, "?path=");
        waitStatusCode(response, 202, 204);
        System.out.println("trash cleaned");
    }
//
    @BeforeAll
    public static void setup() {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n");
        RestAssured.filters(new AllureRestAssured());
    }
}
