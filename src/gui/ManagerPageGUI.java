package gui;

import Hardware.Bank;
import People.Employee;

public class ManagerPageGUI {
	private Employee employee;
	private Bank bank;
	public ManagerPageGUI(Employee employee, Bank bank)
	{
		System.out.println("got here");
		this.setBank(bank);
		this.setEmployee(employee);
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
