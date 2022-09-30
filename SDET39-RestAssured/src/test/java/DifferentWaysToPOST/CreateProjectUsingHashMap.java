package DifferentWaysToPOST;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashMap 
{
	@Test
	public void createProjectUsingHashMap()
	{
		baseURI="http://localhost";
		port=8084;
		//Create prerequisits
		HashMap map=new HashMap();
		map.put("createdBy","Vikas");
		map.put("projectName","SDET39");
		map.put("status","created");
		map.put("teamSize",10);
		 
		//send the request and validate
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201).log().all();
	}

}
