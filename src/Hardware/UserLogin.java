package Hardware;

import java.io.Serializable;

public class UserLogin  implements Serializable{
//Fields
private String username;
private String password;
private int consecutiveLoginFails; 	
//Constructors	
public UserLogin() {
	setUsername("Default");
	setPassword("Default");
}
public UserLogin(String u, String p) {
	this.setUsername(u);
	this.setPassword(p);
}




//Methods
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getConsecutiveLogins() {
	return consecutiveLoginFails;
}
public void setConsecutiveLoginFails(int consecutiveLogins) {
	this.consecutiveLoginFails = consecutiveLogins;
}
	
	
	
}
