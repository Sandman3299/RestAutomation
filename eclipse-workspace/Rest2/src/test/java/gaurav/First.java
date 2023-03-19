package gaurav;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.testng.asserts.SoftAssert;

import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given; 

public class First {
	
	
	@Test
	public void checkGET()
	{
         RestAssured.baseURI = "https://reqres.in";
		
		Response res=given().log().all()
		              .when()
		              .get("/api/users?page=2")
		              .then().log().all()
		              .extract()
		              .response();
		
		JsonPath js= res.jsonPath();
		int i = js.getInt("page");
		int i2 = js.getInt("per_page");
		int i3 = js.getInt("total");
		int i4 = js.getInt("total_pages");
		String first =js.getString("data[3].first_name");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(i,2);
		sa.assertEquals(i2,6);
		sa.assertEquals(i3,12);
		sa.assertEquals(i4,2);
		sa.assertEquals(first,"Byron");
		sa.assertAll();
		System.out.println("*****************");
		System.out.println("Validating name in Response-"+first);
		System.out.println("*****************");
		
		//verify status code
		long tm=res.getTime();
		System.out.println("Response time is:"+tm);
		int sts=res.getStatusCode();
		System.out.println("status code is: "+sts);
        String strLine=res.getStatusLine();
        System.out.println("*******************************");
        System.out.println("Status Line is: "+strLine);
	}	

}
