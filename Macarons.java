/**
 * Name: Clement Ling Yeu Jye
 * Matric. No: A0245782W
 */
import java.util.*;
public class Macarons {
    //Calculate the number of subsequences given numMacaron and divisor
    //PreCond:1<= numMacaron <= 50000, 1<= divisor <= 1000000
    //PostCon: prints totalsub which is an int, no changes to the state
    //of variables
    public static void subsequences(Kattio io,int numMacaron,long divisor){
      long[] macArr = new long[numMacaron]; //array to store the macarons
      int totalSub = 0;//number of subsequences
      long currSum = 0;//sum of the int on the macarons
      for (int i =0; i<numMacaron;i++){ //store the macNumber into the array
          long macNumber = io.getLong();
          macArr[i] = macNumber;
      }
      HashMap<Long,Integer> macMap = new HashMap<>(); //Hashmap to store the sum as the key and occurences as value
      //macMap.put(Long.valueOf(0),1); //   manually put key 0 into the map when start=0
      for (int i =0; i<numMacaron;i++){
        currSum = (((currSum + macArr[i]) % divisor) + divisor) % divisor ; // get the prefix sum and check if it is divisible
        if(currSum==0){
            totalSub++;
        }
        else if (macMap.containsKey(currSum)){
            totalSub += macMap.get(currSum); //update number of subsequences
            macMap.put(currSum,macMap.get(currSum)+1); //update number of occurences
        }
        else{
            macMap.put(currSum,1); // put first occurence of currSum into the hashmap

        }
         
      }          
  io.println(totalSub); //print ans
  }
  public static void main(String args[]) {
    Kattio io  = new Kattio (System.in);
    int numMacaron = io.getInt(); 
    long divisor = io.getInt();
    subsequences(io,numMacaron,divisor);
    io.close();
  }
}
