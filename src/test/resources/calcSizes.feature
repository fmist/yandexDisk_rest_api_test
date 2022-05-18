Feature: calculate sizes
  Scenario: create 3 files, calculate files sizes
    Given create resource "folder"
    Then status code is 201
    Given upload file "1.jpg" to "folder"
    Then operation status is success
#    Given upload file "2.jpg" to "folder"
#    Then operation status is success
#    Given upload file "3.jpg" to "folder"
#    Then operation status is success
    And calculate files sizes in "folder"