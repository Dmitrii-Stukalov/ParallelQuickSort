import quicksort.DefaultQuickSort;
import quicksort.ParallelQuickSort;
import quicksort.QuickSort;
import quicksort.SequentialQuickSort;

import java.util.Arrays;
import java.util.Random;

public class Main {
	private static final int RANDOM_SEED = 52;
	private static final int RUNS = 5;
	private static final int ARRAY_SIZE = 100_000_000;
	private static final Random RANDOM = new Random(RANDOM_SEED);

	public static void main(String[] args) {
		long defaultTotalRunTime = 0;
		long sequentialTotalRunTime = 0;
		long parallelTotalRunTime = 0;

		if (args.length == 0) {
			System.err.println("Empty args");
			return;
		}

		for (int i = 0; i < RUNS; i++) {
			System.out.printf("===== RUN #%d =====\n", i + 1);
			int[] original = RANDOM.ints(ARRAY_SIZE).toArray();
			int[] copyForSequential = Arrays.copyOf(original, original.length);
			int[] copyForParallel = Arrays.copyOf(original, original.length);

			QuickSort defaultQuickSort = new DefaultQuickSort(original);
			QuickSort sequentialQuickSort = new SequentialQuickSort(copyForSequential);
			QuickSort parallelQuickSort = new ParallelQuickSort(copyForParallel);

			defaultTotalRunTime += runTest(defaultQuickSort);
			sequentialTotalRunTime += runTest(sequentialQuickSort);
			parallelTotalRunTime += runTest(parallelQuickSort);

			if (Boolean.parseBoolean(args[0])) {
				System.out.printf("Validate sequential %b\n", Arrays.equals(original, copyForSequential));
				System.out.printf("Validate parallel %b\n", Arrays.equals(original, copyForParallel));
			}
		}

		System.out.println("===== RESULTS =====");
		System.out.printf("Average time default %d ms\n", defaultTotalRunTime / RUNS);
		System.out.printf("Average time sequential %d ms\n", sequentialTotalRunTime / RUNS);
		System.out.printf("Average time parallel %d ms\n", parallelTotalRunTime / RUNS);
	}

	private static long runTest(QuickSort quickSort) {
		long beforeSequentialQuickSort = System.currentTimeMillis();
		quickSort.sort();
		long afterSequentialQuickSort = System.currentTimeMillis();

		long runTime = afterSequentialQuickSort - beforeSequentialQuickSort;
		System.out.printf("Run time for %s %d ms\n", quickSort.getClass().getSimpleName(), runTime);

		return runTime;
	}
}