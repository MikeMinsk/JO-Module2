package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы.
 */

public class ArraysOfArrays03 {

	public static void main(String[] args) {
		int[][] array;

		array = createArray();

		int line;

		line = getFromConsole("line k", array.length, array[0].length);

		int column;

		column = getFromConsole("column p", array.length, array[0].length);

		printLineAndColumn(array, line, column);
	}

	public static void printLineAndColumn(int[][] array, int line, int column) {
		System.out.print("   Line k: {");

		for (int i = 0; i < array[line - 1].length; i++) {

			if (i != array[line - 1].length - 1) {
				System.out.print(array[line - 1][i] + "; ");
			} else {
				System.out.print(array[line - 1][i]);
			}
		}

		System.out.print("}\n   Column p: {");

		for (int j = 0; j < array.length; j++) {

			if (j != array.length - 1) {
				System.out.print(array[j][column - 1] + "; ");
			} else {
				System.out.print(array[j][column - 1]);
			}
		}

		System.out.print("}");
	}

	public static int[][] createArray() {
		int numberOfColumns;

		numberOfColumns = (int) (Math.random() * 50 + 1);

		int numberOfLines;

		numberOfLines = (int) (Math.random() * 50 + 1);

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

	public static int getFromConsole(String variable, int numberOfLines, int numberOfColumns) {
		int maxValue = 0;

		if (variable.equals("line k")) {
			maxValue = numberOfLines;
		} else if (variable.equals("column p")) {
			maxValue = numberOfColumns;
		}

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

			if (value < 0 | value > maxValue) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value < 0 | value > maxValue);

		return value;
	}
}
