package by.mikem.jonline.module2.main;

/*
 * Сортировка обменами. Дана последовательность чисел a1  a2  an.
 * Требуется переставить числа в порядке возрастания. Для этого 
 * сравниваются два соседних числа i i+1 a и a. Если ai  ai+1, 
 * то делается перестановка. Так продолжается до тех пор, пока все 
 * элементы не станут расположены в порядке возрастания. Составить 
 * алгоритм сортировки, подсчитывая при этом количества перестановок.
 */

public class Sortings04 {

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

			for (int j = i; j < array.length; j++) {
				operationCount++;

				if (array[j] < array[i]) {
					tempMember = array[i];
					array[i] = array[j];
					array[j] = tempMember;

					exchangeCount++;
				}
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

		startValue = (int) (Math.random() * 100);

		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				array[i] = startValue + (int) (Math.random() * 10);
			} else {
				array[i] = array[i - 1] - ((int) (Math.random() * 10));
			}
		}

		System.out.println("Size of the sequence = " + array.length);

		printArray(array);

		return array;
	}
}