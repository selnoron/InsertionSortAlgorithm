package test.java.algorithms;

import main.java.algorithms.InsertionSort;
import main.java.metrics.PerfomanceTracker;

import org.junit.jupiter.api.Assertions;

/**
 * Юнит тесты для алгоритма сортировки вставками.
 */
public class InsertionSortTest {

    @org.junit.Test
    public void testEmptyArray() {
        PerfomanceTracker tracker = new PerfomanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] result = sorter.sort(new int[]{});
        Assertions.assertArrayEquals(new int[]{}, result);
    }

    @org.junit.Test
    public void testSingleElement() {
        PerfomanceTracker tracker = new PerfomanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] result = sorter.sort(new int[]{5});
        Assertions.assertArrayEquals(new int[]{5}, result);
    }

    @org.junit.Test
    public void testAlreadySortedArray() {
        PerfomanceTracker tracker = new PerfomanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] result = sorter.sort(new int[]{1, 2, 3, 4, 5});
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
    }

    @org.junit.Test
    public void testReverseSortedArray() {
        PerfomanceTracker tracker = new PerfomanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] result = sorter.sort(new int[]{5, 4, 3, 2, 1});
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result);
    }

    @org.junit.Test
    public void testArrayWithDuplicates() {
        PerfomanceTracker tracker = new PerfomanceTracker();
        InsertionSort sorter = new InsertionSort(tracker);
        int[] result = sorter.sort(new int[]{4, 2, 4, 3, 2});
        Assertions.assertArrayEquals(new int[]{2, 2, 3, 4, 4}, result);
    }
}
