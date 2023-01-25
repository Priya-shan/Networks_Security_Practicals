/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_practicals;

import java.util.Scanner;
import javax.crypto.*;

/**
 *
 * @author Shanmuga Priya M
 */
public class Ex_07_DES {
    public static void main(String[] args) throws Exception{
        
        Scanner sc=new Scanner(System.in);
        String msg=sc.nextLine();
        byte[] input_bytes=msg.getBytes();
        
        KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
        SecretKey myDesKey=keyGenerator.generateKey();
        
        Cipher desCipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
        
        desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
        byte[] encryptedResult=desCipher.doFinal(input_bytes);
        
        System.out.println("Encrypted Text : "+new String(encryptedResult));
        
        desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
        byte[] decryptedResult=desCipher.doFinal(encryptedResult);
        
        System.out.println("Decrypted Text : "+new String(decryptedResult));
        
        
                
    }
}
