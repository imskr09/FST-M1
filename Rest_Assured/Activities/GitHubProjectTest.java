package project;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjectTest {
	
	
	String sshKey ="";// "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFIbrLb6/S3L0oUr3TF8emiBoryKfooSvYY6JgkRqVbV";
	
	int keyId;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setUp()
	
	{
		//Initialize the request specification
		requestSpec=new RequestSpecBuilder()
				.setBaseUri( "https://api.github.com/user/keys")				
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization","token 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")
				.addHeader("X-GitHub-Api-Version", "2022-11-28")
				.build();
		
		
		//Initialize the response specification
		responseSpec= new ResponseSpecBuilder()
				.expectBody("title",Matchers.equalTo("TestKey"))
				.expectResponseTime(Matchers.lessThanOrEqualTo(3000L))
				.expectStatusCode(200)
				.expectContentType("application/json")
				.build();
	}
	
	
	@Test(priority=1)
	public void postRequestTest()
	{
		//Request body as Hashmap
		HashMap<String, String> reqBody = new HashMap<>();
		reqBody.put("title", "TestKey");
		reqBody.put("key", sshKey);
		
		// send request, Save response
		Response response = RestAssured.given().
				spec(requestSpec).
				body(reqBody).log().all().
				when().post();
		
		//Extract the id from the response body
		keyId = response.then().extract().path("id");
		
		//Assertions
		response.then().statusCode(201).spec(responseSpec).log().all();
		
	}
		

		@Test(priority=2)
		public void getRequestTest()
		{
			//send request, receive response and assert
			RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).
			when().get("/{keyId}").
			then().statusCode(200).spec(responseSpec);
		}
		@Test(priority=3)
		public void deleteRequestTest()
		{
			//send request, receive response and assert
			RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).
			when().get("/{keyId}").
			then().statusCode(204);
		}
		
	}


