package by.mikem.jonline.module2.main;

import java.util.Scanner;

/*
 *  На плоскости заданы своими координатами n точек. Написать метод(методы), 
 *  определяющие, между какими из пар точек самое большое расстояние. Указание. 
 *  Координаты точек занести в массив.
 */

public class Decomposition04 {

	public static void main(String[] args) {
		int n;

		n = getFromConsole("n");

		Point[] array;

		array = createPoints(n);

		Point[] foundPoints;

		foundPoints = findMaxDistance(array);

		System.out.println("The maximum distance between points = " + findDistance(foundPoints[0], foundPoints[1]));
		System.out.println("The first point = [" + foundPoints[0].x + "; " + foundPoints[0].y + "]");
		System.out.println("The second point = [" + foundPoints[1].x + "; " + foundPoints[1].y + "]");
	}

	public static Point[] findMaxDistance(Point[] array) {
		double distance = 0;
		int firstPointIndex = -1;
		int secondPointIndex = -1;

		for (int i = 0; i < array.length; i++) {

			for (int j = i; j < array.length; j++) {

				if (findDistance(array[i], array[j]) > distance) {
					distance = findDistance(array[i], array[j]);
					firstPointIndex = i;
					secondPointIndex = j;
				}
			}
		}
		
		Point[] foundPoints = { array[firstPointIndex], array[secondPointIndex] };

		return foundPoints;
	}

	public static double findDistance(Point firstPoint, Point secondPoint) {
		return Math.sqrt(Math.pow(firstPoint.x - secondPoint.x, 2) + Math.pow(firstPoint.y - secondPoint.y, 2));
	}

	public static Point[] createPoints(int size) {
		Point[] array = new Point[size];

		for (int i = 0; i < array.length; i++) {
			double x;

			x = Math.random() * 500 - 250;

			double y;

			y = Math.random() * 500 - 250;

			array[i] = new Point(x, y);
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

			if (value <= 1) {
				sc.nextLine();
				System.out.print("Enter a value for " + variable + " >> ");
			}
		} while (value <= 1);

		return value;
	}
}

class Point {
	double x;
	double y;

	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
