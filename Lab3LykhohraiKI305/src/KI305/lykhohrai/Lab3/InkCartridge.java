package KI305.lykhohrai.Lab3;
import java.util.Scanner;
/*
The class InkCartridge implements a printer cartridge.
@param ink Level nk level in the printer.
*/
public class InkCartridge {
    private int inkLevel;
    // The default constructor.
    public InkCartridge(){
        this.inkLevel = 0;
    }
    // The constructor with parameters.
    public InkCartridge(int inkLevel) {
        this.inkLevel = inkLevel;
    }
    // The method for entering a new amount of ink.
    public void AddInk() {
        Scanner in = new Scanner(System.in);
        System.out.print("Кількість нового чорнила: ");
        inkLevel = in.nextInt();
    }
    // The method for using ink.
    public void UseInk(int length) {
        if(length>2000)
            inkLevel -= 3;
        else if (1000 > length)
            inkLevel -= 2;
        else
            inkLevel -= 1;
    }
    //Get ink level.
    public int GetInkLevel() { return inkLevel; }
    // Reset ink level.
    public void ResetInkLevel() { inkLevel = 0; }
    // Check if the cartridge is empty.
    public boolean isInkEmpty() {return (inkLevel == 0);}
    // Check if the cartridge is full.
    public boolean isInkFull() { return (inkLevel == 100); }
    // Set ink level.
    public void SetInkLevel(int level){ inkLevel = level; }
}