/**
 * @(#)ProcessTester.java
 *
 *
 * @author Osman Burak ÝNTÝÞAH
 * @version 1.00 2017/12/20
 */


public class ProcessTester {
	public static void main (String [] args ){
		
		MyProcess pr1 = new MyProcess();
		pr1.name = "Photo" ;
		pr1.cost = 20;
		MyProcess pr2 = new MyProcess();
		pr2.name = "Music" ;
		pr2.cost = 30;
		MyProcess pr3= new MyProcess();
		pr3.name = "Word" ;
		pr3.cost = 60;
		MyProcess pr4 = new MyProcess();
		pr4.name = "Kernel" ;
		pr4.cost = 45;
		MyProcess pr5 = new MyProcess();
		pr5.name = "Text" ;
		pr5.cost = 15;
		MyProcess pr6 = new MyProcess();
		pr6.name = "Map" ;
		pr6.cost = 40;
		
		ProcessQueue hi = new ProcessQueue (70);
		
		hi.enqueue (pr1);
		System.out.println(hi);
		hi.enqueue (pr2);
		System.out.println(hi);
		hi.enqueue (pr3);
		System.out.println(hi);
		hi.enqueue (pr4);
		System.out.println(hi);
		hi.enqueue (pr5);
		System.out.println(hi);
		hi.enqueue (pr6);
		System.out.println(hi);
		System.out.println("Size of the queue is " + hi.size());
		System.out.println();
		hi.dequeue();
		System.out.println(hi);
		System.out.println("Size of the queue is " + hi.size());
		System.out.println(hi.totalCost(pr2));
		System.out.println();
		hi.run(2);
		System.out.println();
		hi.run(1);
		System.out.println();
		
		hi.enqueue ("Music",30);
		hi.enqueue ("Word",60);
		hi.enqueue ("Kernel",40);
		hi.enqueue ("Text",30);
		hi.enqueue ("Map",40);
		System.out.println();
		System.out.println(hi);	
		ProcessQueue sa ;	
		sa = hi.split();
		System.out.println(sa);
		System.out.println(hi);	


		
		

	}    
    
}