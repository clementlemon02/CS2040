/**
 * Name : Clement Ling Yeu Jye:
 * Matric. No : A0245782W
 */

import java.util.*;
public class SquaringArray {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n*n];
        int[] newarray = new int[n];
        for (int a = 0; a<n; a++){
            array[a] = sc.nextInt();
        }
        int check = 1;
        while (check < n){
            if (check % 2 != 0){
                for (int i = 0; i<n; i++){
                    array[i+(check*n)] = array[n-i-1+(check-1)*n] + array[n-i-1];
                }
            }
            else{
                for(int i = 0; i<n; i++){
                    array[i+(check*n)] = array[n-i-1+(check-1)*n] + array[i];
                }
            }
            check += 1;
        }
        /*for (int i = 0;i<n;i++){
          if(i%2 == 0){
          newarray = newarray.addall(array*i);
          }
          else{
          newarray = newarray.addall((Collections.reverse(array))*i);
          }
          System.out.println(newarray);*/
        for (int i = 0; i < n*n-1; i++){
            System.out.print(array[i] + " ");
        }
        System.out.print(array[n*n-1]+"\n");
        }
    }
