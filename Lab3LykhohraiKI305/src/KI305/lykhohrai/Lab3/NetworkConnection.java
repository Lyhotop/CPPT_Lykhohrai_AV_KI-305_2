package KI305.lykhohrai.Lab3;
import java.util.Scanner;
/*
The method that implements the network connection.
@param ipAddress IP Address.
@param port.
@param connect Inet conection.
 */
public class NetworkConnection {
    private String ipAddress;
    private String port;
    private boolean connect;
    // The default constructor.
    public NetworkConnection(){
        setIpAddress();
        setPort();
    }
    // The constructor with parameters.
    public NetworkConnection(String ipAddress, String port) {
        this.ipAddress = ipAddress;
        this.port = port;
        connect = false;
    }
    // Connect network.
    public  boolean Connect(String address, String new_port) {
        connect = false;
        if(ipAddress.equals(address) && port.equals(new_port))
        {
            connect = true;
        }
        else
            System.out.print("Ip адрес або порт не спіпадають!\n");
        return connect;
    }
    // Disconnect network.
    public void Disconnect() {
        connect = false;
    }
    // Check is connect.
    public boolean isConnected() {
        return (connect);
    }
    // Get IP address.
    public String getIpAddress() {
        return ipAddress;
    }
    // Get port.
    public String getPort() {
        return port;
    }
    // Set IP address.
    public void setIpAddress(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть IP адрес: ");
        ipAddress = in.nextLine();
    }
    // Set port.
    public void setPort(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть порт: ");
        port = in.nextLine();
    }
}

