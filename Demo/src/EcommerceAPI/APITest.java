package EcommerceAPI;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.CreateOrder;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.Orderdetails;

public class APITest {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginRequest  login = new LoginRequest();
		login.setUserEmail("jaanz181@gmail.com");
		login.setUserPassword("Jaanz@3693");
		RequestSpecification rsp = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").setContentType(ContentType.JSON).build();
		RequestSpecification	reqlogin = given().spec(rsp).body(login);
		LoginResponse	loginres = reqlogin.when().post("api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
		String AuthToken = loginres.getToken();
		String UserId = loginres.getUserId();
		System.out.println("login token is " + AuthToken);
		System.out.println("login userid is" + UserId);
		
	// Add a product
		
		RequestSpecification addprod = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/").addHeader("authorization", AuthToken).build();
		
		
		RequestSpecification addprodspecs = given().spec(addprod).param("productName", "PlaceOrder").param("productAddedBy", UserId)
		.param("productCategory", "fashion").param("productSubCategory", "coat")
		.param("productPrice", "11500").param("productDescription", "Addias Originals").param("productFor", "women")
		.multiPart("productImage",new File ("C://Users//vjansi//eclipse-workspace//Demo//images//productImage_1650649434146.jpeg"));
		
		String 	resaddprod = addprodspecs.when().post("api/ecom/product/add-product").then().log().all().extract().response().asString();
		
		JsonPath js = new JsonPath(resaddprod);
		String product= js.get("productId");
		System.out.println("product id added successfulluy" + product);
		
		
	// Create Order
		
		RequestSpecification createorderbase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("authorization", AuthToken).setContentType(ContentType.JSON).build();
		
		Orderdetails	ord = new Orderdetails();
		ord.setCountry("India");
		ord.setProductOrderedId(product);
		
		List<Orderdetails>	orderslist = new ArrayList<Orderdetails>();
		orderslist.add(ord);
		
		CreateOrder	order= new CreateOrder();
		order.setOrders(orderslist);
		
		RequestSpecification  createorders = given().log().all().spec(createorderbase).body(order);
		String	rescreateorder = createorders.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
		System.out.println(rescreateorder);
		
		
		//Delete Order
		
		RequestSpecification deleteorderbase = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").
				addHeader("authorization", AuthToken).setContentType(ContentType.JSON).build();
		
		RequestSpecification  deleteProdreq= given().log().all().spec(deleteorderbase).pathParam("productid", product);
		
		
		String	deleteprodres= deleteProdreq.when().delete("/api/ecom/product/delete-product/{productid}").then().log().all().extract().response().asString();
		
		JsonPath js1 = new JsonPath(deleteprodres);
		String	prodmessage= js1.get("message");
		Assert.assertEquals("Product Deleted Successfully", prodmessage);
		System.out.println(prodmessage);
	}

}
