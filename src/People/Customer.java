package People;

import java.io.Serializable;

import Accounts.CheckingAccount;
import Accounts.CreditCard;
import Accounts.Mortgage;
import Accounts.SavingsAccount;
import Hardware.Bank;
import Hardware.Date;
import Hardware.UserLogin;

public class Customer extends Person  implements Serializable{

// objects used SavingsAccount, CheckingAccount, CreditCard, Mortgage, Bank
private int customerNumber;// could change to ArrayLists
private SavingsAccount savingsAccount;
private CheckingAccount checkingAccount;
private CreditCard creditCard;
private Mortgage mortgage;
//Constructors
//this constructor will cause serious issues
/*public Customer() {
	customerNumber = ;// needs to be a value and managed somehow
}*/
/*public Customer(){ // used if Customer is needed to not be null, if ever used, need to set accounts and cust num
	Bank b1 = new Bank();
	 customerNumber = 0;
	 savingsAccount = new SavingsAccount(b1);
	checkingAccount = new CheckingAccount(b1);
	 creditCard = new CreditCard(b1);
	 mortgage = new Mortgage(b1);
	 
}*/
public Customer(Bank holdingBank, String firstName, String lastName, String sS, String address, int zipcode, Date birthday, long phoneNum,
		UserLogin userLogin) {
	super(holdingBank, firstName, lastName, sS, 
			address, zipcode, birthday, phoneNum, userLogin);
	customerNumber = holdingBank.getCurrentCustomerNum();
}
//Methods
public int getCustomberNumber() {
	return customerNumber;
}
public void setCustomerNumber(int customerNumber) {
	this.customerNumber = customerNumber;
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
public CreditCard getCreditCard() {
	return creditCard;
}
public void setCreditCard(CreditCard creditCard) {
	this.creditCard = creditCard;
}
}
