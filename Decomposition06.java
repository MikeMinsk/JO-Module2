package by.mikem.jonline.module2.main;

/*
 * Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
 */

public class Decomposition06 {

	public static void main(String[] args) {
		int[] numbers;

		numbers = generateNumbers();

		System.out.print("The three numbers are prime to each other: " + checkForPrime(numbers));
	}

	public static boolean checkForPrime(int[] numbers) {
		for (int member : numbers) {

			if (member == 0) {
				System.out.print("One of the numbers is zero. Please, remove it and restart the program.");
				System.exit(0);
			}
		}

		int cDivisor = Math.abs(numbers[0]);

		while (cDivisor > 0) {

			if (numbers[0] % cDivisor == 0 & numbers[1] % cDivisor == 0 & numbers[2] % cDivisor == 0) {
				return cDivisor == 1;
			}

			cDivisor--;
		}

		return false;
	}

	public static void printNumbers(int[] numbers) {
		System.out.print("{");

		for (int i = 0; i < numbers.length; i++) {

			if (i < numbers.length - 1) {
				System.out.print(numbers[i] + "; ");
			} else {
				System.out.println(numbers[i] + "}\n");
			}
		}
	}

	public static int[] generateNumbers() {
		int[] numbers;

		numbers = new int[3];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100 - 50);
		}

		printNumbers(numbers);

		return numbers;
	}
}