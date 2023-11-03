package KI305.Lykhohrai.Lab5;
import java.util.Scanner;
import java.io.*;

/**
 * Class <code>EquationsApp</code> Implements driver for Equations class
 * @version 1.0
 */
public class FioApp{
    /**
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        CalcWFio obj = new CalcWFio();
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Введіть X: ");
            double data = s.nextDouble();
            obj.calculate(data);
        }
        System.out.println("Результат обчислення: " + obj.getResult());
        obj.writeResTxt("textRes.txt");
        obj.writeResBin("BinRes.bin");
        obj.readResBin("BinRes.bin");
        System.out.println("Результат в бінарному файлі: " + obj.getResult());
        obj.readResTxt("textRes.txt");
        System.out.println("Результат в текстовому файлі: " + obj.getResult());
    }
}