package ConnectDB;
import javax.xml.crypto.Data;
import  java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {
    public UDPClient() {
        try {
            DatagramSocket socket = new DatagramSocket(6000) ;
            while(true) {
               byte[] bytenhan = new byte[3024];
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
