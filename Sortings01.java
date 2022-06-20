package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
 * Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами 
 * первого, при этом не используя дополнительный массив.
 */

public class Sortings01 {

	public static void main(String[] args) {
		int[] firstArray;

		firstArray = createArray("first");

		int[] secondArray;

		secondArray = createArray("second");

		int k;

		k = getFromConsole("k", firstArray.length);

		int[] mergedArray;

		mergedArray = mergeArrays(firstArray, secondArray, k);

		System.out.println("The result of merging of the arrays:");

		printArray(mergedArray);
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

	public static int[] mergeArrays(int[] firstArray, int[] secondArray, int startMember) {
		int numberOfMembers;

		if (firstArray.length - startMember < secondArray.length) {
			numberOfMembers = firstArray.length - startMember;
		} else {
			numberOfMembers = secondArray.length;
		}

		int j = 0;

		for (int i = startMember; i < startMember + numberOfMembers; i++) {
			firstArray[i] = secondArray[j];
			j++;
		}

		return firstArray;
	}

	public static int[] createArray(String variable) {
		int size;

		size = (int) (Math.random() * 50 + 1);

		int[] array;

		array = new int[size];

		for (int i = 0; i < array.length; i++) {

			array[i] = (int) (Math.random() * 100 - 50);
		}

		System.out.println("Size of the " + variable + " array = " + array.length);

		printArray(array);

		return array;
	}

	public static int getFromConsole(String variable, int arrayLength) {
		int value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a value for " + variable + " (less than the length of the first array) >> ");

		do {
			while (!sc.hasNextInt()) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}

			value = sc.nextInt();

			if (value <= 0 | value >= arrayLength) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 0 | value >= arrayLength);

		return value;
	}
}
