/**
 * @(#)CustomerService.java
 * Handles the packaging of the items given by the customers to the Company.
 *
 * @author 
 * @version 1.00 2017/10/29
 */


public class CustomerService extends Employee {
	
	//properties
	private int MAX_JOBS = 5; //maximum number of jobs the customer service employee can handle at a time
	private int currentJobs ; //current number of jobs

    public CustomerService(int employeeId,String name) {
    	super(employeeId,name);
    } 	
    
    //methods

    public boolean getAvailability(){ // Returns true if the customer service employee is available
    	if (currentJobs == MAX_JOBS ) return false ;
    	else return true ;
    }
    
	public Delivery addJob (Item sendItem, Customer sender, Customer receiver, int packageNo){ //By considering the weight of the item, creates a concrete Delivery object (Mail or Package)
    	Delivery delivery;
    	if( sendItem.getWeight() <= 0.1 ) {
    		delivery = new Mail (sendItem.getContent(),sender,receiver,packageNo);
    	}
    	else {
    		delivery = new Package (sendItem, sender, receiver, packageNo);
    	}
    	currentJobs ++ ;
    	return delivery;
    }
    
    public void finishJobs () { //Prints out the number of jobs completed and resets currentJobs.
    	System.out.println("Completed Jobs number = " + currentJobs);
    	currentJobs = 0;
    }
    
    public String toString () {
    	String result = "Name is --> " + name + "\nID --> " + employeeNo + "\nNumber of jobs that customer service has " + currentJobs ;
    	return result;
    }
}	