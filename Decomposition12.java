package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Даны натуральные числа К и N. Написать метод(методы) формирования массива А, 
 * элементами которого являются числа, сумма цифр которых равна К и которые не большее N.
 */

public class Decomposition12 { // принимаю, что числа в массиве не должны повторяться

	public static void main(String[] args) {
		int k;

		k = getFromConsole("K");

		int n;

		n = getFromConsole("N"); // числа, больше миллиона лучше не ставить - может завершаться без результата

		int[] array;

		array = makeArray(k, n);

		printArray(array);
	}

	public static int[] makeArray(int k, int n) {
		int size = 0;
		int nTemp = n;

		while (nTemp > 0) { // вычисляем размер массива
			
			if (sumParsedNumbers(nTemp) == k) {
				size++;
			}
			
			nTemp--;
		}

		if (size == 0) {
			System.out.print("Can`t create an array with such values of N and K. Please, restart the program.");
			System.exit(0);
		}

		int[] array = new int[size];

		while (n > 0) {
			
			if (sumParsedNumbers(n) == k) {
				array[size - 1] = n;

				size--;
			}
			
			n--;
		}
		return array;
	}

	public static int sumParsedNumbers(int number) {
		int sum = 0;

		while (number > 0) {
			sum += number % 10;

			number /= 10;
		}

		return sum;
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

			if (value <= 0) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 0);

		return value;
	}
}