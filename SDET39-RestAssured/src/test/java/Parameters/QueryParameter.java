package Parameters;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class QueryParameter 
{
	@Test
	public void queryParameter()
	{
	    baseURI = "https://reqres.in";
	    
	    given()
	     .queryParam("page", 3)
	     
	    .when()
	     .get("/api/users")
	     
	    .then()
	     .log().all();
	}


}
