package by.mikem.jonline.module2.main;

/*
 * Пусть даны две неубывающие последовательности действительных чисел 
 * a1  a2  an и b1  b2  bm. Требуется указать те места, на которые 
 * нужно вставлять элементы последовательности b1  b2  bm в первую 
 * последовательность так, чтобы новая последовательность оставалась возрастающей.
 */

public class Sortings07 {

	public static void main(String[] args) {
		double[] firstArray;

		firstArray = createArray();

		double[] secondArray;

		secondArray = createArray();

		int[] arrayOfIndexes;

		arrayOfIndexes = findIndex(firstArray, secondArray);

		System.out.println("Indexes: ");

		printArrayInt(arrayOfIndexes);
	}

	public static int[] findIndex(double[] firstArray, double[] secondArray) {
		int[] arrayOfIndexes;

		arrayOfIndexes = new int[secondArray.length];

		for (int i = 0; i < secondArray.length; i++) {
			arrayOfIndexes[i] = binarySearch(firstArray, secondArray[i]);
		}

		return arrayOfIndexes;
	}

	public static int binarySearch(double[] array, double memberToSearch) {
		int firstIndex = 0;
		int middleIndex;
		int lastIndex;

		lastIndex = array.length - 1;

		while (firstIndex <= lastIndex) {
			if ((firstIndex + lastIndex) % 2 == 0) {
				middleIndex = (firstIndex + lastIndex) / 2;
			} else {
				middleIndex = (firstIndex + lastIndex + 1) / 2;
			}

			if (middleIndex == 0) {
				return -1;
			} else if (middleIndex == array.length - 1) {
				return +1;
			}

			if (array[middleIndex - 1] <= memberToSearch & array[middleIndex] >= memberToSearch) {
				return middleIndex;
			} else if (array[middleIndex - 1] > memberToSearch) {
				lastIndex = middleIndex - 1;
			} else if (array[middleIndex] < memberToSearch) {
				firstIndex = middleIndex;
			}
		}
		return -1;
	}

	public static void printArrayInt(int[] array) {
		System.out.print("{");

		for (int i = 0; i < array.length; i++) {

			if (i < array.length - 1) {
				System.out.print(array[i] + "; ");
			} else {
				System.out.println(array[i] + "}\n");
			}
		}
	}

	public static void printArrayDouble(double[] array) {
		System.out.print("{");

		for (int i = 0; i < array.length; i++) {

			if (i < array.length - 1) {
				System.out.print(array[i] + "; ");
			} else {
				System.out.println(array[i] + "}\n");
			}
		}
	}

	public static double[] createArray() {
		int size;

		size = (int) (Math.random() * 50 + 1);

		// size = 50;

		double[] array;

		array = new double[size];

		int startValue;

		startValue = (int) (Math.random() * 100);

		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = startValue + (int) (Math.random() * 10);
			} else {
				array[i] = array[i - 1] + ((int) (Math.random() * 10));
			}
		}

		System.out.println("Size of the sequence = " + array.length);

		printArrayDouble(array);

		return array;
	}
}