package practise_POJO_serDes;

public class EmployeesDetails
{
	//Step 1 declare all the variables globally
	String name;
	int phone;
	String EmpID;
	String email;
	boolean isEmployed;
	
	//Step 2 Create a constructor to initialize the variables
	public EmployeesDetails(String name, int phone, String empID, String email, boolean isEmployed) 
	{
		
		this.name = name;
		this.phone = phone;
		this.EmpID = empID;
		this.email = email;
		this.isEmployed = isEmployed;
	}
	//Step 3 provide getters and setters methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmpID() {
		return EmpID;
	}

	public void setEmpID(String empID) {
		EmpID = empID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}
	
	

	
	

}
