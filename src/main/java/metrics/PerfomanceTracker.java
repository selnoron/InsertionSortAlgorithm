package main.java.metrics;

/**
 * Класс PerformanceTracker считает метрики: сравнения, обмены,
 * обращения к массиву и время выполнения.
 */
public class PerfomanceTracker {

    private long comparisons = 0;    // Счётчик сравнений
    private long swaps = 0;          // Счётчик обменов
    private long arrayAccesses = 0;  // Счётчик обращений к массиву
    private long startTime;          // Время начала
    private long endTime;            // Время окончания

    // Начинаем замер времени
    public void start() {
        startTime = System.nanoTime();
    }

    // Останавливаем замер времени
    public void stop() {
        endTime = System.nanoTime();
    }

    // Возвращает время в наносекундах потомучто милисекунды слишком грубые
    public long getExecutionTimeNs() {
        return endTime - startTime;
    }

    // Методы увеличения счётчиков
    public void incrementComparisons(long count) {
        comparisons += count;
    }

    public void incrementSwaps(long count) {
        swaps += count;
    }

    public void incrementArrayAccesses(long count) {
        arrayAccesses += count;
    }

    // Сброс всех счётчиков
    public void reset() {
        comparisons = swaps = arrayAccesses = 0;
    }

    // Геттеры
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    //Вывод метрик на экран
    public void printMetrics() {
        System.out.println("📊 Performance Metrics / Метрики выполнения:");
        System.out.println("Comparisons / Сравнений: " + comparisons);
        System.out.println("Swaps / Обменов: " + swaps);
        System.out.println("Array Accesses / Обращений к массиву: " + arrayAccesses);
        System.out.println("Execution Time (ns) / Время (нс): " + getExecutionTimeNs());
    }
}
