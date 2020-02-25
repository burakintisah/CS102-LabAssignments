/**
 * @(#)Delivery.java
 * An abstract class that creates deliveries.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/24
 */


public abstract class Delivery {
	
	int packageNo ;
	Customer sender ;
	Customer receiver ;
	
	public Delivery (Customer sender, Customer receiver, int packageNo ){
		this.sender = sender;
		this.receiver = receiver ;
		this.packageNo = packageNo ;
	}
	
	public int getPackageNo() {
		return packageNo ;
	}
	
	public Customer getSender () {
		return sender ;
	}
	
	public Customer getReceiver () {
		return receiver ;
	}
	abstract String getContent();
	
	abstract double getWeight() ;
       
}