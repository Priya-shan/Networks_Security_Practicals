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
public class Ex_04_Vigenere {
    public static void main(String[] args) {
        char[][] matrix=new char[26][26];
        int ascii=65;
        for(int row=0;row<26;row++){
            for(int col=0;col<26;col++){
                if(ascii>90){
                    ascii=ascii-26;
                }
                matrix[row][col]=(char)ascii;
                ascii++;
            }
            ascii++;
        }
        for(char[] i:matrix){
            for(char el:i){
                System.out.print(el+" ");
            }
            System.out.println();
        }
        
        HashMap<Character,Integer> hmap=new HashMap<>();
        int idx=0;
        for(int i=65;i<=90;i++){
            hmap.put((char)i, idx);
            idx++;
        }
        System.out.println(hmap);
        String txt="GEEKSFORGEEKS";
        String key="AYUSHAYUSHAYU";
        
        String cipher="";
        for(int i=0;i<txt.length();i++){
            cipher+=matrix[hmap.get(key.charAt(i))][hmap.get(txt.charAt(i))];
        }
        System.out.println(cipher);
    }
}
