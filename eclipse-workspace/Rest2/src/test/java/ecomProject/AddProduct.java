package ecomProject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddProduct extends BaseData{
	
	@Test
	public void addProduct()
	{
		RestAssured.baseURI="https:/rahulshettyacademy.com";
	           Response res = given()
							.log().all()
							.header("Authorization",tokenId)
							.param("productName","Vibrator Brush")
							.param("productAddedBy",userid )
							.param("productCategory","electronics")
							.param("productSubCategory", "toothbrush")
							.param("productPrice", "959")
							.param("productDescription", "AGATO")
							.param("productFor", "men")
							.multiPart("productImage", new File("C:\\Users\\admin\\eclipse-workspace\\Rest2\\images\21VgP6cc1eL.png"))
							.when()
							.post("api/ecom/product/add-product")
							.then().log().all()
							.extract()
							.response();
							
	JsonPath jp=res.jsonPath();
	String prdid=jp.getString("productId");
	pId=prdid;
	System.out.println("#############################");
	System.out.println(pId);
	
	
	}
	
	
	
	
	
	

}
