import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * ���Ͷ�
 * @author John Kwok
 *
 */
public class ChatterClient extends Thread {

    private DatagramSocket s;
    private InetAddress hostAddress;
    private byte[] buf = new byte[1000];
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private int id;

    public ChatterClient(int identifier) {
        id = identifier;
        try {
            s = new DatagramSocket();
            hostAddress = InetAddress.getByName("114.215.17.88");//Ŀ������IP
      //     hostAddress = InetAddress.getByName("localhost");//Ŀ������IP
//            telnet 114.215.17.88 8080
        } catch (UnknownHostException e) {
            System.err.println("Cannot find host");
            System.exit(1);
        } catch (SocketException e) {
            System.err.println("Can't open socket");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("ChatterClient starting");
    }

    public void run() {
        try {
//            String str ="123456789ABCDEFGH123001130203456118301234DJSKCNEU123450";//���͵�����
            String str ="123456789abcdefgh07551211163125003994750012345678123450";//���͵�����
//        	String str ="123456789ABCDEFGH123001030203456118301234DJSKCNEU123450123456789ABCDEFGHFPRP123001130203456118301234DJSKCNEU12345";//���͵�����
//        	String str ="123456789ABCDEFGH123001030203456118301234DJSKCNEU123450123456789ABCDEFGHFPRP123001130203456118301234DJSKCNEU12345123456789ABCDEFGHFPRP123001130203456118301234DJSKCNEU12345";//���͵�����
            s.send(Dgram.toDatagram(str, hostAddress,
                    3000));
            s.receive(dp);//���շ��ص�����
            String rcvd = "Client #" + id + ",rcvd from " + dp.getAddress()
                    + ", " + dp.getPort() + ":" + Dgram.toString(dp);
            System.out.println(rcvd);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
//      for(int i=0;i<1000;i++)
        new ChatterClient(1).start();

//    	new ChatterClient(1).start();
//    	new ChatterClient(2).start();

    }
}