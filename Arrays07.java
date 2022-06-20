package by.mikem.jonline.module2.main;

/*
 *  Даны действительные числа a a an. Найти max( , , , ) a1 + a2n a2 + a2n−1  an + an+1.
 *  Непонятно условие, т.к.  последовательность n, а найти макс. нужно для члена 2n.
 */

public class Arrays07 {

	public static void main(String[] args) {
		double[] array;

		array = createSequence();

		System.out.println("Maximal sum of two members: " + calculateMax(array));
		System.out.println("Total number of members of array: " + array.length);
	}

	public static double[] createSequence() {
		int arrayLength;

		arrayLength = (int) (Math.random() * 5000 + 1);

		double[] array;

		array = new double[2 * arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.sqrt(i * i + 1) - 1000;
		}
		return array;
	}

	public static double calculateMax(double[] array) {
		double min = -Double.MAX_VALUE;
		double sumOfMembers;

		for (int i = 0; i <= ((array.length / 2) - 1); i++) {

			sumOfMembers = array[i] + array[array.length - 1 - i];

			if (sumOfMembers >= 0 && sumOfMembers > min) { // в цикле учитываем случай, когда массив из отрицательных
															// чисел
				min = sumOfMembers;
			} else if (sumOfMembers < 0 && Math.abs(sumOfMembers) < Math.abs(min)) {
				min = sumOfMembers;
			}
		}

		return min;
	}
}
