package by.mikem.jonline.module2.main;

/*
 * Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив 
 * из него каждый второй элемент (освободившиеся элементы заполнить нулями). 
 * Примечание. Дополнительный массив не использовать.
 */

import java.util.Scanner;

public class Arrays10 {

	public static void main(String[] args) {
		int arrayLength;

		arrayLength = getFromConsole("n");

		int[] array;

		array = createArray(arrayLength);

		int countOfReplacements;

		countOfReplacements = squeezeArray(array);

		System.out.print("The job is done. The count of replacements in the array: " + countOfReplacements);
	}

	public static int squeezeArray(int[] array) {
		int countOfReplacements = 0;
		for (int i = 0; i < array.length; i++) {
			if (((i + 1) % 2) == 0 && i != 0) {
				array[i] = 0;
				countOfReplacements++;
			}
		}
		return countOfReplacements;
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
