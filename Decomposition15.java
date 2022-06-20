package by.mikem.jonline.module2.main;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую 
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */

public class Decomposition15 {
	static int NUMBER;

	public static void main(String[] args) {
		NUMBER = getFromConsole("n");

		ArrayList<Integer> array;

		array = findNumbers();

		for (Integer i : array) {
			System.out.println(i);
		}
	}

	public static ArrayList<Integer> findNumbers() {
		ArrayList<Integer> array = new ArrayList<Integer>();

		int startNumber = (int) (1.11111111 * Math.pow(10, NUMBER - 1));
		int finishNumber = startNumber * 9;

		for (int number = startNumber; number <= finishNumber; number++) {

			if (isDigitsAscends(number)) {
				array.add(number);
			}
		}

		return array;
	}

	public static boolean isDigitsAscends(int number) {
		int previousDigit = number;

		while (number > 0) {
			int currentDigit = number % 10;

			if (previousDigit <= currentDigit) {
				return false;
			}

			previousDigit = currentDigit;
			number /= 10;
		}

		return true;
	}

	public static int getFromConsole(String variable) {
		int value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a value for " + variable + " out of range [1, 9] >> ");

		do {
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}

			value = sc.nextInt();

			if (value < 1 | value > 10) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value < 1 | value > 10);

		return value;
	}
}