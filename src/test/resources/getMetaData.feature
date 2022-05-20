@getMetaData
Feature: test foo

  Scenario: test foo
    Given create resource "folder6"
    Then status code is 201
    And create resource "folder6/subfolder"
    Then status code is 201
    And upload file "text.jpg" to "folder6/subfolder"
    Then operation status is success
    And get info about "folder6/subfolder"
    And check "mediaType" must be "image"
    And check "type" must be "file"
    And check "mimeType" must be "image/jpeg"
    Then delete resource "folder6"
    Then operation status is success

