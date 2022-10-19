package fileio;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.UnsupportedEncodingException;

public class Intro {

    //encode a text
    public static String encodeString(String text)
            throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("UTF-8");
        String encodeString = Base64.encode(bytes);
        return encodeString;
    }

    //decode a etext
    public static String decodeString(String encodeText)
            throws UnsupportedEncodingException {
        byte[] decodeBytes = Base64.decode(encodeText);
        String str = new String(decodeBytes, "UTF-8");
        return str;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //Decoding Example
        int values[] = {120, 105, 110, 32, 99, 104, -61, -96, 111};
        byte[] bytes = new byte[values.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) values[i];
        }
        System.out.println(new String(bytes, "utf8"));

        //test encode and decode
        System.out.println("Test encode and decode");
        String text = "Example Vietnamese text - Tiếng Việt";
        byte[]bytes2=text.getBytes();
        System.out.println("Hien thi bytes2");
        for (int i = 0; i < bytes2.length; i++) {
            System.out.print(bytes2[i]);
        }
        System.out.println("\nText before encode: " + text);

        String encodeText = encodeString(text);
        System.out.println("Encode text: " + encodeText);

        String decodeText = decodeString(encodeText);
        System.out.println("Decode text: " + decodeText);
    }

}
