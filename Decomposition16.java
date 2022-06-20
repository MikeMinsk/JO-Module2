package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи 
 * использовать декомпозицию.
*/

public class Decomposition16 {
	static int NUMBER;

	public static void main(String[] args) {
		NUMBER = getFromConsole("n");

		long sum;

		sum = sumOddNumbers();

		System.out.println("The sum of the numbers with the odd digits = " + sum);

		int evenCount;

		evenCount = findEvenDigits(sum);

		System.out.println("The count of the even numbers in the sum = " + evenCount);
	}

	public static int findEvenDigits(long number) {
		int evenCount = 0;

		while (number > 0) {
			long digit = number % 10;

			if (digit % 2 == 0) { // ноль тоже четное число
				evenCount++;
			}

			number /= 10;
		}

		return evenCount;
	}

	public static long sumOddNumbers() {
		int startNumber = (int) (1.111111111 * Math.pow(10, NUMBER - 1));
		int finishNumber = startNumber * 9;
		long sum = 0;

		for (int number = startNumber; number <= finishNumber; number++) {

			if (isOddNumber(number)) {
				sum += number;
			}
		}

		return sum;
	}

	public static boolean isOddNumber(int number) {

		while (number > 0) {
			int digit = number % 10;

			if (digit == 0 | digit % 2 == 0) {
				return false;
			}

			number /= 10;
		}

		return true;
	}

	public static int getFromConsole(String variable) {
		int value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a value for " + variable + " out of range [1, 10] >> ");

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