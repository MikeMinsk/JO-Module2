package by.mikem.jonline.module2.main;

/*
 * Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию. 
 * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1. 
 * Если ai  ai+1, то продвигаются на один элемент вперед. Если ai  ai+1, 
 * то производится перестановка и сдвигаются на один элемент назад. 
 * Составить алгоритм этой сортировки.
 */

//в условии описана не сортировка Шелла, а сортировка обменами

public class Sortings06 {
	public static int operationCount = 0; // счетчик замен и сравнений членов массива

	public static void main(String[] args) {
		double[] array;

		array = createArray();

		sortArray(array);

		System.out.println("The sequence after sorting: ");

		printArray(array);

		System.out.println("Number of operations with the sequence = " + operationCount);
	}

	public static void sortArray(double[] array) {
		int[] increments;

		increments = calculateIncrement(array.length);

		for (int i = increments.length - 1; i >= 0; i--) {
			int count;

			count = (int) (array.length / increments[i]);

			for (int j = 1; j <= count; j++) {
				double value;

				value = array[j * increments[i] - 1];

				int k;

				k = j - 1;

				for (; k > 0; k--) {
					operationCount++;

					if (value < array[k * increments[i] - 1]) {
						array[(k + 1) * increments[i] - 1] = array[k * increments[i] - 1];
					} else {
						break;
					}

				}
				array[(k + 1) * increments[i] - 1] = value;
			}
		}
	}

	public static int[] calculateIncrement(int arrayLength) { // вычисляем смещения по Седжвику
		int[] incrementsTemp = new int[arrayLength];
		int incrementsCount = 0;

		for (int i = 0; i < arrayLength; i++) {
			operationCount++;

			if (i % 2 == 0) {
				incrementsTemp[i] = 9 * pow(2, i) - 9 * pow(2, (i / 2)) + 1;
				incrementsCount++;
			} else {
				incrementsTemp[i] = 8 * pow(2, i) - 6 * pow(2, ((i + 1) / 2)) + 1;
				incrementsCount++;
			}

			if (3 * incrementsTemp[i] > arrayLength) {
				incrementsCount--;

				break;
			}
		}

		int[] increments = new int[incrementsCount];

		for (int i = 0; i < increments.length; i++) {
			increments[i] = incrementsTemp[i];
			operationCount++;
		}

		return increments;
	}

	public static int pow(int value, int powValue) {
		return (int) Math.pow(value, powValue);
	}

	public static void printArray(double[] array) {
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

		// size = (int) (Math.random() * 100 + 1);

		size = 100;

		double[] array;

		array = new double[size];

		for (int i = 0; i < array.length; i++) {

			array[i] = Math.random() * 100 - 50;
		}

		/*
		 * int startValue;
		 * 
		 * startValue = (int) (Math.random() * 100);
		 * 
		 * for (int i = 0; i < array.length; i++) { if (i == 0) { array[i] = startValue
		 * + (int) (Math.random() * 10); } else { array[i] = array[i - 1] - ((int)
		 * (Math.random() * 10)); } }
		 */

		System.out.println("Size of the sequence = " + array.length);

		printArray(array);

		return array;
	}
}
