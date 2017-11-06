package Hardware;

import java.io.Serializable;
import java.util.ArrayList;

import Accounts.BankAccount;
import Accounts.Mortgage;
import People.Customer;
import People.Employee;

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
	
	//Constructors
	public Bank() {
		address = "Default";
		routingNumber = -1;
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
		bankAccounts = new ArrayList<BankAccount>();
		mortgages = new ArrayList<Mortgage>();
		Assets = -1;
		monthlyRevenue = -1;
		monthlyProfit = -1;
		banksBankAccount = new BankAccount();
	}
	public Bank(String a, int rN, ArrayList<Employee> eS, ArrayList<Customer> cS, ArrayList<BankAccount> bS, ArrayList<Mortgage> mS, double at, double mR, double mP, BankAccount money) {
		address = a;
		routingNumber = rN;
		employees = eS;
		customers = cS;
		bankAccounts = bS;
		mortgages = mS;
		Assets = at;
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
	
	
	
	
	
	
	
}
