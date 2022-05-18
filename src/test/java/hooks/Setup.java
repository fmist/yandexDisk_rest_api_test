package hooks;

import api.Routes;
import api.Specification;
import api.Waiter;
import io.cucumber.java.AfterAll;
import io.restassured.http.Method;
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
}
