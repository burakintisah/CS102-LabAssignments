/**
 * @(#)Employee.java
 * A class which is responsible for packaging and delivery.
 *
 * @author 
 * @version 1.00 2017/10/24
 */


public abstract class Employee extends Person {
	
	//properties 
    double salary ; // The salary of the employee
    int employeeNo ; // The no of the employee
    
    //constructor
    public Employee (int employeeNo, String name){
    	super(name);
    	this.employeeNo = employeeNo ;
    	salary = 0 ;
    }
    //methods
    public int getEmployeeNo(){
    	return employeeNo;
    }
    public double getSalary(){
    	return salary;
    }    
    public void adjustSalary(double value) { //Adds the given value to the salary
    	salary = value ;
    }
    
    public abstract String toString ();
    
    
}