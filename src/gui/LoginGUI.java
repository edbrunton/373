package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Accounts.BankAccount;
import Hardware.Bank;
import People.Customer;
import People.Employee;
import People.Person;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class LoginGUI extends JFrame  implements Serializable{
	private final class SaveFile extends WindowAdapter {
		public void windowClosing(WindowEvent ev) {
		   
			FileOutputStream fileOut = null;
			ObjectOutputStream objOut = null;
			try {
				fileOut = new FileOutputStream("bank2.ser");
				objOut = new ObjectOutputStream(fileOut);
				objOut.writeObject(myBank);
				objOut.close();
				fileOut.close();
				System.out.println("Made file");
			}
			catch(IOException i)
			{
				i.printStackTrace();
			}
			 //frame.dispose();
		}
	}
	private final class LoginSubmission implements ActionListener {
		private final JPasswordField dTF;
		private final JTextField sTF;

		private LoginSubmission(JPasswordField dTF, JTextField sTF) {
			this.dTF = dTF;
			this.sTF = sTF;
		}

		public void actionPerformed(ActionEvent e)
		{
			Boolean foundAccount = false;
			Boolean lockedAccount = false;
			Customer customer = null;
			Employee employee= null;
			for(int i = 0; i< myBank.getCustomers().size(); i++)
			{
				if(myBank.getCustomers().get(i).getLogin().getUsername().compareTo(sTF.getText()) ==0)
				{
					foundAccount = true;
					customer = myBank.getCustomers().get(i);
				//	char[] password = dTF.getPassword();
					//System.out.println(password);
					if (myBank.getCustomers().get(i).getLogin().getConsecutiveLogins() >= 3)
					{
						lockedAccount = true;
					}
					else
					{
						if(myBank.getCustomers().get(i).getLogin().getPassword().compareTo(String.valueOf(dTF.getPassword()))==0)
						{
							myBank.getCustomers().get(i).getLogin().setConsecutiveLoginFails(0);			
						}
						else
						{
							myBank.getCustomers().get(i).getLogin().setConsecutiveLoginFails(myBank.getCustomers().get(i).getLogin().getConsecutiveLogins()+1);	
							loginError("Your account info is wrong. Try again. Wrong Password");	
						}
					}
				}
			}
			for(int i = 0; i<myBank.getEmployees().size(); i++) {
				if(myBank.getEmployees().get(i).getLogin().getUsername().compareTo(sTF.getText()) ==0)
				{
					foundAccount = true;
					employee = myBank.getEmployees().get(i);
					char[] password = dTF.getPassword();
					System.out.println(password);
					if (myBank.getEmployees().get(i).getLogin().getConsecutiveLogins() >= 3 && myBank.getEmployees().size() != 1)
					{
						lockedAccount = true;
					}
					else
					{
						if(myBank.getEmployees().get(i).getLogin().getPassword().compareTo(String.valueOf(dTF.getPassword()))==0)
						{
							myBank.getEmployees().get(i).getLogin().setConsecutiveLoginFails(0);
						}
						else
						{
						//	System.out.println(myBank.getEmployees().get(i).getLogin().getPassword());
							System.out.println(dTF.getPassword().toString());
							myBank.getEmployees().get(i).getLogin().setConsecutiveLoginFails(myBank.getEmployees().get(i).getLogin().getConsecutiveLogins()+1);	
							loginError("Your account info is wrong. Try again. Wrong Password");	
						}
					}
				}
			}
			if(lockedAccount)
			{
				loginError("You have too many failed logins. Contact a banker");
			}
			else if(!foundAccount)
			{
				loginError("Your account info is wrong. Try again. Email not registered");
			}
			else
			{
				System.out.println("Got here 1");
				if(employee == null)
				{
					new ManagerClientAccountGUI(customer, myBank);
					System.out.println("Got here 2");
				}
				else
				{
					new ManagerPageGUI(employee, myBank);
					System.out.println("Got here 3");
				}
			}
			
		}
	}
	private final class AccountSubmission implements ActionListener {
		
		private AccountSubmission(){
		}

		public void actionPerformed(ActionEvent e)
		{
			NewAccountNewCustomerGUI newClient = new NewAccountNewCustomerGUI(myBank);	
		}
	}
	public static void main(String[] args) {
		LoginGUI loginGui = new LoginGUI("First Class Bank", loadData());
	}
	private Bank myBank;
	public LoginGUI(String windowTitle, Bank bank1) {
		//super(windowTitle);
		//myBank = bank1;
		//setSize(300, 100);
		//setLayout(new FlowLayout(FlowLayout.LEFT));
		//add(new JLabel("<HTML><center>Welcome to the University." +
		//		"<BR>Choose an action from the above menues.</center></HTML>"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myBank = bank1;
	 /*   addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	        	FileOutputStream fileOut = null;
	    		ObjectOutputStream objOut = null;
	    		try {
	    			fileOut = new FileOutputStream("bank.ser");
	    			objOut = new ObjectOutputStream(fileOut);
	    			objOut.writeObject(myBank);
	    			objOut.close();
	    			fileOut.close();
	    		}
	    		catch(IOException i)
	    		{
	    			i.printStackTrace();
	    		}
	          System.exit(0);
	        }
	      });*/
		buildGUI();	
		//this.pack();
		//setVisible(true);
	}
	
	private void buildGUI() {
		JDialog frame = new JDialog (new JFrame(), "Login To Bank");
		frame.setSize(500, 900);
		frame.addWindowListener(new SaveFile());
		Container inputs = frame.getContentPane();
		inputs.setLayout (new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel b1 = new JLabel("     ");
		JLabel b2 = new JLabel("     ");
		JLabel b3 = new JLabel("     ");
		JLabel b4 = new JLabel("     ");
		JLabel b5 = new JLabel("     ");
		JLabel sName = new JLabel("Login Name: ");
		JTextField sTF = new JTextField(10);			
		JLabel b6 = new JLabel("     ");
		JLabel b7 = new JLabel("     ");
		JLabel dName = new JLabel("Password: ");
		JPasswordField dTF = new JPasswordField(10);
		JLabel b8 = new JLabel("     ");
		JLabel b9 = new JLabel("     ");
		JLabel b10 = new JLabel("     ");
		JButton okay = new JButton("OK");
		okay.addActionListener(new LoginSubmission(dTF, sTF));
		JButton newAccount = new JButton("New? Start Here");
		newAccount.addActionListener(new AccountSubmission());
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e -> System.exit(0)); //frame.dispose());
		c.anchor = GridBagConstraints.LINE_START;
		c.weightx = 15;
		c.weighty = 15;
		c.gridy = 0;
		c.gridx = 0;
		inputs.add(b1,c);
		c.gridy = 0;
		c.gridx = 1;
		inputs.add(b2,c);
		c.gridy = 0;
		c.gridx = 2;
		inputs.add(b3,c);
		c.gridy = 0;
		c.gridx = 3;
		inputs.add(b4,c);
		c.gridy = 0;
		c.gridx = 4;
		inputs.add(b9,c);
		c.gridy = 0;
		c.gridx = 5;
		inputs.add(b10,c);
		c.gridy = 1;
		c.gridx = 0;
		inputs.add(b5,c);
		c.gridy = 1;
		c.gridx = 1;
		inputs.add(sName,c);
		c.gridy = 1;
		c.gridx = 2;
		inputs.add(sTF,c);
		c.gridy = 1;
		c.gridx = 4;
		c.gridheight =2;
		inputs.add(newAccount, c);
		c.gridheight =1;
		
		
		inputs.add(b5,c);
		c.gridy = 2;
		c.gridx = 0;
		inputs.add(b6,c);
		c.gridy = 2;
		c.gridx = 1;
		inputs.add(dName,c);
		c.gridy = 2;
		c.gridx = 2;
		inputs.add(dTF,c);
		c.gridy = 2;
		c.gridx = 3;
		inputs.add(b7,c);
		c.gridy = 3;
		c.gridx = 0;
		c.weightx = 25;
		c.weighty = 25;
		inputs.add(b8,c);
		c.gridy = 3;
		c.gridx = 1;
		//c.anchor = GridBagConstraints.LINE_END;	
		inputs.add(okay,c);
		c.gridy = 3;
		c.gridx = 2;
		//c.anchor = GridBagConstraints.LINE_END;
		inputs.add(cancel,c);
		c.gridy = 3;
		c.gridx = 3;
		System.out.println(myBank.getEmployees().size());
		frame.pack();
		frame.setVisible(true);
	}

	private void loginError(String error) {
		JDialog frameTemp = new JDialog (new JFrame(), "Error logging in");
		 Container contentPane = frameTemp.getContentPane ();
		    contentPane.setLayout (new BorderLayout());
		    JButton okay = new JButton("OK");
		    okay.addActionListener(e2 -> frameTemp.dispose());
		    okay.setSize(30, 10);
		    JPanel p1 = new JPanel();
		    p1.add(okay);
		    contentPane.add(p1, BorderLayout.SOUTH);			    	        
		    JLabel outArea = new JLabel(error);
		    contentPane.add(outArea, BorderLayout.CENTER);
		    frameTemp.pack();
		    frameTemp.setVisible (true);
	}

	public static Bank loadData()
	{
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Bank bank1 = new Bank();
		try {
			fileIn = new FileInputStream("bank2.ser");
			objIn = new ObjectInputStream(fileIn);
			bank1 = (Bank) objIn.readObject();
			objIn.close();
			fileIn.close();
			System.out.println("Got file");
		}
		catch(IOException i)
		{
			i.printStackTrace();
			return new Bank();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			return new Bank();
		}
		catch(Exception p)
		{
			return new Bank();
		}
		return bank1;
	}
}
