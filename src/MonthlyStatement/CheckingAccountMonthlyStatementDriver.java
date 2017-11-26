package MonthlyStatement;


import Accounts.CheckingAccount;
import Hardware.Bank;
import Hardware.Date;
import Hardware.Fee;
public class CheckingAccountMonthlyStatementDriver {
	public static void main (String args[]) {
	Bank b1 = new Bank();
    CheckingAccount ca = new CheckingAccount(b1, 100, 100);
    ca.Deposit(100);
    ca.Deposit(100);
    ca.directDeposit(); 
    ca.withdraw(100);
    ca.withdraw(10);
   
    Date d = new Date( 1,  2018, 15);
    Fee lf = new Fee(d,"Late fee" ,33);
    
    Fee lbf = new Fee(d,"Low balance fee" ,55);
    ca.addFee(lf);
    ca.addFee(lbf);
    CheckingAccountMonthlyStatement m1 = new CheckingAccountMonthlyStatement(ca);
    

   
    
    m1.printMonthlyStatement();
	}
}

