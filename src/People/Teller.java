package People;

public class Teller extends Employee{
	
	//Fields
	private double hourlyPay;
	private int monthlyHours;
	
	//Constructors
	public Teller() {
		hourlyPay = -1;
		monthlyHours = -1;
	}
	public Teller(double hP, int mH) {
		hourlyPay = hP;
		monthlyHours = mH;
	}
	
	
	
	//Methods
	public double getHourlyPay() {
		return hourlyPay;
	}
	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}
	public int getMonthlyHours() {
		return monthlyHours;
	}
	public void setMonthlyHours(int monthlyHours) {
		this.monthlyHours = monthlyHours;
	}
	
	
	
	
	
	
	
}
