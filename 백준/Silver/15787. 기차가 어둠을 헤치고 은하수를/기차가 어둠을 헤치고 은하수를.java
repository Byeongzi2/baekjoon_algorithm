import java.io.*;
import java.util.*;

public class Main {
   
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] train = new int[N][20];
        int[] sum = new int[N];

        for(int h=0; h<M; h++) {
            int first,num,x;

            first = sc.nextInt();
            num = sc.nextInt();

            if(first==1) {
                x = sc.nextInt();
                if(train[num-1][x-1]==0) train[num-1][x-1] = 1;
            }

            else if(first==2) {
                x = sc.nextInt();
                if(train[num-1][x-1]==1) train[num-1][x-1] = 0;
            }

            else if (first==3) {
                for(int i=19;i>0;i--) {
                    train[num-1][i] = train[num-1][i-1];
                }
                train[num-1][0] = 0;
            }
            else {
                for(int i=0;i<19;i++) {
                    train[num-1][i] = train[num-1][i+1];
                }
                train[num-1][19] = 0;
            }
        }
        Set<Integer> ans = new HashSet<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<20; j++) {
                sum[i] += train[i][j]<<j;
            }
            ans.add(sum[i]);
        }

        System.out.println(ans.size());
    }
}