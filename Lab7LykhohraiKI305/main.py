import sys
def main():
    try:
        size = mid = 0
        k = temp = 1
        arr = []
        filter = ""
        # Введення змінної size.
        while True:
            size = int(input("\nВведіть розмір квадратної матриці (непарне число > 3): "))
            if size % 2 == 0 or size < 3:
                print("\nВВЕДІТЬ НЕПАРНЕ ЧИСЛО > 3!")
            else:
                break
        mid = size // 2
        # Виділення пам'яті.
        for i in range(mid):
            arr.append([" "] * k)
            k += 2
        k = size
        for i in range(mid, size):
            arr.append([" "] * k)
            k -= 2
        # Введення символа-заповнювача.
        filter = input("\nВведіть символ-заповнювач: ")
        if len(filter) == 1:
            # Виведення верхньої частини ромба.
            for i in range(mid + 1):
                for j in range(1, size - i + 1):
                    sys.stdout.write(" ")
                for j in range(temp):
                    arr[i][j] = filter
                    sys.stdout.write(arr[i][j])
                sys.stdout.write("\n")
                temp += 2
            # Виведення нижньої частини ромба.
            temp = size - 2
            for i in range(mid + 1, size):
                for j in range(mid, mid + i + 1):
                    sys.stdout.write(" ")
                for j in range(temp):
                    arr[i][j] = filter
                    sys.stdout.write(arr[i][j])
                sys.stdout.write("\n")
                temp -= 2
        elif not filter:
            print("\nНе введено символ заповнювач!")
        else:
            print("\nЗабагато символів заповнювачів!")

        print()

    except ValueError:
        print("Некоректний ввід. Очікується ціле число!")


if __name__ == "__main__":
    main()
