import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * Socket辅助类
 * @author John Kwok
 *
 */
public class Dgram {

    @SuppressWarnings("deprecation")
    public static DatagramPacket toDatagram(String s, InetAddress destIA,
                                            int destPort) {
        byte[] buf = new byte[s.length() + 1];
        s.getBytes(0, s.length(), buf, 0);
        return new DatagramPacket(buf, buf.length, destIA, destPort);
    }

    public static String toString(DatagramPacket p) {
        return new String(p.getData(), 0, p.getLength());
    }
}