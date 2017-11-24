package People;

import java.io.Serializable;

import Hardware.Bank;
import Hardware.Date;
import Hardware.UserLogin;

public abstract class Person  implements Serializable{
//Fields
protected String firstName;
protected String lastName;
protected String socialSecurityNumber;
protected String address;
protected int zipCode;
protected Date birthday;
protected long phoneNumber;
protected UserLogin login;
protected Bank holdingBank;
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public UserLogin getLogin() {
	return login;
}
public void setLogin(UserLogin login) {
	this.login = login;
}
//Constructors
//Probably will cause serious issues
/*public Person() {
	firstName = "Default";
	lastName = "Default";
	socialSecurityNumber = "null";
	address = "Default";
	zipCode = -1;
	birthday = new Date();
	phoneNumber = -1;
}*/
public Person(Bank holdingBank, String firstName, String lastName, String SS, String add, int zC, Date bD, long pN, UserLogin userLogin) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.socialSecurityNumber = SS;
	this.address = add;
	this.zipCode = zC;
	this.birthday = bD;
	this.phoneNumber = pN;
	this.holdingBank = holdingBank;
	this.login = userLogin;
}






//Methods
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getSocialSecurityNumber() {
	return socialSecurityNumber;
}
public void setSocialSecurityNumber(String socialSecurityNumber) {
	this.socialSecurityNumber = socialSecurityNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getZipCode() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
public Date getBirthDay() {
	return birthday;
}
public void setBirthDay(Date birthday) {
	this.birthday = birthday;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
	
	
	
	
}
