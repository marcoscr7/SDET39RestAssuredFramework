package RequestChaining;
import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import CreateProjectUsingPojoClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectGetProjectAndDeleteProject
{
	@Test
	public void createProjectGetProjectAndDeleteProject()
	{
		Random ran=new Random();
		
		//Step 1:Create pre requisties for Post
		baseURI="http://localhost";
		port=8084;
		
		ProjectLibrary plib=new ProjectLibrary("Anish","Amadeus"+ran.nextInt(100),"created",15);
		
		//step 2:Send the request
		 Response resp = given()
		.body(plib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		
		//Step 3: Capture the project ID writing JSON path
		
		 String projectID = resp.jsonPath().get("projectId");
		 System.out.println(projectID);
		 
		 //Step 4:Send the get request with project ID
		 Response resp1 = given()
		 .pathParam("pid",projectID)
		 .when()
		 .get("projects/{pid}");
		 
		 //step5:Delete the created Project
		 given()
		 .pathParam("pid",projectID)
		 .when()
		 .delete("projects/{pid}")
		 .then()
		 .assertThat().statusCode(204).log().all();
	
		 
		
	}

}
