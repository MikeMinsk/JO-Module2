package by.mikem.jonline.module2.main;

/*
 * Дана последовательность целых чисел a a an, , ,1 2 . Образовать новую последовательность, выбросив из исходной те члены, 
 * которые равны min( , , , ) a1 a2  an.
 */

public class Arrays08 {

	public static void main(String[] args) {
		int[] array;

		array = createSequence();

		System.out.println("Total number of members of sequence: " + array.length);

		int minMember;

		minMember = calculateMin(array);

		System.out.println("Minimal member: " + minMember);

		System.out.println("Total number of members of new sequence: " + createNewSequence(array, minMember).length);
	}

	public static int[] createSequence() {
		int arrayLength;

		arrayLength = (int) (Math.random() * 5000 + 1);

		int[] array;

		array = new int[arrayLength];

		int randomNumber;

		randomNumber = (int) (Math.random() * 5000);

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.sqrt(i * i + 1) - randomNumber);
		}
		return array;
	}

	public static int calculateMin(int[] array) {
		int max = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {

			if (array[i] < max) {
				max = array[i];
			}
		}

		return max;
	}

	public static int[] createNewSequence(int[] array, int minMember) {
		int minMembersCount = 0;

		for (int member : array) {
			if (member == minMember) {
				minMembersCount++;
			}
		}

		int[] newArray;

		newArray = new int[array.length - minMembersCount];

		int minMembersCountInCycle = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] != minMember) {
				newArray[i - minMembersCountInCycle] = array[i];
			} else {
				minMembersCountInCycle++;
			}
		}

		return newArray;
	}
}
