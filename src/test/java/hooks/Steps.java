package hooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.List;

import static api.Routes.FILE_URL;
import static api.Routes.TRASH_URL;
import static api.Specification.setQuery;
import static api.Waiter.waitForStatusOperation;
import static api.Waiter.waitStatusCode;
import static io.restassured.http.Method.*;

public class Steps {

    Response response;
    ValidatableResponse json;

    @Given("create resource {string}")
    public void createResource(String name) {
        response = setQuery(PUT, "?path=" + name);
    }

    @Given("upload file {string} to {string}")
    public void uploadFile(String name, String pathToSetFile) {
        response = setQuery(POST, "/upload?path=" + pathToSetFile + "/" + name + "&url=" + FILE_URL + "");
    }

    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
        waitStatusCode(response, statusCode);
    }

    @Then("operation status is success")
    public void operationStatusIsSuccess() {
        waitForStatusOperation(response);
    }

    @And("delete resource {string}")
    public void deleteResource(String name) {
        response = setQuery(DELETE, "?path=" + name + "");
    }

    @Then("restore resource {string}")
    public void restoreResource(String name) {
        response = setQuery(GET, TRASH_URL, "?path=");
        List<String> paths = response.jsonPath().getList("_embedded.items.path");
        for (String path: paths) {
            if (path.contains(name)) {
                response = setQuery(PUT, TRASH_URL, "/restore?path=" + path);
            }
        }
    }

    @And("get body")
    public void getBody() {
        response.then().log().body(true);
    }
}

