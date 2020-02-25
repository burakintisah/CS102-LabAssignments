/**
 * @(#)Company.java
 * A class that implements Locatable and sends item between customers.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/24
 */
import java.util.ArrayList;

public class Company implements Locatable {

    private final int EMPLOYEE_CAPACITY = 15 ;
    private Employee [] employees;
    private ArrayList<Customer> customers  ;
    private int numOfEmployees ;
    private int employeeNo ;
    private int packageNo ;
    private int posX ;
    private int posY ;
    
    public Company (int x, int y) { 
    	posX = x ;
    	posY = y ;
    	numOfEmployees = 0;
    	packageNo = 0;
    	customers = new ArrayList<Customer>();
    	employees = new Employee [EMPLOYEE_CAPACITY];
    }
    
    public int getX (){
    	return posX;
    }
	
	public int getY (){
		return posY;
	}
	
	public void setPos (int x, int y) {
		posX = x ;
		posY = y ;
	}
	
	/*
	 * Looking if true or false can company take new employee
	 * @param candidate adding candidates to the company as an employee
	 * @return boolean
	 */
	public boolean addEmployee (Employee candidate) {
		candidate = new Employee(candidate.getEmployeeNo(),candidate.getName());
		if (numOfEmployees < EMPLOYEE_CAPACITY ) {
			employees [numOfEmployees] = candidate ;
			numOfEmployees++;
			return true;
		}
		else { 
			return false;
		}
	}
	/* 
	 * adding customer to the company
	 * @param customer
	 */
	public void addCustomer (Customer customer ) {
		customers.add(customer);
		
	}
    /* 
     * deletes the employee from the company
     * @param employeeIndex which employee will terminated the Contract
     * @return boolean
     *
     */
    public boolean terminateContract (int employeeIndex) {
    	if (employeeIndex <= numOfEmployees-1 ){
    		employees [employeeIndex] = null ;
    		numOfEmployees--;
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /*
     * Looking for that item can deliverable or not.
     * @param sendItem the item that will send 
     * @param sender
     * @param receiver
     *
     */
    public boolean createDeliverable (Item sendItem, Customer sender, Customer receiver) {
    
    	for(int i=0; i <numOfEmployees ;i++){
    		if (employees[i].getAvailability() == true) {
    			employees[i].addJob(sendItem,sender,receiver,packageNo++);
    			return true;
    		}
    	}
    	return false;	
    }
    
    /*
     * Delivering the packages with the method in employee .
     *
     */
    public void deliverPackages () {
    	for(int i=0;i<numOfEmployees;i++){
    		if(employees[i]!=null){
    			employees[i].deliverPackages();
    		}
    	}
    }
    
    public String toString () {
    	String result = "Employee's names & employee numbers \n";
    	for(int i=0; i<numOfEmployees;i++){
    		result += employees[i].toString();
    	}
    	return result;
    	
    }
    
}