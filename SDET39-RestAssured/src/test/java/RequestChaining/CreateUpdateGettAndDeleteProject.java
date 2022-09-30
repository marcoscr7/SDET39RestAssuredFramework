package RequestChaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.Random;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import CreateProjectUsingPojoClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUpdateGettAndDeleteProject 
{
	@Test
	public void createUpdateGettAndDeleteProject()
	{
		Random ran=new Random();
		
		//Step 1:Create pre requisties for Post
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary plib=new ProjectLibrary("Vikas","TestYantra"+ran.nextInt(100),"created",15);
		
		//step 2:Send the request
		 Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		
		//Step 3: Capture the project ID writing JSON path
		
		 String projectID = resp.jsonPath().get("projectId");
		 System.out.println(projectID);
		 
		 //step 4:Update the project
	
			 plib.setStatus("Completed");
			 given()
			.body(plib)
			.contentType(ContentType.JSON)
			.pathParam("pid", projectID)
			.when()
			.put("/projects/{pid}")
			.then()
			.assertThat().statusCode(200)
			.log().all();
		 
		 //Step 5:Send the get request with project ID
		 Response resp1 = given()
		 .pathParam("pid",projectID)
		 .when()
		 .get("projects/{pid}");
		 
		 //step 6:Delete the created Project
		 given()
		 .pathParam("pid",projectID)
		 .when()
		 .delete("projects/{pid}")
		 .then()
		 .assertThat().statusCode(204).log().all();
}
}
