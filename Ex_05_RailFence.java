/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_practicals;

/**
 *
 * @author Shanmuga Priya M
 */
//if (row == 0) or (row == key - 1):
//            dir_down = not dir_down
//         
//        # fill the corresponding alphabet
//        rail[row][col] = text[i]
//        col += 1
//         
//        # find the next row using
//        # direction flag
//        if dir_down:
//            row += 1
//        else:
//            row -= 1
public class Ex_05_RailFence {
    public static void main(String[] args) {
        String text="geeksforgeeks";
        int key=3;
        int n=text.length();
        char[][] matrix=new char[key][text.length()];
        boolean dir_down=false;
        int row=0,col=0;
        for(int i=0;i<text.length();i++){
            if (row == 0 ){
                dir_down = true;
            }
            if(row==key-1){
                dir_down = false;
            }
		matrix[row][col] = text.charAt(i);
		col += 1;
		if (dir_down){
                    row += 1;
                }
                else{
                    row -= 1;
                }	
        }
        
        for(char[] i:matrix){
            for(char el:i){
                System.out.print(el+" ");
            }
            System.out.println();
        }
    }
}
