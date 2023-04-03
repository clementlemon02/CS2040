/**
 * Name: Clement Ling Yeu Jye
 * Matric. No: A0245782W
 */

import java.util.*;
public class Entrepreneurship {





    public static void runOrder(Kattio io,int numCommand,int maxPizza,String command,Stack<LinkedList<Double>> orderList,LinkedList<Double> batchList){

       
        if (command.equals("ADD")){
            int numOrder = io.getInt();
            String dir = io.getWord();
             



            for (int j=0;j<numOrder;j++){
                int order = io.getInt();
                double price = io.getDouble();
                if(dir.equals("L")){
                    if (order + currNumPizza <=maxPizza){
                        currNumPizza=currNumPizza + order;
                        
                        batchList.add((double)order);
                        batchList.add(price);
                    }
                }
                else if(dir.equals("R")){
                    tempList.push(price);
                    tempList.push((double)order);
                }
            }
              
            for (int i=0 ;i<tempList.size()/2;i++){
                        double tempPrice = tempList.pop();
                        double tempOrder = tempList.pop();
                        if(tempOrder + currNumPizza <=maxPizza){
                            currNumPizza = currNumPizza + (int)tempOrder;
                            
                            batchList.add((double)tempOrder);
                            batchList.add(tempPrice);
                        }
                    } 

                
                
               orderList.push(batchList);
        }
         
        else{
            int cancelBatch = io.getInt();
            for(int j =0; j<=cancelBatch;j++){
                LinkedList<Double>  cancelled = orderList.pop();
                for (int i = 0;i<cancelled.size();i+=2){
                    currNumPizza -= cancelled.get(i);
                }
            }

        }
    }
   /* public static void finalrevenue(Kattio io,Stack<LinkedList<Double>> orderList,double revenue){
        
        for(int i =0; i<orderList.size();i++){
            LinkedList<Double> tempBatch = orderList.pop();
            for(int j =0; j<tempBatch.size();j+=2){
                revenue +=(tempBatch.get(j) * tempBatch.get(j+1));
                
            
            }
        }

    }
*/
    public static int currNumPizza;
    public static LinkedList<Double> tempList = new LinkedList<Double>();
    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        int numCommand =io.getInt();
        int maxPizza = io.getInt();
        LinkedList<Double> batchList = new LinkedList<Double>();
        Stack<LinkedList<Double>> orderList = new Stack<LinkedList<Double>>();
        
        double revenue = 0;
        

        while(io.hasMoreTokens()){
            String command = io.getWord();
            runOrder (io,numCommand,maxPizza,command,orderList,batchList);
           // finalrevenue(io,orderList,revenue);
           while(!orderList.empty()){
                LinkedList<Double> tempBatch = orderList.pop();
                for(int j =0; j<tempBatch.size();j+=2){
                    revenue +=(tempBatch.get(j));
                    
                }

        }

        }
        
        
        io.println((String.format("%.1f",revenue)));
        io.close();
    }
}
