package DifferentWaysToPOST;


import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectIUsingJsonObject
{
	@Test
	public void createProjectUsingJsonObject()
	{
		baseURI="http://localhost";
		port=8084;
		Random ran=new Random();
		int random=ran.nextInt(1000);
		

		//create pre requisites
		JSONObject obj=new JSONObject();
	
		obj.put("createdBy","VikasRajak");
		obj.put("projectName","Garud");
		obj.put("status","Ongoing");
		obj.put("teamSize",7);
		
		//Send the request and validate the response
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201).log().all();
		
	}

}


