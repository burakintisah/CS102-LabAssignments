/*
 *	Polynomial Tester.java
 *	Testing the Polynomial class objects.
 *
 *	@author Osman Burak
 *  @version 1.00 04.10.2017 
 *
 */
public class PolynomialTester {
	public static void main ( String [] args) {
		
		//Variables
		double [] test = {3, 4, 1} ;
		double [] test2 = {2 , 1 } ;
		
		//Creating Objects
		Polynomial first = new Polynomial ();
		Polynomial second  = new Polynomial(-4,9);
		Polynomial third = new Polynomial ( test );
		Polynomial fourth = new Polynomial (test2);
		
		//Checking results 
		System.out.println("Degrees");
		System.out.println("First " + first.getDegree());
		System.out.println ("Second " + second.getDegree());
		System.out.println ("Third " +  third.getDegree());
		System.out.println ("Fourth " +  fourth.getDegree());
		System.out.println("");
		
		System.out.println("Representation");
		System.out.println("First " + "P(x)=" + first.toString () );
		System.out.println ("Second " + "P(x)=" + second.toString());
		System.out.println ("Third " +  "P(x)=" + third.toString());
		System.out.println ("Fourth " +  "P(x)=" + fourth.toString());
		System.out.println("");
		
		System.out.println("Evaluate with Math Class");
		System.out.println("First " + first.eval (4) );
		System.out.println ("Second " + second.eval (-1));
		System.out.println ("Third " +  third.eval (3));
		System.out.println ("Fourth " +  fourth.eval (-6));
		System.out.println("");
		
		System.out.println("Evaluate with Horner's Method");
		System.out.println("First " + first.eval2 (4) );
		System.out.println ("Second " + second.eval2 (-1));
		System.out.println ("Third " +  third.eval2 (3));
		System.out.println ("Fourth " +  fourth.eval2 (-6));
		System.out.println("");
		
		// Second Assignment
		
		Polynomial fifth = third.add(fourth);		
		System.out.println("P(x)+Q(x)= " + fifth.toString());
		
		Polynomial sixth = third.sub(fourth);		
		System.out.println("P(x)-Q(x)= " + sixth.toString());
		
		Polynomial seventh = third.mul(fourth);
		System.out.println("P(x)*Q(x)= " + seventh.toString());
		
		Polynomial eight = third.compose(fourth);
		System.out.println("P(Q(x))= " + eight.toString());
		
		/*
		Polynomial nine = third.div(fourth);
		System.out.println("P(x) / Q(x) = " + nine.toString());
		*/
		
		
		
		
				
				
		
	}
}
