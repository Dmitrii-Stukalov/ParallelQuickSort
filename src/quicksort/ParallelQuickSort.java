package quicksort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort extends QuickSort {

	public ParallelQuickSort(int[] array) {
		super(array);
	}

	@Override
	public void sort() {
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);
		forkJoinPool.invoke(new ForkJoinQuicksortTask(array));
	}

	private class ForkJoinQuicksortTask extends RecursiveAction {
		private static final int SERIAL_THRESHOLD = 1000;

		private final int[] array;
		private final int left;
		private final int right;

		public ForkJoinQuicksortTask(int[] array) {
			this(array, 0, array.length - 1);
		}

		private ForkJoinQuicksortTask(int[] array, int left, int right) {
			this.array = array;
			this.left = left;
			this.right = right;
		}

		@Override
		protected void compute() {
			if (right - left < SERIAL_THRESHOLD) {
				Arrays.sort(array, left, right + 1);
				return;
			}

			int pivot = partition(array, left, right);
			ForkJoinTask<?> task = null;

			if (left < pivot) {
				task = new ForkJoinQuicksortTask(array, left, pivot).fork();
			}
			if (pivot + 1 < right) {
				new ForkJoinQuicksortTask(array, pivot + 1, right).invoke();
			}

			if (task != null) {
				task.join();
			}
		}
	}
}
