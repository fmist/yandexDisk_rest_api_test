package api;

import io.restassured.response.Response;

import static api.Specification.setQuery;
import static io.restassured.http.Method.GET;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class Waiter {

    public static long timeout = 10L;

    public static void waitStatusCode(Response response, int expectedCode) {
        await().atMost(timeout, SECONDS)
                .until(() -> response.getStatusCode() == expectedCode);
    }

    public static void waitStatusCode(Response response, int code1, int code2) {
        await().atMost(timeout, SECONDS)
                .until(() -> response.getStatusCode() == code1 || response.getStatusCode() == code2);
    }

    public static void waitForStatusOperation(Response response) {
        String operation = response.jsonPath().get("href");
        await().atMost(timeout, SECONDS)
                .until(
                        () -> setQuery(GET, operation).jsonPath().get("status").equals("success")
                );
    }
}
