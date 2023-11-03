package KI305.lykhohrai.Lab2;
import java.io.*;
public class PrinterDriver {
    public static void main(String[] args) throws FileNotFoundException{
            Printer myPrinter = new Printer("HP2", new InkCartridge(100), new PaperTray(2), new NetworkConnection(), 100);
            myPrinter.powerOn();
            myPrinter.AboutPrinter();
            myPrinter.printDocument();
            myPrinter.AboutPrinter();
            myPrinter.addPaper();
            myPrinter.printDocument();
            myPrinter.AboutPrinter();
        }

   }