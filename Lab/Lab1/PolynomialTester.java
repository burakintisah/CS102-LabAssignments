
public class PolynomialTester {
	public static void main ( String [] args) {
		
		//Variables
		double [] test = { 6 , 8 , 7 , -6 , 0.5 } ;
		
		//Creating Objects
		Polynomial first = new Polynomial ();
		Polynomial second  = new Polynomial(-4,1);
		Polynomial third = new Polynomial ( test );
		
		//Checking results 
		System.out.println("Degrees");
		System.out.println("First " + first.getDegree());
		System.out.println ("Second " + second.getDegree());
		System.out.println ("Third " +  third.getDegree());
		System.out.println("");
		
		System.out.println("Representation");
		System.out.println("First " + "P(x)=" + first.toString () );
		System.out.println ("Second " + "P(x)=" + second.toString());
		System.out.println ("Third " +  "p(x)=" + third.toString());
		System.out.println("");
		
		System.out.println("Evaluate with Math Class");
		System.out.println("First " + first.eval (4) );
		System.out.println ("Second " + second.eval (3));
		System.out.println ("Third " +  third.eval (3));
		System.out.println("");
		
		System.out.println("Evaluate with Horner's Method");
		System.out.println("First " + first.eval2 (4) );
		System.out.println ("Second " + second.eval2 (3));
		System.out.println ("Third " +  third.eval2 (3));
		System.out.println("");
		
		
	
		
		
		
		
		
				
				
		
	}
}
