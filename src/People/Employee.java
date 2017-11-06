package People;

import java.io.Serializable;

import Hardware.Record;

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
