package cli;

import main.java.algorithms.InsertionSort;
import main.java.metrics.PerfomanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * BenchmarkRunner
 * Runs performance tests for Insertion Sort algorithm.
 * Saves results into CSV file for analysis and plotting.
 *
 * Бенчмарк-раннер
 * Запускает тесты производительности для алгоритма вставками
 * и сохраняет результаты в CSV-файл для анализа и построения графиков.
 */
public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] inputSizes = {100, 1000, 5000, 10000, 20000, 50000}; // разные размеры массива
        Random random = new Random();
        String csvFilePath = "docs/performance-plots/insertion_sort_results.csv";

        try (FileWriter writer = new FileWriter(csvFilePath)) {
            // Заголовок таблицы
            writer.write("InputSize,Comparisons,Swaps,Time(ns)\n");

            for (int n : inputSizes) {
                int[] array = new int[n];

                // Генерация случайных данных
                for (int i = 0; i < n; i++) {
                    array[i] = random.nextInt(100000);
                }

                PerfomanceTracker tracker = new PerfomanceTracker();
                InsertionSort sorter = new InsertionSort(tracker);

                long startTime = System.nanoTime();
                sorter.sort(array);
                long endTime = System.nanoTime();

                long duration = endTime - startTime;

                // Запись результатов в CSV
                writer.write(String.format("%d,%d,%d,%d\n",
                        n,
                        tracker.getComparisons(),
                        tracker.getSwaps(),
                        duration));

                System.out.println("✅ Completed: n = " + n + " | Time: " + duration + " ns");
            }

            System.out.println("\n📊 Results saved to: " + csvFilePath);
        } catch (IOException e) {
            System.err.println("❌ Error writing CSV file: " + e.getMessage());
        }
    }
}
