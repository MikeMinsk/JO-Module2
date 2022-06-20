package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Сформировать квадратную матрицу порядка N по правилу: 
 * и подсчитать количество положительных элементов в ней.
 */

public class ArraysOfArrays07 {

	public static void main(String[] args) {
		int sizeOfArray;

		sizeOfArray = getFromConsole("N");

		double[][] array;

		array = createArray(sizeOfArray);
		
		System.out.println("The amount of positive members in the array: " + calculatePositiveMembers(array));

		printArray(array);
	}

	public static int calculatePositiveMembers(double[][] array) {
		int countOfMembers = 0;

		for (double[] subArray : array) {
			for (double member : subArray) {
				if (member > 0) {
					countOfMembers++;
				}
			}
		}

		return countOfMembers;
	}

	public static void printArray(double[][] array) {

		if (array.length > 69) {
			System.out.print("Size of the array is too big! The program works but will not print the array.");
			return;
		}

		System.out.print("The array:\n{");

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

	public static double[][] createArray(int sizeOfArray) {

		if (sizeOfArray > 9999) {
			System.out.print("Size of the array is too big! The program won`t work. Please, restart the program.");
			System.exit(0);
		}

		double[][] array;

		array = new double[sizeOfArray][sizeOfArray];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.sin((i * i - j * j + 0.0) / sizeOfArray);
			}
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
