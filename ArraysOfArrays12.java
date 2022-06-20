package by.mikem.jonline.module2.main;

/*
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

public class ArraysOfArrays12 {

	public static void main(String[] args) {
		int[][] array;

		array = createArray();

		printArray(array);

		System.out.println("\nThe array after ascending sort:");

		sortLinesAscend(array);

		printArray(array);

		System.out.println("\nThe array after descending sort:");

		sortLinesDescend(array);

		printArray(array);
	}

	public static void sortLinesDescend(int[][] array) {
		int tempMember;

		for (int i = 0; i < array.length; i++) {

			for (int out = (array[i].length - 1); out > 0; out--) {

				for (int in = 0; in < out; in++) {

					if (array[i][in] < array[i][in + 1]) {
						tempMember = array[i][in + 1];
						array[i][in + 1] = array[i][in];
						array[i][in] = tempMember;
					}
				}
			}
		}
	}

	public static void sortLinesAscend(int[][] array) {
		int tempMember;

		for (int i = 0; i < array.length; i++) {

			for (int out = (array[i].length - 1); out > 0; out--) {

				for (int in = 0; in < out; in++) {

					if (array[i][in] > array[i][in + 1]) {
						tempMember = array[i][in + 1];
						array[i][in + 1] = array[i][in];
						array[i][in] = tempMember;
					}
				}
			}
		}
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
				System.out.println("}}");
			}
		}
	}

	public static int[][] createArray() {
		int numberOfColumns;

		numberOfColumns = (int) (Math.random() * 10 + 1);

		int numberOfLines;

		numberOfLines = (int) (Math.random() * 10 + 1);

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
}
