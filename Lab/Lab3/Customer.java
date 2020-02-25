/**
 * @(#)Customer.java
 * A class that extends Person. Which is for the customers of the company.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/24
 */


public class Customer extends Person {

    private Item currentItem ;
    
    public Customer (String name){
    	super (name);
    }
    public Customer (String name,int x,int y){
    	super (name,x,y);
    }
    
    public Item getCurrentItem () {
    	return currentItem ;
    }
    
    public void setCurrentItem (Item newItem) {
    	currentItem = newItem ;
    }
    
    public boolean sendItem (Company company, Item item, Customer receiver){
    	if( currentItem != null){
    		item = currentItem;
    		currentItem = null;
    	}
    	if(company.createDeliverable(item,this,receiver))
    		return true;
    		
    	currentItem = item;
    	return false;
    }
    
    public String toString () {
    	String result = name + "\n" + name + "'s" +" position is " + posX + " + " + posY ; 
    	return result ;
    }
    
}