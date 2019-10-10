package modulos;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONObject;

public class Utilidades {

    public static String jsonConvertMapToJson(Map map) {
        return new JSONObject(map).toString();
    }

    public static Map jsonConvertJsonToMap(String json) {
        return new JSONObject(json).toMap();
    }

    public static String convertMD5(String s) throws NoSuchAlgorithmException {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

    public static String getMac() throws UnknownHostException, SocketException {
        byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
        String a = "";
        for (int i = 0; i < mac.length; i++) {
            a += String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
        }
        return a;
    }
}
