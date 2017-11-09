package People;

import java.io.Serializable;

import Hardware.Date;
import Hardware.Record;
import Hardware.UserLogin;

public class Employee extends Person  implements Serializable{
	
	//Fields
	private int employeeNumber;
	private Record paperWork;
	
	//Constructors
	public Employee() {
		employeeNumber = -1;
		paperWork = new Record();
	}
	public Employee(int eN) {
		employeeNumber = eN;
		paperWork = new Record();
	}
	public Employee(String firstName, String lastName, String SS, String add, int zC, Date bD, long pN,
			int eN, UserLogin login) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = SS;
		this.address = add;
		this.zipCode = zC;
		this.birthday = bD;
		this.phoneNumber = pN;
		this.login = login;
		employeeNumber = eN;
		paperWork = new Record();
	}
	
	
	
	
	
	
	
	
	//Methods
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Record getPaperWork() {
		return paperWork;
	}
	public void setPaperWork(Record paperWork) {
		this.paperWork = paperWork;
	}

}
