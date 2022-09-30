package End2EndScenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import CreateProjectUsingPojoClass.ProjectLibrary;
import GenericLibararies.BaseAPIClass;
import GenericLibararies.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
public class CreateProjectAndVerifyInDatabase extends BaseAPIClass

{
@Test
public void createProject() throws SQLException
{
	//Step 1:Create pre requisites
	ProjectLibrary plib=new ProjectLibrary("VikasGaming","Apple"+jlib.getRandomNumber(),"Created",7);
	
	//Step 2:Send the post request
	Response resp = given()
	.body(plib)
	.contentType(ContentType.JSON)
	.when()
	.post(EndPointsLibrary.createProject);
	
	//Step 3:capture the project ID
	String expData = rlib.getJsonData(resp,"projectId");
	System.out.println(expData);
	
	//Step 4:verify the project ID in database
	String query="select* from project;";
	String actData=dblib.executeQueryAndReturnData(query,1, expData);
	Assert.assertEquals(actData,expData);
	
}

}
