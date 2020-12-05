import java.util.*;
import java.io.*;
public class day1{
    public static void main(String [] args){
            File file = new File("day1.txt");
            try{
                Scanner scan = new Scanner(file);
                int sum = 0;
                int gsum = 0;
                while(scan.hasNext()){
                    int num = Integer.parseInt(scan.next());
                    while(num > 0 && fuel(num) >0 ){
                        sum += fuel(num);
                        num = fuel(num);
                    }
                    gsum += sum;
                    sum = 0;

                }
                 System.out.println(gsum);
                scan.close();
            } catch(FileNotFoundException e){
                e.printStackTrace();
            }

        
    }
    public static int fuel(int num){
        return (int)Math.floor(num / 3) - 2;
    }
}