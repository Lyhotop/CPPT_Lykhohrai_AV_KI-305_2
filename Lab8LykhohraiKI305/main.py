import os
import struct
import sys
import math

# Функція для запису результату у текстовий файл
def writeResTxt(file_name, result):
    with open(file_name, 'w') as file:
        file.write(str(result))

# Функція для читання результату з текстового файлу
def readResTxt(file_name):
    result = 0.0
    try:
        if os.path.exists(file_name):
            with open(file_name, 'r') as file:
                result = float(file.read())
        else:
            raise FileNotFoundError(f"Файл {file_name} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    return result

# Функція для запису результату у бінарний файл
def writeResBin(file_name, result):
    with open(file_name, 'wb') as file:
        packed_result = struct.pack('f', result)
        file.write(packed_result)

# Функція для читання результату з бінарного файлу
def readResBin(file_name):
    result = 0.0
    try:
        if os.path.exists(file_name):
            with open(file_name, 'rb') as file:
                packed_result = file.read(4)  # читаємо 4 байти (розмір типу float)
                result = struct.unpack('f', packed_result)[0]
        else:
            raise FileNotFoundError(f"Файл {file_name} не знайдено.")
    except FileNotFoundError as e:
        print(e)
    return result

# Функція для обчислення виразу (1 / Math.tan(rad)) / ( Math.sin(2 * rad) + 4 * Math.cos(rad))
def calculate_expression(x):
    try:
        rad = math.radians(x)
        er_value = math.sin(2 * rad) + 4 * math.cos(rad)
        if er_value == 0:
            raise ZeroDivisionError("Знаменник не може дорівнювати нулю!")
        elif x == 90 and math.tan(rad):
            raise ZeroDivisionError("Не прийнятне значення для обчислення ctg()!")
        result = (1.0 / math.tan(rad) / er_value)
        return result
    except ZeroDivisionError as e:
        raise CalcException(str(e))

# клас для власного виключення CalcException
class CalcException(Exception):
    pass

if __name__ == "__main__":
    try:
        data = float(input("Введіть Х: "))
        result = calculate_expression(data)
        print(f"Результат обчислення: {result}")
        writeResTxt("textRes.txt", result)
        writeResBin("binRes.bin", result)
        print("Результат з бінарного файлу: {0}".format(readResBin("binRes.bin")))
        print("Результат з текстового файлу: {0}".format(readResTxt("textRes.txt")))
    except CalcException as e:
        print(e)
    except FileNotFoundError as e:
        print(e)
        sys.exit(1)