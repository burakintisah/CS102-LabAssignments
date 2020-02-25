/**
 * @(#)Mail.java
 * Returns a constant weight and only contains the content of the respective item. 
 * The subclass of Delivery which is the type of mail.
 *
 * @author 
 * @version 1.00 2017/10/24
 */


public class Mail extends Delivery {

    private String content ;
    
    public Mail (String content, Customer sender, Customer receiver, int packageNo){
    		super(sender,receiver,packageNo);
    		this.content = content ;
    }
    public String getContent(){
    	return content;
    }
    
    public double getWeight () {
    	return 0.1 ;
    }
    
    public String toString () {
    	
    	String result = "Sending a delivery which is a mail." + "\nSender is " + this.sender + "\nReceiver is " + receiver + "\nPackage Number is " + packageNo ;
    	result += "\nContent is " + content ;
    	return result ;
    }
    
    
}