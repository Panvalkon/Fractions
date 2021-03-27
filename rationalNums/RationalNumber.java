package rationalNums;

/**
 * A class that define behavior of rational numbers
 * 
 * @author Illya Roz.
 * @Date March 26-27, 2021
 */
public class RationalNumber {
	/**
	 * @param numerator   Fraction's numerator
	 * @param denominator Fraction's denominator
	 */
	private int numerator, denominator;

	public RationalNumber() {

		this(0, 1);
	}

	public RationalNumber(int numerator, int denominator) {
		this.numerator = numerator;
		if (denominator == 0)
			throw new RuntimeException("Denominator can not be zero");
		else
			this.denominator = denominator;
	}

	/**
	 * Sum two given fraction, caller and parameter
	 * @param Object of type RationalNumber()
	 * @return
	 * A new fraction, as a string
	 */
	public String sumFractions(RationalNumber frac) {
		RationalNumber ans = new RationalNumber();
		if (this.denominator != frac.getDenominator()) {
			ans.setDenominator(calculateLCM(this.getDenominator(), frac.getDenominator()));
			ans.setNumerator(this.getNumerator() * (ans.getDenominator() / this.getDenominator())
						   + frac.getNumerator() * (ans.getDenominator() / frac.getDenominator()));
		} else {
			ans.setNumerator(this.numerator + frac.getNumerator());
			ans.setDenominator(this.denominator);
		}
		simplifyFraction(ans);
		return ans.toString();
	}
	
	/**
	 * Subtracts, passed as parameter, fraction from a caller
	 * @param Object of type RationalNumber() 
	 * @return
	 * A new fraction, as a string
	 */
	public String subFractions(RationalNumber frac) {
		RationalNumber ans = new RationalNumber();
		if (this.denominator != frac.getDenominator()) {
			ans.setDenominator(calculateLCM(this.getDenominator(), frac.getDenominator()));
			ans.setNumerator(this.getNumerator() * (ans.getDenominator() / this.getDenominator())
						   - frac.getNumerator() * (ans.getDenominator() / frac.getDenominator()));
		} else {
			ans.setNumerator(this.numerator - frac.getNumerator());
			ans.setDenominator(this.denominator);
		}
		simplifyFraction(ans);
		return ans.toString();
	}
	/**
	 * Multiply two fraction, caller and parameter
	 * @param Object of type RationalNumber()
	 * @return
	 * A new fraction, as a string
	 */
	public String multFractions(RationalNumber frac) {
		RationalNumber ans = new RationalNumber();
		ans.setNumerator(this.numerator * frac.getNumerator());
		ans.setDenominator(this.denominator * frac.getDenominator());
		simplifyFraction(ans);
		return ans.toString();
	}

	/**
	 * Divide the caller fraction by parameter fraction
	 * @param Object of type RationalNumber()
	 * @return
	 * A new fraction, as a string
	 */
	public String divideFractions(RationalNumber frac) {
		RationalNumber ans = new RationalNumber();
		if (frac.getNumerator() != 0) {
			ans.setNumerator(this.getNumerator() * frac.getDenominator());
			ans.setDenominator(this.getDenominator() * frac.getNumerator());
			simplifyFraction(ans);
		} else {
			throw new RuntimeException("You can not divide by zero");
		}
		return ans.toString();
	}

	public int getNumerator() {
		return this.numerator;
	}

	public int getDenominator() {
		return this.denominator;
	}

	public String toString() {
		String ss = new String();
		if (this.denominator == 1) {
			ss += Integer.toString(this.getNumerator());
		} else if (this.getNumerator() == 0 && this.getDenominator() == 0) {
			ss += "0";
		} else {
			ss += this.getNumerator() + "/" + this.getDenominator();
		}
		return ss;
	}

	private int calculateGCD(int num2, int num1) {
		int gcd = 1, rem = -1;
		num2 = Math.abs(num2);
		num1 = Math.abs(num1);
		if (num2 > num1) {
			gcd = num1;
			num1 = num2;
			num2 = gcd;
		}
		if (num2 == num1) {
			gcd = num1;
		}
		while (rem != 0) {
			rem = num1 % num2;
			gcd = num2;
			num1 = num2;
			num2 = rem;
		}
		return gcd;
	}

	private int calculateLCM(int num1, int num2) {
		int lcm = (num1 * num2) / calculateGCD(num1, num2);
		return lcm;
	}

	private void simplifyFraction(RationalNumber frac) {
		if (frac.getNumerator() != 0) {
			int gcd = calculateGCD(frac.getNumerator(), frac.getDenominator());
			if (gcd > 1) {
				frac.setNumerator(frac.getNumerator() / gcd);
				frac.setDenominator(frac.getDenominator() / gcd);
			}
		} else {
			frac.setDenominator(0);
		}
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
}
