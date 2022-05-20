@restore
Feature: restore resource
Scenario: create folder, create file, delete file, restore file, delete file and folder
Given create resource "10"
Then status code is 201
And upload file "10.jpg" to "10"
Then operation status is success
And delete resource "10/10.jpg"
Then status code is 204
And get info about "trash"
Then status code is 200
And restore resource "10.jpg"
Then status code is 201
And delete resource "10"
Then operation status is success