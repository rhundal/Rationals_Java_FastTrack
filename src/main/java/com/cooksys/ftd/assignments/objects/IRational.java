package com.cooksys.ftd.assignments.objects;

import com.cooksys.ftd.assignments.objects.util.MissingImplementationException;

interface IRational {

	/**
	 * @return the numerator of this rational number
	 */
	int getNumerator();

	/**
	 * @return the denominator of this rational number
	 */
	int getDenominator();

	/**
	 * Specializable constructor to take advantage of shared code between
	 * Rational and SimplifiedRational
	 * <p>
	 * Essentially, this method allows us to implement most of IRational methods
	 * directly in the interface while preserving the underlying type
	 *
	 * @param numerator
	 *            the numerator of the rational value to construct
	 * @param denominator
	 *            the denominator of the rational value to construct
	 * @return the constructed rational value
	 * @throws IllegalArgumentException
	 *             if the given denominator is 0
	 */
	IRational construct(int numerator, int denominator) throws IllegalArgumentException;

	/**
	 * negation of rational values
	 * <p>
	 * definition: `negate(n / d) = -n / d`
	 *
	 * @return the negation of this
	 */
	default IRational negate() {

		return construct(getNumerator() * -1, getDenominator());

	}

	/**
	 * inversion of rational values
	 * <p>
	 * definition: `invert(n / d) = d / n`
	 *
	 * @return the inversion of this
	 * @throws IllegalStateException
	 *             if the numerator of this rational value is 0
	 */
	default IRational invert() throws IllegalStateException {
		
		if(getNumerator() == 0) {
			
			throw new IllegalStateException("Numerator cannot be 0.");
		}
		return construct(getDenominator(), getNumerator());
		
		//throw new MissingImplementationException();
	}

	/**
	 * addition of rational values
	 * <p>
	 * definition: `(n1 / d1) + (n2 / d2) = ((n1 * d2) + (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to add to this
	 * @return the sum of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational add(IRational that) throws IllegalArgumentException {		
 		
		if(that == null) {
			
			throw new IllegalArgumentException("That cannot be null.");
		}
		
		int numerator, denominator;
		IRational addResult;
		
		numerator = (getNumerator() * that.getDenominator()) + (that.getNumerator() * getDenominator());		// ((n1 * d2) + (n2 * d1))
		
		denominator = getDenominator() * that.getDenominator();  // (d1 * d2)
		
		addResult = construct(numerator, denominator);
		
		return addResult;

				
		//return sum;
		
		
		
		//throw new MissingImplementationException();
	}

	/**
	 * subtraction of rational values
	 * <p>
	 * definition: `(n1 / d1) - (n2 / d2) = ((n1 * d2) - (n2 * d1)) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to subtract from this
	 * @return the difference between this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational sub(IRational that) throws IllegalArgumentException {
		
		if(that == null) {
			
			throw new IllegalArgumentException("That cannot be null.");
		}

		int numerator, denominator;
		IRational subResult;
		
		numerator = (getNumerator() * that.getDenominator()) - (that.getNumerator() * getDenominator());		// ((n1 * d2) - (n2 * d1))
		
		denominator = getDenominator() * that.getDenominator();  // (d1 * d2)
		
		subResult = construct(numerator, denominator);
		
		return subResult;
		
			
	}

	/**
	 * multiplication of rational values
	 * <p>
	 * definition: `(n1 / d1) * (n2 / d2) = (n1 * n2) / (d1 * d2)`
	 *
	 * @param that
	 *            the value to multiply this by
	 * @return the product of this and that
	 * @throws IllegalArgumentException
	 *             if that is null
	 */
	default IRational mul(IRational that) throws IllegalArgumentException {
		
		if(that == null) {
			
			throw new IllegalArgumentException("That cannot be null.");
		}
		
		int numerator, denominator;
		IRational mulResult;
		
		numerator = getNumerator() * that.getNumerator();		// (n1 * n2)
		
		denominator = getDenominator() * that.getDenominator();  // (d1 * d2)
		
		mulResult = construct(numerator, denominator);
		
		return mulResult;
		
		//throw new MissingImplementationException();
	}

	/**
	 * division of rational values
	 * <p>
	 * definition: `(n1 / d1) / (n2 / d2) = (n1 * d2) / (d1 * n2)`
	 *
	 * @param that
	 *            the value to divide this by
	 * @return the ratio of this to that
	 * @throws IllegalArgumentException
	 *             if that is null or if the numerator of that is 0
	 */
	default IRational div(IRational that) throws IllegalArgumentException {
		
		
		if(that == null) {
			
			throw new IllegalArgumentException("That cannot be null.");
		}
		
		int numerator, denominator;
		IRational divisonResult;
		
		numerator = getNumerator() * that.getDenominator();		// (n1 * d2) 
		
		denominator = getDenominator() * that.getNumerator();	// (d1 * n2)
		
		divisonResult = construct(numerator, denominator);
		
		return divisonResult;
		
		//throw new MissingImplementationException();
	}
}
