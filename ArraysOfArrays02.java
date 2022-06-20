package by.mikem.jonline.module2.main;

/*
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */

public class ArraysOfArrays02 {

	public static void main(String[] args) {
		printDiagonals(createArray());
	}

	public static void printDiagonals(int[][] array) {

		System.out.print("Desired diagonals of the array: \n   direct diagonal: {");

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == j) {
					System.out.print(array[i][j] + "; ");
				}
			}
		}

		System.out.print("}\n   reverse diagonal: {");

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i == (array.length - 1 - j)) {
					System.out.print(array[i][j] + "; ");
				}
			}
		}

		System.out.print("}");
	}

	public static int[][] createArray() {
		int arraySize;

		arraySize = (int) (Math.random() * 50 + 1);

		int[][] array;

		array = new int[arraySize][arraySize];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 1000 - 500);
			}
		}

		return array;
	}
}
