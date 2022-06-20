package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Два простых числа называются «близнецами», если они отличаются друг от друга на 2 
 * (например, 41 и 43). Найти и напечатать все пары «близнецов» из отрезка [n,2n],
 * где n - заданное натуральное число больше 2. Для решения задачи использовать декомпозицию.
 */

public class Decomposition13 {

	public static void main(String[] args) {
		int n;

		n = getFromConsole("n");

		Gemini[] gemini;

		gemini = findGemini(n);

		System.out.println("Geminies:");

		printGemini(gemini);
	}

	public static void printGemini(Gemini[] gemini) {
		for (int i = 0; i < gemini.length; i++) {
			System.out.println("[" + gemini[i].first + ", " + gemini[i].second + "]");
		}
	}

	public static Gemini[] findGemini(int n) {
		int size = 0;

		for (int i = n; i <= 2 * n - 2; i++) {

			if (checkForGemini(i, i + 2)) {
				size++;
			}
		}

		if (size == 0) {
			System.out.print("There are no gemenies in the range [n,2n]. Please, restart the program.");
			System.exit(0);
		}

		Gemini[] gemini = new Gemini[size];

		int index = 0;

		for (int i = n; i <= 2 * n - 2; i++) {

			if (checkForGemini(i, i + 2)) {
				gemini[index] = new Gemini(i, i + 2);
				index++;
			}
		}

		return gemini;
	}

	public static boolean checkForGemini(int first, int second) {
		if (first + 2 != second) {
			return false;
		} else if (!checkForPrime(first) | !checkForPrime(second)) {
			return false;
		}

		return true;
	}

	public static boolean checkForPrime(int number) {
		int divider = number - 1;

		while (divider > 0) {

			if (number % divider == 0) {
				break;
			}

			divider--;
		}

		return divider == 1;
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

class Gemini {
	int first;
	int second;

	Gemini(int first, int second) {
		this.first = first;
		this.second = second;
	}
}