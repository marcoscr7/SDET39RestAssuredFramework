package Parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PathParameters
{
	@Test
	public void getSingleProject()
	{
		//Pre requisites
		baseURI ="http://localhost";
		port = 8084;
				
		
		given()
	      .pathParam("pid", "TY_PROJ_1609")
	      
		//Actions
	    .when()
	      .get("/projects/{pid}")
		
		//Validations
	     .then()
	      .log().all();
	}

}
