package KI305.lykhohrai.Lab3;
import java.io.*;

public class PrinterDriver {
    public static void main(String[] args) throws IOException {
        //MultifunctionDevice myDevice = new MultifunctionDevice("HP3", new InkCartridge(100), new PaperTray(30), new NetworkConnection(), 110);
        MultifunctionDevice myDevice = new MultifunctionDevice();
        myDevice.powerOn();
        myDevice.printDocument(myDevice.scanDocument("MyFile.txt"));
        myDevice.AboutPrinter();
        myDevice.printDocument();
        myDevice.AboutPrinter();
        myDevice.powerOff();
    }
};
