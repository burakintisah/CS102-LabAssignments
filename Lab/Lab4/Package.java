/**
 * @(#)Package.java
 * The subclass of Delivery which is the type of package.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/24
 */


public class Package extends Delivery {
	
	private Item packedItem ;
	
	public Package (Item content, Customer sender, Customer receiver, int packageNo){
		super(sender,receiver,packageNo);
		this.packedItem = content ;
	}
	public String getContent(){
    	return packedItem.getContent();
    }
    
    public double getWeight(){
    	return packedItem.getWeight();
    }
    
    public String toString () {
    	String result = "Sending a delivery which is a package." + "\nSender is " + this.sender + "\nReceiver is " + receiver + "\nPackage Number is " + packageNo ;
    	result += "\nPacked item " + packedItem ;
    	return result ;
    }
}