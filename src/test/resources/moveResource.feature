@move
Feature: move resource

  Scenario: create folder, move folder to folder2
    Given create resource "folder7"
    Then status code is 201
    And do "move" resource from "disk:/folder7" to "disk:/folder8"
    Then status code is 201
    And delete resource "folder8"
    Then status code is 204

  Scenario: create file, move to folder
    Given create resource "folder9"
    Then status code is 201
    Given upload file "file.jpg" to "folder9"
    Then operation status is success
    And create resource "folder10"
    Then status code is 201
    And do "move" resource from "disk:/folder9/file.jpg" to "disk:/folder10/file.jpg"
    Then status code is 201
    And delete resource "folder9"
    Then status code is 204
    And delete resource "folder10"
    Then operation status is success

