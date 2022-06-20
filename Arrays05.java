package by.mikem.jonline.module2.main;

/*
 *  Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.
 */

public class Arrays05 {

	public static void main(String[] args) {
		int[] array;

		array = createArray();

		printMember(array);
	}

	public static int[] createArray() {
		int arrayLength;

		arrayLength = (int) (Math.random() * 1000);

		int[] array;

		array = new int[arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() - 0.5) * 1000);
		}

		return array;
	}

	public static void printMember(int[] array) {
		System.out.println("Total number of members: " + array.length);
		System.out.print("Required members: ");

		for (int i = 0; i < array.length; i++) {
			if (array[i] > i) {
				System.out.println("№ " + i + " = " + array[i]);
			}
		}
	}
}
