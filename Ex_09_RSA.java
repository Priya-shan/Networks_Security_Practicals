/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_practicals;

import java.math.*;

/**
 *
 * @author Shanmuga Priya M
 */
public class Ex_09_RSA {
    public static void main(String[] args) {
        int p=7,q=11;
        int e=7;
        int d=find_d(60,7);
        int n=77;
//        int cipher=(int)Math.pow(8, e)%77;
        double cipher = (Math.pow(8, e)) % 77;
        
        BigInteger big_n=BigInteger.valueOf(n);
        BigInteger big_cipher=BigDecimal.valueOf(cipher).toBigInteger();
        BigInteger decrypt=big_cipher.pow(d).mod(big_n);
        
        
        System.out.println("cipher : "+(int)cipher+" plain : "+decrypt);
    }
    
    private static int find_d(int siN,int e) {
        int i=1;
        while(i>0){
            int temp=(siN*i)+1;
            if(temp%e==0){
                return temp/e;
            }
            i++;
        }
        return -1;
    }
}
