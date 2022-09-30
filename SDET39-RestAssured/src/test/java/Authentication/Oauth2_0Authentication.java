package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2_0Authentication 
{
	@Test
	public void oauth2Auth()
	{
        //Step 1: genrate the access token POST
		baseURI="http://coop.apps.symfonycasts.com";
		
		 Response resp = given()
		.formParam("client_id","SDET39RestAssuredVikas")
		.formParam("client_secret","ba5764acc022815db75dd14f6692f683")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","http://example.com")
		.formParam("code","authorization_code")
		.when()
		.post("/token");
		 
		 //Step 2: capture the access token
		 
		 String token = resp.jsonPath().get("access_token");
		 System.out.println(token);
		 
		 //Step 3: use it for other end point
		 
		 given()
		 .pathParam("USER_ID","3857")
		 .auth()
		 .oauth2(token)
		 .when()
		 .post("/api/{USER_ID}/chickens-feed")
		 .then().log().all();
		
	    
		
	}
  
	
	
}
