/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3arailfence;

import java.util.Scanner;

/**
 *
 * @author antariksh
 */
public class P3ARailFence {

    public static void main(String[] args)throws Exception {

        RailFenceBasic railFence = new RailFenceBasic();
        
        Scanner sc = new Scanner(System.in);
        int depth;
        String plainText, cipherText, decryptedText;
        System.out.print("Enter plain text: ");
        plainText = sc.nextLine();
        
        System.out.print("Enter depth for Encryption: ");
        depth = sc.nextInt();
        
        cipherText = railFence.encryption(plainText, depth);
        System.out.println("Encrypted Text is: " + cipherText);
        
        decryptedText = railFence.decryption(cipherText, depth);
        System.out.println("Encrypted Text is: " + decryptedText);
        
    }
    
}

class RailFenceBasic {
    
    int depth;
    
    String encryption(String plainText, int depth) throws Exception {
        
        int r = depth, len = plainText.length();
        int c = len / depth;
        char mat[][] = new char[r][c];
        int k = 0;
        
        String cipherText = "";
        for (int i = 0; i < c; i++) {
            
            for (int j = 0; j < r; j++) {
                
                if (k != len) {
                    mat[j][i] = plainText.charAt(k++);
                } else {
                    mat[j][i] = 'X';
                }
                
            }
            
        }
        for (int i = 0; i < r; i++) {
            
            for (int j = 0; j < c; j++) {
                
                cipherText += mat[i][j];
                
            }
            
        }
        return cipherText;
    }
    
    String decryption(String cipherText, int depth) throws Exception {
        
        int r = depth, len = cipherText.length();
        int c = len / depth;
        char mat[][] = new char[r][c];
        int k = 0;
        String plainText="";
        
        
        for (int i = 0; i < r; i++) {
           
            for (int j = 0; j < c; j++) {
                
                mat[i][j] = cipherText.charAt(k++);
                
            }
            
        }
        
        
        for (int i = 0; i < c; i++) {
            
            for (int j = 0; j < r; j++) {
                
                plainText += mat[j][i];
                
            }
            
        }
        return plainText;
        
    }
    
}
