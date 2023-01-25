/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_practicals;

import java.util.*;

/**
 *
 * @author Shanmuga Priya M
 */
public class Ex_03_HillCipher {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String txt="PAY";
        int[][] key=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                key[i][j]=sc.nextInt();
            }
        }
        for(int[] i:key){
            for(int el:i){
                System.out.print(el+" ");
            }
            System.out.println();
        }
        HashMap<Character,Integer> hmap1=new HashMap<>();
        HashMap<Integer,Character> hmap2=new HashMap<>();
        
        int idx=0;
        for(int i=65;i<=90;i++){
            hmap1.put((char)i,idx);
            hmap2.put(idx, (char)i);
            idx++;
        }
        System.out.println(hmap1);
        System.out.println(hmap2);
        String temp;
        String res="";
        for(int start=0;start<=txt.length()-3;start=start+3){
            int end=start+3;
            temp=txt.substring(start,end);
            res+=hill(temp,hmap1,hmap2,key);
        }
        System.out.println(res);
    }
    public static String hill(String temp,HashMap<Character,Integer> hmap1,HashMap<Integer,Character> hmap2,int[][] key){
        int sum=0;
        String res="";
        for(int i=0;i<3;i++){
            sum=0;
            for(int j=0;j<3;j++){
                char ch=temp.charAt(j);
                int loc=hmap1.get(ch);
                sum+=loc*key[i][j];
            }
            sum=sum%26;
            res+=hmap2.get(sum);
        }
        return res;
    }
}
