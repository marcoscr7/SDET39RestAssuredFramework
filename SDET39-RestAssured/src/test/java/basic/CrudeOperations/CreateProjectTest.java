package basic.CrudeOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest 
{
	@Test
	public void createProjectTest()
	{
		//Step 1:Create the prerequister neccessary
		JSONObject obj=new JSONObject();
		obj.put("createdBy","VikasRajak");
		obj.put("projectName","Sdet39");
		obj.put("status","On Going");
		obj.put("teamSize",7);
		
		//Step2:Send the request
	RequestSpecification request = RestAssured.given();
	request.body(obj);
	request.contentType(ContentType.JSON);
	Response resp = request.post("http://localhost:8084/addProject");
	
	//Step 3:Validate the response
	System.out.println(resp.getContentType());
	System.out.println(resp.getStatusCode());
	System.out.println(resp.getStatusLine());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.asPrettyString());
        ValidatableResponse validate = resp.then();
        System.out.println(validate.log().all());
	}
	
	

}
