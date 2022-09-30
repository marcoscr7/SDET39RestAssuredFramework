package DifferentWaysToPOST;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectUsingJSONFile
{
	@Test
	public void CreateProjectUsingJSONFIle()
	
	{
	   baseURI="http//:localhost";
       port=8084;
       
       //create prerequistes
       File file=new File(".\\data.json");
       
       //send request and validate
       given()
       .body(file)
       .contentType(ContentType.JSON)
       .when()
       .post("/addProject")
       .then()
       .assertThat().statusCode(201).log().all();
       
	}

}
