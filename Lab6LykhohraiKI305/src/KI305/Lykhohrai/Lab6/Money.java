package KI305.Lykhohrai.Lab6;
/**
 * Class <code>Money</code> implements Data
 * @author Andrew Lykhohrai
 * @version 1.0
 **/
public class Money implements Data{
    private String billName;
    private int amount;
    private static int countMoney = 0;
    /**
     * Constructor
     * @param name Name of money
     * @param size Amount of money
     */
    public Money (String name,  int size)
    {
        billName = name;
        amount = size;
        countMoney += size;
    }
    /**
     *
     * @return amount of money
     */
    public static int getCountGold() {
        return countMoney;
    }
    /**
     * Method simulates comparing variable size
     */
    public int compareTo(Data p)
    {
        Integer s = amount;
        return s.compareTo(p.getSize());
    }
    /**
     * Method of displaying the added jewelry
     */
    @Override
    public void printInfoAbout() {
        System.out.print("Купюра: \"" + billName + "\", кількість: " + amount + "\n");
    }
    /**
     *
     * @return name of bill
     */
    public String getName() {
        return billName;
    }
    /**
     * Set name of bill
     */
    public void setName(String billName) {
        this.billName = billName;
    }
    /**
     *
     * @return amount of money
     */
    public int getSize() {
        return amount;
    }
    /**
     * Set size of jewelry
     */
    public void setSize(int size) { this.amount = size; }
}
