package by.mikem.jonline.module2.main;

/*
 * Сортировка вставками. Дана последовательность чиселn a ,a , ,a 1 2 . 
 * Требуется переставить числа в порядке возрастания. Делается это следующим образом. 
 * Пусть a a ai, , , 1 2  - упорядоченная последовательность, т. е. 
 * a1  a2  an. Берется следующее число i+1 a и вставляется в последовательность так, 
 * чтобы новая последовательность была тоже возрастающей. Процесс производится до тех пор, 
 * пока все элементы от i +1 до n не будут перебраны. Примечание. Место помещения 
 * очередного элемента в отсортированную часть производить с помощью двоичного поиска. 
 * Двоичный поиск оформить в виде отдельной функции.
 */

public class Sortings05 {
	public static int operationCount = 0; // счетчик замен и сравнений членов массива

	public static void main(String[] args) {
		int[] array;

		array = createArray();

		sortArray(array);

		System.out.println("The sequence after sorting: ");

		printArray(array);

		System.out.println("Number of operations with the sequence = " + operationCount);
	}

	public static void sortArray(int[] array) {
		int indexToInsert;

		for (int i = 1; i < array.length; i++) {
			indexToInsert = binarySearch(array, i, array[i]);
			insertMember(array, indexToInsert, i);
		}
	}

	public static void insertMember(int[] array, int insertIndex, int lastIndex) {
		int tempMember;

		for (int i = 0; i < lastIndex - insertIndex; i++) {
			tempMember = array[insertIndex + i];
			array[insertIndex + i] = array[lastIndex];
			array[lastIndex] = tempMember;

			operationCount++;
		}
	}

	public static int binarySearch(int[] array, int lastIndex, int memberToSearch) {
		int firstIndex = 0;
		int middleIndex;

		while (firstIndex <= lastIndex) { 
			if ((firstIndex + lastIndex) % 2 == 0) {
				middleIndex = (firstIndex + lastIndex) / 2;
			} else {
				middleIndex = (firstIndex + lastIndex + 1) / 2;
			}

			if (middleIndex == 0) {
				return 0;
			}

			if (array[middleIndex - 1] <= memberToSearch & array[middleIndex] >= memberToSearch) {
				operationCount++;
				return middleIndex;
			} else if (array[middleIndex - 1] > memberToSearch) {
				lastIndex = middleIndex - 1;
				operationCount++;
			} else if (array[middleIndex] < memberToSearch) {
				firstIndex = middleIndex;
				operationCount++;
			}
		}

		return -1;
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