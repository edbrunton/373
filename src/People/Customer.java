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
//TODO ryan. Missing credit card
//Constructors
public Customer() {
	customberNumber = -1;// needs to be a value and managed somehow
//savingsAccount = new SavingsAccount();//TODO Ryan. They should not have a new mortgage for just making an account
	//checkingAccount = new CheckingAccount();//TODO Ryan none of these should be initialized. Going to cause major issues
//	mortgage = new Mortgage();
}
/*public Customer(int cN, SavingsAccount sA) {//this is never used
	customberNumber = cN;
	savingsAccount = sA;
	checkingAccount = new CheckingAccount();
	mortgage = new Mortgage();
}*/
/*public Customer(int cN, CheckingAccount cA, Mortgage m) {//this is never used
	customberNumber = cN;
	savingsAccount = new SavingsAccount();
	checkingAccount = cA;
	mortgage = m;
}*/










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
public SavingsAccount getSavingsAccount() {
	return savingsAccount;
}
public void setSavingsAccount(SavingsAccount savingsAccount) {
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
