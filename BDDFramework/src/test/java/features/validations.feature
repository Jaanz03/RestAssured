Feature: PlaceAPI Validation

Scenario Outline: Validate if place api is added successfully
    Given 	Add place payload with "<name>" "<phonenumber>" "<address>"
    When 	user "POST" the http request using the "AddPlaceAPI" payload
    Then 	user receives 200 response
    And 	"status" in response body as "OK"
    And 	"scope" in response body as "APP"
    Then  validate the place id created maps to "<name>" using "GetPlaceAPI"
  
Examples:
					| name 	 | phonenumber 		| address 	 |
					| Helena | +91 8682395245 | wareshouse |
					| John 	 | +84 2568563548 | Sea house  |
					
		
  			
    

