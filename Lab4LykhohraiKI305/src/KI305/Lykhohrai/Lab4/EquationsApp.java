package KI305.Lykhohrai.Lab4;
import java.util.Scanner;
import java.io.*;
import static java.lang.System.out;
/**
 * Class <code>EquationsApp</code> Implements driver for Equations class
 * @version 1.0
 */
public class EquationsApp {
    public static void main(String[] args) {
        try
        {
            out.print("Введіть назву файлу, куди зберегти результат: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try
            {
                Equations eq = new Equations();
                out.print("Введіть X: ");
                int x = in.nextInt();
                fout.print(eq.calculate(x));
                out.print(eq.calculate(x));
            }
            finally
            {
                fout.flush();
                fout.close();
            }
        }
        catch (CalcException | FileNotFoundException ex)
        {
            if (ex instanceof CalcException) {
                out.print(((CalcException)ex).getMessage());
            } else {
                out.print("Можливо, неправильний шлях до файлу!");
            }
        }
    }
}