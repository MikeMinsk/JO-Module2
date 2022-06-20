package by.mikem.jonline.module2.main;

/*
 * Написать метод(методы) для нахождения наибольшего общего делителя 
 * и наименьшего общего кратного двух натуральных чисел:
 */

public class Decomposition01 {

	public static void main(String[] args) {
		int numberA = 2147483640;
		int numberB = 32;

		System.out.println("The choosen numbers: " + numberA + ", " + numberB);

		int divisor;

		divisor = findDivisor(numberA, numberB);

		System.out.println("The greatest common divisor = " + divisor);

		long cDenominator;

		cDenominator = findCDenominator(numberA, numberB, divisor);

		System.out.println("The least common denominator = " + cDenominator);
	}

	public static long findCDenominator(int numberA, int numberB, int divisor) {
		if (numberA <= 0 | numberB <= 0 | divisor <= 0) {
			System.out.println("The numbers must be above zero! Please, restart the program.");
			System.exit(0);
		}

		long cDenominator;

		cDenominator = (long) numberA * numberB / divisor;

		if (cDenominator < 0) {
			System.out.println("The common denominator for those numbers goes beyond the range of"
					+ " Long numbers. Please, restart the program.");
			System.exit(0);
		}
		return cDenominator;
	}

	public static int findDivisor(int numberA, int numberB) {
		if (numberA <= 0 | numberB <= 0) {
			System.out.println("The numbers must be above zero! Please, restart the program.");
			System.exit(0);
		}

		for (int divisor = numberB; divisor > 0; divisor--) {

			if (numberA % divisor == 0 & numberB % divisor == 0) {
				return divisor;
			}
		}
		return -1;
	}
}