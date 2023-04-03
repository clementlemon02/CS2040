/**
 * Name :Clement Ling Yeu Jye:
 * Matric. No : A0245782W
 */

import java.util.*;
import java.io.*;
public class SpiralSnake {
    public static void main(String args[]) throws IOException {
        Kattio io = new Kattio(System.in);
        int row = io.getInt();
        int col = io.getInt();
        String [] arr = new String[row];
        for (int i=0; i<row;i++){
            arr[i] = io.getWord();
        }
        /* char [][] arr = new char[row][col];
        sc.nextLine();
        String matrix = io.getWord();
        for (int i=0; i<row; i++){
        for(int j=0; j<col; j++){
        int idx = i * col +j;
        arr[i][j] =matrix.charAt(idx);
        }
        }*/
        int up = 0, down = row - 1, left = 0, right = col - 1;
        int dir =1,step = 1,nrow = 0, ncol = 0;
        for (int i=0; i<(row*col);i++) {

            if(arr[nrow].charAt(ncol)!='.'){
                io.println("Apple at ("+ ncol +", "+ nrow + ") eaten at step " + step);
            }
            if (dir==1 &&(left<= right)){
                if (ncol == right){
                    up++;
                    nrow++;
                    dir=2;
                }
                else{
                    ncol++;
                }
            } else if (dir == 2 && (up<=down)){
                if (nrow == down){
                    ncol--;
                    right--;
                    dir=3;
                }
                else{
                    nrow++;
                }
            }
            else if(dir==3 && (left<=right)){
                if(ncol ==left){
                    nrow--;
                    down--;
                    dir = 4;
                }
                else{
                    ncol--;
                }
            }else if (dir== 4  && (up <= down)){
                if (nrow == up){
                    ncol++;
                    left++;
                    dir = 1;
                }
                else{
                    nrow--;
                }

            }
            step++;
        }
        io.close();
    }
}


















    /* int up = 0, down = row - 1, left = 0, right = col - 1;
       int dir =1,step = 0;
       while (up<= down && left<= right){

       if (dir ==1){
       for (int i = left; i <=right; i++){
       step+=1;
       if (arr[up][i] == '.'){
       continue;
       }
       else{
       io.println("Apple at " +'('+up+','+i+')' + " eaten at step " + step);
       }
       }
       ++up;
       dir =2;
       }
       else if (dir ==2){
       for (int i = up; i<= down; i++){
       step+=1;

       if (arr[i][right] == '.'){
       continue;
       }
       else{
       io.println("Apple at " +'('+i+','+right+')' + " eaten at step " + step);
       }
       }
       --right;
       dir = 3;
       }
       else if (dir ==3){
       for(int i = right; i>= left; i--){
       step+=1;
       if (arr[down][i] == '.'){
       continue;
       }
       else{
       io.println("Apple at " + '('+down+','+i+')' + " eaten at step " + step);
       }
       }
       --down;
       dir=4;
       }
       else{
       for(int i = down; i>= up; i--){
       step+=1;
       if (arr[i][left] == '.'){
       continue;
       }
       else{
       io.println("Apple at " + '('+i+','+left+')' + " eaten at step " + step);
       }
       }
       ++left;
       dir =1;*/
