/**
 * @(#)Motorcycle.java
 *	Faster than truck, yet it cannot carry as much.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/29
 */


public class Motorcycle extends Vehicle {

    //constants 
    
    int MOTORCYCLE_CAPACITY = 5 ;
    double MOTORCYCLE_SPEED = 25;
    double MOTORCYCLE_WEIGHT_LIMIT = 10;
    
    //constructer
    public Motorcycle (int vehicleNo ) {
    	super(vehicleNo);
    	deliveries = new Delivery [MOTORCYCLE_CAPACITY];
    	this.speed = MOTORCYCLE_SPEED;
    }
    
    //methods 
    public String drive () {
    	String result = "" ;
    	double timeTook;
    	for (int i=0;i<numOfDeliveries;i++){
    		timeTook = calculateDistance(deliveries[i].getReceiver(), this) / MOTORCYCLE_SPEED ;
       		result += "The " + i + ". ==> "  + deliveries[i].getContent() + "Content is " + deliveries[i].getPackageNo() ;
       		result += "\nSender's location is " + deliveries[i].getSender().getX() + "+" + deliveries[i].getSender().getY();
       		result += "\nReceiver's location is " + deliveries[i].getReceiver().getX() + "+" + deliveries[i].getReceiver().getY();
       		result += "\nTime took is " + timeTook ;
    		deliveries[i] = null;
    	}
    	numOfDeliveries = 0;
    	System.out.println(result);
    	return result;
    }
    
    public int getDeliveryLimit () {
    	return MOTORCYCLE_CAPACITY;
    } 
    
    public double getWeightLimit () {
    	return MOTORCYCLE_WEIGHT_LIMIT;
    }
    
    public String toString () {
    	String result = " Motorcycle\nVehicle number is " + this.vehicleNo + "\nNumber of deliveries " + numOfDeliveries ;
    	for (int i = 0;i<numOfDeliveries;i++){
    		result+="\n" +deliveries[i].toString();
    	}
    	return result;
    	
    }
    public double getSpeed () { 
    	return MOTORCYCLE_SPEED;
    }
    
}