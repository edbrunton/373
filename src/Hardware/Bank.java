package Hardware;
// make a method called print all 
import java.io.Serializable;
import java.util.ArrayList;

import Accounts.BankAccount;
import Accounts.Mortgage;
import People.Customer;
import People.Employee;
import People.Person;

public class Bank  implements Serializable{
	
	//Fields Ryan Raettig
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
	private ArrayList<Person> suspendedAccounts;
	private int currentAccountNum;
	private int currentCustomerNum;
	private int currentEmployeeNum;
	private BankPolicy bankPolicy;
	//Constructors
	public Bank() {
		address = "Default";
		routingNumber = -1;
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
		bankAccounts = new ArrayList<BankAccount>();
		mortgages = new ArrayList<Mortgage>();
		pendingPeople = new ArrayList<Person>();
		suspendedAccounts = new ArrayList<Person>();
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
	}
	//this constructor is going to cause serious issues. Employeees, customers and accounts need to be added one by one
	/*public Bank(String a, int rN, ArrayList<Employee> eS, ArrayList<Customer> cS, ArrayList<BankAccount> bS, ArrayList<Mortgage> mS, double mR, double mP, BankAccount money) {
		address = a;
		routingNumber = rN;
		employees = eS;
		customers = cS;
		bankAccounts = bS;
		mortgages = mS;
		monthlyRevenue = mR;
		monthlyProfit = mP;
		banksBankAccount = money;
	}*/
	
	
	
	//Methods

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
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public ArrayList<BankAccount> getBankAccounts() {
		return bankAccounts;
	}
	public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	public ArrayList<Mortgage> getMortgages() {
		return mortgages;
	}
	public void setMortgages(ArrayList<Mortgage> mortgages) {
		this.mortgages = mortgages;
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
	public void setPendingAccounts(ArrayList<BankAccount> pendingAccounts) {
		this.pendingAccounts = pendingAccounts;
	}
	public ArrayList<Person> getPendingPeople() {
		return pendingPeople;
	}
	public void setPendingPeople(ArrayList<Person> pendingPeople) {
		this.pendingPeople = pendingPeople;
	}
	public ArrayList<Person> getSuspendedAccounts() {
		return suspendedAccounts;
	}
	public void setSuspendedAccounts(ArrayList<Person> suspendedAccounts) {
		this.suspendedAccounts = suspendedAccounts;
	}
	public int getCurrentAccountNum() {
		currentAccountNum +=1;
		return currentAccountNum-1;
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
	
	
}
