package Parameters;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class formParameter 

{
	 @Test
		public void formParameterTest()
		{
			//Step 1: create pre requisites
		 baseURI="localhost";
		 port=8084;
		 
			//Step 2: send the request and validate response
			given()
			  .formParam("createdBy", "MarcosYT")
			  .formParam("projectName", "BGMI")
			  .formParam("status", "Completed")
			  .formParam("teamSize", 12)
			  .contentType(ContentType.JSON)
			.when()
			  .post("/addProject")
			.then()
			.log().all();
		}
}
