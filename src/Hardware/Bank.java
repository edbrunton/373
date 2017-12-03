package Hardware;
//objects used Date, Employee, Customer, BankAccount, Mortgage, Person
import java.io.Serializable;
import java.util.ArrayList;

import Accounts.BankAccount;
import Accounts.Mortgage;
import People.Customer;
import People.Employee;
import People.Person;

public class Bank  implements Serializable{
//Objects contained/used: Date,  Employee, Customer, BankAccount, Person, Bank Policy
	
	private String name;
	private Date date;
	private String address;
	private int routingNumber;
	private ArrayList<Employee> employees;
	private ArrayList<Customer> customers;
	private ArrayList<BankAccount> bankAccounts;
	private ArrayList<Mortgage> mortgages;
	private double Assets;//should be a function
	private double monthlyRevenue;//should be a function
	private double monthlyProfit;//should be a function
	private BankAccount banksBankAccount;
	private ArrayList<BankAccount> pendingAccounts;
	private ArrayList<Person> pendingPeople;
	private ArrayList<BankAccount> suspendedAccounts;
	private ArrayList<Employee> loginLockedEmps;
	private int currentAccountNum;
	private int currentCustomerNum;
	private int currentEmployeeNum;
	private BankPolicy bankPolicy;
	//Constructors
	public Bank() {
		setName("Top Notch Bank");
		address = "Default";
		routingNumber = -1;
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
		bankAccounts = new ArrayList<BankAccount>();
		mortgages = new ArrayList<Mortgage>();
		pendingPeople = new ArrayList<Person>();
		suspendedAccounts = new ArrayList<BankAccount>();
		pendingAccounts = new ArrayList<BankAccount>();
		Assets = -1;
		monthlyRevenue = -1;
		monthlyProfit = -1;
		banksBankAccount = new BankAccount(this);//if problems, look here
		banksBankAccount.setVisible(true);
		currentAccountNum = 1;
		currentCustomerNum = 1;
		currentEmployeeNum =1;
		setBankPolicy(new BankPolicy(0.00001, 100, 0.2599, 0.0599));
		date = new Date(12, 17, 1); //December 1st, 2017
	}
	
	public Bank(String name, String addr, int routNum, BankAccount money) { // created parametered constructor
		this.setName(name);
		address = addr;
		routingNumber = routNum;
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
		bankAccounts =  new ArrayList<BankAccount>();
		mortgages =  new ArrayList<Mortgage>();
		monthlyRevenue = 0;
		monthlyProfit = 0;
		banksBankAccount = money;
		banksBankAccount.setVisible(true);
		pendingPeople = new ArrayList<Person>();
		suspendedAccounts = new ArrayList<BankAccount>();
		pendingAccounts = new ArrayList<BankAccount>();
		Assets = -1;
		date = new Date(12, 17, 1); //December 1st, 2017
		setBankPolicy(new BankPolicy(0.00001, 100, 0.2599, 0.0599));
		currentAccountNum = 1;
		currentCustomerNum = 1;
		currentEmployeeNum =1;



	}
	
	
	

	
	public void addEmployee(Employee emp) { // add employee
		this.employees.add(emp);
	}
	public void addCustomer(Customer cust) {// add customer 
		this.customers.add(cust);
	}
	public void addBankAccount(BankAccount bankAccnts) {// add bank account
		this.bankAccounts.add(bankAccnts);
	}
	public void addMortgages(Mortgage mort) {//add Mortgage
		this.mortgages.add(mort);
	}
	public void addPendingAccount(BankAccount pendAccnt) {// add pendingAccount
		this.pendingAccounts.add(pendAccnt);
	}
	public void addPendingPerson(Person pendPers) {// add pending Person
		this.pendingPeople.add(pendPers);
	}
	public void addSuspendedAccount(BankAccount suspAccnt) {// add suspended account 
		this.suspendedAccounts.add(suspAccnt);
	}
	public void addLoginLockedEmp(Employee forgetFulEmp) {// add locked Employee
		this.loginLockedEmps.add(forgetFulEmp);
	}
	
	public void removeEmployee(Employee emp) { // remove employee
		this.employees.remove(emp);
	}
	public void removeCustomer(Customer cust) {// remove customer 
		this.customers.remove(cust);
	}
	public void removeBankAccount(BankAccount bankAccnts) {// remove bank account
		this.bankAccounts.remove(bankAccnts);
	}
	public void removeMortgages(Mortgage mort) {//remove Mortgage
		this.mortgages.remove(mort);
	}
	public void removePendingAccount(BankAccount pendAccnt) {// remove pendingAccount
		this.pendingAccounts.remove(pendAccnt);
	}
	public void removePendingPerson(Person pendPers) {// remove pending Person
		this.pendingPeople.remove(pendPers);
	}
	public void removeSuspendedAccount(BankAccount suspAccnt) {// remove suspended account 
		this.suspendedAccounts.remove(suspAccnt);
	}
	public void removeLoginLockedEmp(Employee forgetFulEmp) {// remove locked Employee
		this.loginLockedEmps.remove(forgetFulEmp);
	}
/* this function searches through bankAccounts field by customer name and returns the account if found, and null otherwise   
*/	public BankAccount findAccount(Person waldo) {
		BankAccount waldoAccount = null;
		for(BankAccount b : bankAccounts) {
			if((b.getOwner().getFirstName()+" "+ b.getOwner().getLastName()).compareTo(waldo.getFirstName()+" "+waldo.getLastName())==0) {
				waldoAccount = b;
				
			}
		}
		return waldoAccount;
	}
	
	// getters and setters 
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public ArrayList<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	
	public ArrayList<Mortgage> getMortgages() {
		return mortgages;
	}
	
	public double getAssets() {
		return Assets;
	}
	public void setAssets(double assets) {
		Assets = assets;
	}
	public double getMonthlyRevenue() {
		return monthlyRevenue;
	}
	public void setMonthlyRevenue(double monthlyRevenue) {
		this.monthlyRevenue = monthlyRevenue;
	}
	public double getMonthlyProfit() {
		return monthlyProfit;
	}
	public void setMonthlyProfit(double monthlyProfit) {
		this.monthlyProfit = monthlyProfit;
	}
	public BankAccount getBanksBankAccount() {
		return banksBankAccount;
	}
	public void setBanksBankAccount(BankAccount banksBankAccount) {
		this.banksBankAccount = banksBankAccount;
	}
	public ArrayList<BankAccount> getPendingAccounts() {
		return pendingAccounts;
	}
	
	public ArrayList<Person> getPendingPeople() {
		return pendingPeople;
	}
	
	public ArrayList<BankAccount> getSuspendedAccounts() {
		return suspendedAccounts;
	}
	
	public int getCurrentAccountNum() {
		currentAccountNum +=1;
		return currentAccountNum-1;
	}
	public void setCurrentAccountNum(int newAccountNumber) {
		this.currentAccountNum = newAccountNumber;
		
	}
	public int getCurrentCustomerNum() {
		currentCustomerNum += 1;
		return currentCustomerNum-1;
	}
	public int getCurrentEmployeeNum() {
		currentEmployeeNum -= 1;
		return currentEmployeeNum-1;
	}



	public BankPolicy getBankPolicy() {
		return bankPolicy;
	}



	public void setBankPolicy(BankPolicy bankPolicy) {
		this.bankPolicy = bankPolicy;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Employee> getLoginLockedEmps() {
		return loginLockedEmps;
	}

	
	
	
}
