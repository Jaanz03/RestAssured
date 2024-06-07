package files;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import pojo.api;
import pojo.getcourse;
import pojo.webautomation;

public class OAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[]	courseTitle= {"Selenium Webdriver Java","Cypress","Protractor"};
		String	response=given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").then().extract().response().asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String	accesstoken=js.getString("access_token");
		
		getcourse  gc=given().queryParam("access_token", accesstoken).when().log().all().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(getcourse.class);
		System.out.println(gc.getInstructor());
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		List<api>	apicourse=gc.getCourses().getApi();
		for (int i=0;i<apicourse.size();i++) {
			if(apicourse.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
				System.out.println(apicourse.get(i).getPrice());
			}
		}
		
		//get all course titles in webautomation
		ArrayList<String> a = new ArrayList<String>();

		List<webautomation>	webcourse=gc.getCourses().getWebAutomation();
		for (int i=0;i<webcourse.size();i++) {
			a.add(webcourse.get(i).getCourseTitle());
		}
		List<String> 	expectedlist = Arrays.asList(courseTitle);
		Assert.assertTrue(a.equals(expectedlist));
		
	}

}
