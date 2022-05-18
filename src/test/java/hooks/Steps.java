package hooks;

import api.Specification;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;

import static io.restassured.RestAssured.request;
import static io.restassured.http.Method.PUT;

public class Steps {
    @Given("Создаю ресурс {string}")
    public void create(String name) {
        Response response = Specification.request(PUT, "?path=" + name + "");
    }
}

