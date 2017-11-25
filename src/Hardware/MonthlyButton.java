package Hardware;

import java.io.Serializable;

import Accounts.CheckingAccount;
import Accounts.CreditCard;
import Accounts.Mortgage;
import Accounts.SavingsAccount;
import People.Banker;
import People.Manager;
import People.Teller;

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
		
		
		//Bank Accounts
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
			//Credit Cards monthly payment
			else if(this.monthlyBank.getBankAccounts().get(i).getClass() == CreditCard.class) {
				CreditCard C2 = (CreditCard) this.monthlyBank.getBankAccounts().get(i);
				C2.monthlyPayment();
				this.monthlyBank.getBankAccounts().set(i, C2);
			}
			
			
			//Employee paychecks
			for(int j = 0; j<this.monthlyBank.getEmployees().size(); j++) {
				if(this.monthlyBank.getEmployees().get(j).getClass() == Banker.class) {
					Banker banker1 = (Banker) this.monthlyBank.getEmployees().get(j);										
					this.monthlyBank.getBanksBankAccount().setBalance(this.monthlyBank.getBanksBankAccount().getBalance() - banker1.getMonthlySalary());
					
				}
				else if(this.monthlyBank.getEmployees().get(j).getClass() == Manager.class) {
					Manager manager1 = (Manager) this.monthlyBank.getEmployees().get(j);										
					this.monthlyBank.getBanksBankAccount().setBalance(this.monthlyBank.getBanksBankAccount().getBalance() - manager1.getMonthlySalary());

				}
				else if(this.monthlyBank.getEmployees().get(j).getClass() == Teller.class) {
					Teller teller1 = (Teller) this.monthlyBank.getEmployees().get(j);
					teller1.setMonthlyPayCheck();
					this.monthlyBank.getBanksBankAccount().setBalance(this.monthlyBank.getBanksBankAccount().getBalance() - teller1.getMonthlyPayCheck());

				}
				
				
				
				
				
				
				
				
				
				
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
