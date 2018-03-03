import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ն�
 * @author John Kwok
 *
 */
public class DataRecieveServer {
    static final int INPORT = 3000;//socket�˿ں�
    private byte[] buf = new byte[1024];//������Ϣ���Ĵ�С
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private DatagramSocket socket;

    public DataRecieveServer() {
		
        try {
            socket = new DatagramSocket(INPORT);
            System.out.println("Server started");
            while (true) {
                socket.receive(dp);
                /*
//                String rcvd = Dgram.toString(dp) + ",from address:"
//                        + dp.getAddress() + ",port:" + dp.getPort();
//                System.out.println("From Client:"+rcvd);
//                String[] b=Dgram.toString(dp).split(",");
//        		String s1=b[0];
//        		String s2=b[1];
//        		String s3=b[2];
                */
        		String receive = Dgram.toString(dp);
//        		System.out.print(":::"+receive+":::");
//        		receive = receive.substring(0,receive.length() - 1);//ȥ���ַ��������Ŀո�
                System.out.print(":::"+receive+":::\n");


                //写入文件
                try {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    File file = new File(System.getProperty("user.dir")+"/1.txt");

                    PrintStream ps = new PrintStream(new FileOutputStream(file));
                    //    ps.println("http://www.jb51.net");// 往文件里写入字符串
                    ps.append(df.format(new Date())+"数据内容\n"+receive);// 在已有的基础上添加字符串
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


//        		String devID = receive.substring(0,17);
//        		String time = receive.substring(17,23);
//        		String cellID = receive.substring(23,31);
        	
//        		System.out.println(devID);
//        		System.out.println(time);
//        		System.out.println(cellID);
//        		System.out.println(Dgram.toString(dp)+".");
        		
                String echoString = "反馈给发送端的数据。";//��������Ϣ
                DatagramPacket echo = Dgram.toDatagram(echoString,
                        dp.getAddress(), dp.getPort());
                
                socket.send(echo); //���ͷ�����Ϣ
                
                DBOperator dbo=new DBOperator();
                dbo.insertData(receive);//���ݿ�д��
            }
        } catch (SocketException e) {
            System.err.println("Can't open socket");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Communication error");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataRecieveServer();
    }
}