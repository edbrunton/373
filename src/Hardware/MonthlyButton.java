package Hardware;

import java.io.Serializable;

import Accounts.CheckingAccount;
import Accounts.Mortgage;
import Accounts.SavingsAccount;

public class MonthlyButton implements Serializable{
	//Fields
	private Date date;
	private Bank monthlyBank;
	//Constructor
	public MonthlyButton() {
		date = new Date();	
	}
	public MonthlyButton(Bank B) {
		date = monthlyBank.getDate();
		monthlyBank = B;
	}
	
	
	
	
	
	//Methods
	public void pushMonthlyButton() {
		//Every Monthly Function
		
		//SETS NEW MONTH
		if(this.date.getMonth() == 12) {
			this.date.setMonth(1);
			this.date.setYear(this.date.getYear() + 1);
		}
		else {
		this.date.setMonth(this.date.getMonth() + 1);
		}
		monthlyBank.setDate(date);
		
		for(int i = 0; i < this.monthlyBank.getBankAccounts().size(); i++) {
			//savings account monthly interest
			if (this.monthlyBank.getBankAccounts().get(i).getClass() == SavingsAccount.class ) {
				SavingsAccount S1 = (SavingsAccount) this.monthlyBank.getBankAccounts().get(i);
				S1.monthlyInterest();
				this.monthlyBank.getBankAccounts().set(i, S1);
			}
			//mortgage monthly payment
			else if(this.monthlyBank.getBankAccounts().get(i).getClass() == Mortgage.class) {
				Mortgage M1 = (Mortgage) this.monthlyBank.getBankAccounts().get(i);
				M1.monthlyPayment();
				this.monthlyBank.getBankAccounts().set(i, M1);

			}
			//checking account monthly direct deposit
			else if(this.monthlyBank.getBankAccounts().get(i).getClass() == CheckingAccount.class) {
				CheckingAccount C1 = (CheckingAccount) this.monthlyBank.getBankAccounts().get(i);
				C1.directDeposit();
				this.monthlyBank.getBankAccounts().set(i, C1);
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
