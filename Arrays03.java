package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных, 
 * положительных и нулевых элементов.
 */

public class Arrays03 {

	public static void main(String[] args) {
		int arrayLength;

		arrayLength = getFromConsole("N");

		double[] array;

		array = createArray(arrayLength);

		int negative = 0;
		int positive = 0;
		int zero = 0;

		for (double a : array) {
			if (a == 0) { // Nath.random() не генерирует почему-то 0, либо с генерирует с какой-то
							// точностью
				zero++;
			} else if (a < 0) {
				negative++;
			} else if (a > 0) {
				positive++;
			}
		}	

		System.out.println("Amount of negative numbers: " + negative);
		System.out.println("Amount of positive numbers: " + positive);
		System.out.println("Amount of zeroes: " + zero);
	}

	public static double[] createArray(int arrayLength) {
		double[] array;

		array = new double[arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() - 0.5;
		}

		return array;
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
