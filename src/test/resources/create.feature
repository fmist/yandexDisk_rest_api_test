Feature: test1

  Scenario: create folder, create file, delete file, delete folder
    Given create resource "folder1"
    Then status code is 201
    And upload file "1.jpg" to "folder1"
    Then operation status is success
    And delete resource "folder1/1.jpg"
    Then status code is 204
    And delete resource "folder1"
    Then status code is 204

  Scenario: create folder, create file, delete folder with file
    Given create resource "folder1"
    Then status code is 201
    And upload file "1.jpg" to "folder1"
    Then operation status is success
    And delete resource "folder1"
    Then operation status is success

  Scenario: create folder, create file, delete file, restore file, delete file and folder
    Given create resource "folder1"
    Then status code is 201
    And upload file "1.jpg" to "folder1"
    Then operation status is success
    And delete resource "folder1/1.jpg"
    Then status code is 204
    And restore resource "1.jpg"
    Then status code is 201
    And delete resource "folder1"
    Then operation status is success
