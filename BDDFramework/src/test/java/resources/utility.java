package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class utility {
	public static RequestSpecification req;
	public RequestSpecification baseuri() throws IOException {
			
		if (req == null) {
		PrintStream  logging= new PrintStream(new FileOutputStream("logging.txt"));
		req = new RequestSpecBuilder().setBaseUri(globalvar("baseurl")).addQueryParam("key","qaclick123").
				setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(logging))
				.addFilter(ResponseLoggingFilter.logResponseTo(logging))
	    		.build();
		return 	req;
		}
		return req;
		
		
	}
	
	public  static String 	globalvar(String  keyvalue) throws IOException 
	{
		Properties pr = new Properties();
		FileInputStream 	fis = new FileInputStream("C:\\Users\\vjansi\\eclipse-workspace\\BDDFramework\\src\\test\\java\\resources\\global.properties");
		pr.load(fis);
//		System.out.println(pr.getProperty(keyvalue));
		return pr.getProperty(keyvalue);
		
	}
	
	public String getJSonPath(Response response, String key) {
		String res= response.asString();
		JsonPath js = new JsonPath(res);
		return(js.get(key));
		
	}

}
