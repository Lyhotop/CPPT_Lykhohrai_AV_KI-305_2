package KI305.Lykhohrai.Lab6;
/**
 * Class Safe implements main method for Safe
 * Class possibilities demonstration
 * @author Andrew Lykhohrai
 * @version 1.0
 */
public class SafeApp {
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Safe <? super Data> MySafe = new Safe <Data>(10);
        MySafe.addItem(new Money("Долар", 4000));
        MySafe.addItem(new Precious("Золото", 20));
        MySafe.addItem(new Money("Євро", 100));
        MySafe.addItem(new Money("Рубін", 1000));
        MySafe.addItem(new Precious("Діамант", 2));
        MySafe.addItem(new Money("Долар", 1000));
        MySafe.addItem(new Money("Гривня", 500));
        MySafe.addItem(new Money("Долар", 190));
        MySafe.addItem(new Money("Євро", 3000));
        MySafe.addItem(new Money("Гривня", 2000));
        MySafe.addItem(new Money("Євро", 15));
        MySafe.addItem(new Money("Рубін", 130));
        MySafe.getMax();
        MySafe.deleteItem("Долар");
        MySafe.deleteItem("Рубін");
        MySafe.getMax();
        MySafe.printItem();
        System.out.print("\nЗагальна кількість купюр: " + Money.getCountGold());
    }
}