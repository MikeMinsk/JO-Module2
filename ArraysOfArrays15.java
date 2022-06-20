package by.mikem.jonline.module2.main;

/*
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.
 */

public class ArraysOfArrays15 {

	public static void main(String[] args) {
		int[][] array;

		array = createArray();

		printArray(array);

		int maxMember;

		maxMember = findMaxMember(array);

		System.out.println("\nThe max member of the array: " + maxMember);

		replaceOddMembers(array, maxMember);

		System.out.println("\nThe array after replacements:");

		printArray(array);
	}

	public static void replaceOddMembers(int[][] array, int maxMember) {
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				if (array[i][j] % 2 != 0) {
					array[i][j] = maxMember;
				}
			}
		}
	}

	public static int findMaxMember(int[][] array) {
		int maxMember = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				if (array[i][j] > maxMember) {
					maxMember = array[i][j];
				}
			}
		}

		return maxMember;
	}

	public static void printArray(int[][] array) {

		if (array.length > 150 | array[0].length > 150) {
			System.out.print("The array is too big to print it.");

			return;
		}

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

		numberOfColumns = (int) (Math.random() * 50 + 1);

		int numberOfLines;

		numberOfLines = (int) (Math.random() * 50 + 1);

		int[][] array;

		array = new int[numberOfLines][numberOfColumns];

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = (int) (Math.random() * 100);
			}
		}
		System.out.println("The size of the array: " + numberOfLines + " lines, " + numberOfColumns + " columns.");

		return array;
	}
}
