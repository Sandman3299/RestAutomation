package serialiseDeserialize;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class SerialDe {
	
	
	@Test
	public void postSD()
	{
		
RequestPOJO req  = new RequestPOJO();
		
		req.setId(0);
		req.setUsername("Anil");
		req.setFirstName("Ron");
		req.setLastName("Tayde");
		req.setEmail("ron.Tayde@gmail.com");
		req.setPassword("Test@12345");
		req.setPhone("9874562130");
		req.setUserStatus(0);

		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		ResponcePOJO    res      = given()
		                     .header("Content-Type", "application/json")
		                     .body(req)
		                     .log().all()
		                     .when()
		                     .post("/user")
		                     .then()
		                     .extract()
		                     .response()
		                     .as(ResponcePOJO.class);
		String typ= res.getType();
		String msg= res.getMessage();
		System.out.println("*************");
		System.out.println(typ);
		System.out.println(msg);
	}
}
