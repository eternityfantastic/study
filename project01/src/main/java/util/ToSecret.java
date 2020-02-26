package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ToSecret {
    public static final String salt = "我的盐值";

    public static String toSecret(String ps){
        return encrypted(ps);
    }

    private static String  encrypted(String password){
        try {
            password+=salt;

            MessageDigest mess = MessageDigest.getInstance("SHA-256");
            byte[] input = password.getBytes("UTF-8");
            byte[] output = mess.digest(input);

            StringBuilder sb= new StringBuilder();
            for(byte x :output){
                sb.append(String.format("%02x",x));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
