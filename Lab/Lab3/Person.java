/**
 * @(#)Person.java
 * An abstract class that implements Locatable.
 *
 * @author OsmanBurak
 * @version 1.00 2017/10/24
 */


public abstract class Person implements Locatable {
	
	protected String name ;
	protected int posX ;
	protected int posY ;
	
	public Person (String name, int x, int y) {
		this.name = name ;
		posX = x ;
		posY = y ;
	}
	
	public Person (String name){
		this.name = name ;
		posX = 0 ;
		posY = 0 ;
	}  
	
	public String getName () {
		return name ;
	}
	
	public void setName (String newName){
		name = newName ;
	}
	
	public int getX () {
		return posX ;
	}
	
	public int getY () {
		return posY ;
	}
	
	public void setPos (int x, int y){
		posX = x ;
		posY = y ;
	}   
}