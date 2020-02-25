/**
 * Polynomial.java
 * The Polynomial class creates polynomials and consists of properties of polynomials .
 * 
 * @author Osman Burak	
 * @version 1.00 04.10.2017 
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
		
		int degree = 0 ;
		for (int i = coefficients.length-1 ; i>0 ; i--){
			if (coefficients[i] == 0) {
				degree = i-1;
			}
			else {
				degree = i ; 
				break;
			}
		}
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
				if (coefficients[0] == 0 ) {
					while (coefficients[i] == 0){
						i++;
					}
				}
				if ( coefficients[i]!= 0 ) {
					pol += coefficients [i]  ;
				
					if (i>0 ) pol+= "x^" + i ;
					
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

	/**
	 * Add two polynomial
	 *@param p2 polynomial that given at second time.
	 *@return double array which is the result of the addition
	 */
	public Polynomial add (Polynomial p2){
		int max = p2.getDegree();
		int min = this.getDegree();
		if (p2.getDegree() < this.getDegree()) {
			max = this.getDegree();
			min = p2.getDegree() ;
		}	
		double[] result = new double [max+1] ;
		for (int i = 0 ; i<min+1 ; i++){
			result [i] = this.coefficients[i] + p2.coefficients[i] ;
		}
		for (int i=min+1 ; i<max+1; i++){
			if (p2.getDegree() < this.getDegree()){
				result [i] = this.coefficients [i] ;
			}
			else {
				result [i] = p2.coefficients [i];
			}
		}
		return new Polynomial(result);	
	}
	/**
	 * Multiply two polynomial 
	 *@param p2 that given in the second time two multiply with the first one
	 *@return a double array which is the result of multiplication
	 */	
	public Polynomial mul (Polynomial p2) {
		int last = p2.getDegree() + this.getDegree() + 1 ;
		double result [] = new double [ last ] ;
		
		for (int i = 0 ; i < this.getDegree()+1 ; i++){
			for (int j = 0 ; j < p2.getDegree()+1  ; j++ ){
				result[i+j] += this.coefficients [i] * p2.coefficients[j]; 
			}
		}
		return new Polynomial(result);
	}	
	/**
	 *Substract two polynomial from each other
	 *@param p2 taken from the user to substract it from the first one 
	 *@return double array which is the result of substraction 
	 */
	public Polynomial sub (Polynomial p2) {
		
		Polynomial minus = new Polynomial (-1,0) ;
		return this.add(p2.mul(minus));
		
	}
	
	/**
	 *Composition of the two polynom
	 *@param p2 polynomial which is the written instead of x
	 *@return double array which is the result of the composition
	 */	
	 	
	public Polynomial compose (Polynomial p2) {	
		double[]  result = new double [(this.getDegree() + p2.getDegree()) +1];
		result[0] = this.coefficients[0];
		Polynomial result1 = new Polynomial (result);
		for (int i=1; i<this.getDegree()+1; i++){
			Polynomial temp = p2;
			for(int j=1; j<i; j++){
				temp = temp.mul(p2);
			}
			result1 = result1.add(temp.mul(new Polynomial(this.coefficients[i],0)));
		}
		return result1;
	}
	
	
	/**
	 *Divide two function
	 *@param p2 is the subdivision
	 *@return double array which is the result of the division
	 */
	 
	public Polynomial div (Polynomial p2){
		
		while (){
			
			int degree = this.getDegree();
			int degree2 = p2.getDegree();
			int a = (int) (this.coefficients[getDegree] / p2.coefficients[getDegree] );
			Polynomial last = new Polynomial (a,(degree-degree2));
			Polynomial result = this.sub(p2.mul(last));
			
		}
	}
		
	
}
