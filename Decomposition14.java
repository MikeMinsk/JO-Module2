package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Натуральное число, в записи которого n цифр, называется числом Армстронга, 
 * если сумма его цифр, возведенная в степень n, равна самому числу. Найти все числа 
 * Армстронга от 1 до k. Для решения задачи использовать декомпозицию.
 */

public class Decomposition14 {

	public static void main(String[] args) {
		int k;

		k = getFromConsole("k");

		int[] armstrongNumbers;

		armstrongNumbers = findArmstrongNumbers(k);
		
		System.out.println("The Armstrong`s numbers:");

		printArray(armstrongNumbers);
	}

	public static int[] findArmstrongNumbers(int range) {
		int[] arrayTemp = new int[range];

		int size = 0;

		for (int i = 1; i <= range; i++) {

			if (checkForArmstrongNumber(i)) {
				arrayTemp[i] = i;
				size++;
			}
		}

		int[] armstrongNumbers = new int[size];
		int index = 0;

		for (int i = 0; i < arrayTemp.length; i++) {

			if (arrayTemp[i] != 0) {
				armstrongNumbers[index] = arrayTemp[i];
				index++;
			}
		}

		return armstrongNumbers;
	}

	public static boolean checkForArmstrongNumber(int number) {
		int power;

		power = findAmountOfNumbers(number);

		int sumNumbers = 0;

		int[] parsedNumber = parseNumber(number);

		for (int i = 0; i < parsedNumber.length; i++) {
			sumNumbers += Math.pow(parsedNumber[i], power);
		}

		return sumNumbers == number;
	}

	public static int findAmountOfNumbers(int number) {
		int amount = 0;

		while (number > 0) {
			amount++;

			number /= 10;
		}

		return amount;
	}

	public static int[] parseNumber(int number) {
		int size;

		size = findAmountOfNumbers(number);

		int[] parsedNumber = new int[size];

		for (int i = 0; i < parsedNumber.length; i++) {
			parsedNumber[i] = number % 10;

			number /= 10;
		}

		return parsedNumber;
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

			if (value <= 2) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 2);

		return value;
	}
}