package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.AddPlaceResources;
import resources.TestData;
import resources.utility;

import static io.restassured.RestAssured.*;

public class stepdefinition extends utility {
	ResponseSpecification	respec;
	RequestSpecification	res;
	Response	specresponse;
	String placeid;
	JsonPath js;
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload(String name, String	phonenumber, String address) throws IOException {
		TestData  td = new TestData();	    
	    res = given().spec(baseuri()).body(td.AddPlacePayload(name,phonenumber,address));	    
	}
	@When("user {string} the http request using the {string} payload")
	public void user_posts_the_http_request_using_the_payload(String method,String resource) {
		AddPlaceResources API = AddPlaceResources.valueOf(resource) ;
		String apiinput = API.getResource();
		
		if (method.equalsIgnoreCase("POST")) 
			specresponse=res.when().post(apiinput).then().extract().response();
		else if(method.equalsIgnoreCase("GET")) {
			specresponse=res.when().get(apiinput).then().extract().response();
			
		}
	}
	@Then("user receives {int} response")
	public void user_receives_response(Integer inter) {
		assertEquals(specresponse.getStatusCode(),200);
	}
	
	@And("{string} in response body as {string}")
	public void status_in_response_body_as(String keyvalue, String expectedvalue) {
//		String	resp = specresponse.asString();
//		js = new	JsonPath(resp);
//		placeid = js.get("place_id");
//		String  keyinput = js.get(keyvalue.toString());
		assertEquals(getJSonPath(specresponse,keyvalue), expectedvalue);
			    
	}
	
	@Then("validate the place id created maps to {string} using {string}")
	public void validate_the_place_id_created_maps_to_using(String string, String string2) throws IOException {
		
	    res=given().spec(baseuri()).queryParam("place_id",getJSonPath(specresponse,"place_id"));
	    user_posts_the_http_request_using_the_payload("GET", string2);
	}

}
