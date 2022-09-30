package GenericLibararies;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * This class will contains basic configuration annotations
 * @author Vikas
 *
 */
public class BaseAPIClass 
{
	public DatabaseLibrary dblib=new DatabaseLibrary();
	public RestAssuredLibrary rlib=new RestAssuredLibrary();
	public JavaLibrary jlib=new JavaLibrary();
	
	@BeforeSuite
	public void beforeSuiteConfig() throws SQLException
	{
		dblib.connectToDatabase();
		Reporter.log("===Database connection successfull===",true);
		
		baseURI=IConstantsLibrary.appURL;
		port=IConstantsLibrary.appPort;
	}
	@AfterSuite
	public void afterSuiteConfig() throws SQLException
	{
		dblib.closeDatabase();
		Reporter.log("===Database Closed===",true);
		
	}
	
	

}
