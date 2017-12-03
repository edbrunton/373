package Hardware;
//objects used null 
import java.io.Serializable;

public class BankPolicy  implements Serializable {
	private double SavingsAccountinterestRate;
	private double SavingsAccountminBalance;
	private double CreditCardinterestRate;
	private double MortgageInterestRate;
	public BankPolicy(double SavingsAccountinterestRate, double SavingsAccountminBalance,
			double CreditCardinterestRate,  double MortgageInterestRate )
	{
		this.SavingsAccountinterestRate=SavingsAccountinterestRate;
		this.SavingsAccountminBalance=SavingsAccountminBalance;
		this.CreditCardinterestRate=CreditCardinterestRate;
		this.MortgageInterestRate=MortgageInterestRate;
	}
	public double getSavingsAccountinterestRate() {
		return SavingsAccountinterestRate;
	}
	public void setSavingsAccountinterestRate(double savingsAccountinterestRate) {
		SavingsAccountinterestRate = savingsAccountinterestRate;
	}
	public double getCreditCardinterestRate() {
		return CreditCardinterestRate;
	}
	public void setCreditCardinterestRate(double creditCardinterestRate) {
		CreditCardinterestRate = creditCardinterestRate;
	}
	public double getSavingsAccountminBalance() {
		return SavingsAccountminBalance;
	}
	public void setSavingsAccountminBalance(double savingsAccountminBalance) {
		SavingsAccountminBalance = savingsAccountminBalance;
	}
	public double getMortgageInterestRate() {
		return MortgageInterestRate;
	}
	public void setMortgageInterestRate(double mortgageInterestRate) {
		MortgageInterestRate = mortgageInterestRate;
	}
	
}
