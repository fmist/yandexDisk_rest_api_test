@getMetaData
Feature: getMetaData

  Scenario: get metadata about uploaded resource
    Given create resource "5"
    Then status code is 201
    And create resource "5/subfolder"
    Then status code is 201
    And upload file "text.jpg" to "5/subfolder"
    Then operation status is success
    And get info about "5/subfolder"
    And check "text.jpg" key "mediaType" must have value "image"
    And check "text.jpg" key "type" must have value "file"
    And check "text.jpg" key "mimeType" must have value "image/jpeg"
    Then delete resource "5"
    Then operation status is success

  Scenario: get metadata about uploaded resources
    Given create resource "11"
    Then status code is 201
    And create resource "11/subfolder"
    Then status code is 201
    And create resource "11/subfolder/sub1"
    Then status code is 201
    And create resource "11/subfolder/sub1/sub2"
    Then status code is 201
    And create resource "11/subfolder/sub1/sub2/sub3"
    Then status code is 201
    And upload file "text.jpg" to "11/subfolder/sub1/sub2/sub3"
    Then operation status is success
    And upload test file "testFile" to "11/subfolder/sub1/sub2/sub3"
    Then operation status is success
    And get info about "11/subfolder/sub1/sub2/sub3"
    And check "text.jpg" key "mediaType" must have value "image"
    And check "testFile" key "size" must have value "10485760"
    And check "testFile" key "mimeType" must have value "application/octet-stream"
    And check "text.jpg" key "mimeType" must have value "image/jpeg"
    Then delete resource "11"
    Then operation status is success

