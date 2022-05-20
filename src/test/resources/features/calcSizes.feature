@calc
Feature: calculate sizes

  Scenario: create 3 files, calculate files sizes
    Given create resource "1"
    Then status code is 201
    And upload file "1.jpg" to "1"
    Then operation status is success
    And upload file "2.jpg" to "1"
    Then operation status is success
    And upload file "3.jpg" to "1"
    Then operation status is success
    And get info about "1"
    And check sum sizes must be 83871
    And delete resource "1"
    Then operation status is success