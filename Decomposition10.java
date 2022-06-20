package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Дано натуральное число N. Написать метод(методы) для формирования массива, 
 * элементами которого являются цифры числа N.
 */

public class Decomposition10 {

	public static void main(String[] args) {
		long number;

		number = getFromConsole("N");

		int[] array;

		array = parseNumber(number);

		printArray(array);
	}

	public static void printArray(int[] array) {
		System.out.print("{");

		for (int i = 0; i < array.length; i++) {

			if (i < array.length - 1) {
				System.out.print(array[i] + "; ");
			} else {
				System.out.println(array[i] + "}\n");
			}
		}
	}

	public static int[] parseNumber(long number) {
		int size;

		size = checkForDigits(number);

		int[] parser = new int[size];

		while (number > 0) {
			parser[size - 1] = (int) (number % 10);

			number /= 10;
			size--;
		}

		return parser;
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

		do {
			while (!sc.hasNextLong()) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}

			value = sc.nextLong();

			if (value <= 1) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 1);

		return value;
	}
}