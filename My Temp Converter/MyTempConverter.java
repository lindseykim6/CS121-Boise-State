/**
 * Converts a fahrenheit temperature to celsius using the formula:
 * C=9/5(F-32)
 * @author lindseykim
 *
 */
public class MyTempConverter {
	public static void main(String[] args) {
		final int BASE = 32;
		final double CONVERSION_FACTOR = 5.0 / 9.0;

		int fahrenheitTemp = 75;  // value to convert

		double celsiusTemp = CONVERSION_FACTOR * (fahrenheitTemp - BASE);

		System.out.println("Fahrenheit Temperature: " + fahrenheitTemp);
		System.out.println("Celsius Equivalent: " + celsiusTemp);
	}
}
