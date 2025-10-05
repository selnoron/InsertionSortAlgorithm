package main.java.algorithms;

import main.java.metrics.PerfomanceTracker;

/**
 * Алгоритм сортировки вставками с оптимизацией для почти отсортированных массивов.
 * <p>
 * Временная сложность:
 * Лучший случай: O(n)
 * Средний случай: O(n^2)
 * Худший случай: O(n^2)
 * Память: O(1) (сортировка на месте)
 */
public class InsertionSort {

    // PerformanceTracker — для подсчёта сравнений, обменов и обращений к массиву
    private PerfomanceTracker tracker;

    // Конструктор
    public InsertionSort(PerfomanceTracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Сортирует массив методом вставок.
     *
     * @param arr input array / входной массив
     * @return sorted array / отсортированный массив
     */
    public int[] sort(int[] arr) {
        // Проверяем, что массив не null
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null / Массив не может быть null");
        }

        int n = arr.length;

        // Перебираем элементы массива, начиная со второго
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // element to insert / элемент, который нужно вставить
            tracker.incrementArrayAccesses(1);

            int j = i - 1;

            // Оптимизация: если текущий элемент уже больше предыдущего — пропускаем
            if (arr[j] <= key) {
                tracker.incrementComparisons(1);
                continue;
            }

            // Сдвигаем элементы, которые больше key, вправо
            while (j >= 0 && arr[j] > key) {
                tracker.incrementComparisons(1);
                arr[j + 1] = arr[j]; // сдвиг вправо
                tracker.incrementSwaps(1);
                tracker.incrementArrayAccesses(2); // чтение и запись
                j--;
            }

            // Вставляем key в правильную позицию
            arr[j + 1] = key;
            tracker.incrementArrayAccesses(1);
        }

        return arr;
    }
}
