package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Дана последовательность действительных чисел а1 ,а2 ,..., аn. Заменить все ее члены, большие данного Z, этим 
 * числом. Подсчитать количество замен.
 */

public class Arrays02 {

	public static void main(String[] args) {
		double[] array;

		array = createSequence();

		double z;

		z = getFromConsole("Z");

		int count;

		count = replaceInSequence(array, z);

		System.out.println("Number of terms in sequence: " + array.length);
		System.out.print("Number of replacements in the sequence: " + count);
	}

	public static double[] createSequence() {
		double[] array;
		int arrayLength;

		arrayLength = (int) (Math.random() * 1000 + 1);

		array = new double[arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.sqrt(i * i + 1) - 100;
		}
		return array;
	}

	public static int replaceInSequence(double[] array, double z) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > z) {
				array[i] = z;
				count++;
			}
		}
		return count;
	}

	public static double getFromConsole(String variable) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a value for " + variable + " >> ");

		while (!sc.hasNextDouble()) {
			sc.nextLine();
			System.out.print("Enter a value for " + variable + " >> ");
		}
		return sc.nextDouble();
	}
}
