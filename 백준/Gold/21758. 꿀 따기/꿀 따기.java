import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] bees;

    public static int case1() {
        int ans = -1;
        
        for(int i=1;i<N-1;i++) {
            // 벌 벌 꿀통
            int tmp1 = (bees[N-1] - bees[i])*2 +bees[i-1] - bees[0];

            // 꿀통 벌 벌
            int tmp2 = bees[i-1] * 2 + bees[N-2] - bees[i];

            // 벌 꿀통 벌
            int tmp3 = bees[i] - bees[0] + bees[N-2] - bees[i-1];
            
            ans = Math.max(ans,tmp1);
            ans = Math.max(ans, tmp2);
            ans = Math.max(ans,tmp3);
            
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        bees = new int[N+1];
        bees[0] = sc.nextInt();
        for(int i=1; i<N; i++) {
            bees[i] = sc.nextInt();
            bees[i] += bees[i-1];
            
        }
        
        System.out.println(case1());
    }
}