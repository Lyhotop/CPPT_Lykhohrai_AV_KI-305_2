package KI305.Lykhohrai.Lab6;
/**
 * Interface <code>Data</code> extends Comparable
 * @author Andrew Lykhohrai
 * @version 1.0
 **/
interface Data extends Comparable<Data>
{
    public int getSize();
    public void printInfoAbout();
    public void setName(String name);
    public String getName();


}