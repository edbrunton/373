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
	private JDialog frameTemp;
	private boolean adminaccess;
	public AccountGUI(BankAccount account, Bank bank, boolean adminaccess)
	{
		this.setBank(bank);
		this.setBankaccount(account);
		this.adminaccess = adminaccess;
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
		frame = new JDialog (new JFrame(), windowTitle);
		frame.setSize(500, 900);
		inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		JLabel a0 = new JLabel("     ");
		JLabel d0 = new JLabel("     ");
		JLabel f0 = new JLabel("     ");
		JLabel b0 = new JLabel("Transactions: ");
		JButton e0 = new JButton("Make Transfer");
		e0.addActionListener(new Transfer());
		JButton e1 = new JButton("View Statement");
		e1.addActionListener(new ViewStatment());
		JButton e2 = new JButton("Edit Personal Info");//only for manager, check that
		e2.addActionListener(new EditPersonalInfo());
		JButton e3 = new JButton("Delete Account");//differet action depending on person
		e3.addActionListener(new DeleteAccount());
		JButton e7  = new JButton("Exit");
		e7.addActionListener(e -> frame.dispose());
	//	JButton b7 = new JButton("Open Selected");
	//	b7.addActionListener(new OpenAccount());
		//JButton b1 = new JButton("Search");
	//	b1.addActionListener(new SearchAccount());
		//JButton monthylButton = new JButton("Monthly Button");
		//monthylButton.addActionListener(new AdvanceMonth());
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		JScrollPane scroll = new JScrollPane(list);
		addAt(scroll, 2, 1, 4, 2);
		//c0 = new JTextField(10);
		listModel.addElement("new");//example of how to have a search element
	//	System.out.println("Removing trial element");
		listModel.remove(0);
	//	System.out.println("Trial element removed");
		addAt(a0, 0, 0);
		addAt(b0, 0, 1, 2);
		//addAt(c0, 0, 2);
		addAt(d0, 0, 3);
		addAt(e0, 0, 4);
		addAt(f0, 0, 5);
		//addAt(b1, 1, 2, 2);
		addAt(e1, 2, 4);
		//addAt(monthylButton, 3, 4);
		addAt(e2, 5, 4);
		addAt(e3, 6, 4);
	//	addAt(b7, 7, 1);
		addAt(e7, 7, 4);
		frame.pack();
		frame.setVisible(true);
	}
	private final class Transfer implements ActionListener {
		
		private Transfer(){
		}

		public void actionPerformed(ActionEvent e)
		{
			new TransferGUI();
		}
	}
	private final class ViewStatment implements ActionListener {
		
		private ViewStatment(){
		}

		public void actionPerformed(ActionEvent e)
		{
			new StatementGUI();
		}
	}
	private final class EditPersonalInfo implements ActionListener {
		
		private EditPersonalInfo(){
		}

		public void actionPerformed(ActionEvent e)
		{
			if(adminaccess)
			{
				new ManagerEditPersonalInfo(bankaccount.getOwner(), bank);
			}
			else
			{
				new EditPersonalInfoGUI(bankaccount.getOwner(), bank);
			}
		}
	}	
	private final class DeleteAccount implements ActionListener {
		
		private DeleteAccount(){
		}

		public void actionPerformed(ActionEvent e)
		{
			confirmDelete("Your Account is About to be Deleted", "Close this window if you wish to abort the deletion"); 
		}
	}
	private void confirmDelete(String title, String message) {
		frameTemp = new JDialog (new JFrame(), title);//inspired by https://stackoverflow.com/questions/2665355/how-do-i-remove-the-maximize-and-minimize-buttons-from-a-jframe  
		        Container contentPane = frameTemp.getContentPane ();
		        contentPane.setLayout (new BorderLayout());
		        JButton okay = new JButton("Confirm Delete");
		        okay.addActionListener(new ActuallyDelete());
		        okay.setSize(30, 10);
		        JPanel p1 = new JPanel();
		        p1.add(okay);
		        contentPane.add(p1, BorderLayout.SOUTH);			    	        
		        JLabel outArea = new JLabel(message);
		        contentPane.add(outArea, BorderLayout.CENTER);
		        frameTemp.pack();
		        frameTemp.setVisible (true);		//need to throw error
	}
	private final class ActuallyDelete implements ActionListener {
		
		private ActuallyDelete(){
		}

		public void actionPerformed(ActionEvent e)
		{
			if(adminaccess)
			{
				bank.getBankAccounts().remove(bankaccount);
				if(bankaccount instanceof CheckingAccount)
				{
					bankaccount.getOwner().setCheckingAccount(null);
				}
				else if(bankaccount instanceof SavingsAccount)
				{
					bankaccount.getOwner().setSavingsAccount(null);
				}
				else if(bankaccount instanceof CreditCard)
				{
			//		bankaccount.getOwner().setCreditCard(null);//TODO Ryan. Make the setter and uncomment
				}
				else if(bankaccount instanceof Mortgage)
				{
					bankaccount.getOwner().setMortgage(null);
				}
				else
				{
					System.out.println("Surely an error, cannot delete bank");
				}
				//deletes person if they bno longer have accounts
				if (bankaccount.getOwner().getMortgage() == null &&
					bankaccount.getOwner().getCheckingAccount() == null &&
					bankaccount.getOwner().getSavingsAccount() == null //&&
					//bankaccount.getOwner().getCreditCard() == null//TODO Ryan. need this getter please; uncomment when done
				)
				{
					bank.getCustomers().remove(bankaccount.getOwner());
				}
				frameTemp.dispose();
				frame.dispose();
			}
			else
			{
				textParseError("Permission Denied", "Please contact a banker to do this action");
			}
		}
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
