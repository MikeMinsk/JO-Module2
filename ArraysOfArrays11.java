package by.mikem.jonline.module2.main;

/*
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, 
 * в которых число 5 встречается три и более раз.
 */

public class ArraysOfArrays11 {

	public static void main(String[] args) {
		int[][] array;

		array = createArray(10, 20);

		printArray(array);

		printLines(array);
	}

	public static void printLines(int[][] array) {
		System.out.println("Numbers of lines with three or more numbers 5 in it: ");

		int countOfFives;
		int countOfLines = 0;

		for (int i = 0; i < array.length; i++) {
			countOfFives = 0;

			for (int j = 0; j < array[i].length; j++) {

				if (array[i][j] == 5) {
					countOfFives++;
				}
			}

			if (countOfFives >= 3) {
				System.out.println((i + 1) + "; ");

				countOfLines++;
			}
		}

		if (countOfLines == 0) {
			System.out.print("there is no such lines.");
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

	public static int[][] createArray(int numberOfLines, int numberOfColumns) {
		int[][] array;

		array = new int[numberOfLines][numberOfColumns];

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 15);
			}
		}

		return array;
	}
}
