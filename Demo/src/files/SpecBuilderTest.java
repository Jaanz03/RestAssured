package files;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.locationapi;
import pojo.placeAPI;

public class SpecBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		placeAPI p = new placeAPI();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName("Frontline house");
		List<String>	mylist=new ArrayList<String>();
		mylist.add("shoe park");
		mylist.add("shop");
		p.setTypes(mylist);
		locationapi	l=new locationapi();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		RequestSpecification rs = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addQueryParam("key","qaclick123")
				.setContentType(ContentType.JSON).build();
		RequestSpecification	response = given().spec(rs).body(p);
		String	specresponse=response.when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
		
		// recreated below code using request specification reusable method
		
//		RestAssured.baseURI="https://rahulshettyacademy.com/";
//		String res=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
//		.body(p).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(specresponse);
		

	}

}
