package Hardware;
//objects used: null 

import java.io.Serializable;
import java.util.ArrayList;
//We can probably delete this class; seems useless
public class Record  implements Serializable{
//Fields
private ArrayList<String> discrepencies;

//Constructors
public Record() {
	discrepencies = new ArrayList<String>();
}


//Methods
public void addDiscrepency(String d) {
	discrepencies.add(d);
}
public ArrayList<String> getDiscrepencies() {
	return discrepencies;
}

public void setDiscrepencies(ArrayList<String> discrepencies) {
	this.discrepencies = discrepencies;
}


}
