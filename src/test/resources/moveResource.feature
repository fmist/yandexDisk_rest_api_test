@move
Feature: move resource

  Scenario: create folder, move folder to folder2
    Given create resource "folder"
    Then status code is 201
    And do "move" resource from "disk:/folder" to "disk:/folder2"
    Then status code is 201
    And delete resource "folder2"
    Then status code is 204

  Scenario: create file, move to folder
    Given create resource "folder"
    Then status code is 201
    Given upload file "file.jpg" to "folder"
    Then operation status is success
    And create resource "folder2"
    Then status code is 201
    And do "move" resource from "disk:/folder/file.jpg" to "disk:/folder2/file.jpg"
    Then status code is 201
    And delete resource "folder"
    Then status code is 204
    And delete resource "folder2"
    Then operation status is success

