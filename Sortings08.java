package by.mikem.jonline.module2.main;

/*
 * Даны дроби (pi qi, - натуральные). Составить программу, которая приводит эти дроби 
 * к общему знаменателю и упорядочивает их в порядке возрастания.
 */

public class Sortings08 {

	public static void main(String[] args) {
		Fraction[] array;

		array = createFractions();

		printArray(array);

		long cDenominator = findCDenominator(array);

		System.out.println("The common denominator = " + cDenominator + "\n");

		makeJointDenominator(array, cDenominator);

		sortFractions(array);

		printArray(array);
	}

	public static void makeJointDenominator(Fraction[] array, long cDenominator) {
		for (int i = 0; i < array.length; i++) {

			if (array[i].denominator != cDenominator) {
				array[i].numerator = array[i].numerator * (cDenominator / array[i].denominator);
				array[i].denominator = cDenominator;
			}
		}
	}

	public static long findCDenominator(Fraction[] array) {
		long cDenominator;

		cDenominator = array[0].denominator;

		for (int i = 1; i < array.length; i++) {

			for (long divisor = array[i].denominator; divisor > 0; divisor--) {

				if (cDenominator % divisor == 0 & array[i].denominator % divisor == 0) {
					cDenominator = (cDenominator * array[i].denominator) / divisor;
					break;
				}
			}
		}

		if (cDenominator < 0) {
			System.out.println("Сommon denominator for those fractions goes beyond the range of"
					+ " Long numbers. Please, restart the program.");
			System.exit(0);
		}
		return cDenominator;
	}

	public static void sortFractions(Fraction[] array) {
		for (int i = 0; i < array.length; i++) {
			Fraction tempMember;
			int tempIndex = -1;
			long minValue = Long.MAX_VALUE;

			for (int j = i; j < array.length; j++) {

				if (array[j].numerator < 0) {
					System.out.println(
							"Some fraction goes beyond the range of Long numbers. Please, restart the program.");
					System.exit(0);
				}

				if (array[j].numerator < minValue) {
					tempIndex = j;
					minValue = array[j].numerator;
				}
			}

			if (tempIndex != -1) {
				tempMember = array[tempIndex];
				array[tempIndex] = array[i];
				array[i] = tempMember;
			}
		}

		System.out.println("The fractions after sorting:");
	}

	public static void printArray(Fraction[] array) {
		System.out.print("{");

		for (int i = 0; i < array.length; i++) {

			if (i < array.length - 1) {
				System.out.print(array[i].numerator + "/" + array[i].denominator + "; ");
			} else {
				System.out.println(array[i].numerator + "/" + array[i].denominator + "}\n");
			}
		}
	}

	public static Fraction[] createFractions() {
		int size;

		size = (int) (Math.random() * 50 + 1);

		Fraction[] array = new Fraction[size];

		for (int i = 0; i < array.length; i++) {
			long numerator;

			numerator = (long) (Math.random() * 50) + 1;

			long denominator;

			denominator = (long) (Math.random() * 50) + 1;

			array[i] = new Fraction(numerator, denominator);
		}

		return array;
	}
}

class Fraction {
	long numerator;
	long denominator;

	Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
}