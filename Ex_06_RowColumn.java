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
public class Ex_06_RowColumn {
    public static void main(String[] args) {
        String text="Geeks for Geeks";
        String key="hack";
        ArrayList<Character> temp;
        ArrayList<Character> res=new ArrayList<>();
        HashMap<Character,ArrayList<Character>> hmap=new HashMap<>();
        int idx=0;
        for(int i=0;i<text.length();i++){
            if(!hmap.containsKey(key.charAt(idx))){
                hmap.put(key.charAt(idx), new ArrayList<Character>());
            }
            hmap.get(key.charAt(idx)).add(text.charAt(i));
            idx++;
            if(idx>key.length()-1){
                idx=0;
            }
        }
        char[] carr=key.toCharArray();
        Arrays.sort(carr);
        for(char ch:carr){
            temp=hmap.get(ch);
            res.addAll(temp);
        }
        System.out.println(res);
    }
}
