package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import Hardware.Bank;
import People.Customer;
import People.Employee;


public class ClientPageGUI {
	private Container inputs;
	private Customer customer;
	private Bank bank;
	private JDialog frame;
	private final class LoadAccount implements ActionListener {
		private BankAccount bA;
		private String account;
		private LoadAccount(BankAccount ba, String account){
			this.bA = ba;
			this.account = account;
		}
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Looking for user's account");
		//	if(bA.equals(null))
			if(bA == null)
			{
				System.out.println("User hasn't created the account");
				System.out.println(account);
				textParseError("You don't have a " + account, "Please consider opening a " + account + " with us on your home page");
			}
			else if(bA.isVisible() == false)
			{
				System.out.println("User hasn't been approved for the account");
				System.out.println(account);
				textParseError(account + " still pending", "Please contact the bank to speed up the process");
			}
			else
			{
				System.out.println("User has the account");
				System.out.println(account);
				new AccountGUI(bA, bank, false);
			}
		}
	}
	private final class EditPersonalInfo implements ActionListener {
		private EditPersonalInfo(){
		}
		public void actionPerformed(ActionEvent e)
		{
			//TODO launch personal info editor
		}
	}
	private final class OpenNewAccount implements ActionListener {
		private Bank bank;
		private Customer customer;
		private OpenNewAccount(Bank bank, Customer customer){
			this.bank = bank;
			this.customer = customer;
		}
		public void actionPerformed(ActionEvent e)
		{
			new NewAccountExistingCustomerGUI(bank, customer);
		}
	}
	public ClientPageGUI(Customer customer, Bank bank)
	{
		this.setBank(bank);
		this.setCustomer(customer);
		System.out.println("Bank and Client info loaded");
		frame = new JDialog (new JFrame(), customer.getFirstName() + " " + customer.getLastName() + "'s portal");
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
		JButton e7  = new JButton("Log Out");
		e7.addActionListener(e -> frame.dispose());
		JButton b7 = new JButton("Open New Account");
		b7.addActionListener(new OpenNewAccount(bank, customer));
		JButton b1 = new JButton("Credit Card");
		b1.addActionListener(new LoadAccount(customer.getCreditCard(), "Credit Card"));
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
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
        
}
