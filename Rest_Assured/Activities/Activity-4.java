package Activities;



import java.util.HashMap;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Activity4 {		
		@Test
		public void getRequest1()
		{	        
	        Response response = RestAssured.given().
	        		baseUri("https://petstore.swagger.io/v2/pet").
	        		header("Content-Type","application/json").
	        		queryParam("status", "sold").
	        	when().
	        		get("/findByStatus");
	        
	        System.out.println(response.getBody().asPrettyString());
	        System.out.println(response.getBody().asString());
	        System.out.println(response.getHeaders().asList());
	        
	        String petStatus = response.then().extract().path("[0]['status']");
	        Assert.assertEquals(petStatus,"sold");
	        
	        response.then().statusCode(200).body("[0]['status']",Matchers.equalTo("sold"));

		}
		
		@Test
		public void getRequestWithPathParam() {
			// Send request, receive response, assert
			RestAssured.given().
				baseUri("https://petstore.swagger.io/v2/pet").
				header("Content-Type", "application/json"). // Define request type
				pathParam("petId", 12).
			when().
				get("/{petId}"). // get("/12")
			then().
				statusCode(200).
				body("status", Matchers.equalTo("available")).
				body("name", Matchers.equalTo("doggie"));
			
			//POST/PUT
			HashMap<String, String> reqBody = new  HashMap<>();
			  reqBody.put("id", "77232");
			  reqBody.put("name", "Riley");
			  reqBody.put("status", "alive");
			  
			   RestAssured.given().
			   baseUri("https://petstore.swagger.io/v2/pet").
				header("Content-Type", "application/json").
				body(reqBody).
			  when().
			  get("{petId}").
			  then().
			  statusCode(200).
			   body("status", Matchers.equalTo("available")).
				body("name", Matchers.equalTo("doggie"));

			  
			
		}
}