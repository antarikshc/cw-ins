package p4baes;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author antariksh
 */
public class P4BAES {

    Cipher enCipher;
    Cipher deCipher;

    public P4BAES(SecretKey key) {
        try {
            enCipher = Cipher.getInstance("AES");
            enCipher.init(Cipher.ENCRYPT_MODE, key);
            deCipher = Cipher.getInstance("AES");
            deCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            System.out.println("Exception occured: " + e);
        }
    }

    public String encrypt(String str) {
        try {
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = enCipher.doFinal(utf8);
            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (Exception e) {
            System.out.println("Exception occured: " + e);
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
            byte[] utf8 = deCipher.doFinal(dec);
            return new String(utf8, "UTF8");
        } catch (Exception e) {
            System.out.println("Exception occur:" + e);
        }
        return null;
    }

    public static void main(String[] args) {

        try {
            System.out.println("\n\t=========AES================\n");
            SecretKey key = KeyGenerator.getInstance("AES").generateKey();
            P4BAES aes = new P4BAES(key);

            System.out.print("\tEnter the string to encrypted: ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String encrypt = aes.encrypt(input);
            String decrypt = aes.decrypt(encrypt);

            System.out.println("\n\tOriginal String is: " + input);
            System.out.println("\tEncrypted String is : " + encrypt);
            System.out.println("\tDecrypted String is : " + decrypt);
        } catch (Exception e) {
            System.out.println("Exception occur:" + e);
        }

    }

}
