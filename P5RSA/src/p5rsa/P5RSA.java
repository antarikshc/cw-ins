package p5rsa;

import java.util.Scanner;

/**
 *
 * @author antariksh
 */
public class P5RSA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int p, q, n, z, d = 0, e, i;
        
        System.out.print("Enter the number to Encrypt and Decrypt: ");
        int msg = sc.nextInt();
        
        double c, msgBack;
        System.out.print("Enter Prime number P: ");
        p = sc.nextInt();
        
        System.out.print("Enter Prime number Q: ");
        q = sc.nextInt();
        
        n = p * q;
        z = (p - 1)*(q - 1);
        
        System.out.println("n = p * q: " + n);
        System.out.println("Phi(n) = (p-1) * (q-1): " + z);
        
        for (e = 2; e < z; e++) {
            // e is for Public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("Public Key(n, e) = (" + n + ", " + e + ")");
        
        for ( i = 0; i <=9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                // d is for Private key exponent
                d = x / e;
                break;
            }
        }
        
       System.out.println("Private key(n, d)= (" + n + ", " + d + ")");
       
       c = (Math.pow(msg, e)) % n;
       System.out.println("Encrypted Message: " + c);
       
       msgBack = (Math.pow(c, d)) % n;
       System.out.println("Decrypted Message: " + msgBack);
       
    }    
    static int gcd(int e, int z) {
    
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    
    }
    
}
