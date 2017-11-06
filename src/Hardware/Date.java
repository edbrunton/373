package Hardware;

import java.io.Serializable;

public class Date  implements Serializable{
//Fields
private int month;
private int year;
private int day;

//Constructors
public Date() {
	setMonth(-1);
	setYear(-1);
	setDay(-1);
	
}
public Date(int month, int year, int day) {
	this.setMonth(month);
	this.setYear(year);
	this.setDay(day);
}

//Methods
public void setDate(int month, int year, int day) {
	this.setMonth(month);
	this.setYear(year);
	this.setDay(day);
}
public int getMonth() {
	return month;
}
public void setMonth(int month) {
	this.month = month;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}





}
