package gaurav;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ComplexPath {

      @Test
      public void complex()
      {
    	  RestAssured.baseURI="https://reqres.in";
    	String res=given()
    			       .log().all()
    			       .when()
    			       .get("/api/users?page=2")
    			       .then()
    			       .log().all()
    			       .extract()
    			       .response().asPrettyString();
    	  
    			      JsonPath js =new JsonPath(res);
    			      int num = js.getInt("data.size()");
    			      for(int i=0; i<num; i++)
    			      {
    			    	  int idvalue=js.getInt("data["+i+"].id");
    			    	    if(idvalue==10)
    			    	    {
    			    	    
    			    	    	String firstname=js.get("data["+i+"].first_name");
    			    	         System.out.println(firstname);
    			    	    }
    			    	  
    			      }
    			      
      }







}
