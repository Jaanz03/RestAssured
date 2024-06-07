package files;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;


public class JIRATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="http://localhost:8080";
//API Login		
		SessionFilter 	session = new  SessionFilter();
		String response = given().relaxedHTTPSValidation().header("Content-Type","application/json").body("{\r\n"
				+ "    \"username\": \"jansisowmiya.vijayakumar\",\r\n"
				+ "    \"password\": \"Jaanz@3693\"\r\n"
				+ "}").log().all().filter(session).post("/rest/auth/1/session").then().log().all().extract().response().asString();
String	expectedmess="hello world automation";
		//Add comment
		String addcommentresponse=given().pathParam("Key", "10101").log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \""+expectedmess+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{Key}/comment").then().assertThat().statusCode(201).extract().response().asString();
		JsonPath js1=new JsonPath(addcommentresponse);
		String 	comentid=js1.getString("id");
		
		//Add Attachment
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("key", "10101").header("Content-Type","multipart/form-data").multiPart("file",new File("jira.txt"))
		.when().post("/rest/api/2/issue/{key}/attachments").then().log().all().statusCode(200);
		
		//Get comment
		String 	issuedetails=given().filter(session).pathParam("key", "10101").queryParam("fields", "comment").
				log().all().when().get("/rest/api/2/issue/{key}").then().log().all().extract().response().asString();
//		System.out.println(issuedetails);
		
		JsonPath js = new JsonPath(issuedetails);
		int	commentcount=js.getInt("fields.comment.comments.size()");
		for (int i=0;i<commentcount;i++) {
			String  commentIdissue=js.get("fields.comment.comments["+i+"].id").toString();
			if(commentIdissue.equalsIgnoreCase(comentid))
			{
				String 	message = js.getString("fields.comment.comments["+i+"].body").toString();
				System.out.println(message);
				Assert.assertEquals(message, expectedmess);
			}
		}
		
	}

}
