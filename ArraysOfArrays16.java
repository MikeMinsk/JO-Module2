package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная 
 * из чисел 1, 2, 3, ..., 2n так, что суммы по каждому столбцу, каждой строке и каждой из 
 * двух больших диагоналей равны между собой. Построить такой квадрат. Пример магического 
 * квадрата порядка 3:
 */

public class ArraysOfArrays16 {

	public static void main(String[] args) {
		int size;

		size = getFromConsole("n");

		int[][] array;

		array = createOddSquare(size);

		System.out.println("The magic sum = " + findMagicSum(array));

		printArray(array);
	}

	public static void printArray(int[][] array) {

		if (array.length > 150 | array[0].length > 150) {
			System.out.print("The array is too big to print it.");

			return;
		}

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array[i].length; j++) {

				if (array[i][j] < 10) {
					System.out.print("    " + array[i][j] + " ");
				} else if (array[i][j] >= 10 & array[i][j] < 100) {
					System.out.print("   " + array[i][j] + " ");
				} else if (array[i][j] >= 100 & array[i][j] < 1000) {
					System.out.print("  " + array[i][j] + " ");
				} else if (array[i][j] >= 1000 & array[i][j] < 10000) {
					System.out.print(" " + array[i][j] + " ");
				} else {
					System.out.print(array[i][j] + " ");
				}
			}
			
			System.out.println("");
		}
	}

	public static int findMagicSum(int[][] array) {
		int magicSum;

		int size = array.length;

		magicSum = (size * size * size + size) / 2;

		return magicSum;
	}
	/*
	public static int[][] createEvebSquare(int size) {
		int[][] arrayStraight;
		
		
	}
	*/

	public static int[][] createOddSquare(int size) {
		int[][] array;

		array = new int[size][size];

		int i = 0;
		int j = (size - 1) / 2;

		for (int count = 1; count <= size * size; count++) {
			int iTemp = i + 1;
			int jTemp = j - 1;

			if (i < 0) {
				i = size - 1;
			}

			if (j > size - 1) {
				j = 0;
			}

			if (array[i][j] != 0) {
				i = iTemp;
				j = jTemp;
				i++;
			}

			array[i][j] = count;
			i--;
			j++;
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

			if (value <= 2) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 2);

		return value;
	}
}
