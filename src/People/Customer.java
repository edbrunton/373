package People;

import java.io.Serializable;

import Accounts.CheckingAccount;
import Accounts.Mortgage;
import Accounts.SavingsAccount;
import Hardware.Date;
import Hardware.UserLogin;

public class Customer extends Person  implements Serializable{

//Fields
private int customberNumber;
private SavingsAccount savingsAccount;
private CheckingAccount checkingAccount;
private Mortgage mortgage;

//Constructors
public Customer() {
	customberNumber = -1;
	savingsAccount = new SavingsAccount();
	checkingAccount = new CheckingAccount();
	mortgage = new Mortgage();
}
public Customer(int cN, SavingsAccount sA) {
	customberNumber = cN;
	savingsAccount = sA;
	checkingAccount = new CheckingAccount();
	mortgage = new Mortgage();
}
public Customer(int cN, CheckingAccount cA, Mortgage m) {
	customberNumber = cN;
	savingsAccount = new SavingsAccount();
	checkingAccount = cA;
	mortgage = m;
}










public Customer(String firstName, String lastName, String sS, String address, int zipcode, Date temp, long phoneNum,
		UserLogin userLogin) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.socialSecurityNumber = sS;
	this.address = address;
	this.zipCode = zipcode;
	this.birthday = temp;
	this.phoneNumber = phoneNum;
	this.login = userLogin;
}
//Methods
public int getCustomberNumber() {
	return customberNumber;
}
public void setCustomberNumber(int customberNumber) {
	this.customberNumber = customberNumber;
}
public SavingsAccount getSacingsAccount() {
	return savingsAccount;
}
public void setSacingsAccount(SavingsAccount savingsAccount) {
	this.savingsAccount = savingsAccount;
}
public CheckingAccount getCheckingAccount() {
	return checkingAccount;
}
public void setCheckingAccount(CheckingAccount checkingAccount) {
	this.checkingAccount = checkingAccount;
}













public Mortgage getMortgage() {
	return mortgage;
}













public void setMortgage(Mortgage mortgage) {
	this.mortgage = mortgage;
}
	
	
	
	
	
}
