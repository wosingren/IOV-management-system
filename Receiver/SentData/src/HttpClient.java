/**
 * Created by John Kwok on 2017/2/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    //发送一个GET请求
    public static String get(String path) throws Exception {
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        try {
            URL url = new URL(path);
            httpConn = (HttpURLConnection) url.openConnection();

            //读取响应
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuffer content = new StringBuffer();
                String tempStr = "";
                in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while ((tempStr = in.readLine()) != null) {
                    content.append(tempStr);
                }
                return content.toString();
            } else {
                throw new Exception("请求出现了问题!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            httpConn.disconnect();
        }
        return null;
    }

    //发送一个GET请求,参数形式key1=value1&key2=value2...
    public static String post(String path, String params) throws Exception {
        HttpURLConnection httpConn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            URL url = new URL(path);
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);

            //发送post请求参数
            out = new PrintWriter(httpConn.getOutputStream());
            out.println(params);
            out.flush();

            //读取响应
            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuffer content = new StringBuffer();
                String tempStr = "";
                in = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while ((tempStr = in.readLine()) != null) {
                    content.append(tempStr);
                }
                return content.toString();
            } else {
                throw new Exception("请求出现了问题!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
            httpConn.disconnect();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
//        String resMessage = HttpClient.get("http://restapi.amap.com/v3/assistant/coordinate/convert?locations=116.312500,39.947500&coordsys=gps&key=93d76e3a2b02e951a85989a0f2608f98");
////        String resMessage = HttpClient.post("http://localhost:3000/hello", "hello=hello post");
//        String res[] = resMessage.split("locations");
//        String res1[] = res[1].split("\"");
//        System.out.println(res1[2]);
        LatLng latLng = new LatLng("116.312500", "39.947500");
        latLng = GPSConvert(latLng);
        printGPS(latLng);
    }

    public static LatLng GPSConvert(LatLng latLng) throws Exception {
        String resMessage = HttpClient.get("http://restapi.amap.com/v3/assistant/coordinate/convert?locations="
                + latLng.longitude + "," + latLng.latitude + "&coordsys=gps&key=93d76e3a2b02e951a85989a0f2608f98");
        System.out.println(resMessage + "\n");
        String res[] = resMessage.split("locations");
        String res1[] = res[1].split("\"");
        System.out.println(res1[2] + "\n");
        String GPS[] = res1[2].split(",");
        latLng = new LatLng(GPS[0], GPS[1]);
        return latLng;
    }

    private static void printGPS(LatLng latLng) {
        System.out.print("经度：" + latLng.longitude + "\n纬度：" + latLng.latitude);
    }

}

