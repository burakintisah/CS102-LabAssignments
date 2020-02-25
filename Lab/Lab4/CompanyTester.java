/**
 * @(#)CompanyTester.java
 *
 *
 * @author 
 * @version 1.00 2017/10/24
 */
import java.util.Scanner;

public class CompanyTester {

	public static void main (String [] args){
		
			//Create company
		Company comp = new Company(10, 11);
		
			//Create people
		Person pers1 = new Customer("Antonio");
		comp.addCustomer(pers1);
		pers1.setPos(4, 3);
		Person pers2 = new Customer("Jack");
		comp.addCustomer(pers2);
		
		
			//Hire them
		Person pers3 = new Person("Baby Driver");
		comp.hireEmployee(pers3, "Driver");
		Person pers5 = new Person("Han Solo");
		comp.hireEmployee(pers5, "Driver");
		Person pers4 = new Person("Brad Pitt");
		comp.hireEmployee(pers4, "CustomerService");
		

			//Create items
		Item item1 = new Item(5,"A plate");
		Item item2 = new Item(0.01,"TOP SECRET");
		
			//Send between customers
		((Customer)comp.customers.get(1)).sendItem(comp, item1, (Customer)comp.customers.get(0));
		((Customer)comp.customers.get(0)).sendItem(comp, item2, (Customer)comp.customers.get(1));
		
			//Add vehicles
		comp.addVehicle("Truck");
		comp.addVehicle("Motorcycle");
		
			//Assign them to drivers
		comp.assignVehicle(0, 1);
		comp.assignVehicle(1, 0);
		
			//Load deliveries
		
		comp.loadDelivery(1, 0);
		comp.loadDelivery(0, 1);
		System.out.println(comp.toString());
		
			//Deliver
		comp.deliverPackages();
		System.out.println(comp.toString());
	}
}