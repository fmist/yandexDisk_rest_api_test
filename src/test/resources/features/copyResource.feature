@copy
Feature: copy resource

  Scenario: create folder, copy folder
    Given create resource "2"
    Then status code is 201
    And do "copy" resource from "2" to "copyFolder"
    Then status code is 201
    And delete resource "2"
    Then status code is 204
    And delete resource "copyFolder"
    Then status code is 204

  Scenario: create file, copy file
    Given upload file "autotest.jpg" to ""
    Then operation status is success
    And do "copy" resource from "autotest.jpg" to "copy_autotest.jpg"
    Then status code is 201
    And delete resource "autotest.jpg"
    Then status code is 204
    And delete resource "copy_autotest.jpg"
    Then status code is 204


