package by.mikem.jonline.module2.main;

/*
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. 
 * Определить, какой столбец содержит максимальную сумму.
 */

public class ArraysOfArrays09 {

	public static void main(String[] args) {
		double[][] array;

		array = createArray();

		double[] arrayOfSums;

		arrayOfSums = calculateSums(array);

		printResults(arrayOfSums);
	}

	public static void printResults(double[] array) {
		System.out.println("Required sums:");

		for (int i = 0; i < array.length; i++) {
			System.out.println("Column [" + (i + 1) + "]: " + array[i]);
		}

		double maxSum = 0;

		for (int i = 0; i < array.length; i++) {
			if (maxSum < array[i]) {
				maxSum = array[i];
			}
		}

		System.out.println("The maximal sum of members in columns: " + maxSum);
	}

	public static double[] calculateSums(double[][] array) {
		double[] arrayOfSums;

		arrayOfSums = new double[array[0].length];

		for (int j = 0; j < array[0].length; j++) {
			double sum = 0;

			for (int i = 0; i < array.length; i++) {
				sum += array[i][j];
			}
			arrayOfSums[j] = sum;
		}

		return arrayOfSums;
	}

	public static double[][] createArray() {
		int numberOfColumns;

		numberOfColumns = (int) (Math.random() * 50 + 1);

		int numberOfLines;

		numberOfLines = (int) (Math.random() * 50 + 1);

		double[][] array;

		array = new double[numberOfLines][numberOfColumns];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.random();
			}
		}
		System.out.println("The size of the array: " + numberOfLines + " lines, " + numberOfColumns + " columns.");

		return array;
	}
}
