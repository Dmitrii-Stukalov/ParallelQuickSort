package quicksort;

import java.util.Arrays;

public class DefaultQuickSort extends QuickSort {

	public DefaultQuickSort(int[] array) {
		super(array);
	}

	@Override
	public void sort() {
		Arrays.sort(array);
	}
}
