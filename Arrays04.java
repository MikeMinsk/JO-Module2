package by.mikem.jonline.module2.main;

/*
 * Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.
 */

public class Arrays04 {

	public static void main(String[] args) {
		double[] array;

		array = createArray();

		changeMembers(array);
	}

	public static double[] createArray() {
		int arrayLength;

		arrayLength = (int) (Math.random() * 1000);

		double[] array;

		array = new double[arrayLength];

		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random() - 0.5;
		}

		return array;
	}

	public static void changeMembers(double[] array) {
		double min;
		double max;

		max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;

		int indexOfMax = 0;
		int indexOfMin = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				indexOfMax = i;
			} else if (array[i] < min) {
				min = array[i];
				indexOfMin = i;
			}
		}

		double temp;

		System.out.println("The members before changing. № " + indexOfMin + " is " + array[indexOfMin] + ", № "
				+ indexOfMax + " is " + array[indexOfMax]);

		temp = array[indexOfMax];
		array[indexOfMax] = array[indexOfMin];
		array[indexOfMin] = temp;

		System.out.println("Those members after changing. № " + indexOfMin + " is " + array[indexOfMin] + ", № "
				+ indexOfMax + " is " + array[indexOfMax]);
	}
}
