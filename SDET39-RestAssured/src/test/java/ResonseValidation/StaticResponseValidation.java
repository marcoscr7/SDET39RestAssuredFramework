package ResonseValidation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation 
{
  @Test
  public void staticResponseValidation()
  {
		//step1 create pre requisites
		baseURI="http://localhost";
		port=8084;
		JSONObject obj=new JSONObject();
		obj.put("createdBy","sakiv");
		obj.put("projectName","SDET");
		obj.put("status","completed");
		obj.put("teamSize",1);
	
		String expData="SDET";
		
		//step2 send the request
		Response resp = given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//step 3 valid the response
		String actData=resp.jsonPath().get("projectName");
		Assert.assertEquals(actData,expData);
		resp.then().log().all();
  }

}
