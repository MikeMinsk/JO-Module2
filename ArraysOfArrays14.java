package by.mikem.jonline.module2.main;

import java.util.Scanner;

/* 
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число 
 * единиц равно номеру столбца.
 */

public class ArraysOfArrays14 {

	public static void main(String[] args) {
		int m;

		m = getFromConsole("m, lines");

		int n;

		n = getFromConsole("n, columns");

		int[][] array;

		array = createArray(m, n);

		printArray(array);
	}

	public static void printArray(int[][] array) {

		if (array.length > 150 | array[0].length > 150) {
			System.out.print("The array is too big to print it.");

			return;
		}

		System.out.print("The resulting array:\n{");

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
				System.out.println("}}");
			}
		}
	}

	public static int[][] createArray(int numberOfLines, int numberOfColumns) {

		/*
		 * Сначала в строки рандомно прописываем единицы, если счетчик единиц count
		 * (номер столбца) не уменьшился до нуля, то вручную добавляем единицы в
		 * столбец.
		 */

		int[][] array;

		array = new int[numberOfLines][numberOfColumns];

		for (int j = 0; j < array[0].length; j++) {
			int count;

			count = j + 1;

			if (count >= array.length) {
				count = array.length;
			}

			for (int i = 0; i < array.length; i++) {

				if (count != 0) {
					array[i][j] = (int) (Math.random() + 0.5);

					if (array[i][j] == 1) {
						count--;
					}
				}
			}
			if (count != 0) {

				for (int i = 0; i < array.length; i++) {

					if (array[i][j] != 1 && count != 0) {
						array[i][j] = 1;
						count--;
					}
				}
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