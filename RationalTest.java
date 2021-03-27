import rationalNums.RationalNumber;

public class RationalTest {
	public static void main(String[] args) {
		try {
			
			// set Fraction one numerator and denominator inside the parenthesis
			
			RationalNumber frac = new RationalNumber(-2, 5);
			System.out.println("Fraction one is: " + frac.toString());
			
			// set Fraction two numerator and denominator inside the parenthesis
			RationalNumber frac2 = new RationalNumber(3, 4);
			System.out.println("Fraction two is: " + frac2.toString());
			
			System.out.println("Sum result is: \t\t\t" + frac.sumFractions(frac2));
			System.out.println("Subtraction result is: \t\t" + frac.subFractions(frac2));
			System.out.println("Multiplication result is: \t" + frac.multFractions(frac2));
			System.out.println("Division result is: \t\t" + frac.divideFractions(frac2));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}
