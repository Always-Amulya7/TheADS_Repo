package Quiz_Workspace.Quiz_Work;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeTravel;

	public int getemployeeId(){
		return employeeId;
	}

	public void setemployeeId(int employeeId){
		this. employeeId =employeeId;
	}

	public String getemployeeName(){
		return employeeName;
	}

	public void setemployeeName(String employeeName){
		this. employeeName = employeeName;
	}
	
	public String getemployeeAddress(){
		return employeeAddress;
	}
	
	public void setemployeeAddress(String employeeAddress) {
		this. employeeAddress = employeeAddress;
	}
	
	public int getemployeeTravel(){
		return employeeId;
	}

	public void setemployeeTravel(String employeeTravel){
		this. employeeTravel = employeeTravel;
	}
	
	public Employee(int employeeId, String employeeName, String employeeAddress, String employeeTravel) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeTravel = employeeTravel;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + ", employeeTravel=" + employeeTravel + "]";
	}
	
	
}