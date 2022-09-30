package bdd.CRUDEOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectTest
{
	@Test
	public void createProject() 
	{
		//Step 1:Create prerequisites
		
		baseURI="http://localhost";
		port=8084;
		JSONObject obj=new JSONObject();
		obj.put("createdBy","Sachita");
		obj.put("projectName","Home");
		obj.put("status","Completed");
		obj.put("teamSize",4);
		
		//Send the request
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		//validate the response
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
	}

}
