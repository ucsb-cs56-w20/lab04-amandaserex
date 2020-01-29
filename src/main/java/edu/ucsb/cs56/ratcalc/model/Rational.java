/** A class to represent a rational number
    with a numerator and denominator

    @author Amanda Serex, Ishana Narayanan

    */
package edu.ucsb.cs56.ratcalc.model;

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */

    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }

    /**
     * Basic constructor for rational
     * sets num and denom to 1
     */

    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    /**
     * parameterized constructor for rational
     * @param num first int
     * @param denom second int
     * sets num to this.num 
     * sets denom to this.denom
     * reduces to simplest form with negative in numerator
     */

    public Rational(int num, int denom) {
	
        if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
        int gcd = Rational.gcd(num,denom);
	if (num != 0) {
	    this.num /= gcd;
	    this.denom /= gcd;
	}
	if(this.denom<0){
		this.denom = Math.abs(this.denom);
		this.num = -1 * this.num; 
	}
    }

   /**
    * converts Rational to string
    */

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    /**
     * @return num
     */

    public int getNumerator() { return this.num; }
    
    /**
     * @return denom
     */

    public int getDenominator() { return this.denom; }

    /**
     * Multiplies this by r
     * @param r first Rational
     * @return product of r and this
     */

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    /**
     * product of a and b
     * @param a first Rational
     * @param b second Rational
     * @return product of a and b
     */

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    /**
     * least common multiple of a and b
     * @param a first number
     * @param b second number
     * @return lcm of a and b
     */

    public static int lcm(int a, int b) {
	if (a==b)
	    return a;
	else if (b==0||a==0)
	    return 0;
	else
	    return Math.abs((a*b)/gcd(a,b));
    }

    /**
     * Adds of r to this
     * @param r first Rational
     * @return sum of r and this
     */

    public Rational plus(Rational r){
	    if (r.num==0)
		    return this;
	    Rational a = new Rational((r.num*this.denom)+(r.denom*this.num),this.denom*r.denom);
	    return a;
    }
   
    /**
     * sum of a and b
     * @param a first Rational
     * @param b second Rational
     * @return sum of a and b
     */

    public static Rational sum(Rational a, Rational b) {
	    if (a.num==0)
		    return b;
	    else if (b.num==0)
		    return a;
	    return new Rational((a.num*b.denom)+(a.denom*b.num),a.denom*b.denom);
    }

    /**
     * Subtract r from this
     * @param r first Rational
     * @return difference of r and this
     */

    public Rational minus(Rational r){
	    if (r.num==0)
		    return this;
	    Rational a = new Rational(-(r.num*this.denom)+(r.denom*this.num),this.denom*r.denom);
	    return a;
    }
   
    /**
     * difference of a and b
     * @param a first Rational
     * @param b second Rational
     * @return difference of a and b
     */

    public static Rational difference(Rational a, Rational b) {
	    return new Rational(-(b.num*a.denom)+(b.denom*a.num),a.denom*b.denom);
    }

    /**
     * Reciprocal of this
     * @return reciprocal
     */

    public Rational reciprocalOf() {
	if (this.num == 0) {
	    throw new ArithmeticException("denominator may not be zero");
	}
	int t;
	int h;
	if (this.num<0){
		t = -this.denom;
		h = Math.abs(this.num);
	}
	else{
		t= this.denom;
		h= this.num;
	}
	return new Rational(t,h);
    }

    /**
     * Divides this by r
     * @param r first Rational
     * @return this divided by r
     */

    public Rational dividedBy(Rational r){
	    Rational recip= r.reciprocalOf();
	    return new Rational(this.num * recip.num, this.denom * recip.denom);
    }

    /**
     * quotient of a and b
     * @param a first Rational
     * @param b second Rational
     * @return quotient of a and b
     */

    public static Rational quotient(Rational a, Rational b){
	    Rational recip = b.reciprocalOf();
	    return new Rational(a.num * recip.num, a.denom * recip.denom);
    }
}
