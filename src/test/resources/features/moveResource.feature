@move
Feature: move resource

  Scenario: create folder, move folder to another folder
    Given create resource "6"
    Then status code is 201
    And do "move" resource from "disk:/6" to "disk:/7"
    Then status code is 201
    And delete resource "7"
    Then status code is 204

  Scenario: create file, move to folder
    Given create resource "8"
    Then status code is 201
    Given upload file "8.jpg" to "8"
    Then operation status is success
    And create resource "9"
    Then status code is 201
    And do "move" resource from "disk:/8/8.jpg" to "disk:/9/9.jpg"
    Then status code is 201
    And delete resource "8"
    Then status code is 204
    And delete resource "9"
    Then operation status is success

