package GenericLibararies;

import java.util.Random;

/**
 * This class contains  generic methods related to java 
 * @author Vikas
 *
 */

public class JavaLibrary 
{
	/**
	 * This method will return the random number for every execution
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		return ran.nextInt(1000);
				
	}

}
