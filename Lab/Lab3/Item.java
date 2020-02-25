/**
 * @(#)Item.java
 * A class that creates an item that is converted to a Delivery first to be sent.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/24
 */


public class Item {
	
	private double weight ;
	private String content ;
	
	public Item (double weight, String content){
		this.weight = weight ;
		this.content = content ;
	}
	
	public double getWeight() {
		return weight;
	} 
	
	public String getContent () {
		return content ;
	}
	
	public String toString () {
		return "Weight is " + weight + "\nContent is " + content ;
	}
	
    
    
}