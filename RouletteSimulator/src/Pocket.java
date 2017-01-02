
public class Pocket {

	private String number;
	private String color;
	
	public Pocket() {
		number = "";
		color = "";
	}
	
	public Pocket(String n, String c) {		//default constructor 
		number = n;
		color = c;
	} 
	
	public String getNumber() {		//get pocket number
		return number;
	}
	
	public String getColor() {		//get pocket color
		return color;
	}
	
	
}
