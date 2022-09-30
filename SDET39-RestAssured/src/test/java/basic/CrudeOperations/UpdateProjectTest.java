package basic.CrudeOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		//Step 1:Create prerequisites
		
		JSONObject obj=new JSONObject();
		obj.put("createdBy","Vikram");
		obj.put("projectName","UI/UX");
		obj.put("status","Completed");
		obj.put("teamSize",7);
		//Step 2:Send the request
		RequestSpecification request = RestAssured.given();
		request.body(obj);
		request.contentType(ContentType.JSON);
		Response resp = request.put("http://localhost:8084/projects/TY_PROJ_1002");
		//Step 3:Validate the response
		System.out.println(resp.getStatusCode());
	}

}
