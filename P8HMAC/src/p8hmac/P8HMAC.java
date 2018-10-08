/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p8hmac;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Encoder;

/**
 *
 * @author antariksh
 */
public class P8HMAC {

    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[20];
        random.nextBytes(keyBytes);
        
        SecretKeySpec key = new SecretKeySpec(keyBytes, "HMACSHA1");
        
        System.out.println("Key: " + new BASE64Encoder().encode(key.getEncoded()));
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Input: ");
        String input = sc.nextLine();
        
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(key);
            mac.update(input.getBytes("UTF8"));
            byte[] result = mac.doFinal();
            System.out.println("MAC: " + new BASE64Encoder().encode(result));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
