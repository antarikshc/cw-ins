package p2vernam;

import java.util.Scanner;

/**
 *
 * @author antariksh
 */
public class P2Vernam {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Plaintext: ");
        String plainText = sc.nextLine();
        System.out.print("Enter Cipher Key: ");
        String cipherKey = sc.nextLine();
        
        String cipherText = encryptText(plainText, cipherKey);
        System.out.println("Cipher Text is: " + cipherText);
        
        String decryptedText = decryptText(cipherText, cipherKey);
        System.out.println("Plain Text is: " + decryptedText);
        
       
    }
    
    private static String encryptText(String plainText, String cipherKey) {
        
        char[] textChar = plainText.toCharArray();
        char[] keyChar = cipherKey.toCharArray();
        
        char[] cipher = new char[textChar.length];
        String returnString = "";
        for (int i = 0; i < textChar.length; i++) {
            
            cipher[i] = (char) (textChar[i] ^ keyChar[i]);
            int temp = (int) cipher[i];
            System.out.println(temp+50);
            System.out.println(Character.toString((char) (temp+26)));
            returnString += cipher[i];
            
        }
        
        return returnString;
        
        
    }

    private static String decryptText(String cipherText, String cipherKey) {
        
        char[] textChar = cipherText.toCharArray();
        char[] keyChar = cipherKey.toCharArray();
        
        char[] cipher = new char[textChar.length];
        String returnString = "";
        for (int i = 0; i < textChar.length; i++) {
            
            cipher[i] = (char) (textChar[i] ^ keyChar[i]);
            returnString += cipher[i];
            
        }
        
        return returnString;
        
    }
    
}
