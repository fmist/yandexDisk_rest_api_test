package api;

import io.restassured.response.Response;
import org.awaitility.Awaitility;

import static api.Specification.setQuery;
import static io.restassured.http.Method.GET;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Waiter {

    public static long timeout = 10L;

    public static void waitStatusCode(Response response, int expectedCode) {
        Awaitility.await().atMost(timeout, SECONDS)
                .until(() -> response.getStatusCode() == expectedCode);
    }

    public static void waitStatusCode(Response response, int code1, int code2) {
        Awaitility.await().atMost(timeout, SECONDS)
                .until(() -> response.getStatusCode() == code1 || response.getStatusCode() == code2);
    }

    public static void waitForStatusOperation(Response response) {
        String operation = response.jsonPath().get("href");
        Awaitility.await().atMost(timeout, SECONDS)
                .until(
                        () -> setQuery(GET, operation).jsonPath().get("status").equals("success")
                );
    }
}
