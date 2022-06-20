package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Составить программу, которая в массиве A[N] находит второе по величине число 
 * (вывести на печать число, которое меньше максимального элемента массива, 
 * но больше всех других элементов).
 */

public class Decomposition05 {

	public static void main(String[] args) {
		int n;

		n = getFromConsole("N");

		int[] array;

		array = createArray(n);

		System.out.print("The next max member = " + findSecondMax(array));
	}

	public static int findSecondMax(int[] array) {
		int maxMember = Integer.MIN_VALUE;
		int secondMaxMember = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {

			if (array[i] > maxMember) {
				maxMember = array[i];
			}
		}

		for (int i = 0; i < array.length; i++) {

			if (array[i] > secondMaxMember & maxMember != array[i]) {
				secondMaxMember = array[i];
			}
		}

		if (secondMaxMember == Integer.MIN_VALUE) {
			System.out.print("There is no next max member in the array.");
		}

		return secondMaxMember;
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

	public static int[] createArray(int size) {
		int[] array;

		array = new int[size];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 500 - 250);
		}

		printArray(array);

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

			if (value <= 1) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 1);

		return value;
	}
}