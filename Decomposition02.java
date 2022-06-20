package by.mikem.jonline.module2.main;

/*
 * Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.
 */

public class Decomposition02 {

	public static void main(String[] args) {
		int numberA = 200;
		int numberB = 100;
		int numberC = 11;
		int numberD = 200;

		findCDivisor(numberA, numberB, numberC, numberD);
	}

	public static long findCDivisor(int numberA, int numberB, int numberC, int numberD) {
		if (numberA <= 0 | numberB <= 0 | numberC <= 0 | numberD <= 0) {
			System.out.println("The numbers must be above zero! Please, restart the program.");
			System.exit(0);
		}

		int divisor = numberA;

		while ((numberA % divisor != 0) | (numberB % divisor != 0) | (numberC % divisor != 0)
				| (numberD % divisor != 0)) {
			divisor--;
		}

		System.out.println("The greatest common divisor = " + divisor);

		return divisor;
	}
}