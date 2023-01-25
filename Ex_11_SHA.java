/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security_practicals;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 *
 * @author Shanmuga Priya M
 */
public class Ex_11_SHA {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String msg = sc.nextLine();
        byte[] input_bytes = msg.getBytes();

        MessageDigest md = MessageDigest.getInstance("SHA1");
        System.out.println("Algorithm=" + md.getAlgorithm());
        System.out.println("Provider=" + md.getProvider());

        md.update(input_bytes);
        byte[] result = md.digest();
        BigInteger num = new BigInteger(1, result);
        System.out.println(num.toString(16));

    }
}
