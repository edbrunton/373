package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Accounts.BankAccount;
import Accounts.CheckingAccount;
import Accounts.Mortgage;
import Accounts.SavingsAccount;
import Hardware.Bank;
import Hardware.Date;
import Hardware.UserLogin;
import People.Customer;
import People.Employee;

public class NewAccountExistingCustomerGUI {
	private Bank bank;
	private Customer customer;
	private JDialog frame;
	private Container inputs;
	private JComboBox f1;
	private JTextField f2;
	private String[] AccountTypes;
	//TODO: make type of account have selection box
	public NewAccountExistingCustomerGUI(Bank bank, Customer customer)
	{
		String[] temp = {"Savings", "Checking", "Credit", "Mortgage"};
		AccountTypes = temp;
		this.bank = bank;
		this.customer = customer;
		buildGUI();
	}
	private final class SubmitApplication implements ActionListener {
		
		private SubmitApplication(){
		}

		public void actionPerformed(ActionEvent e)
		{
			boolean valid = true;
			String accountType = (String)f1.getSelectedItem();
			String loanAmountIn = f2.getText();
			double loanAmount = -1;
			if(accountType.compareTo("Mortgage") == 0)
			{
				try {
					loanAmount = Double.parseDouble(loanAmountIn);
					if (loanAmount <= 0)
					{
						throw new Exception("error");
					}
				}
				catch(Exception p)
				{
					valid = false;
					String title = "Error Loan Amount Not Valid";
					String message ="Enter a valid loan amount";
					textParseError(title, message);
				}
			}
			if(valid == true)
			{
				BankAccount tempBA = null;
					if(accountType.compareTo("Savings") == 0 && customer.getSavingsAccount().equals(null))
					{
						tempBA = new SavingsAccount(0.001, 0.0, 0.0);
						customer.setSavingsAccount((SavingsAccount)tempBA);//TODO Ryan
					}
					if(accountType.compareTo("Checking") == 0 && customer.getSavingsAccount().equals(null))
					{
						tempBA = new CheckingAccount(0.0, 0.0);
						customer.setCheckingAccount((CheckingAccount)tempBA);//TODO Ryan
					}
					if(accountType.compareTo("Mortgage") == 0 && customer.getCheckingAccount().equals(null))
					{
						tempBA =new Mortgage(loanAmount, loanAmount, 7.25, new CheckingAccount(0.0, 0.0));
						customer.setMortgage((Mortgage)tempBA);//TODO Ryan
					}
					//TODO: different account types and such
					if(tempBA.equals(null))
					{
						textParseError("Account Exists", "You already have this type of account");
					}
					else
					{
						bank.getPendingAccounts().add(tempBA);	
					}
//bank.getPendingPeople().get(bank.getPendingPeople().size()-1);
				}
				frame.dispose();
			}
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
			        frameTemp.setVisible (true);	//need to throw error
		}
	
	private void buildGUI() {
		frame = new JDialog (new JFrame(), "New Account Request");
		frame.setSize(500, 900);
		inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		JLabel a0 = new JLabel("  a0   ");
		JLabel d0 = new JLabel("   d0  ");
		JLabel g0 = new JLabel("  g0   ");
		JLabel e0 = new JLabel("Account Info: ");
		JLabel e1 = new JLabel("Type of Account: ");
		JLabel e2 = new JLabel("Loan Amount (if applicable): ");
		 f2 = new JTextField(10);
		 f1 = new JComboBox(AccountTypes);//JTextField(10);
		JButton d6 = new JButton("Submit");
		d6.addActionListener(new SubmitApplication());
		addAt(a0, 0, 0);
		addAt(d0, 0, 3);
		addAt(g0, 0, 6);
		addAt(e0, 0, 4, 2);
		addAt(e1, 1, 4);
		addAt(e2, 2, 4);
		addAt(f1, 1, 5);
		addAt(f2, 2, 5);
		addAt(d6, 7, 3);
		frame.pack();
		frame.setVisible(true);
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
