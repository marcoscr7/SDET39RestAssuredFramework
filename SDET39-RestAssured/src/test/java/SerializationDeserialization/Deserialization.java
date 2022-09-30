package SerializationDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import practise_POJO_serDes.EmployeesDetails;

public class Deserialization 
{
	@Test
	public void deserializationTest() throws JsonParseException, JsonMappingException, IOException
	{
		
	//step 1 create object for objectMapper
	ObjectMapper obj=new ObjectMapper();
	
	//step 2 read the value from objectMapper class
	EmployeesDetails emp=obj.readValue(new File(".\\Emp.json"),EmployeesDetails.class);
	
	//step 3 access the value using reference
	System.out.println(emp.getEmail());
	}
}
