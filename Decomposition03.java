package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Вычислить площадь правильного шестиугольника со стороной а, используя метод
 * вычисления площади треугольника.
 */

public class Decomposition03 {

	public static void main(String[] args) {
		double a;

		a = getFromConsole("a");

		double square;

		square = calculateSquare(a);

		System.out.print("The square of the hexagon = " + square);
	}

	public static double calculateSquare(double side) {
		return 6 * side * side * Math.sqrt(3) / 4;
	}

	public static double getFromConsole(String variable) {
		double value;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a value for " + variable + " >> ");

		do {
			while (!sc.hasNextDouble()) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}

			value = sc.nextDouble();

			if (value <= 0) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 0);

		return value;
	}
}