package People;

import java.io.Serializable;

import Hardware.Bank;
import Hardware.Date;
import Hardware.Record;
import Hardware.UserLogin;
// objects used Record, Bank,
public class Employee extends Person  implements Serializable{
	
	//Fields
	private int employeeNumber;
	private Record paperWork;
	
	//Constructors
	//cause serious issues. Employee number needs to be assigned based on bank upon creation
	/*public Employee() {
		employeeNumber = -1;
		paperWork = new Record();
	}
	public Employee(int eN) {
		employeeNumber = eN;
		paperWork = new Record();
	}*/
	public Employee() {
		employeeNumber = 0; // needs to be assigned based on bank upon creation 
		paperWork = new Record();
	}
	public Employee(Bank holdingBank, String firstName, String lastName, String SS, String address, int zipcode, 
			Date birthday, long phoneNum, UserLogin userLogin) {
		super(holdingBank, firstName, lastName, SS, 
				address, zipcode, birthday, phoneNum, userLogin);
		employeeNumber = holdingBank.getCurrentEmployeeNum();
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
