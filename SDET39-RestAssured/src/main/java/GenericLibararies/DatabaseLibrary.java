package GenericLibararies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseLibrary 
{
	/**
	 * This class consists of generic methods related to database
	 * @author Vikas
	 */
	
	Driver driverRef;
	Connection conn;
	
	/**
	 *This method will estabilsh connection with database 
	 * @throws SQLException
	 */
	
	public void connectToDatabase() throws SQLException
	{
	   driverRef=new Driver();
	   DriverManager.registerDriver(driverRef);
	   conn=DriverManager.getConnection(IConstantsLibrary.databaseURL,IConstantsLibrary.databaseUserName,IConstantsLibrary.databasePassword);
	}
	
	/**
	 * This method will close database connection
	 * @throws SQLException
	 */
    public void closeDatabase() throws SQLException
    {
    	conn.close();
    }
    
    /**
     * This method will execute a query,fetch the data and verify the data in database with exp data from the caller
     * @param query
     * @param columnIndex
     * @param expData
     * @return
     * @throws SQLException
     */
    public String executeQueryAndReturnData(String query,int columnIndex,String expData) throws SQLException
    {
    	ResultSet result = conn.createStatement().executeQuery(query);
    	boolean flag=false;
    	while(result.next())
    	{
    		String actData = result.getString(columnIndex);
    		if(expData.equalsIgnoreCase(actData))
    		{
    			flag=true;
    			break;
    		}
    	}
    	if(flag) 
    	{
    		System.out.println("The data is verified");
    		return expData;
    	}
    	else
    	{
    		System.out.println("The data is not verified");
    		return " ";
    	}

    }
}
