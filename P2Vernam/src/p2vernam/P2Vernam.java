package p2vernam;

import java.util.Scanner;

/**
 *
 * @author antariksh
 */
public class P2Vernam {

    public static void main(String[] args) {

        String input, key;
        String encryptedText = "", decryptedText = "";
        char t, k;
        int x;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text to encrypt: ");
        input = sc.nextLine();
        
        System.out.print("Enter one time password:  ");
        key = sc.nextLine();
        
        for (int i = 0; i < input.length(); i++) {
            t = input.charAt(i);
            k = key.charAt(i);
            x = t ^ k;
            encryptedText += (char) (x + 64);
        }
        System.out.println("Encryption text is: " + encryptedText);

        for (int i = 0; i < encryptedText.length(); i++) {
            t = encryptedText.charAt(i);
            k = key.charAt(i);
            x = t ^ k;
            decryptedText += (char) (x + 64);
        }
        System.out.println("Decrypted text is: " + decryptedText);

    }
}
