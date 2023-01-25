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
public class Ex_10_Diffie {
    public static void main(String[] args) {
        int p=11;
        int alpha=2;
        int xa=9;
        int xb=4;
        int ya,yb,ka,kb;
        
        ya=(int)(Math.pow(alpha, xa)%p);
        yb=(int)(Math.pow(alpha, xb)%p);
        
        ka=(int)(Math.pow(yb,xa)%p);
        kb=(int)(Math.pow(ya, xb)%p);
        
        System.out.println(ya+" "+yb+" "+ka+" "+kb);
    }
}
