@getMetaData
Feature: test foo

  Scenario: test foo
    Given create resource "5"
    Then status code is 201
    And create resource "5/subfolder"
    Then status code is 201
    And upload file "text.jpg" to "5/subfolder"
    Then operation status is success
    And get info about "5/subfolder"
    And check "mediaType" must be "image"
    And check "type" must be "file"
    And check "mimeType" must be "image/jpeg"
    Then delete resource "5"
    Then operation status is success

