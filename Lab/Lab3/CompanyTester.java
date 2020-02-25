/**
 * @(#)CompanyTester.java
 *
 *
 * @author 
 * @version 1.00 2017/10/24
 */


public class CompanyTester {

	public static void main (String [] args){
		
		Company company1 = new Company (0,0);
		
		Item item1 = new Item (21 ,"pc" );
		Item item2 = new Item (0.01,"letter");
		Item item3 = new Item (5,"box");
		Item item4 = new Item (0.1,"page");
		Item item5 = new Item (4,"car toy");
		Item item6 = new Item (0.1,"toy");
			
		Customer sender1 = new Customer ("Sender1");
		Customer sender2 = new Customer ("Sender2");
		Customer sender3 = new Customer ("Sender3");
		Customer sender4 = new Customer ("Sender4");
		Customer sender5 = new Customer ("Sender5");
		Customer sender6 = new Customer ("Sender6");
		
		Customer receiver = new Customer ("Receiver",11,22);
				
		Employee employee1 = new Employee (21,"Efe");
		Employee employee2 = new Employee (45,"Rümeysa");
		Employee employee3 = new Employee (47,"Serdar");
		
		
		if (company1.addEmployee(employee1)== true){
			System.out.println("Now on, he/she is an employee!!");
		}
		else{
			System.out.println("He/she can't be an employee!! ");
		}
		/*
		if (company1.addEmployee(employee2)== true){
			System.out.println("okey");
		}
		else{
			System.out.println("NOT okey");
		}
		
		if (company1.addEmployee(employee3)== true){
			System.out.println("okey");
		}
		else{
			System.out.println("NOT okey");
		}
		*/
		
		// sending items
		if(	sender1.sendItem(company1,item1,receiver) == true ) {
			System.out.println("Item added to the sequence.");
		}
		else {
			System.out.println("The item cannot be send because there is no available employee!!");
		}
		if (sender2.sendItem(company1,item2,receiver) == true){
			System.out.println("Item added to the sequence.");
		}
		else {
			System.out.println("The item cannot be send because there is no available employee!!");
		}
		if (sender3.sendItem(company1,item3,receiver) == true){
			System.out.println("Item added to the sequence.");
		}
		else {
			System.out.println("The item cannot be send because there is no available employee!!");
		}
		if (sender4.sendItem(company1,item4,receiver) == true){
			System.out.println("Item added to the sequence.");
		}
		else {
			System.out.println("The item cannot be send because there is no available employee!!");
		}
		if (sender5.sendItem(company1,item5,receiver) == true){
			System.out.println("Item added to the sequence.");
		}
		else {
			System.out.println("The item cannot be send because there is no available employee!!");
		}
		if (sender6.sendItem(company1,item6,receiver) == true){
			System.out.println("Item added to the sequence.");
		}
		else {
			System.out.println("The item cannot be send because there is no available employee!!");
		}
		System.out.println("");
		System.out.println(company1.toString());
		System.out.println("");
		company1.deliverPackages() ;
		System.out.println("");
		System.out.println(company1.toString());
		
		
	}
}