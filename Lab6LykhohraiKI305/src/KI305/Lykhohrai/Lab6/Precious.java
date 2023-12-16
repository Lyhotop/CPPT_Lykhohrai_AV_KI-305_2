package KI305.Lykhohrai.Lab6;
/**
 * Class <code>Precious</code> implements Data
 * @author Andrew Lykhohrai
 * @version 1.0
 **/
public class Precious implements Data{
    private String preciousName;
    private int nSize;
    private static int countPrecious = 0;
    /**
     * Constructor
     * @param name Name of precious
     * @param size size of precious
     */
    public Precious(){};
    public Precious (String name,  int size)
    {
        preciousName = name;
        nSize = size;
        countPrecious++;
    }
    /**
     *
     * @return count of precious
     */
    public static int getCountPrecious() {
        return countPrecious;
    }
    /**
     * Method simulates comparing variable size
     */
    public int compareTo(Data p)
    {
        Integer s = nSize;
        return s.compareTo(p.getSize());
    }
    /**
     * Method of displaying the added jewelry
     */
    @Override
    public void printInfoAbout() {
        System.out.print("Коштовність: \"" + preciousName + "\", кільсть: " + nSize + "\n");
    }
    /**
     *
     * @return name of jewelry
     */
    public String getName() {
        return preciousName;
    }
    /**
     * Set name of jewelry
     */
    public void setName(String preciousName) {
        this.preciousName = preciousName;
    }
    /**
     *
     * @return amount of jewelry
     */
    public int getSize() {
        return nSize;
    }
    /**
     * Set size of jewelry
     */
    public void setSize(int nSize) {
        this.nSize = nSize;
    }
}


