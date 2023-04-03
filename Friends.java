/**
 * Name: Clement Ling Yeu Jye
 * Matric. No: A0245782W
 */

import java.util.*;
public class Friends {
    public static int  maxFriends(Kattio io,String cafeName,int visitorNo,long timeLimit){
        long[] customersIn = new long[visitorNo];
        long[] customersOut = new long[visitorNo];
        int friends = 0 ;
        int maxFriends = 0;
        int ii = 0;
        int jj = 0;

        for (int i=0;i<visitorNo;i++){
            long timeIn = io.getLong();
            long timeOut = io.getLong();
            if (timeLimit>0){
                if (timeIn <= timeLimit){
                    timeIn = 0;
                }else{
                    timeIn-=timeLimit;
                }
            }
            customersIn[i]=timeIn;
            customersOut[i]=timeOut;
        }
        //io.println(visitorNo);
        //io.println(Arrays.toString(customersIn));
        Arrays.sort(customersIn);
        //io.println(Arrays.toString(customersIn));
        Arrays.sort(customersOut);
        //io.println(Arrays.toString(customersOut));
        while (ii<visitorNo && jj<visitorNo){
            if (customersIn[ii] <= customersOut[jj]){
                friends++;
                if (friends > maxFriends){
                    maxFriends = friends;
                }
                ii++;
            }else{
                friends--;
                jj++;
            }
        }
        return maxFriends;
    }

    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        int cafeNumber = io.getInt();
        long timeLimit = io.getLong();
        int maxMaxFriends = 0;
        int tryMax = 0;
        int arrNum = 0;
        int totalMaxCafe = 1;
        String[] cafeArr = new String[cafeNumber];
        String maxCafeName = " ";
        for (int i=0;i< cafeNumber;i++){
            String cafeName = io.getWord();
            int visitorNo = io.getInt();
            //maxFriends(io,cafeName,visitorNo,timeLimit);
            tryMax = maxFriends(io,cafeName,visitorNo,timeLimit);
            if (tryMax > maxMaxFriends){
                arrNum = 0;
                totalMaxCafe = 1;
                cafeArr = new String [cafeNumber];
                maxMaxFriends = tryMax;
                maxCafeName = cafeName;
                cafeArr[arrNum] = maxCafeName; 
            }else if (tryMax == maxMaxFriends){
                arrNum++;
                totalMaxCafe++;
                maxMaxFriends = tryMax;
                maxCafeName = cafeName;
                cafeArr[arrNum] = maxCafeName; 
            }
        }
        if (totalMaxCafe >1){
            Arrays.sort(cafeArr,Comparator.nullsLast(Comparator.naturalOrder()));
        }

        io.println(maxMaxFriends);
        for (int i=0;i<totalMaxCafe;i++){
            io.println(cafeArr[i]);
        }
        io.close();


    }
}
