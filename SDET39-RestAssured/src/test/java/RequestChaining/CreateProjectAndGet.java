package RequestChaining;

import java.util.Random;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import CreateProjectUsingPojoClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndGet 
{
	@Test
	public void createAndGet()
	{
		//Step 1: create a project using POJO
		Random ran=new Random();
		
		ProjectLibrary pLib = new ProjectLibrary("Raju", "Chrome "+ran.nextInt(1000), "Completed", 24);
		baseURI = "http://localhost";
		port = 8084;
		
		Response resp = given()
		                  .body(pLib)
		                  .contentType(ContentType.JSON)
		                .when()
		                  .post("/addProject");
		
		//capture the project id
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		//Create a get request and pass proID as path parameter
		given()
		 .pathParam("pid", proId)
		.when()
		 .get("/projects/{pid}")
		.then()
		 .assertThat().statusCode(200).log().all();
		 
		
	}

}
