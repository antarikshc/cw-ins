package p1monoalpha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author antariksh
 */
public class P1MonoAlpha {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Input Text: ");
        String inputStr = sc.nextLine();
        
        String lowerAlphabets = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        ArrayList<Integer> permutation = new ArrayList();
        for (int i = 0; i < lowerAlphabets.length(); i++) {
            permutation.add(i);
        }
        Collections.shuffle(permutation);
        
        String lowerKey = "", upperKey = "";
        
        for (int j = 0; j < upperAlphabets.length(); j++) {
            
            lowerKey += lowerAlphabets.charAt(permutation.get(j));
            upperKey += upperAlphabets.charAt(permutation.get(j));
                    
        }
        String cipherText = "";
        int i, j;
        
        // Encryption
        for (i = 0; i < inputStr.length(); i++) {
            for (j = 0; j < lowerAlphabets.length(); j++) {
                
                if (inputStr.charAt(i) == lowerAlphabets.charAt(j)) {
                    cipherText += lowerKey.charAt(j);
                    break;
                }
                
                if (inputStr.charAt(i) == upperAlphabets.charAt(j)) {
                    cipherText += upperKey.charAt(j);
                    break;
                }
                
            }
            if (j == upperAlphabets.length())
                cipherText += inputStr.charAt(i);
        }
        
        // Decryption
        String decryptText = "";
        i = 0; j = 0;
        
        for (i = 0; i < cipherText.length(); i++) {
            for (j = 0; j < lowerKey.length(); j++) {
                
                if (cipherText.charAt(i) == lowerKey.charAt(j)) {
                    
                    decryptText += lowerAlphabets.charAt(j);
                    break;
                    
                }
                
                if (cipherText.charAt(i) == upperKey.charAt(j)) {
                    
                    decryptText += upperAlphabets.charAt(j);
                    break;
                    
                }
                
            }
            
            if ( j == upperKey.length())
                decryptText += cipherText.charAt(j);
        }
        
        System.out.println("Mono Aplhabetic Cipher [ ENCRYPTION ] ");
        System.out.println("Input Text is: " + inputStr);
        System.out.println("Upper Key: " + upperKey);
        System.out.println("Lower Key: " + lowerKey);
        System.out.println("Encrypted Text: " + cipherText);
        System.out.println("Decrypted Text: " + decryptText);
        
    }
    
}
