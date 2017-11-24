package gui;

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Accounts.BankAccount;
import Accounts.CheckingAccount;
import Accounts.CreditCard;
import Accounts.Mortgage;
import Accounts.SavingsAccount;
import Hardware.Bank;
import People.Customer;

public class AccountGUI {
	private Container inputs;
	private BankAccount bankaccount;
	private Bank bank;
	private JDialog frame;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	public AccountGUI(BankAccount account, Bank bank)
	{
		this.setBank(bank);
		this.setBankaccount(account);
		System.out.println("Bank and Client info loaded");
		String windowTitle = account.getOwner().getFirstName() + " " + account.getOwner().getLastName() + "'s ";
		//for Bank's account, getOwner may throw an error. Needs to be resolved at some point
		if(account instanceof CheckingAccount)
		{
			windowTitle += "Checking Account";
		}
		else if(account instanceof SavingsAccount)
		{
			windowTitle += "Savings Account";
		}
		else if(account instanceof CreditCard)
		{
			windowTitle += "Credit Card";
		}
		else if(account instanceof Mortgage)
		{
			windowTitle += "Mortgage";
		}
		else
		{
			windowTitle += "Master Account";
		}
		frame = new JDialog (new JFrame(), );
		frame.setSize(500, 900);
		inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		JLabel a0 = new JLabel("     ");
		JLabel d0 = new JLabel("     ");
		JLabel f0 = new JLabel("     ");
		JButton e0 = new JButton("Checking Account");
		e0.addActionListener(new LoadAccount(customer.getCheckingAccount(), "Checking Account"));
		JButton e1 = new JButton("Savings Account");
		e1.addActionListener(new LoadAccount(customer.getSavingsAccount(), "Savings Account"));
		JButton e2 = new JButton("Edit Personal Info");
		e2.addActionListener(new EditPersonalInfo());
		JButton e3 = new JButton("Mortgage");
		e3.addActionListener(new LoadAccount(customer.getMortgage(), "Mortgage"));
		JButton e7  = new JButton("Exit");
		e7.addActionListener(e -> frame.dispose());
		JButton b7 = new JButton("Open New Account");
		b7.addActionListener(new OpenNewAccount(bank, customer));
		JButton b1 = new JButton("Credit Card");
	//	b1.addActionListener(new LoadAccount(customer.getCreditCard(), "Credit Card")); //TODO Ryan uncomment when credit card getter made
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		JScrollPane scroll = new JScrollPane(list);
		listModel.addElement("new");//TODO Ryan. Add transactions using this model
		System.out.println("Removing trial element");
		listModel.remove(0);//obvs you won't remove, this is just an example of how to
		System.out.println("Trial element removed");
		addAt(a0, 0, 0);
		addAt(d0, 0, 3);
		addAt(e0, 0, 1);
		addAt(f0, 0, 5);
		addAt(b1, 2, 1);
		addAt(e1, 2, 4);
		addAt(e2, 5, 4);
		addAt(e3, 5, 1);
		addAt(b7, 7, 1);
		addAt(e7, 7, 4);
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
	private void textParseError(String title, String message) {
		JDialog frameTemp = new JDialog (new JFrame(), title);//inspired by https://stackoverflow.com/questions/2665355/how-do-i-remove-the-maximize-and-minimize-buttons-from-a-jframe  
		        Container contentPane = frameTemp.getContentPane ();
		        contentPane.setLayout (new BorderLayout());
		        JButton okay = new JButton("OK");
		        okay.addActionListener(e2 -> frameTemp.dispose());
		        okay.setSize(30, 10);
		        JPanel p1 = new JPanel();
		        p1.add(okay);
		        contentPane.add(p1, BorderLayout.SOUTH);			    	        
		        JLabel outArea = new JLabel(message);
		        contentPane.add(outArea, BorderLayout.CENTER);
		        frameTemp.pack();
		        frameTemp.setVisible (true);		//need to throw error
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public BankAccount getBankaccount() {
		return bankaccount;
	}
	public void setBankaccount(BankAccount bankaccount) {
		this.bankaccount = bankaccount;
	}
}
