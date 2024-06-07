package files;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Sumvalidation {
	
	@Test
	public void SumCourses() 
	{
		int amount=0;
		JsonPath js=new JsonPath(payload.CoursePrice());
		int count = js.getInt("courses.size()");
		for(int	i=0;i<count;i++)
		{
			int	price=js.getInt("courses["+i+"].price");
			int	copies=js.getInt("courses["+i+"].copies");
			int	sum=price*copies;
			System.out.println(sum);
			amount = amount+sum;
		}
		System.out.println(amount);
		int ttlpurchaseamt= js.getInt("dashboard.purchaseAmount");
		System.out.println(ttlpurchaseamt);
		Assert.assertEquals(amount, ttlpurchaseamt);
	
	}
}
