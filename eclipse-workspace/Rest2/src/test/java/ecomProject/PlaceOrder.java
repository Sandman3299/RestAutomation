package ecomProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class PlaceOrder extends BaseData{
	
	@Test
	public void placeOrderDetail()
	{
		RestAssured.baseURI="https://www.rahulshettyacademy.com";
		                    given()
		                    .log().all()		                    
		                    .header("Content-Type","application/json")
		                    .header("Authorization",tokenId)
		                    .body(JsonBody.getJsonBody(pId))
		                    .when()
		                    .post("api/ecom/order/create-order")
		                    .then()
		                    .log().all()
		                    .extract()
		                    .response();
		
		
	}
	
	
	

}
