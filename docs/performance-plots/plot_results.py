import pandas as pd
import matplotlib.pyplot as plt
import os

# Путь к CSV-файлу с результатами
csv_path = "docs/performance-plots/insertion_sort_results.csv"

# Проверяем, существует ли файл
if not os.path.exists(csv_path):
    print("❌ CSV file not found! Run BenchmarkRunner.java first to generate it.")
    exit()

# Загружаем данные
data = pd.read_csv(csv_path)

# Проверяем, что нужные колонки есть
required_columns = {"InputSize", "Time(ns)"}
if not required_columns.issubset(data.columns):
    print("❌ CSV file is missing required columns! Expected: InputSize, Time(ns)")
    exit()

# Создаем папку для графика, если её нет
os.makedirs("docs/performance-plots", exist_ok=True)

# Построение графика
plt.figure(figsize=(8, 5))
plt.plot(data["InputSize"], data["Time(ns)"], marker='o', linestyle='-', linewidth=2)

plt.title("Insertion Sort Performance")
plt.xlabel("Input Size (n)")
plt.ylabel("Execution Time (ns)")
plt.grid(True)
plt.tight_layout()

# Сохраняем график
output_path = "docs/performance-plots/time_vs_inputsize.png"
plt.savefig(output_path)
plt.close()

print(f"✅ Plot saved to: {output_path}")
