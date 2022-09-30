package basic.CrudeOperations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getAllProjectsTest 
{
	@Test
	public void getAllProject()
	{
		//Step 1:Create prerequisites
		
		//Step 2:Send the request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		//Step 3:Validate the response
			ValidatableResponse validate = resp.then();
		System.out.println(validate.log().all());
		int expectedStatusCode=200;
		int actualStatusCode=resp.getStatusCode();
		Assert.assertEquals(actualStatusCode,expectedStatusCode);
	}

}
