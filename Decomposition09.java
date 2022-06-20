package by.mikem.jonline.module2.main;

/*
 * Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) 
 * вычисления его площади, если угол между сторонами длиной X и Y— прямой.
 */

public class Decomposition09 {

	public static void main(String[] args) {
		Tetragon tetragon = new Tetragon();

		System.out.println("The tetragon`s sides: ");
		System.out.println(tetragon.x);
		System.out.println(tetragon.y);
		System.out.println(tetragon.z);
		System.out.println(tetragon.t + "\n");

		System.out.println("The area of the tetragon = " + calculateArea(tetragon));
	}

	public static double calculateArea(Tetragon tetragon) {
		double thirdSideTriangle;

		thirdSideTriangle = calculateThirdSide(tetragon.x, tetragon.y);

		double areaFirstTriangle;

		areaFirstTriangle = calculateAreaTriangle(thirdSideTriangle, tetragon.z, tetragon.t);

		double areaSecondTriangle;

		areaSecondTriangle = 0.5 * tetragon.x * tetragon.y;

		return areaFirstTriangle + areaSecondTriangle;
	}

	public static double calculateThirdSide(double a, double b) {
		return Math.sqrt(a * a + b * b);
	}

	public static double calculateAreaTriangle(double a, double b, double c) {
		double p;

		p = (a + b + c) / 2;

		double areaTriangle;

		areaTriangle = Math.sqrt(p * (p - a) * (p - a) * (p - a));

		return areaTriangle;
	}
}

class Tetragon {
	double x;
	double y;
	double z;
	double t;

	Tetragon() {
		this.x = Math.random() * 50 + 1;
		this.y = Math.random() * 50 + 1;
		this.z = x + y + Math.random() * 50;
		this.t = z - Decomposition09.calculateThirdSide(x, y) + Math.random() * 50;
	}
}