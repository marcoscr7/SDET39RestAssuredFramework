package DataDriven_DataProvider;

import java.util.Random;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CreateProjectUsingPojoClass.ProjectLibrary;
import io.restassured.http.ContentType;

public class CreateMultipleProjectWithDifData 
{

	@Test(dataProvider = "DataForPost")
	public void createProjectWithDiffData(String createdBy, String projectName, String status, int teamSize) {
		baseURI = "http://localhost";
		port = 8084;
		
		//pre-requisite
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		
		ProjectLibrary plib = new ProjectLibrary(createdBy, projectName+random, status, teamSize);
		
		given()
		.body(plib)
		.contentType(ContentType.JSON)
		
		//Actions to be performed
		.when()
		.post("/addProject")
		//Validation
		.then().log().all();
	}
		@DataProvider(name="DataForPost")
		public Object[][] dataForPost()
		{
			Object[][] data = new Object[10][4];
			data[0][0] = "sachi";
			data[0][1] = "Tsm";
			data[0][2] = "On Going";
			data[0][3] = 14;
			
			data[1][0] = "Sonu";
			data[1][1] = "Cisf";
			data[1][2] = "Created";
			data[1][3] = 5;
			
			data[2][0] = "Musk";
			data[2][1] = "Windows";
			data[2][2] = "On Going";
			data[2][3] = 15;
			
			data[3][0] = "ashish";
			data[3][1] = "Iphone";
			data[3][2] = "Completed";
			data[3][3] = 9;
			
			data[4][0] = "shanu";
			data[4][1] = "lpu";
			data[4][2] = "Created";
			data[4][3] = 20;
			
			data[4][0] = "nanu";
			data[4][1] = "iquanta";
			data[4][2] = "Created";
			data[4][3] = 2;
			
			data[5][0] = "vikram";
			data[5][1] = "Impact";
			data[5][2] = "Created";
			data[5][3] = 20;
			
			data[6][0] = "Beni";
			data[6][1] = "Ncl";
			data[6][2] = "Created";
			data[6][3] = 20;
			
			data[7][0] = "nitesh";
			data[7][1] = "ncl";
			data[7][2] = "Created";
			data[7][3] = 20;
			
			data[8][0] = "Mahi";
			data[8][1] = "Lenovo";
			data[8][2] = "Created";
			data[8][3] = 20;
			
			data[9][0] = "Mahi";
			data[9][1] = "Lenovo";
			data[9][2] = "Created";
			data[9][3] = 20;
			
			
			return data;
			
		}
}
