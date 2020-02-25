/**
 * @(#)Vehicle.java
 *
 *
 * @author 
 * @version 1.00 2017/10/29
 */


public abstract class Vehicle implements Locatable {
	
	//properties

    int vehicleNo ; // the id of the vehicle
    Delivery [] deliveries ; // array of deliveries
    int numOfDeliveries ; // current number of deliveries
    double currentWeight; //current total weight of deliveries
    double speed; //speed of the vehicle (constant)
    int posX;
    int posY;
    
    //methods
    public Vehicle(int vehicleNo){
    	this.vehicleNo = vehicleNo;
    	numOfDeliveries = 0;
    	currentWeight = 0;
    	speed = 0;
    }
    
    public void setSpeed (double value){
    	this.speed = value;
    }
    
   
    public int getNumOfDeliveries() {
    	return numOfDeliveries ;
    }
    
    public double getCurrentWeight (){
    	return currentWeight ;
    }
    
    public int getVehicleNo () {
    	return vehicleNo ;	
    }
    
    public void loadDelivery (Delivery delivery) {
    	 deliveries [numOfDeliveries] = delivery ;
    	 numOfDeliveries ++;
    }
    
    public static double calculateDistance (Locatable source, Locatable target) {
    	int sx = source.getX () ;
    	int sy = source.getY ();
    	int tx = target.getX () ;
    	int ty = target.getY();
    	double result = ((tx-sx) * (tx-sx)) + ((ty-sy)*(ty-sy)) ;
    	result = Math.sqrt(result) ;
    	return result ;
    }
    
    public void position(Company company) {
    	this.setPos(company.getX(),company.getY());
    }
    public int getX (){
    	return posX;
    }
    public int getY () {
    	return posY;
    }
    public void setPos(int x,int y){
    	posX = x;
    	posY = y;
    }
    
    public abstract String toString ();
    
    abstract double getWeightLimit () ;
    
    abstract int getDeliveryLimit () ;

	abstract String drive () ;
    
    abstract public double getSpeed () ;
    
    
}