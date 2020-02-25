/**
 * @(#)Company.java
 * A class that implements Locatable and sends item between customers.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/24
 */
import java.util.ArrayList;

public class Company implements Locatable {
	
	//properties
    private final int EMPLOYEE_CAPACITY = 20  ;
    private final int VEHICLE_CAPACITY = 10 ;
    public Employee [] employees ;
    public Vehicle [] vehicles ;
    public ArrayList<Delivery> deliveries;
    public ArrayList<Customer> customers  ;
    private int numOfEmployees ;
    private int numOfVehicles ;
    private int employeeNo ;
    private int packageNo ;
    private int vehicleNo ;
    private int posX ;
    private int posY ;
    
    //Constructor
    public Company (int x, int y) { 
    	posX = x ;
    	posY = y ;
    	numOfEmployees = 0;
    	numOfVehicles = 0;
    	employeeNo = 0;
    	packageNo = 0;
    	vehicleNo = 0;
    	deliveries = new ArrayList<Delivery>();
    	customers = new ArrayList<Customer>();
    	vehicles = new Vehicle [VEHICLE_CAPACITY];
    	employees = new Employee [EMPLOYEE_CAPACITY];
    }
    
    //methods
    public int getX (){
    	return posX;
    }
	
	public int getY (){
		return posY;
	}
	
	public void setPos (int x, int y) {
		this.posX = x ;
		this.posY = y ;
	}
	
	public void addCustomer (Person customer){
		customers.add((Customer)customer);
	}
	
	public boolean hireEmployee (Person candidate,String type) {
		boolean result = true;
		if (type.equals("CustomerService")){
			employees [numOfEmployees] = new CustomerService ( numOfEmployees, candidate.getName());
			result = true;
			numOfEmployees++;
		}
		else if (type.equals("Driver")){
			employees [numOfEmployees] = new Driver ( numOfEmployees, candidate.getName() );
			result = true;
			numOfEmployees++;
		}
		else {
			result = false;
		}
		
		return result;
		
	}
	
	public boolean addVehicle (String type){
    	boolean result = true;
		if (type.equals("Motorcycle")){
			vehicles[numOfVehicles] = new Motorcycle (numOfVehicles);
			vehicles[numOfVehicles].setPos(posX,posY);
			numOfVehicles++;
			result = true;
		}
		else if(type.equals("Truck")){
			vehicles [numOfVehicles] = new Truck (numOfVehicles);
			vehicles[numOfVehicles].setPos(posX,posY);
			numOfVehicles++;
			result = true;
		}
		else {
			result = false;
		}
				
		return result;
    }
    //Creates a delivery object from the item with sending info. Uses an available customer service employee for  packaging.
	public boolean createDeliverable (Item sendItem, Customer sender, Customer receiver) {
    	for(int i=0; i < numOfEmployees ;i++){
    		if (employees[i] instanceof CustomerService && ((CustomerService)employees[i]).getAvailability() == true) {
    			deliveries.add ( ((CustomerService)employees[i]).addJob(sendItem,sender,receiver,packageNo++));
    			return true;
    		}
    	}
    	return false;	
    }
    

    //Given the driver and vehicle index (their indices in their respective arrays), assign the vehicle to the driver. As the drivers are in the employee’s array, the given index should be checked if it is a driver
    public boolean assignVehicle (int employeeIndex, int vehicleIndex){
    	if (employees[employeeIndex] instanceof Driver){
    		((Driver)employees[employeeIndex]).assignVehicle(vehicles[vehicleIndex]);
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    //Loads the delivery to the vehicle of the given driver.
    public boolean loadDelivery (int deliveryNo, int employeeIndex){
    	for (int i=0;i<deliveries.size();i++){
    		if (deliveries.get(i).getPackageNo() == deliveryNo ){
    			((Driver)employees[employeeIndex]).giveCargo(deliveries.get(i));
    			deliveries.remove(i);
    			return true;
    		}
    	}
    	return false;
    } 
    //Drivers deliver their packages and Customer Service Employees finish their jobs.
    public void deliverPackages () {
    	for(int i=0;i<numOfEmployees;i++){
    		if(employees[i]!= null && employees[i] instanceof Driver){
    			((Driver)employees[i]).deliver();
    		}
    		else if (employees[i]!= null && employees[i] instanceof CustomerService){
    			((CustomerService)employees[i]).finishJobs();
    		}
    	}
    }	
    
    public String toString () {
   		String result = "*************************\n";
   		result += "Company\n" + "\nNumber of employees " + numOfEmployees + " which are\n" ;
   		   	for (int i = 0;i<numOfEmployees ;i++){
   				result += employees[i].toString() + "\n";
   			}
   		result += "\nNumber of vehicles " + numOfVehicles + " which are\n";
   		for(int i=0;i<numOfVehicles;i++){
   			result+= vehicles[i].toString() + "\n";
   		}
   		result += "\nDeliveries\n" + deliveries ;
   		result += "\nCostumers\n" + customers ;
   		return result;
    }
}