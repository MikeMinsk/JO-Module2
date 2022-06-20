package by.mikem.jonline.module2.main;

import java.util.Scanner;

/* В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких 
 * чисел несколько, то определить наименьшее из них.
 */

public class Arrays09 {

	public static void main(String[] args) {
		int arrayLength;

		arrayLength = getFromConsole("n");

		int[] array;

		array = createArray(arrayLength);

		int desiredMember;

		desiredMember = findFrequentMember(array);

		printMember(array, desiredMember);
	}

	public static void printMember(int[] array, int member) {
		if (member == Integer.MIN_VALUE) {
			System.out.print("There is no repeating members in the array");
		} else {
			int count = 0;

			for (int a : array) {
				if (a == member) {
					count++;
				}
			}

			System.out.println("The most frequent member in the array: " + member + " with " + count + " repeats");
		}
	}

	public static int findFrequentMember(int[] array) {
		int countTemp = 0;
		int countFinal = 0;
		int desiredMember = 0;
		int desiredMemberTemp = 0;

		for (int i = 0; i < array.length; i++) {

			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					countTemp++;
					desiredMemberTemp = array[j];
				}
			}

			if (countTemp > countFinal) {
				countFinal = countTemp;
				desiredMember = array[i];
			} else if (countTemp == countFinal && countTemp != 0) {
				if (desiredMember >= desiredMemberTemp) {
					desiredMember = desiredMemberTemp;
				}
			}

			countTemp = 0;
		}

		if (countFinal == 0) {
			desiredMember = Integer.MIN_VALUE;
		}

		return desiredMember;
	}

	public static int[] createArray(int arrayLength) {
		int[] array;

		array = new int[arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) ((Math.random() - 0.5) * 1000);
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

			if (value <= 0) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 0);

		return value;
	}
}
