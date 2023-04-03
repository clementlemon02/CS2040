
/**
 * Name:Clement Ling Yeu Jye
 * Matric. No:A0245782W
 **/


public class Constellations {

    //count number of configurations
    //precond : starsNo <= 50,maxStars<=50
    //postcon:long value ,total number of configurations
    public static long countconfig(int starsNo, int minStars, int maxStars){
        long configNo = 0;
        if (starsNo<=minStars){ //minimum
            return 1;
        }else{
            for (int i = minStars;i<=maxStars;i++){ //iterate through all configurations from the minimum combinations possible
                configNo += nCk(starsNo,i) * (countconfig(starsNo -i,minStars,maxStars) % 1000000007);
            }

            return configNo % 1000000007;
        }
    }
    //n choose k method
    //precond:n<=50,k<=50
    //postcon: output is a long value the answer for n choose k
    public static long nCk(int n,int k){
        long combination = 1;
        for (int i =0;i<k;i++){
            combination =combination * (n-i)/(i+1);
        }

        return combination % 1000000007;
    }

    public static void main(String args[]) {
        Kattio io = new Kattio(System.in, System.out);
        int starsNo = io.getInt();
        int minStars = io.getInt();
        int maxStars = io.getInt();
        long finalConfigNo = 0; //placeholder for final answer

        finalConfigNo = countconfig(starsNo,minStars,maxStars);

        io.println(finalConfigNo% 1000000007);
        io.close();
    }
}

