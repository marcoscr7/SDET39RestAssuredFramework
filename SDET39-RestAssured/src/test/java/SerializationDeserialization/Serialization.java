package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practise_POJO_serDes.EmployeesDetails;

public class Serialization
{
	@Test
	public void serializationTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		//step 1 create object of pojo class
		EmployeesDetails emp=new EmployeesDetails("Vikas",8839699,"TY777","vrajak07@gmail.com",true);
		// step 2 create object of objectMapper from jacksonMapper-tool
		ObjectMapper obj=new ObjectMapper();
		
		//step 3 call write value method and provide the file path
		obj.writeValue(new File(".\\Emp1.json"),emp);
	
	}
}
