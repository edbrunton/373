package gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Accounts.BankAccount;
import Accounts.CheckingAccount;
import Accounts.CreditCard;
import Accounts.Mortgage;
import Accounts.SavingsAccount;
import Hardware.Bank;
import MonthlyStatement.CheckingAccountMonthlyStatement;
import MonthlyStatement.CreditCardMonthlyStatement;
import MonthlyStatement.MortgageMonthlyStatement;
import MonthlyStatement.SavingsAccountMonthlyStatement;

public class StatementGUI {
	private Container inputs;
	private BankAccount bankaccount;
	private Bank bank;
	private JDialog frame;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JDialog frameTemp;
	private boolean adminaccess;
	public StatementGUI(BankAccount account)
	{
		this.bankaccount = account;
		System.out.println("Account Info loaded");
		String windowTitle = account.getOwner().getFirstName() + " " + account.getOwner().getLastName() + "'s ";
		//for Bank's account, getOwner may throw an error. Needs to be resolved at some point
		JLabel b1 = new JLabel();
		if(account instanceof CheckingAccount)
		{
			CheckingAccountMonthlyStatement checkingAccount = new CheckingAccountMonthlyStatement((CheckingAccount)account);
			b1 = new JLabel(checkingAccount.printMonthlyStatement().toString());
			windowTitle += "Checking Account";
		}
		else if(account instanceof SavingsAccount)
		{
			SavingsAccountMonthlyStatement savingsAccount = new SavingsAccountMonthlyStatement();
			b1 = new JLabel(savingsAccount.printMonthlyStatement().toString());
			windowTitle += "Savings Account";
		}
		else if(account instanceof CreditCard)
		{
			CreditCardMonthlyStatement creditCard = new CreditCardMonthlyStatement((CreditCard)account);
			b1 = new JLabel(creditCard.printMonthlyStatement().toString());
			windowTitle += "Credit Card";
		}
		else if(account instanceof Mortgage)
		{
			MortgageMonthlyStatement mortgage = new MortgageMonthlyStatement((Mortgage)account);
			b1 = new JLabel(mortgage.printMonthlyStatement().toString());
			windowTitle += "Mortgage";
		}
		else
		{
			windowTitle += "Master Account";
		}
		windowTitle += " Statement";
		frame = new JDialog (new JFrame(), windowTitle);
		frame.setSize(500, 900);
		inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		JLabel a0 = new JLabel("     ");
		JLabel b0 = new JLabel("     ");
		JLabel c0 = new JLabel("     ");
		JButton e7  = new JButton("Exit");
		e7.addActionListener(e -> frame.dispose());
		//c0 = new JTextField(10);
		listModel.addElement("new");//example of how to have a search element
	//	System.out.println("Removing trial element");
		listModel.remove(0);
	//	System.out.println("Trial element removed");
		addAt(a0, 0, 0);
		addAt(b0, 0, 1);
		addAt(c0, 0, 2);
		//addAt(b1, 1, 2, 2);
		addAt(b1, 1, 1);
		addAt(e7, 2, 1);
		frame.pack();
		frame.setVisible(true);
	}
	private void addAt(JScrollPane scroll, int row, int column, int rowSpan, int colSpan) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		c.gridwidth = colSpan;
		c.gridheight = rowSpan;
		inputs.add(scroll, c);	
	}
	private void addAt(JButton a1, int row, int column, int span) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		c.gridwidth = span;
		inputs.add(a1, c);	
	}	
	private void addAt(JLabel a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JTextField a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JPasswordField a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JButton a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JComboBox a1, int row, int column) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		inputs.add(a1, c);	
	}
	private void addAt(JLabel a1, int row, int column, int span) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridy =row;
		c.gridx = column;
		c.gridwidth = span;
		inputs.add(a1, c);	
	}	
}
