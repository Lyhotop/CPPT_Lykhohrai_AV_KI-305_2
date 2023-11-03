package KI305.Lykhohrai.Lab6;
import java.util.ArrayList;
/**
 * @author Andrew Lykhohrai
 * Class Safe
 * @version 1.0
 */
class Safe<T extends Data>
{
    private ArrayList<T> arr;
    private int capacity;
    private int maxItem = 0;
    private int countItem = 0;
    /**
     * Constructor
     */
    public Safe(int size)
    {
        arr = new ArrayList<T>(size);
        capacity = size;
    }
    /**
     * Method simulates finding the most valuable in Safe
     */
    void getMax()
    {
        maxItem = arr.get(0).getSize();
        int temp = 0;
        // Get the minimum number in the entire stack
        if (arr.isEmpty())
            System.out.println("Сейф пустий!\n");
        else
        {
            for(int i = 0; i < arr.size(); i++)
            {
                if(maxItem < arr.get(i).getSize()) {
                    maxItem = arr.get(i).getSize();;
                    temp = i;
                }
            }
        }
            System.out.print("Найбільша цінність: \"" + arr.get(temp).getName() + "\", кількість: " + maxItem + "\n\n");
    }
    /**
     * Method simulates add jewelry
     */
    public int addItem(T Data)
    {
        if (IsFull()) {
            System.out.println("У сейфі не має місця!\n");
            return -1;
        }
        arr.add(Data);
        System.out.print("Додано: \t");
        Data.printInfoAbout();
        countItem++;
        return 0;
    }
    /**
     * Method simulates delete jewelry from Safe
     */
    public void deleteItem(String nameItem) {
        if (IsEmpty())
        {
            System.out.println("Сейф пустий!\n");
            System.exit(-1);
        }
        for(int i = 0; i < arr.size(); i++)
            if(arr.get(i).getName() == nameItem) {
                arr.get(i).printInfoAbout();
                arr.remove(arr.get(i));

                System.out.print(" - був видалений!\n\n");
            }
    }
    /**
     * Method for checking the contents of the safe
     */
    public boolean IsEmpty() {
        return countItem == 0;
    }
    /**
     * Method for checking the contents of the safe
     */
    public boolean IsFull() {
        return countItem == capacity;
    }
    /**
     * Method for printing all jewelry from Safe
     */
    public void printItem() {
        System.out.print("Вміст сейфа: \n");
        for (int i = 0 ; i < arr.size(); i++) {
            System.out.print(i + ". ");
            arr.get(i).printInfoAbout();
        }
    }
}
