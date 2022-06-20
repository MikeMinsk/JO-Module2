package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
 */

public class Arrays01 {

	public static void main(String[] args) {
		int n;

		n = getFromConsole("N");

		int[] array = new int[n];

		fillArray(array);

		int k;

		k = getFromConsole("K");

		System.out.print("Required sum = " + sumArray(array, k));
	}

	public static void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100000 + 1);
		}
	}

	public static long sumArray(int[] array, int k) {
		long sum = 0;

		for (int i : array) {
			if (i % k == 0) {
				sum += i;
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