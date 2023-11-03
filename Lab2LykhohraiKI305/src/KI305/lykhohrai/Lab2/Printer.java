package KI305.lykhohrai.Lab2;
import java.io.*;
import java.util.*;
/*
The method that implements the printer.
@param model Name of printer.
@param resource Resource work of printer.
@param work Is printer work.
 */
public class Printer {
    private String model;
    private int resourse;
    private boolean work;
    private PaperTray paperTray;
    private InkCartridge inkCartridge;
    private NetworkConnection networkConnection;
    // The default constructor.
    public Printer() {
        model = "unknow";
        resourse = 0;
        paperTray = new PaperTray();
        inkCartridge = new InkCartridge();
        networkConnection = new NetworkConnection();

    }
    // The constructor with parameters.
    public Printer(String model, InkCartridge inkCartridge, PaperTray paperTray, NetworkConnection networkConnection, int resourse) {
        this.model = model;
        this.paperTray = paperTray;
        this.inkCartridge = inkCartridge;
        this.networkConnection = networkConnection;
        this.resourse = resourse;
    }
    // Print document.

    public void printDocument() {
        writeLogs("Print document.\n");
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть назву документу: ");
        String document = in.nextLine();
        System.out.print("Введіть кількість копій: ");
        int count = in.nextInt();
        System.out.print("Введіть ваш IP адрес (178.212.111.75): ");
        String address;
        address = in.next();
        System.out.print("Введіть порт (1024): ");
        String port = in.next();
        if (!isWork() || (count == 0) || !networkConnection.Connect(address, port)) {
            System.out.print("Пристрій не ввімкнуто!!!\n");
            writeLogs("Printer has problem!\n");
        } else {
            System.out.print("Розпочато друк документу: " + document + "\n");
            if (paperTray.GetPaperCount() >= count && inkCartridge.GetInkLevel() > 10) {
                for (int i = 1; i <= count; i++) {
                    System.out.print("\nДрук " + i + " сторінки. \n");
                    workPrinter(document);
                    useInkPaper(document);
                }
            } else
                System.out.print("Замало чорнила або паперу!\n");
        }
    }
    // Print text to the console.
    public void workPrinter(String document) {
        writeLogs("Printing document.\n");
        try {
            File file = new File(document);

            if (!file.exists()) {
                System.out.println("Файл не знайдено.");
                return;
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            System.out.print("\n");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("\t" + line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Виникла помилка при читанні файлу: " + e.getMessage());
        }
    }
    // Count ink for printing.
    public int countInk(String text) {
        writeLogs("Count ink.\n");
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return text.length();
    }
    // Use ink and paper.
    public void useInkPaper(String text) {
        writeLogs("Use ink and paper.\n");
        paperTray.UsePaper();
        inkCartridge.UseInk(countInk(text));
    }
    // Check if printer is work.
    public boolean isWork() {
        writeLogs("Is printer work?" + work + ".\n");
        return (work);
    }
    // Power on.
    public void powerOn() {
        writeLogs("Printer is on.\n");
        if (resourse == 0)
            System.out.print("Пристрій потрібно відкалібрувати!\n");
        else {
            System.out.print("Принтер ввімкнено!\n");
            work = true;
            resourse--;
        }
    }
    // Power off.
    public void powerOff() {
        writeLogs("Printer is off.\n");
        System.out.print("Принтер вимкнено! \n");
        work = false;
        networkConnection.Disconnect();
    }
    // Calibrate printer.
    public void calibratePrinter() {
        writeLogs("Calibrate printer\n");
        System.out.print("Принтер було відкалібровано! \n");
        inkCartridge.ResetInkLevel();
        paperTray.ResetPaperCount();
        resourse = 100;
    }
    // Clean printer heads.
    public void cleanPrintHeads() {
        writeLogs("Clear printer\n");
        paperTray.ResetPaperCount();
        inkCartridge.ResetInkLevel();
        resourse = 0;
        System.out.print("Принтер очищено! \n");
    }
    // Print "About printer".
    public void AboutPrinter() {
        writeLogs("About printer.\n");
        System.out.print("\n\nПро принтер:\n");
        System.out.print("Назва: " + GetPrinterName() + "\n");
        CheckPaperLevel();
        CheckInkLevel();
        System.out.print("IP адреса: " + networkConnection.getIpAddress() + "\n");
    }
    // Check ink level.
    public void CheckInkLevel() {
        writeLogs("Check ink level.\n");
        System.out.print("Залишилось чорнила:" + inkCartridge.GetInkLevel() + "\n");
    }
    // Check paper level.
    public void CheckPaperLevel() {
        writeLogs("Check paper level.\n");
        System.out.print("Залишилось паперу:" + paperTray.GetPaperCount() + "\n");
    }
    // Add paper.
    public void addPaper() {
        writeLogs("Add paper.\n");
        paperTray.AddPaper();
    }
    // Add ink.
    public void addInkLevel() {
        writeLogs("Add ink.\n");
        inkCartridge.AddInk();
    }
    // Set printer name.
    void SetPrinterName(String name) {
        writeLogs("Set printer name.\n");
        model = name;
    }
    // Get printer name.
    String GetPrinterName() {
        writeLogs("Get printer name.\n");
        return model;
    }
    // Write logs about work of printer.
    public void writeLogs(String textToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Logs.txt", true))) {
            // Записуємо переданий текст у файл
            bufferedWriter.write(textToWrite);
        } catch (IOException e) {
            System.err.println("Сталася помилка при записі до файлу: " + e.getMessage());
        }
    }
    // Set max paper count.
    public void replacePaperTray(PaperTray newPaperTray) {
        newPaperTray.ResetPaperCount();
        newPaperTray.SetPaperCount(250);
    }
    // Set max ink leve.
    public void replaceInkCartridge(InkCartridge newInkCartridge) {
        newInkCartridge.ResetInkLevel();
        newInkCartridge.SetInkLevel(100);
    }

    public int GetResource(){
        return resourse;
    }
}
