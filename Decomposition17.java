package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. 
 * Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи 
 * использовать декомпозицию
 */

public class Decomposition17 {

	public static void main(String[] args) {
		int number;
		
		number = getFromConsole("a number");
		
		int operationsCount;
		
		operationsCount = subtractNumber(number);
		
		System.out.print("Number of operations = " + operationsCount);
	}
	
	public static int subtractNumber(int number) {
		int operationsCount = 0;
		
		while (number != 0) {
			number -= sumParsedDigits(number);
			
			operationsCount++;
		}
		
		return operationsCount;
	}
	
	public static int sumParsedDigits(int number) {
		int sum = 0;
		
		while (number > 0) {
			sum += number % 10;

			number /= 10;
		}

		return sum;
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

			if (value < 1) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value < 1);

		return value;
	}
}