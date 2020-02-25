/**
 * The Polynomial class creates polynomials and consists of properties of polynomials .
 * 
 * author Osman Burak	
 */
public class Polynomial {

	private double [] coefficients ; 
	
	/**
	 * Constructs a polynomial which is 0.
	 */
	public Polynomial () {
		coefficients = new double [1];
		coefficients [0] = 0 ;
	}
	
	/**
	 * Constructs a plynomial with type of coeff^exponent.
	 * @param coeff which is the coefficient
	 * @param exponent 
	 */
	public Polynomial (double coeff, int exponent) {
		coefficients = new double [exponent+1] ;
		coefficients [exponent] = coeff ;
	}
	
	/**
	 * Constructs a polynomial which is given in the array. 
	 * @param coeff the coefficients of the polynomial.
	 */
	public Polynomial ( double [] coeff ) {
		coefficients = coeff ;
	}
	
	/**
	 * Gives the value of the biggest degree of the polynomial.
	 * @return degree of the polynomial.
	 */
	public int getDegree() {
		int degree = coefficients.length -1 ;
		return degree;
		
	}
	
	/**
	 * Writes the polynomial that given.
	 * @return polynomial which has given in the array.
	 */
	public String toString() {
		String pol = "" ;
		if (coefficients.length==1 && coefficients[0]== 0) pol = "0";
		else {
			for (int i = 0 ; i < coefficients.length ; i++) {
				if ( coefficients[i]!= 0 ) {
					pol += coefficients [i]  ;
					if (i != 0 ) pol += "x^" + i ;
				
					if( i != coefficients.length-1 && coefficients[i+1]>0 ) pol += "+";
					else if (i != coefficients.length-1 && coefficients[i+1]<0) pol+= "";
				}
				else {
					if( i != coefficients.length-1 && coefficients[i+1]>0 ) pol += "+";
					else if (i != coefficients.length-1 && coefficients[i+1]<0 ) pol+= "";
				}
			}
		}
		return pol;
	}
	
	/**
	 * Evaluates the polynomial by math.pow
	 * @param x that written instead of x of the polynomial. 
	 * @return sum which is result of the polynomial with the given parameter.
	 */
	public double eval (double x) {
		double sum = 0;
		double value = 0;
		for (int i = 0; i < coefficients.length; i ++ ) {
			value = coefficients[i] * Math.pow(x,i);
			sum += value;
		}
		return sum ;
	}
	
	/**
	 * Evaluates the polynomial by Horner's method.
	 * @param x that written instead of x of the polynomial.
	 * @return sum which is the result.
	 */
	public double eval2 (double x ) {
		
		double value =  0 ; 
		
		for (int i = coefficients.length-1 ; i >= 0 ; i--) {
			value = (value * x ) + coefficients[i] ;
		}
		return value;
	}
	
}
