package by.mikem.jonline.module2.main;

/*
 * Даны две последовательности a1  a2  an и b1  b2  bm. 
 * Образовать из них новую последовательность чисел так, чтобы она тоже была неубывающей. 
 * Примечание. Дополнительный массив не использовать.
 */

public class Sortings02 {

	public static void main(String[] args) {
		int[] firstArray;

		firstArray = createSequence("first");

		int[] secondArray;

		secondArray = createSequence("second");

		int[] mergedArray;

		mergedArray = mergeArrays(firstArray, secondArray);

		System.out.println("The result of merging of the sequences:");

		printArray(mergedArray);
	}

	public static int[] mergeArrays(int[] firstArray, int[] secondArray) {

		int tempMember = 0;

		if (firstArray.length <= secondArray.length) {

			for (int i = 0; i < firstArray.length; i++) {

				for (int j = 0; j < secondArray.length; j++) {

					if (firstArray[i] > secondArray[j]) {
						tempMember = firstArray[i];
						firstArray[i] = secondArray[j];
						secondArray[j] = tempMember;

					}
				}
			}

			return firstArray;

		} else {

			for (int i = 0; i < secondArray.length; i++) {

				for (int j = 0; j < firstArray.length; j++) {

					if (firstArray[j] < secondArray[i]) {
						tempMember = secondArray[i];
						secondArray[i] = firstArray[j];
						firstArray[j] = tempMember;
					}
				}
			}

			return secondArray;
		}
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

	public static int[] createSequence(String variable) {
		int size;

		size = (int) (Math.random() * 50 + 1);

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

		System.out.println("Size of the " + variable + " sequence = " + array.length);

		printArray(array);

		return array;
	}
}
