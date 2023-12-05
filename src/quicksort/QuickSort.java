package quicksort;

public abstract class QuickSort {

	protected final int[] array;

	public QuickSort(int[] array) {
		this.array = array;
	}

	public abstract void sort();

	protected int partition(int[] array, int left, int right) {
		int pivot = array[left + (right - left) / 2];

		while (true) {
			while (array[left] < pivot) {
				left++;
			}

			while (array[right] > pivot) {
				right--;
			}

			if (left < right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			} else {
				return right;
			}
		}
	}
}
