package gui;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Hardware.Bank;

public class NewAccountNewCustomerGUI extends JFrame   {
	private Bank bank;
	private Container inputs;
	private JTextField c1;
	private JTextField c2;
	private JTextField c3;
	private JTextField c4;
	private JTextField c5;
	private JComboBox f1;
	private JTextField f2;
	private JPasswordField f3;
	private JTextField f4;
	private JPasswordField f5;
	private String[] AccountTypes;
	//TODO: make type of account have selection box
	public NewAccountNewCustomerGUI(Bank bank)
	{
		String[] temp = {"Savings", "Checking", "Credit", "Mortgage", "Manager"};
		AccountTypes = temp;
		this.bank = bank;
		buildGUI();
	}
	private final class SubmitApplication implements ActionListener {
		
		private SubmitApplication(){
		}

		public void actionPerformed(ActionEvent e)
		{
			String firstName= c1.getText();
			String lastName = c2.getText();
			String address = c3.getText();
			String zipode = c4.getText();
			String phoneNum = c5.getText();
			String accountType = (String)f1.getSelectedItem();
			String loanAmount = f2.getText();
		//	String SSPreCheck = f3.getPassword().toString();
			String email = f4.getText();
			String password = f5.getPassword().toString();
			int socialSecurity;
			try {
				socialSecurity = Integer.parseInt(f3.getPassword().toString());
			}
			catch(Exception p){
				//need to throw error
			}
		}
	}
	private void buildGUI() {
		JDialog frame = new JDialog (new JFrame(), "New Account Request");
		frame.setSize(500, 900);
		inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		JLabel a0 = new JLabel("     ");
		JLabel d0 = new JLabel("     ");
		JLabel g0 = new JLabel("     ");
		JLabel b0 = new JLabel("Contact");
		JLabel b1 = new JLabel("First Name: ");
		JLabel b2 = new JLabel("Last Name: ");
		JLabel b3 = new JLabel("Address: ");
		JLabel b4 = new JLabel("Zip Code: ");
		JLabel b5 = new JLabel("Phone Number: ");
		JLabel e1 = new JLabel("Type of Account: ");
		JLabel e0 = new JLabel("Account Info: ");
		JLabel e2 = new JLabel("Loan Amount: ");
		JLabel e3 = new JLabel("Social Security: ");
		JLabel e4 = new JLabel("Email: ");
		JLabel e5 = new JLabel("Password: ");
		 c1 = new JTextField(10);
		 c2 = new JTextField(10);
		 c3 = new JTextField(10);
		 c4 = new JTextField(10);
		 c5 = new JTextField(10);
		 f2 = new JTextField(10);
		 f3 = new JPasswordField(10);
		 f4 = new JTextField(10);
		 f5 = new JPasswordField(10);
		 f1 = new JComboBox(AccountTypes);//JTextField(10);
		JButton d6 = new JButton("Submit");
		d6.addActionListener(new SubmitApplication());
		addAt(a0, 0, 0);
		addAt(b0, 0, 1 , 2);
		addAt(d0, 0, 3);
		addAt(g0, 0, 6);
		addAt(b1, 1, 1);
		addAt(b2, 2, 1);
		addAt(b3, 3, 1);
		addAt(b4, 4, 1);
		addAt(b5, 5, 1);
		addAt(e0, 0, 4, 2);
		addAt(e1, 1, 4);
		addAt(e2, 2, 4);
		addAt(e3, 3, 4);
		addAt(e4, 4, 4);
		addAt(e5, 5, 4);
		addAt(c1, 1, 2);
		addAt(c2, 2, 2);
		addAt(c3, 3, 2);
		addAt(c4, 4, 2);
		addAt(c5, 5, 2);
		addAt(f1, 1, 5);
		addAt(f2, 2, 5);
		addAt(f3, 3, 5);
		addAt(f4, 4, 5);
		addAt(f5, 5, 5);
		addAt(d6, 6, 3);
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
