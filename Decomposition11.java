package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Decomposition11 {

	public static void main(String[] args) {
		long numberA;

		numberA = getFromConsole("the first number");

		long numberB;

		numberB = getFromConsole("the second number");

		if (compareDigits(numberA, numberB) == -1) {
			System.out.print("The numbers have the same amount of digits.");
		} else {
			System.out.print("The number " + compareDigits(numberA, numberB) + " has more digits.");
		}
	}

	public static long compareDigits(long numberA, long numberB) {
		int digitsA;

		digitsA = checkForDigits(numberA);

		int digitsB;

		digitsB = checkForDigits(numberB);

		if (digitsA > digitsB) {
			return numberA;
		} else if (digitsA < digitsB) {
			return numberB;
		} else {
			return -1;
		}
	}

	public static int checkForDigits(long number) {
		int digit = 1;

		while (number > 9) {
			number /= 10;
			digit++;
		}

		return digit;
	}

	public static long getFromConsole(String variable) {
		long value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a value for " + variable + " >> ");

		while (!sc.hasNextLong()) {
			sc.nextLine();
			System.out.print("Enter a value for " + variable + " >> ");
		}

		value = sc.nextLong();

		return value;
	}
}