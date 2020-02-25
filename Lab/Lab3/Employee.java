/**
 * @(#)Employee.java
 * A class which is responsible for packaging and delivery.
 *
 * @author 
 * @version 1.00 2017/10/24
 */


public class Employee extends Person {

    private final int MAX_JOBS = 5 ;
    private int currentJobs ;
    private Delivery[] deliveries;
    private double salary ;
    private int employeeNo ;
    
    public Employee (int employeeNo, String name){
    	super(name);
    	this.employeeNo = employeeNo ;
    	currentJobs = 0;
    	salary = 0 ;
    	deliveries = new Delivery [MAX_JOBS] ;
    }
    
    public int getEmployeeNo(){
    	return employeeNo;
    }
    public double getSalary(){
    	return salary;
    }
    public double getCurrentJobs(){
    	return currentJobs;
    }
    
    public void adjustSalary(double value) {
    	salary = value ;
    }
    /*
     * Looking if the employee is busy or not.
     * 
     * @return boolean 
     */
    public boolean getAvailability(){
    	if (currentJobs == MAX_JOBS ) return false ;
    	else return true ;
    }
    /*
     * Adding jobs to the employee with the info about receiver,sender,packageNo
     *
     * @param sendItem
     * @param sender
     * @param receiver
     * @param packageNo
     *
     */
    public void addJob (Item sendItem, Customer sender, Customer receiver, int packageNo){
    	
    	if( sendItem.getWeight() <= 0.1 ) {
    		deliveries [currentJobs] = new Mail (sendItem.getContent(),sender,receiver,packageNo);
    	}
    	else {
    		deliveries [currentJobs] = new Package (sendItem, sender, receiver, packageNo);
    	}
    	//System.out.println(deliveries [currentJobs]);
    	currentJobs ++ ;
    }
    /*
     * Delivering packages.
     *
     */
    public void deliverPackages () {
    	for (int i=0; i<currentJobs;i++){
    		System.out.println("Sending Item's "+ deliveries[i].toString() );
    		System.out.println("");
    		deliveries[i] = null;
    	}	
    	currentJobs = 0;
    }
    
    public String toString () {
    	String result = "Employee's name is " + name + "\nEmployee's number is " + employeeNo + "\nEmployee's salary is " + salary + "\nEmployee's has " + currentJobs + " current jobs." ;
    	result += "\nWhich are " ;
    	for(int i=0; i < currentJobs ; i++){
    		result += deliveries[i].getContent() + " " ;
    	}
    	result += "\n";
    	return result;
    }
    
    
}