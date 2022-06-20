package by.mikem.jonline.module2.main;

/*
 *  Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9.
 */

public class Decomposition07 {

	public static void main(String[] args) {
		int number = 9;

		System.out.println("The sum of odd factorials up to " + number + " = " + sumFactorials(number));
	}

	public static long sumFactorials(int number) {
		long sum = 0;

		while (number > 0) {

			if (number % 2 != 0) {
				int factNumber = number;
				long factorial = 1;

				while (factNumber > 0) {
					factorial *= factNumber;
					factNumber--;
				}

				sum += factorial;
			}
			number--;
		}		
		
		return sum;
	}
}