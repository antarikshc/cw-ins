package p7md5hash;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author antariksh
 */
public class P7MD5Hash {
    
    // Global params
    static Scanner sc;

    public static void main(String[] args) {
        
        // Uncomment this for running Basic MD5 generation
        //generateMD5();
        
        sendMD5();
        recieveMD5();
    }
    
    private static void generateMD5() {
        
        
        sc = new Scanner(System.in);
        System.out.print("Enter Something: ");
        String str = sc.nextLine();
        String md5 = null;
        
        if (str == null) {
            System.out.println("Please provide string to create hash!");
        }
        
        try {
            // Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance("MD5");
            
            // Updaet str string in MessageDigest
            digest.update(str.getBytes(), 0, str.length());
            
            // Converts MessageDigest value in base16(hex)
            md5 = new BigInteger(1, digest.digest()).toString(16);
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Generated Message Digest: " + md5);
        
    }
    
    private static void sendMD5() {
        
        String input;
        byte buffer[] = new byte[1024];
        
        System.out.println("Enter the message to be sent: ");
        
        try {
            
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //input = reader.readLine();
            sc = new Scanner(System.in);
            input = sc.nextLine();
            
            FileOutputStream outputStream = new FileOutputStream("anx.txt");
            ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
            
            MessageDigest digest = MessageDigest.getInstance("MD5");
            buffer = input.getBytes();
            digest.update(buffer);
            
            objectStream.writeObject(input);
            objectStream.writeObject(digest.digest());
            System.out.println("Message sent successfully!");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private static void recieveMD5() {
        
        byte digest[] = new byte[1024];
        
        try {
            FileInputStream inputStream = new FileInputStream("anx.txt");
            ObjectInputStream objectStream = new ObjectInputStream(inputStream);
            
            Object obj = objectStream.readObject();
            String data = (String) obj;
            
            System.out.println("Received data: " + data);
            
            obj = objectStream.readObject();
            digest = (byte[]) obj;
            
            MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(data.getBytes());
            
            if (MessageDigest.isEqual(mDigest.digest(), digest)) {
                System.out.println("Message retrieved successfully!");
            } else {
                System.out.println("Message got corrupted!");
            }
            
            objectStream.close();
        } catch (StreamCorruptedException e) {
            System.out.println("Stream got corrupted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
