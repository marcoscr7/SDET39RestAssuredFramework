package basic.CrudeOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class DeleteProjectTest
{
	@Test
	public void deleteProject()
	{
		//Step 1:Create pre requisites
		
		//Step 2:Send request
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1003");
		
		
		//Step 3:Validate the reponse
		System.out.println(resp.getStatusCode());
	}

}
