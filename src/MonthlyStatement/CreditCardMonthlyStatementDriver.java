package MonthlyStatement;


import Accounts.CheckingAccount;
import Accounts.CreditCard;
import Hardware.Bank;
import Hardware.Date;
import Hardware.Fee;
public class CreditCardMonthlyStatementDriver {
	public static void main (String args[]) {
	Bank b1 = new Bank();
	CheckingAccount ca = new CheckingAccount(b1, 30000000, 350);
    CreditCard cc = new CreditCard(b1, 20, 3000, 50000,ca);//starting balance 3000
    ca.Deposit(100);
    ca.Deposit(100);
    ca.directDeposit(); 
    ca.withdraw(100);
    ca.withdraw(10);
   
    Date d = new Date( 1,  2018, 15);
    Fee lf = new Fee(d,"Late fee" ,33); //endbal = 3033
    
    Fee lbf = new Fee(d,"Low balance fee" ,55);//
    cc.addFee(lf);
    cc.addFee(lbf);
    cc.purchase(300);
    cc.monthlyPayment();
    CreditCardMonthlyStatement m1 = new CreditCardMonthlyStatement("January 2018", cc);
    

   
    
    m1.printMonthlyStatement();
	}
}
