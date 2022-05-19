@calc
Feature: calculate sizes

  Scenario: create 3 files, calculate files sizes
    Given create resource "folder"
    Then status code is 201
    And upload file "1.jpg" to "folder"
    Then operation status is success
    And upload file "2.jpg" to "folder"
    Then operation status is success
    And upload file "3.jpg" to "folder"
    Then operation status is success
    And get info about "folder"
    And check sum sizes must be 30441
    And delete resource "folder"
    Then operation status is success