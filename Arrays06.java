package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых 
 * являются простыми числами.
 */

public class Arrays06 {

	public static void main(String[] args) {
		int n;

		n = getFromConsole("N");

		double[] array;

		array = createArray(n);

		System.out.println("Required sum of members: " + sumNumbers(array));
	}

	public static double[] createArray(int arrayLength) {
		double[] array;

		array = new double[arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.sqrt(i * i + 1) - 100;
		}

		return array;
	}

	public static boolean checkPrime(int number) {

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static double sumNumbers(double[] array) {
		double sum;

		sum = 0;

		for (int i = 2; i < array.length; i++) {
			if (checkPrime(i)) {
				sum += array[i];
			}
		}

		return sum;
	}

	public static int getFromConsole(String variable) {
		int value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a value for " + variable + " >> ");

		do {
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}

			value = sc.nextInt();

			if (value <= 0) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 0);

		return value;
	}
}
