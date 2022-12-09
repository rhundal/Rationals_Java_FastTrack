package com.cooksys.ftd.assignments.objects;

import com.cooksys.ftd.assignments.objects.util.MissingImplementationException;

public class SimplifiedRational implements IRational {
	
	private int numerator;
	private int denominator;
//	private int[] expectedArray;
	private static int[] simplifiedElm = new int[2];

	/**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
       
		//throw new MissingImplementationException();

    	int GCD = 1;

    	if((a <= 0) || (b <= 0)) {		
    		
    		throw new IllegalArgumentException("a cannot be <= 0. b cannot be <= 0.");
    	}
    	else {
    		    		
			 while (true) {
			  int remainder = a % b;
			  if(remainder==0){
			   return b;
			  }else{
			   a=b;
			   b=remainder;
			  }
			 }			
    	}     
    	
    }

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {

		//throw new MissingImplementationException();

    	
    	if(denominator == 0) {
    		
    		throw new IllegalArgumentException("Denominator cannot be 0.");
    	}
    	
    	
    	
    	if(numerator == 0) {
    		
    		simplifiedElm[0] = 0;		// eg. 2/2 => 1
        	simplifiedElm[1] = 1;
        	
    	}else {
    		
    		int sr = gcd(Math.abs(numerator), Math.abs(denominator));
	    	
        	//int[] simplifiedElm = new int[2];

        	simplifiedElm[0] = numerator/sr;		// eg. 2/2 => 1
        	simplifiedElm[1] = denominator/sr;		// eg. 10/2 => 5
    	}
    	
    
    	
    	return simplifiedElm;  
    	    	
    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
        
	//	throw new MissingImplementationException();

    	
    	if(denominator == 0) {
    		
    		throw new IllegalArgumentException("Denominator cannot be zero.");
    	}

    	int[] testArray = simplify(numerator, denominator);

    	this.numerator = testArray[0];
    	this.denominator = testArray[1];
    	
    	
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
    	return this.numerator;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
    	return this.denominator;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
        
    	if(denominator == 0) {
    		
    		throw new IllegalArgumentException("Denominator cannot be 0.");
    	}
    	    	
    	return new SimplifiedRational(numerator, denominator);

    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        
		//throw new MissingImplementationException();


    	if(this == obj) {
    		
    		return true;
    	}
    	
    	
    	if(obj instanceof SimplifiedRational && (((SimplifiedRational) obj).getNumerator()== getNumerator() && ((SimplifiedRational) obj).getDenominator() == getDenominator())){    			
    			
    		return true;
    	}
    
    	return false; 
    	    	
    } 

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    
    @Override
    public String toString() {
    	
	//	throw new MissingImplementationException();

    	String finalString = "";
    	//(-1 * Math.abs(getNumerator()))  + "/" + Math.abs(getDenominator());
    	
    	
    	if(getNumerator() > 0 && getDenominator() > 0) {
    		
			finalString = Math.abs(getNumerator())  + "/" + Math.abs(getDenominator());  

    	}
    	if(getNumerator() > 0 && getDenominator() < 0) {
			finalString = (-1*Math.abs(getNumerator()))  + "/" + Math.abs(getDenominator());  

    		
    	}
    	if(getNumerator() < 0 && getDenominator() < 0) {
			finalString = Math.abs(getNumerator())  + "/" + Math.abs(getDenominator());  

    		
    	}
    	if(getNumerator() < 0 && getDenominator() > 0) {
			finalString = (-1*Math.abs(getNumerator()))  + "/" + Math.abs(getDenominator());  

    		
    	}
    	
    	
    	return finalString;

    } 
}
