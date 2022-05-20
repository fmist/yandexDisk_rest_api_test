@create
Feature: create
  Scenario: create folder, create file, delete file, delete folder
	Given create resource "3"
	Then status code is 201
	And upload file "3.jpg" to "3"
	Then operation status is success
	And delete resource "3/3.jpg"
	Then status code is 204
	And delete resource "3"
	Then status code is 204

  Scenario: create folder, create file, delete folder with file
	Given create resource "4"
	Then status code is 201
	And upload file "4.jpg" to "4"
	Then operation status is success
	And delete resource "4"
	Then operation status is success