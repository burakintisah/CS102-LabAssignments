/**
 * @(#)Truck.java
 * Slow type of a vehicle but it cannot carry a lot. 
 *
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/29
 */


public class Truck extends Vehicle {

	//constants
   	public int TRUCK_CAPACITY = 25;
    public double TRUCK_SPEED = 5 ;
    public double TRUCK_WEIGTH_LIMIT = 100;
    
    //constructers
    
    public Truck (int vehicleNo) {
    	super(vehicleNo);
    	this.speed = TRUCK_SPEED;
    	deliveries = new Delivery [TRUCK_CAPACITY];
    }
    
    //methods 
    
    public String drive () {
    	String result = "" ;
    	double timeTook;
       	for (int i=0; i<numOfDeliveries; i++){
       		timeTook = calculateDistance (deliveries[i].getReceiver(),this) / TRUCK_SPEED ;
       		result += "The " + (i+1) + ". ==> "  + deliveries[i] ;
       		result += "\nTime took is " + timeTook ;
    		deliveries[i] = null;
    	}
    	numOfDeliveries = 0;
    	System.out.println(result);
    	return result;
    }
    
    public int getDeliveryLimit () {
    	return TRUCK_CAPACITY ;
    }
    
    public double getWeightLimit () {
    	return TRUCK_WEIGTH_LIMIT;
    }
    
    public String toString () {
    	String result = " Truck \nVehicle number is " + this.vehicleNo + "\nNumber of deliveries " + numOfDeliveries ;
    	for (int i = 0;i<numOfDeliveries;i++){
    		result+="\n" +deliveries[i].toString();
    	}
    	return result;
    }
    public double getSpeed () { 
    	return TRUCK_SPEED;
    }

}