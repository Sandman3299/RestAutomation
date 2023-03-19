package ecomProject;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class LoginClass extends BaseData

{
	
	@Test
	public void loginToApp()
	{
		RestAssured.baseURI="https://www.rahulshettyacademy.com";
		
		      Response res =given()
		                   .header("Content-Type","application/json")
		                   .body("{\r\n"
		                   		+ "    \"userEmail\": \"v.v.s@gmail.com\",\r\n"
		                   		+ "     \"userPassword\": \"Sapkale@123\"\r\n"
		                   		+ "}")
		                   .log().all()
		                   .when()
		                   .post("api/ecom/auth/login")
		                   .then()
		                   .log().all()
		                   .extract()
		                   .response();	
		      
		      JsonPath jp= res.jsonPath();
		      String token =jp.getString("token");
		      tokenId=token;
		      System.out.println("***************************************");
		      System.out.println(tokenId);
		      String uid =jp.get("userId");
              userid=uid;	
              System.out.println(userid);
		
	}
	
	
	
	
}
