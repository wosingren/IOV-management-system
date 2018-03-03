import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ݿ����������
 *
 * @author John Kwok
 */
public class DBOperator {

    public void insertTable(String carId, String LON, String LAT) {
        // ����SQL���
        String sql = "insert into car_info (devID,time,cellID)values (?,?,?)";
        // ���ݿ����ӹ�����
        DBUtil util = new DBUtil();
        // �������
        Connection conn = util.openConnection();
        try {
            conn.setAutoCommit(false);
            // ���Ԥ�������
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, carId);
            pstmt.setString(2, LON);
            int cellID = Integer.parseInt(LAT);
            pstmt.setInt(3, cellID);
            System.out.print(carId + " " + LON + " " + LAT);
            // ����
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            util.closeConn(conn);
        }
    }

    public void insertData(String receive) throws Exception {
        String devID, time, state, GPS_longitude, GPS_latitude, cellID, carNum, warn, info1_devID, info1_FP, info1_RP, info1_time, info1_state, info1_longitude, info1_latitude, info1_cellID, info1_carNum, info2_devID, info2_FP, info2_RP, info2_time, info2_state, info2_longitude, info2_latitude, info2_cellID, info2_carNum;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
        System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
        df.format(new Date()).toString();

        if (receive.length() == 55) {// ��INFO��Ϣ
            devID = receive.substring(0, 17);
            time = df.format(new Date()).toString() + " " + receive.substring(17, 19) + ":" + receive.substring(19, 21) + ":" + receive.substring(21, 23);
            System.out.println(time);
            state = receive.substring(23, 24);
            GPS_longitude = receive.substring(24, 27) + "." + receive.substring(27, 33);
            GPS_latitude = receive.substring(33, 35) + "." + receive.substring(35, 41);

            //纠偏
            LatLng latLng = new LatLng(GPS_longitude, GPS_latitude);
            latLng = HttpClient.GPSConvert(latLng);
            GPS_longitude = latLng.longitude + "";
            GPS_latitude = latLng.latitude + "";
            printGPS(latLng);//输出

            cellID = receive.substring(41, 49);
            carNum = receive.substring(49, 54);
            warn = receive.substring(54, 55);

            // ���ݿ����ӹ�����
            DBUtil util = new DBUtil();
            // �������
            Connection conn = util.openConnection();

            insertNewData(devID, time, state, GPS_longitude, GPS_latitude,
                    cellID, carNum, warn, conn, util);
            util.closeConn(conn);
        } else if (receive.length() == (55 + 58)) {// ����һ������INFO��Ϣ

            devID = receive.substring(0, 17);
//			time = receive.substring(17, 23);
            time = df.format(new Date()).toString() + " " + receive.substring(17, 19) + ":" + receive.substring(19, 21) + ":" + receive.substring(21, 23);
            state = receive.substring(23, 24);
            GPS_longitude = receive.substring(24, 27) + "." + receive.substring(27, 33);
            GPS_latitude = receive.substring(33, 35) + "." + receive.substring(35, 41);

            //纠偏
            LatLng latLng = new LatLng(GPS_longitude, GPS_latitude);
            latLng = HttpClient.GPSConvert(latLng);
            GPS_longitude = latLng.longitude + "";
            GPS_latitude = latLng.latitude + "";
            printGPS(latLng);//输出

            cellID = receive.substring(41, 49);
            carNum = receive.substring(49, 54);
            warn = receive.substring(54, 55);
            info1_devID = receive.substring(55, 72);
            info1_FP = receive.substring(72, 74);
            info1_RP = receive.substring(74, 76);
//			info1_time = receive.substring(76, 82);
            info1_time = df.format(new Date()).toString() + " " + receive.substring(76, 78) + ":" + receive.substring(78, 80) + ":" + receive.substring(80, 82);
            info1_state = receive.substring(82, 83);
            info1_longitude = receive.substring(83, 86) + "." + receive.substring(86, 92);
            info1_latitude = receive.substring(92, 94) + "." + receive.substring(94, 100);

            //纠偏
            latLng = new LatLng(GPS_longitude, GPS_latitude);
            latLng = HttpClient.GPSConvert(latLng);
            GPS_longitude = latLng.longitude + "";
            GPS_latitude = latLng.latitude + "";
            printGPS(latLng);//输出

            info1_cellID = receive.substring(100, 108);
            info1_carNum = receive.substring(108, 113);
            // ����SQL���
            String sql = "insert into car_info (devID,time,state,GPS_longitude,GPS_latitude,cellID,carNum,warn,info1_devID,"
                    + "info1_FP,info1_RP,info1_time,info1_state,info1_longitude,info1_latitude,info1_cellID,info1_carNum)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // ���ݿ����ӹ�����

            DBUtil util = new DBUtil();
            // �������
            Connection conn = util.openConnection();
            try {
                conn.setAutoCommit(false);
                // ���Ԥ�������
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, devID);
                pstmt.setString(2, time);
                pstmt.setString(3, state);
                pstmt.setString(4, GPS_longitude);
                pstmt.setString(5, GPS_latitude);
                pstmt.setString(6, cellID);
                pstmt.setString(7, carNum);
                pstmt.setString(8, warn);
                pstmt.setString(9, info1_devID);
                pstmt.setString(10, info1_FP);
                pstmt.setString(11, info1_RP);
                pstmt.setString(12, info1_time);
                pstmt.setString(13, info1_state);
                pstmt.setString(14, info1_longitude);
                pstmt.setString(15, info1_latitude);
                pstmt.setString(16, info1_cellID);
                pstmt.setString(17, info1_carNum);
                pstmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } finally {
                insertNewData(info1_devID, info1_time, info1_state,
                        info1_longitude, info1_latitude, info1_cellID,
                        info1_carNum, null, conn, util);
                util.closeConn(conn);
            }

        } else if (receive.length() == (55 + 58 + 58)) {// ������������INFO��Ϣ

            devID = receive.substring(0, 17);
            time = df.format(new Date()).toString() + " " + receive.substring(17, 19) + ":" + receive.substring(19, 21) + ":" + receive.substring(21, 23);
            state = receive.substring(23, 24);
            GPS_longitude = receive.substring(24, 27) + "." + receive.substring(27, 33);
            GPS_latitude = receive.substring(33, 35) + "." + receive.substring(35, 41);

            //纠偏
            LatLng latLng = new LatLng(GPS_longitude, GPS_latitude);
            latLng = HttpClient.GPSConvert(latLng);
            GPS_longitude = latLng.longitude + "";
            GPS_latitude = latLng.latitude + "";
            printGPS(latLng);//输出

            cellID = receive.substring(41, 49);
            carNum = receive.substring(49, 54);
            warn = receive.substring(54, 55);
            info1_devID = receive.substring(55, 72);
            info1_FP = receive.substring(72, 74);
            info1_RP = receive.substring(74, 76);
            info1_time = df.format(new Date()).toString() + " " + receive.substring(76, 78) + ":" + receive.substring(78, 80) + ":" + receive.substring(80, 82);
            info1_state = receive.substring(82, 83);
            info1_longitude = receive.substring(83, 86) + "." + receive.substring(86, 92);
            info1_latitude = receive.substring(92, 94) + "." + receive.substring(94, 100);

            //纠偏
            latLng = new LatLng(GPS_longitude, GPS_latitude);
            latLng = HttpClient.GPSConvert(latLng);
            GPS_longitude = latLng.longitude + "";
            GPS_latitude = latLng.latitude + "";
            printGPS(latLng);//输出

            info1_cellID = receive.substring(100, 108);
            info1_carNum = receive.substring(108, 113);
            info2_devID = receive.substring(113, 130);
            info2_FP = receive.substring(130, 132);
            info2_RP = receive.substring(132, 134);
            info2_time = df.format(new Date()).toString() + " " + receive.substring(134, 136) + ":" + receive.substring(136, 138) + ":" + receive.substring(138, 140);
            info2_state = receive.substring(140, 141);
            info2_longitude = receive.substring(141, 144) + "." + receive.substring(144, 150);
            info2_latitude = receive.substring(150, 152) + "." + receive.substring(152, 158);

            //纠偏
            latLng = new LatLng(GPS_longitude, GPS_latitude);
            latLng = HttpClient.GPSConvert(latLng);
            GPS_longitude = latLng.longitude + "";
            GPS_latitude = latLng.latitude + "";
            printGPS(latLng);//输出

            info2_cellID = receive.substring(158, 166);
            info2_carNum = receive.substring(166, 171);

            // ����SQL���
            String sql = "insert into car_info (devID,time,state,GPS_longitude,GPS_latitude,cellID,carNum,warn,info1_devID,"
                    + "info1_FP,info1_RP,info1_time,info1_state,info1_longitude,info1_latitude,info1_cellID,info1_carNum,info2_devID, info2_FP, info2_RP, info2_time, info2_state, info2_longitude, info2_latitude, info2_cellID, info2_carNum)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            // ���ݿ����ӹ�����
            DBUtil util = new DBUtil();
            // �������
            Connection conn = util.openConnection();
            try {
                conn.setAutoCommit(false);
                // ���Ԥ�������
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, devID);
                pstmt.setString(2, time);
                pstmt.setString(3, state);
                pstmt.setString(4, GPS_longitude);
                pstmt.setString(5, GPS_latitude);
                pstmt.setString(6, cellID);
                pstmt.setString(7, carNum);
                pstmt.setString(8, warn);
                pstmt.setString(9, info1_devID);
                pstmt.setString(10, info1_FP);
                pstmt.setString(11, info1_RP);
                pstmt.setString(12, info1_time);
                pstmt.setString(13, info1_state);
                pstmt.setString(14, info1_longitude);
                pstmt.setString(15, info1_latitude);
                pstmt.setString(16, info1_cellID);
                pstmt.setString(17, info1_carNum);
                pstmt.setString(18, info2_devID);
                pstmt.setString(19, info2_FP);
                pstmt.setString(20, info2_RP);
                pstmt.setString(21, info2_time);
                pstmt.setString(22, info2_state);
                pstmt.setString(23, info2_longitude);
                pstmt.setString(24, info2_latitude);
                pstmt.setString(25, info2_cellID);
                pstmt.setString(26, info2_carNum);
                pstmt.executeUpdate();
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } finally {
                //��INFO�����µ���Ŀ��
                insertNewData(info1_devID, info1_time, info1_state,
                        info1_longitude, info1_latitude, info1_cellID,
                        info1_carNum, null, conn, util);
                insertNewData(info2_devID, info2_time, info2_state,
                        info2_longitude, info2_latitude, info2_cellID,
                        info2_carNum, null, conn, util);

                util.closeConn(conn);
            }

        }

    }

    private void insertNewData(String devID, String time, String state,
                               String gPS_longitude, String gPS_latitude, String cellID,
                               String carNum, String warn, Connection conn, DBUtil util) {
        // ����SQL���
        String sql = "insert into car_info (devID,time,state,GPS_longitude,GPS_latitude,cellID,carNum,warn)values (?,?,?,?,?,?,?,?)";

        try {
            conn.setAutoCommit(false);
            // ���Ԥ�������
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, devID);
            pstmt.setString(2, time);
            pstmt.setString(3, state);
            pstmt.setString(4, gPS_longitude);
            pstmt.setString(5, gPS_latitude);
            pstmt.setString(6, cellID);
            pstmt.setString(7, carNum);
            pstmt.setString(8, warn);

            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            // util.closeConn(conn);
        }

    }

    private void printGPS(LatLng latLng) {
        System.out.print("经度：" + latLng.longitude + "\n纬度：" + latLng.latitude);
    }

}
