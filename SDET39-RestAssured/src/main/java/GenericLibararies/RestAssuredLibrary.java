package GenericLibararies;

import io.restassured.response.Response;

/**
 * This class consists of generic methods related to restassured
 * @author Vikas
 */


public class RestAssuredLibrary 
{
/**
 * This method will fetch the data based on json path	
 * @param response
 * @param path
 * @return
 */
	
	public String getJsonData(Response response,String path)
	{
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}
	

}
