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

import Hardware.Bank;
import Hardware.Date;
import People.Customer;
import People.Employee;

public class EditPersonalInfoGUI {
	private JDialog frame;
	private Bank bank;
	private Container inputs;
	private JTextField c1;
	private JTextField c2;
	private JTextField c3;
	private JTextField c4;
	private JTextField c5;
	//private JPasswordField f3;
	private JTextField f4;
	private JPasswordField f5;
	//private JTextField f6;
	private Employee emp1;
	private Customer cust1;
	public EditPersonalInfoGUI(Customer cust, Bank bank1)
	{
		bank = bank1;
		cust1 =cust;
		frame = new JDialog (new JFrame(), "Edit " + cust.getFirstName() + " " + cust.getLastName() + "'s Account Info");
		buidGUI();
	}
	public void buidGUI()
	{
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
		JLabel e0 = new JLabel("Account Info: ");
	//	JLabel e3 = new JLabel("Social Security: ");
		JLabel e4 = new JLabel("Email: ");
		JLabel e5 = new JLabel("Password: ");
	//	JLabel e6 = new JLabel("Birthday (MM/DD/YYYY): ");
		 c1 = new JTextField(10);
		 c2 = new JTextField(10);
		 c3 = new JTextField(10);
		 c4 = new JTextField(10);
		 c5 = new JTextField(10);

	//	 f3 = new JPasswordField(10);
		 f4 = new JTextField(10);
		 f5 = new JPasswordField(10);
	//	 f6 = new JTextField(10);

		JButton d6 = new JButton("Submit");
		d6.addActionListener(new EditInfo());
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

	//	addAt(e3, 3, 4);
		addAt(e4, 4, 4);
		addAt(e5, 5, 4);
	//	addAt(e6, 6, 4);
		addAt(c1, 1, 2);
		addAt(c2, 2, 2);
		addAt(c3, 3, 2);
		addAt(c4, 4, 2);
		addAt(c5, 5, 2);
	//	addAt(f3, 3, 5);
		addAt(f4, 4, 5);
		addAt(f5, 5, 5);
	//	addAt(f6, 6, 5);
		addAt(d6, 7, 3);
		frame.pack();
		frame.setVisible(true);
	}
	private final class EditInfo implements ActionListener {
		
		private EditInfo(){
		}

