import java.io.*;
import java.util.*;

public class Main {
    
    public static int sungmin(int chart[], int dailyStock[], int cash) {
        int sungminSum = 0;
        int scash = cash;
        int sstock = 0;
        for(int i=1;i<14;i++) {
            if(chart[i] <= -3) {
                sstock += (int)(scash / dailyStock[i]);
                scash %= dailyStock[i];
            }
            else if (chart[i] >= 3) {
                scash += sstock * dailyStock[i];
                sstock = 0;
            }
        }
        return sungminSum = (sstock*dailyStock[13] + scash);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cash = sc.nextInt();
        int chart[];
        int dailyStock[];
        dailyStock = new int[15];
        chart = new int[15];
        int beforeStock = Integer.MAX_VALUE;
        int jcash = cash;
        int jstock = 0;
        for(int i=0; i<14; i++) {
            int stock = sc.nextInt();
            dailyStock[i] = stock;
            int jtmpstock = (int)(jcash / stock);
            if( jtmpstock >= 1 ) {
                jstock+=jtmpstock;
                jcash %= stock;
            }
            
            if(i==0) {
                beforeStock = stock;
                continue;
            }
            if(stock < beforeStock) {
                if(chart[i-1] <= 0 ){
                    chart[i] = chart[i-1]-1;
                }
                else {
                    chart[i] = -1;
                }
            }
            else if (stock > beforeStock) {
                if(chart[i-1] >= 0) {
                    chart[i] = chart[i-1]+1;
                }
                else {
                    chart[i] = 1;
                }
            }
            beforeStock = stock;
            
        }
        int jSum = jstock * dailyStock[13] + jcash;
        int sSum = sungmin(chart, dailyStock,cash);
        if(jSum > sSum) System.out.println("BNP");
        else if (sSum > jSum) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}