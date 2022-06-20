package by.mikem.jonline.module2.main;

/* 
 * Сортировка выбором. Дана последовательность чисел a1  a2  an.
 * Требуется переставить элементы так, чтобы они были расположены по убыванию. 
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и 
 * ставится на первое место, а первый - на место наибольшего. 
 * Затем, начиная со второго, эта процедура повторяется. 
 * Написать алгоритм сортировки выбором.
 */

public class Sortings03 {

	public static void main(String[] args) {
		int[] array;

		array = createSequence();

		sortArray(array);

		System.out.println("The sequence after sorting: ");

		printArray(array);
	}

	public static void sortArray(int[] array) {
		int tempMember = 0;
		int exchangeCount = 0;
		int operationCount = 0;

		for (int i = 0; i < array.length; i++) {
			int tempNumber = -1;

			for (int j = i; j < array.length; j++) {
				operationCount++;

				if (array[j] > array[i]) {
					tempNumber = j;
				}
			}

			if (tempNumber != -1) {
				tempMember = array[i];
				array[i] = array[tempNumber];
				array[tempNumber] = tempMember;

				exchangeCount++;
			}
		}

		System.out.println("Number of exchanges in the sequence = " + exchangeCount);
		System.out.println("Number of compares in the sequence = " + operationCount);
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

	public static int[] createSequence() {
		int size;

		// size = (int) (Math.random() * 100 + 1);

		size = 100;

		int[] array;

		array = new int[size];

		int startValue;

		startValue = (int) (Math.random() * 100 - 50);

		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = startValue + (int) (Math.random() * 10);
			} else {
				array[i] = array[i - 1] + ((int) (Math.random() * 10));
			}
		}

		System.out.println("Size of the sequence = " + array.length);

		printArray(array);

		return array;
	}
}