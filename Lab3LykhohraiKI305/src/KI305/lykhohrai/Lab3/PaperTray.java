package KI305.lykhohrai.Lab3;
import java.io.*;
import java.util.*;
/*
The method that implements the paper mechanism.
@param paperCount Amount of paper.
@param maxPaperLevel Max amount of paper.
 */
public class PaperTray  {
    private int paperCount;
    private int maxPaperLevel = 250;
    // The default constructor.
    public PaperTray()   {

        this.paperCount = 0;
    }
    // The constructor with parameters.
    public PaperTray(int count)
    {
        if(count <= maxPaperLevel)
            this.paperCount = count;
        else
            System.out.print("\nПаперу забагато!!!\n");
    }
    // The method for entering a new amount of paper.
    public void AddPaper() {
        Scanner in = new Scanner(System.in);
        System.out.print("Кількість нового паперу: ");
        int temp = in.nextInt();
        if(temp <= maxPaperLevel)
            paperCount = temp;
        else
            System.out.print("\nПаперу забагато!!!\n");
    }
    // The method for using paper.
    public void UsePaper() {paperCount--;}
    // Get paper count.
    public int GetPaperCount() {
        return paperCount;
    }
    // Reset amount of paper.
    public void ResetPaperCount() {
        paperCount = 0;
    }
    // Check if amount of paper = 0.
    public boolean isPaperEmpty() {
        return(paperCount == 0);
    }
    // Check if amount of paper is full/
    public boolean isPaperFull() {
        return(paperCount == maxPaperLevel);
    }
    // Set paper count.
    public void SetPaperCount(int count){ paperCount = count; }
}
