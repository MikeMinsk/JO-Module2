package by.mikem.jonline.module2.main;

/*
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class ArraysOfArrays10 {

	public static void main(String[] args) {
		double[][] array;

		array = createArray();

		double[] arrayOfPositiveMembers;

		arrayOfPositiveMembers = findPositiveDiagonalMembers(array);

		printPositiveMembers(arrayOfPositiveMembers);
	}

	public static void printPositiveMembers(double[] array) {
		System.out.print("Positive members of main diagonal in the array:\n{");

		for (int i = 0; i < array.length; i++) {

			if (i != array.length - 1) {
				System.out.print(array[i] + "; ");
			} else {
				System.out.println(array[i] + "}");
			}
		}

		System.out.print("Total amount of the positive members: " + array.length);
	}

	public static double[] findPositiveDiagonalMembers(double[][] array) {
		double[] diagonalMembersTemp;

		diagonalMembersTemp = new double[array.length];

		int membersCount = 0;
		int notPositiveMemberCount = 0;

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[0].length; j++) {

				if (i == j && array[i][j] > 0) {
					diagonalMembersTemp[i - notPositiveMemberCount] = array[i][j];
					membersCount++;
				} else if (i == j && array[i][j] < 0) {
					notPositiveMemberCount++;
				}
			}
		}

		double[] diagonalMembers;

		diagonalMembers = new double[membersCount];

		for (int i = 0; i < diagonalMembers.length; i++) {

			if (diagonalMembersTemp[i] != 0) {
				diagonalMembers[i] = diagonalMembersTemp[i];
			}
		}

		return diagonalMembers;
	}

	public static double[][] createArray() {
		int arrayLength;

		arrayLength = (int) (Math.random() * 50 + 2);

		double[][] array;

		array = new double[arrayLength][arrayLength];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Math.random() - 0.5;
			}
		}

		System.out.println("The size of the array: " + arrayLength + " lines and columns.");

		return array;
	}
}
