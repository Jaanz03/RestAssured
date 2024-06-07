package files;

import io.restassured.path.json.JsonPath;

public class complexjson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js=new JsonPath(payload.CoursePrice());
		
		//Print No of courses returned by API
		
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//Print purchase amount
		int amount = js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
		//Print title of the first course
		String  firstcoursetitle=js.getString("courses[0].title");
		System.out.println(firstcoursetitle);
		
		//Print all course titles and their respective prices:
		for(int	i=0;i<count;i++)
		{
			String  allcoursetitle= js.getString("courses["+i+"].title");
			System.out.println(js.get("courses["+i+"].price").toString());
			System.out.println(allcoursetitle);			
			
		}
		//Print number of courses with RPA
		for(int	i=0;i<count;i++)
		{
			String  allcoursetitle= js.getString("courses["+i+"].title");
			if(allcoursetitle.equalsIgnoreCase("RPA"))
			{
				System.out.println(js.get("courses["+i+"].copies").toString());
			}
		}
		
		// Verify the purchase amount - assertion
		int ttlpurchaseamt= js.getInt("dashboard.purchaseAmount");
		System.out.println(ttlpurchaseamt);
		for(int	i=0;i<count;i++)
		{
			int	price=js.getInt("courses["+i+"].price");
			int	copies=js.getInt("courses["+i+"].copies");
			int	sum=price*copies;
		}
		
	}

}
