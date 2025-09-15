package examples;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	
	
	// GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
	
	
	@Test
	public void getRequestQueryParam() {
		// This method will send a GET request to the Petstore API with a query parameter
		// Example: GET https://petstore.swagger.io/v2/pet/findByStatus?status=sold
		
		Response response = 
				RestAssured.given().
				  baseUri("https://petstore.swagger.io/v2/pet").
				  header("Content-Type", "application/json"). //Define Request Type
				  header("Accept", "application/json"). //Define Response Type
				  queryParam("status", "sold").
				when().
				  get("/findByStatus");
		
		// Print the response body
		System.out.println("Response Body: " + response.getBody().asString());
		System.out.println("==============================================");
		System.out.println("Response Body: " + response.getBody().asPrettyString());
		//System.out.println("Response: " + response.getHeaders.asList());
		
		String petStatus = response.then().extract().path("[0]['status']");
		System.out.println("Pet Status: " + petStatus);
		
		//Assertions
		Assert.assertEquals(petStatus, "sold");
		
		//RestAssured assertions
		response.then().statusCode(200).
		body("[0]['status']", Matchers.equalTo("sold"));
		
	} 
	
	// GET https://petstore.swagger.io/v2/pet/{petId}
	
	public void getRequestWithPathParam() {
		// This method will send a GET request to the Petstore API with a path parameter
		// Example: GET https://petstore.swagger.io/v2/pet/{petId}
		
		
				RestAssured.given().
				  baseUri("https://petstore.swagger.io/v2/pet").
				  header("Content-Type", "application/json"). //Define Request Type
				  header("Accept", "application/json"). //Define Response Type
				  pathParam("petId", 12).
				when().
				  get("/{petId}").
				then().
				   statusCode(200).
				   body("status", Matchers.equalTo("available")).
				   body("name", Matchers.equalTo("doggie"));
				   
		
		/*// Print the response body
		System.out.println("Response Body: " + response.getBody().asString());
		
		String petName = response.then().extract().path("name");
		System.out.println("Pet Name: " + petName);
		
		//Assertions
		Assert.assertEquals(petName, "doggie");*/
		
	}
	

}
