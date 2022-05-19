@getMetaData
Feature: test foo

  Scenario: test foo
    Given create resource "folder"
    Then status code is 201
    And create resource "folder/subfolder"
    Then status code is 201
    And upload file "autotest.jpg" to "folder/subfolder"
    Then operation status is success
    And get info about "folder/subfolder"
    And check "mediaType" must be "image"
    And check "type" must be "file"
    And check "mimeType" must be "image/jpeg"
    Then delete resource "folder"
    Then operation status is success

