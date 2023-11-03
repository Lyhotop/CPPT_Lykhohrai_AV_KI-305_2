import java.io.*;
import java.util.*;
/**
 * Class <code>Lab1LykhohraiKI305</code> creates an array in the form of a diamond.
 * @author Andrew Lykhohrai
 * @version 1.0
 */
public class Lab1LykhohraiKI305
{
    /* Статичний метод main є точкою входу в програму*/
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * @param nSize size of matrix,
         * @param nMid half size
         */
        int nSize, nMid, k = 1, temp = 1;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("Lab1.txt");
        PrintWriter fout = new PrintWriter(dataFile);
        /**
         Check if nSize < 3 and odd.
         */
        while (true) {
            System.out.print("\nВведіть розмір квадратної матриці (непарне число > 3): ");
            nSize = in.nextInt();
            in.nextLine();
            if (nSize % 2 == 0 || nSize < 3)
                System.out.print("\nВВЕДІТЬ НЕПАРНЕ ЧИСЛО > 3!");
            else
                break;
        }
        arr = new char[nSize][]; /** Creating an array.*/
        nMid = nSize / 2; /** Calculating nMid*/
        /**
         Allocation of memory for the upper part of the array.
         */
        for (int i = 0; i < nMid; i++) {
            arr[i] = new char[k];
            k += 2;
        }
        /**
         Allocation of memory for the lower part of the array.
         */
        k = nSize;
        for (int i = nMid; i < nSize; i++) {
            arr[i] = new char[k];
            k -= 2;
        }
        System.out.print("\nВведіть символ-заповнювач: ");
        filler = in.nextLine();
        exit:
        /** Check for the correctness of the input of the placeholder symbol. */
        if (filler.length() == 1) {
            /**
             The cycle in which the alignment of the upper part is performed
             rhombus (matrix) at output, filling it with a placeholder symbol
             and save to file.
             */
            for (int i = 0; i <= nMid; i++) {
                /** Output alignment. */
                for (int j = 1; j <= nSize - i; j++) {
                    fout.print(" ");
                    System.out.print(" ");
                }
                /** Filling with a symbol and saving to a file. */
                for (int j = 0; j < temp; j++) {
                    arr[i][j] = (char) filler.codePointAt(0);
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }
                fout.print("\n");
                System.out.print("\n");
                temp += 2;
            }
            /**
             The cycle in which the alignment of the lower part is performed
             rhombus (matrix) at output, filling it with a placeholder symbol
             and save to file.
             */
            temp = nSize - 2;
            for (int i = nMid + 1; i <= nSize; i++) {
                /** Output alignment. */
                for (int j = nMid; j <= nMid + i; j++) {
                    fout.print(" ");
                    System.out.print(" ");
                }
                /** Filling with a symbol and saving to a file. */
                for (int j = 0; j < temp; j++) {

                    arr[i][j] = (char) filler.codePointAt(0);
                    System.out.print(arr[i][j]);
                    fout.print(arr[i][j]);
                }
                fout.print("\n");
                System.out.print("\n");
                temp -= 2;
            }
        }
        else if(filler.isEmpty())
        {
            System.out.print("\nНе введено символ заповнювач");
            break exit;
        }
        else{
            System.out.print("\nЗабагато символів заповнювачів!");
            break exit;
        }
        System.out.println();
        fout.flush();
        fout.close();
    }
}