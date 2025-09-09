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

public class GithubProject {
	
	String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIC1FGDJmYm55wSPZzkI90054GsT4EEuGYEPXZ3TCPykH";
    int keyid;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    
    @BeforeClass
    public void setup() {
    	
    	requestSpec = new RequestSpecBuilder().
    			setBaseUri("https://api.github.com/users/keys").
    			addHeader("Content-Type","application/json").
    			addHeader("Authorization","token ").
    			addHeader("X-GitHub-Api-Version", "2022-11-28").
    			build();
    	
    	responseSpec = new ResponseSpecBuilder().
    			expectBody("title", Matchers.equalTo("TestKey")).
    			expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
    			build();
    }
    
    @Test(priority = 1)
    public void postRequestTest() {
    	HashMap<String ,String> reqbody = new HashMap<>();
    	reqbody.put("title", "TestKey");
    	reqbody.put("key", sshkey);
    	
    	Response response = RestAssured.given().
    		spec(requestSpec).
    		body(reqbody).when().post();
    	
    	keyid = response.then().extract().path("id");
    	response.then().statusCode(201).spec(responseSpec);
    }
    
    @Test(priority = 2)
    public void getRequestTest() {
    	RestAssured.given().spec(requestSpec).pathParam("keyid", keyid).
    	when().get("/{keyid}").then().
    	statusCode(200).spec(responseSpec);
    }
    
    @Test(priority = 3)
    public void deleteRequestTest() {
    	RestAssured.given().spec(requestSpec).pathParam("keyid", keyid).
    	when().delete("/{keyid}").then().
    	statusCode(204);
    }
}
