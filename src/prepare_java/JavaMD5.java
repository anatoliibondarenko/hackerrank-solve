package prepare_java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte[] bytes = md.digest();

            for(byte b : bytes){
                System.out.printf("%02x",b);
            }
            System.out.println();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}