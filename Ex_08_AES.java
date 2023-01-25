/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_practicals;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.*;

/**
 *
 * @author Shanmuga Priya M
 */
public class Ex_08_AES {

    
    static SecretKeySpec secretKey=null;
    static byte[] key;
    public static void main(String[] args)throws Exception {
        final String Key="annaUniv";
        String msg="annauniv.edu";
        
        String encryptedText=encrypt(Key,msg);
        String DecryptedText=decrypt(Key,encryptedText);
        
        System.out.println("Encrypted text : "+encryptedText);
        System.out.println("Decrypted text : "+DecryptedText);
        
    }
    private static String encrypt(String Key, String msg) throws Exception{
        setKey(Key);
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        
        return Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes("UTF-8")));
        
        
    }

    private static String decrypt(String Key, String encryptedText) throws Exception{
        setKey(Key);
        Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedText)));
    }
    
    private static void setKey(String Key) throws Exception{
        key=Key.getBytes();
        MessageDigest sha=MessageDigest.getInstance("SHA1");
        key=sha.digest(key);
        key=Arrays.copyOf(key, 16);
        secretKey=new SecretKeySpec(key,"AES");
    }
}
