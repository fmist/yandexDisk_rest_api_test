package hooks;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static api.Specification.setQuery;
import static io.restassured.http.Method.PUT;

public class Steps {
    @Given("Create resource {string}")
    public void createResource(String name) {
        Response response = setQuery(PUT, "?path=" + name + "");
    }
}

