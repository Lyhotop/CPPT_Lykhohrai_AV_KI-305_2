package KI305.lykhohrai.Lab3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

interface ScanInterface {
    String scanDocument(String document);
    void printDocument();


};

public class MultifunctionDevice  extends Printer implements ScanInterface{
    public MultifunctionDevice() {
       super(new InkCartridge(), new PaperTray(), new NetworkConnection());
    };

    public MultifunctionDevice(String model, InkCartridge inkCartridge, PaperTray paperTray, NetworkConnection networkConnection, int resourse) {
        super(model, inkCartridge, paperTray, networkConnection, resourse);
    };
    @Override public String scanDocument(String document){
        System.out.print("Розпочато сканування " + document + "\n\n");
            try (BufferedReader reader = new BufferedReader(new FileReader(document))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append("\n");
                }
                System.out.print(text.toString());
                return text.toString();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.print( "Помилки при скануванні документу:" + e.getMessage());
                return e.getMessage();
            }
    };
    public void printDocument(String text) {
        writeLogs("Print document.\n");
        Scanner in = new Scanner(System.in);

        System.out.print("Введіть кількість копій: ");
        int count = in.nextInt();

        if (!isWork() || (count == 0)) {
            System.out.print("Пристрій не ввімкнуто!!!\n");
            writeLogs("Printer has problem!\n");

        } else {
            System.out.print("Розпочато друк відсканованого документу: \n");
            if (GetPaper() >= count && GetInk() > 10) {
                for (int i = 1; i <= count; i++) {
                    System.out.print("\nДрук " + i + " сторінки. \n");
                    System.out.print(text);
                    useInkPaper(text);
                }
            } else
                System.out.print("Замало чорнила або паперу!\n");
        }
    }
}
