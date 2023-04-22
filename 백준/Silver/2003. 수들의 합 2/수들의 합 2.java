import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N,M;
        N = sc.nextInt();
        M = sc.nextInt();
        int[] seq = new int[N+1];
        int cnt = 0;
        long sum = 0;
        int lo = 0;
        int hi = 0;

        for(int i=0; i<N;i++) {
            seq[i] = sc.nextInt();
        }
        while(true) {
            if(sum>=M) sum-=seq[lo++];
            else if (hi == N) break;
            else sum+=seq[hi++];
            if(sum==M) cnt++;

        }
        System.out.println(cnt);
    }
}