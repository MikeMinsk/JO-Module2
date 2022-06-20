package by.mikem.jonline.module2.main;

import java.util.Scanner;

public class ArraysOfArrays08 {

	public static void main(String[] args) {
		int[][] array;

		array = createArray();

		System.out.println("The array before exchange of columns:");

		printArray(array);

		int columnA;

		columnA = getFromConsole("A", array[0].length);

		int columnB;

		columnB = getFromConsole("B", array[0].length);

		exchangeColumns(array, columnA, columnB);

		System.out.println("The array after exchange of columns:");

		printArray(array);
	}

	public static void printArray(int[][] array) {
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

		System.out.println("}");
	}

	public static void exchangeColumns(int[][] array, int columnA, int columnB) {

		if (columnA == columnB) {
			System.out.println("The numbers of columns are the same.");
		}

		int tempValue;

		for (int i = 0; i < array.length; i++) {
			tempValue = array[i][columnA - 1];
			array[i][columnA - 1] = array[i][columnB - 1];
			array[i][columnB - 1] = tempValue;
		}
	}

	public static int[][] createArray() {
		int numberOfColumns;

		numberOfColumns = (int) (Math.random() * 20 + 1);

		int numberOfLines;

		numberOfLines = (int) (Math.random() * 20 + 1);

		int[][] array;

		array = new int[numberOfLines][numberOfColumns];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 1000 - 500);
			}
		}
		System.out.println("The size of the array: " + numberOfLines + " lines, " + numberOfColumns + " columns.");

		return array;
	}

	public static int getFromConsole(String variable, int arrayLength) {
		int value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a number for column " + variable + " >> ");

		do {
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Enter a number for column " + variable + " >> ");
			}

			value = sc.nextInt();

			if (value <= 0 | value > arrayLength) {
				sc.nextLine();
				System.out.print("Enter a number for column " + variable + " >> ");
			}
		} while (value <= 0 | value > arrayLength);

		return value;
	}
}
