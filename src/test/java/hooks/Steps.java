package hooks;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.getInfo.GetInfo;
import pojo.getInfo.ItemsItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static api.Routes.FILE_URL;
import static api.Routes.TRASH_URL;
import static api.Specification.setQuery;
import static api.Waiter.waitForStatusOperation;
import static api.Waiter.waitStatusCode;
import static io.restassured.http.Method.*;

public class Steps {
    Response response;
    GetInfo getInfo;

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
        for (String path : paths) {
            if (path.contains(name)) {
                response = setQuery(PUT, TRASH_URL, "/restore?path=" + path);
            }
        }
    }

    @And("get body")
    public void getBody() {
        response.then().log().body(true);
    }

    @And("check sum sizes must be {int}")
    public void calculateFilesSizes(int expectedSize) {
        List<ItemsItem> items = getInfo.getEmbedded().getItems();
        int sum = 0;
        for (int i = 0; i < items.size(); i++) {
            sum = items.stream().mapToInt(ItemsItem::getSize).sum();
        }
        Assert.assertEquals(expectedSize, sum);
    }

    @And("get info about {string}")
    public void getInfoAboutResource(String name) {
        response = setQuery(GET, "?path=" + name + "");
        getInfo = response.jsonPath().getObject("", GetInfo.class);
    }

    @And("check {string} must be {string}")
    public void checkSomethingMustBe(String key, String value) {
        Map<String, Object> map = new HashMap<>();
        map.put("antivirusStatus", getInfo.getEmbedded().getItems().get(0).antivirusStatus);
        map.put("commentIds", getInfo.getEmbedded().getItems().get(0).commentIds);
        map.put("created", getInfo.getEmbedded().getItems().get(0).created);
        map.put("exif", getInfo.getEmbedded().getItems().get(0).exif);
        map.put("file", getInfo.getEmbedded().getItems().get(0).file);
        map.put("md5", getInfo.getEmbedded().getItems().get(0).md5);
        map.put("mediaType", getInfo.getEmbedded().getItems().get(0).mediaType);
        map.put("modified", getInfo.getEmbedded().getItems().get(0).modified);
        map.put("name", getInfo.getEmbedded().getItems().get(0).name);
        map.put("path", getInfo.getEmbedded().getItems().get(0).path);
        map.put("preview", getInfo.getEmbedded().getItems().get(0).preview);
        map.put("resourceId", getInfo.getEmbedded().getItems().get(0).resourceId);
        map.put("revision", getInfo.getEmbedded().getItems().get(0).revision);
        map.put("type", getInfo.getEmbedded().getItems().get(0).type);
        map.put("mimeType", getInfo.getEmbedded().getItems().get(0).mimeType);
        map.put("sha256", getInfo.getEmbedded().getItems().get(0).sha256);
        map.put("size", getInfo.getEmbedded().getItems().get(0).size);
        Assert.assertEquals(value, map.get(key));
    }

    @And("do {string} resource from {string} to {string}")
    public void moveResource(String action, String oldParam, String newParam) {
        response = setQuery(POST, "/" + action + "?from=" + oldParam + "&path=" + newParam);
        response.then().log().ifError();
    }
}

