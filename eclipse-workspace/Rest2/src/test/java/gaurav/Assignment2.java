package gaurav;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Assignment2 {

	
	@Test
	public void assig()
	{
		JsonPath js = new JsonPath("{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}");
		
		int size = js.getInt("courses.size()");
		System.out.println("******************************");
		System.out.println("Total Number of courses is:"+size);
		int purchase= js.getInt("dashboard.purchaseAmount");
		System.out.println("purchase ammout is:"+purchase);
		String firsttittle = js.getString("courses[0].title");
		System.out.println("tittle of first course is:"+firsttittle);
		
		for(int i=0;i<size;i++)	
		{
			
			String altittle = js.getString("courses["+i+"].title");
			int allprices= js.getInt("courses["+i+"].price");
			System.out.println("#####################");
			System.out.println(altittle+":"+allprices);
			System.out.println("#####################");
			   if(altittle=="RPA")
			   {
				   int rpa=js.getInt("courses["+i+"].copies");
				   System.out.println("number of copies sold by RPA:"+rpa);
				   
			   }
			    
		}
		int sum=0;
		for(int i=0;i<size;i++)
		{
			int totalprice=js.getInt("courses["+i+"].price");
			int totalcopies=js.getInt("courses["+i+"].copies");
			int multi=(totalprice*totalcopies);
			sum=sum+multi;
		}
		
		System.out.println("Total sum of prices is:-"+sum);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%");
		Assert.assertEquals(purchase, sum);
		
	}
	
	
}
