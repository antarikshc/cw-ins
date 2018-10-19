package p4ades;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author antariksh
 */
public class P4ADES {

    Cipher enCipher;
    Cipher deCipher;
    
    public P4ADES(SecretKey key) {
        try {
            enCipher = Cipher.getInstance("DES");
            enCipher.init(Cipher.ENCRYPT_MODE, key);
            deCipher = Cipher.getInstance("DES");
            deCipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {

        System.out.print("Input for encryption: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            SecretKey key = KeyGenerator.getInstance("DES").generateKey();
            P4ADES encrypter = new P4ADES(key);
            String encrypted = encrypter.encrypt(input);
            String decrypted = encrypter.decrypt(encrypted);

            System.out.println("Original String was:" + input);
            System.out.println("Encrypted String is : " + encrypted);
            System.out.println("Decrypted String is : " + decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String encrypt(String str) {

        try {
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = enCipher.doFinal(utf8);
            return new sun.misc.BASE64Encoder().encode(enc);

        } catch (Exception e) {
        }
        return null;

    }

    public String decrypt(String str) {
        try {
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
            byte[] utf8 = deCipher.doFinal(dec);
            return new String(utf8, "UTF8");

        } catch (Exception e) {
        }
        return null;
    }

}
