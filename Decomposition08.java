package by.mikem.jonline.module2.main;

/*
 * Задан массив D. Определить следующие суммы: 
 * D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].Пояснение. Составить метод(методы) 
 * для вычисления суммы трех последовательно расположенных элементов массива с номерами от k до m.
 */

public class Decomposition08 {

	public static void main(String[] args) {
		int[] array;

		array = createArray();

		System.out.println("The sum of D[l] + D[2] + D[3] = " + sumNumbers(array, 0));
		System.out.println("The sum of D[3] + D[4] + D[5] = " + sumNumbers(array, 2));
		System.out.println("The sum of D[4] + D[5] + D[6] = " + sumNumbers(array, 3));
	}

	public static int sumNumbers(int[] array, int startIndex) {
		int sum = 0;

		for (int i = startIndex; i < startIndex + 3; i++) {
			sum += array[i];
		}

		return sum;
	}

	public static void printArray(int[] array) {
		System.out.print("{");

		for (int i = 0; i < array.length; i++) {

			if (i < array.length - 1) {
				System.out.print(array[i] + "; ");
			} else {
				System.out.println(array[i] + "}\n");
			}
		}
	}

	public static int[] createArray() {
		int size;

		size = (int) (Math.random() * 500 + 7);

		int[] array;

		array = new int[size];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 500 - 250);
		}

		printArray(array);

		return array;
	}
}