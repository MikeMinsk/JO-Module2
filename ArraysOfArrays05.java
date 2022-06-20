package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

public class ArraysOfArrays05 {

	public static void main(String[] args) {
		int sizeOfArray;

		sizeOfArray = getFromConsole("n");

		int[][] array;

		array = createArray(sizeOfArray);

		printArray(array);
	}

	public static void printArray(int[][] array) {

		if (array.length > 101) {
			System.out.print("Size of the array is too big! The program works but will not print the array.");
			return;
		}

		System.out.print("{");

		for (int i = 0; i < array.length; i++) {
			System.out.print("{");

			for (int j = 0; j < array[i].length; j++) {

				if (j != array[i].length - 1) {
					System.out.print(array[i][j] + "; ");
				} else {
					System.out.print(array[i][j]);
				}
			}

			if (i != array.length - 1) {
				System.out.println("}");
			} else {
				System.out.print("}");
			}
		}

		System.out.print("}");
	}

	public static int[][] createArray(int sizeOfArray) {

		if (sizeOfArray > 9999) {
			System.out.print("Size of the array is too big! The program won`t work. Please, restart the program.");
			System.exit(0);
		}

		int[][] array;

		array = new int[sizeOfArray][sizeOfArray];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length - i; j++) {
				array[i][j] = i + 1;
			}

		}

		return array;
	}

	public static int getFromConsole(String variable) {
		int value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter an even value for " + variable + " >> ");

		do {
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Enter an even value for " + variable + " >> ");
			}

			value = sc.nextInt();

			if (value <= 0 | value % 2 != 0) {
				sc.nextLine();
				System.out.print("Enter an even value for " + variable + " >> ");
			}
		} while (value <= 0 | value % 2 != 0);

		return value;
	}
}
