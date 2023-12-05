package quicksort;

public class SequentialQuickSort extends QuickSort {

	public SequentialQuickSort(int[] array) {
		super(array);
	}

	public void sort() {
		quickSort(array, 0, array.length - 1);
	}


	private void quickSort(int[] array, int left, int right) {
		if (array.length == 0) {
			return;
		}

		if (left >= right) {
			return;
		}

		int pivot = partition(array, left, right);

		if (left < pivot) {
			quickSort(array, left, pivot);
		}

		if (pivot + 1 < right) {
			quickSort(array, pivot + 1, right);
		}
	}
}
