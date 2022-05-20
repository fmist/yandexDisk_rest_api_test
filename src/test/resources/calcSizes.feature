@calc
Feature: calculate sizes

  Scenario: create 3 files, calculate files sizes
    Given create resource "folder1"
    Then status code is 201
    And upload file "1.jpg" to "folder1"
    Then operation status is success
    And upload file "2.jpg" to "folder1"
    Then operation status is success
    And upload file "3.jpg" to "folder1"
    Then operation status is success
    And get info about "folder1"
    And check sum sizes must be 83871
    And delete resource "folder1"
    Then operation status is success