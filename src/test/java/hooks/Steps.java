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

import static api.Routes.*;
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

    @Given("upload test file {string} to {string}")
    public void uploadTestFile(String name, String pathToSetFile) {
        response = setQuery(POST, "/upload?path=" + pathToSetFile + "/" + name + "&url=" + test_file_url + "");
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
    public void restoreResource(String name){
        List<ItemsItem> paths = getInfo.getEmbedded().getItems();
        for (ItemsItem path : paths) {
            if (path.path.contains(name)) {
                response = setQuery(PUT, TRASH_URL, "/restore?path=" + path.path);
                response.then().log().ifError();
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
        if (name.equals("trash")) {
            response = setQuery(GET, TRASH_URL, "?path=");
        } else {
            response = setQuery(GET, "?path=" + name + "");
        }
        getInfo = response.jsonPath().getObject("", GetInfo.class);
    }

    @And("check {string} key {string} must have value {string}")
    public void checkSomethingMustBe(String name, String key, String value) {
        Map<String, Object> map = new HashMap<>();
        List<ItemsItem> items = getInfo.getEmbedded().getItems();
        for (int i=0; i<items.size(); i++) {
            if (items.get(i).name.equals(name)) {
                map.put("antivirusStatus", getInfo.getEmbedded().getItems().get(i).antivirusStatus);
                map.put("commentIds", getInfo.getEmbedded().getItems().get(i).commentIds);
                map.put("created", getInfo.getEmbedded().getItems().get(i).created);
                map.put("exif", getInfo.getEmbedded().getItems().get(i).exif);
                map.put("file", getInfo.getEmbedded().getItems().get(i).file);
                map.put("md5", getInfo.getEmbedded().getItems().get(i).md5);
                map.put("mediaType", getInfo.getEmbedded().getItems().get(i).mediaType);
                map.put("modified", getInfo.getEmbedded().getItems().get(i).modified);
                map.put("name", getInfo.getEmbedded().getItems().get(i).name);
                map.put("path", getInfo.getEmbedded().getItems().get(i).path);
                map.put("preview", getInfo.getEmbedded().getItems().get(i).preview);
                map.put("resourceId", getInfo.getEmbedded().getItems().get(i).resourceId);
                map.put("revision", getInfo.getEmbedded().getItems().get(i).revision);
                map.put("type", getInfo.getEmbedded().getItems().get(i).type);
                map.put("mimeType", getInfo.getEmbedded().getItems().get(i).mimeType);
                map.put("sha256", getInfo.getEmbedded().getItems().get(i).sha256);
                map.put("size", getInfo.getEmbedded().getItems().get(i).size);
            }
        }
        Assert.assertEquals(value, map.get(key).toString());
    }

    @And("do {string} resource from {string} to {string}")
    public void moveResource(String action, String beforeParameter, String afterParameter) {
        response = setQuery(POST, "/" + action + "?from=" + beforeParameter + "&path=" + afterParameter);
        response.then().log().ifError();
    }
}

