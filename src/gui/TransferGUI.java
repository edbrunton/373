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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Accounts.BankAccount;
import Hardware.Bank;
import People.Customer;
public class TransferGUI {
	private Container inputs;
	private BankAccount destinationAccount;
	private BankAccount originAccount;
	private Bank bank;
	private Boolean adminaccess;
	private JDialog frame;
	private JTextField c0;
	private JTextField c1;
	public TransferGUI(Bank bank, BankAccount baseAccount, boolean IsTransferTo, boolean adminaccess)
	{
		this.bank = bank;
		this.adminaccess = adminaccess;
		String title = "Transfer money ";
		if(!IsTransferTo)
		{
			originAccount = baseAccount;
			title += "from";
		}
		else
		{
			destinationAccount = baseAccount;
			title += "to";
		}
		title += " account " + baseAccount.getAccountNumber();
		frame = new JDialog (new JFrame(), title);
		frame.setSize(500, 900);
		inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		JLabel a0 = new JLabel("     ");
		JLabel d0 = new JLabel("     ");
		JLabel b0= new JLabel("Transfer Amount");
		c0= new JTextField(10);//for amount
		JLabel b1;
		String account2Info ="";
		if(IsTransferTo)
		{
			account2Info += "Origin Account";
		}
		else
		{
			account2Info += "Destination Account";
		}
		if(adminaccess)
		{
			account2Info += " (type 'Cash' if applicable)";
		}
		b1 = new JLabel(account2Info);
		c1 = new JTextField(10);//For account
		JButton c2  = new JButton("Cancel");
		c2.addActionListener(e -> frame.dispose());
		JButton b2 = new JButton("Submit");
		b2.addActionListener(new MakeTransfer());
		addAt(a0, 0, 0);
		addAt(b0,0,1);
		addAt(c0,0,2);
		addAt(d0, 0, 3);
		addAt(b1, 1,1);
		addAt(c1, 1,1);
		addAt(b2, 2, 1);
		addAt(c2, 2, 1);
	}
	private final class MakeTransfer implements ActionListener {
		
		private MakeTransfer(){
		}

		public void actionPerformed(ActionEvent e)
		{
			
			double amountUsable;
			boolean validInput = true;
			try {
				String amount = c0.getText().replace("$", "");
				amountUsable = Double.parseDouble(amount);
				if(amountUsable <= 0.00)
				{
					throw new Exception("bad amount");
				}
			}
			catch(Exception p)
			{
				validInput = false;
				textParseError("Invalid Amount", "Please enter an amount greater than $0.00");
			}
			int accountNum;
			
			try {
				String accountNumberInput = c1.getText();
				if(adminaccess && 
				(accountNumberInput.compareTo("cash") ==0 || accountNumberInput.compareTo("Cash")==0)
				)
				{
					accountNum = 0;
				}
				accountNum = Integer.parseInt(accountNumberInput);
				int i = 0;
				for(i=0; i<bank.getBankAccounts().size(); i++)
				{
					if(bank.getBankAccounts().get(i).getAccountNumber() == accountNum)
					{
						break;
					}
				}
				if(i==bank.getBankAccounts().size()) {
					throw new Exception("Invalid Account");
				}
			}
			catch(Exception p)
			{
				validInput = false;
				textParseError("Invalid Account Number", "Please enter a valid account number");
			}
			if(validInput) {
				//accountNum is Account number
				//amountUsable is Amount
				//TODO Ryan; transfer amount
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
}
