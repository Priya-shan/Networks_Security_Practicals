package security_practicals;

// Imports
import java.math.BigInteger;
import java.util.*;
import java.security.*;

import javax.xml.bind.DatatypeConverter;

public class Ex_12_Signature_Scheme {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Message :");
        String msg=sc.nextLine();
        byte[] input_bytes=msg.getBytes();
        
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair=keyPairGenerator.generateKeyPair();
        
        Signature signature=Signature.getInstance("SHA256withDSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(input_bytes);
        byte[] signature_bytes=signature.sign();
        BigInteger no = new BigInteger(1, signature_bytes);
        String signature_ganerated=no.toString(16);
        
        System.out.println("Signature generated : "+signature_ganerated);
        System.out.println("Verification : "+verify(input_bytes,keyPair.getPublic(),signature_bytes));
        
    }

    private static boolean verify(byte[] input_bytes, PublicKey key, byte[] signature_bytes) throws Exception{
        Signature signature=Signature.getInstance("SHA256withDSA");
        signature.initVerify(key);
        signature.update(input_bytes);
        return signature.verify(signature_bytes);
    }
}
