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
	
	//Fields
	private String address;
	private int routingNumber;
	private ArrayList<Employee> employees;
	private ArrayList<Customer> customers;
	private ArrayList<BankAccount> bankAccounts;
	private ArrayList<Mortgage> mortgages;
	private double Assets;
	private double monthlyRevenue;
	private double monthlyProfit;
	private BankAccount banksBankAccount;
	private ArrayList<BankAccount> pendingAccounts;
	private ArrayList<Person> pendingPeople;
	private ArrayList<Person> suspendedAccounts;
	
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
		banksBankAccount = new BankAccount();
		banksBankAccount.setVisible(true);
	}
	public Bank(String a, int rN, ArrayList<Employee> eS, ArrayList<Customer> cS, ArrayList<BankAccount> bS, ArrayList<Mortgage> mS, double mR, double mP, BankAccount money) {
		address = a;
		routingNumber = rN;
		employees = eS;
		customers = cS;
		bankAccounts = bS;
		mortgages = mS;
		monthlyRevenue = mR;
		monthlyProfit = mP;
		banksBankAccount = money;
	}
	
	
	
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
	
	
	
	
	
	
	
}
