/**
 * @(#)Driver.java
 * Responsible for loading the deliveries onto associated vehicle, while respecting its limits.
 *
 * @author 
 * @version 1.00 2017/10/29
 */


public class Driver extends Employee{ 
	
	//properties
	private Vehicle vehicle ; //The assigned vehicle to this driver object
	
	//constuctor
	public Driver (int employeeNo,String name){
		super(employeeNo,name);
	}
	//methods
	
	public void assignVehicle (Vehicle vehicle){
		this.vehicle = vehicle ;
	}
	public Vehicle getVehicle(){
		return vehicle;
	}
    
    public boolean giveCargo (Delivery delivery){
    	boolean result = true;
		if (vehicle instanceof Truck){
			if ((vehicle.getCurrentWeight() + delivery.getWeight())<= vehicle.getWeightLimit() ){
				if ( vehicle.getNumOfDeliveries() < vehicle.getDeliveryLimit()){
					((Truck)vehicle).loadDelivery(delivery);
					result = true;
				}
			}
		}
		else if(vehicle instanceof Motorcycle){
			if((vehicle.getCurrentWeight()+delivery.getWeight())<= vehicle.getWeightLimit() ){
				if(vehicle.getNumOfDeliveries()< vehicle.getDeliveryLimit()){
					((Motorcycle)vehicle).loadDelivery(delivery);
					result = true;
				}
			}
		}
		else result = false;
		return result;
    }
    
    public void deliver () {
    	if (vehicle != null){
    		vehicle.drive();
    		System.out.println("Number of deliveries " + vehicle.getNumOfDeliveries() );
    	}
    	else System.out.println("No vehicle has been assigned");  		
    }
    
    public String toString () {
    	String result =  "Name is --> " + name + "\nID --> " + employeeNo + "\nEmployee's vehicle is " + vehicle ;
    	return result;
    }
    
}