		public void actionPerformed(ActionEvent e)
		{
			boolean valid = true;
			String firstName= c1.getText();
			try {	
				if (firstName.length() == 0)
				{
					throw new Exception("error");	
				}
			}
			catch(Exception p)
			{
				valid =false;
				String title = "Error First Name Not Valid";
				String message ="Enter a valid first name";
				textParseError(title, message);
			}
			String lastName = c2.getText();
			try {			
				if (lastName.length() == 0)
				{
					throw new Exception("error");	
				}
			}
			catch(Exception p)
			{
				valid = false;
				String title = "Error Last Name Not Valid";
				String message ="Enter a valid last name";
				textParseError(title, message);
			}
			String address = c3.getText();
			try {
				
				if (address.length() == 0)
				{
					throw new Exception("error");	
				}
			}
			catch(Exception p)
			{
				valid = false;
				String title = "Error Address Not Valid";
				String message ="Enter a valid address";
				textParseError(title, message);
			}
			int zipcode = 0;
			try {
				zipcode = Integer.parseInt(c4.getText());
				if(c4.getText().length() != 5)
				{
					throw new Exception("error");
				}
			}
			catch(Exception p)
			{
				valid = false;
				String title = "Error Zipcode Not Valid";
				String message ="Enter a valid zipcode";
				textParseError(title, message);
			}
			long phoneNum = 0;
			try{
				System.out.println(c5.getText());
				phoneNum = Long.parseLong(c5.getText());
				System.out.println(phoneNum);
				if(c5.getText().length() > 12 || c5.getText().length() < 7)
				{
					throw new Exception("error");
				}
			}
			catch(Exception p)
			{
				valid = false;
				String title = "Error Phone Number Not Valid";
				String message ="Enter a valid phone number";
				textParseError(title, message);
			}
		//	String SSPreCheck = f3.getPassword().toString();
			String email = f4.getText();
			boolean preExisting = false;
			try {
				if(email.contains("@") == false)
				{
					throw new Exception("error");
				}
				else
				{
					for(int i = 0; i < bank.getCustomers().size(); i++)
					{
						if(bank.getCustomers().get(i).getLogin().getUsername().compareTo(email) == 0)
						{
							preExisting = true;
							if(cust1 != null && cust1.getLogin().getUsername().compareTo(email) == 0)
							{
								//user is not changing email
							}
							else
							{
							throw new Exception("error");
							}
							
							}
						}
					}
					for(int i = 0; i < bank.getEmployees().size(); i++)
					{
						if(bank.getEmployees().get(i).getLogin().getUsername().compareTo(email) == 0)
						{
							preExisting = true;
							if(emp1 != null && emp1.getLogin().getUsername().compareTo(email) == 0)
							{
								//user is not changing email
							}
							else
							{
							throw new Exception("error");
							}
							
							}
					}
			}
			catch(Exception p){
				valid = false;
				String title = "Error Email Address Not Valid";
				String message ="Enter a valid Email Address number";
				if(preExisting == true)
				{
					title = "Email already registered";
					message = "Please login to add a new account";
				}
				
				textParseError(title, message);
			}
			String password = String.valueOf(f5.getPassword());
			try {
				if(password.length() < 8)
				{
					throw new Exception("error");	
				}
			}
			catch(Exception p){
				valid = false;
				String title = "Error Password Not Valid";
				String message ="Enter a password of at least eight characters";
				textParseError(title, message);
			}
	/*		String SS = String.valueOf(f3.getPassword());
			try {
				if(String.valueOf(f3.getPassword()).length()== 0)
				{
					throw new Exception("error");
				}
			}
			catch(Exception p){
				valid = false;
				String title = "Error Social Security Number Not Valid";
				String message = SS + "Enter a valid Social Security number";
				textParseError(title, message);
			}*/
		/*	int[] dateParts = null;
			
			try {
				String[] tokens = f6.getText().split("/");
				System.out.println(f6.getText());
				if(tokens.length != 3)
				{
					throw new Exception("error");
				}
				int[] temp  = {Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])};
				dateParts = temp;
				if(dateParts[0] > 12 || dateParts[1] > 31 || dateParts[2] > 2016 || dateParts[0] <1 || dateParts[1] <  1)
				{
					throw new Exception("error");
				}
				
			}
			catch(Exception p){
				valid = false;
				String title = "Error Birthday Not Valid";
				String message = "Enter a valid Birthday";
				textParseError(title, message);
			}*/
			if(valid == true)
			{
				/*if(emp1 != null)
				{
					Employee changingPerson = emp1;
					Date temp = new Date(dateParts[0], dateParts[2], dateParts[1]);
					changingPerson.setSocialSecurityNumber(SS);
					changingPerson.setAddress(address);
					changingPerson.setBirthday(temp);
					changingPerson.setFirstName(firstName);
					changingPerson.setLastName(lastName);
					changingPerson.getLogin().setPassword(password);
					changingPerson.getLogin().setUsername(email);
					changingPerson.setZipCode(zipcode);
					changingPerson.setPhoneNumber(phoneNum);
				}
				else if(cust1 != null)
				{*/
					Customer changingPerson = cust1;
				//	Date temp = new Date(dateParts[0], dateParts[2], dateParts[1]);
					//changingPerson.setSocialSecurityNumber(SS);
					changingPerson.setAddress(address);
				//	changingPerson.setBirthday(temp);
					changingPerson.setFirstName(firstName);
					changingPerson.setLastName(lastName);
					changingPerson.getLogin().setPassword(password);
					changingPerson.getLogin().setUsername(email);
					changingPerson.setZipCode(zipcode);
					changingPerson.setPhoneNumber(phoneNum);
			/*	}
				else
				{
					System.out.println("Error: did not get a person");
				}*/
				frame.dispose();
			}
		}
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
}
