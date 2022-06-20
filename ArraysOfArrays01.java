package by.mikem.jonline.module2.main;

/*
 * Дана матрица. Вывести на экран все нечетные столбцы, 
 * у которых первый элемент больше последнего.
 */

public class ArraysOfArrays01 {

	public static void main(String[] args) {
		printColumns(createArray());
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

		return array;
	}

	public static void printColumns(int[][] array) {

		System.out.println("Desired columns of the array: ");

		for (int j = 0; j < array[0].length; j++) {

			if ((array[0][j] > array[array.length - 1][j]) && ((j - 1) % 2 == 0)) {

				System.out.print("the column № " + j + " {");

				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i][j] + "; ");
				}

				System.out.println("}");
			}
		}
	}
}
