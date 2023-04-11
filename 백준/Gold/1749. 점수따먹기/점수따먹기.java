import java.io.*;
import java.util.*;

public class Main {
   
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N,M;

        N = sc.nextInt();
        M = sc.nextInt();

        int[][] matrix = new int[N+1][M+1];
        int oneMax = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++){
            matrix[i][1] = sc.nextInt();
            if(matrix[i][1] > oneMax) oneMax = matrix[i][1];
            for(int j=2; j<=M; j++) {
                int tmp = sc.nextInt();
                if(tmp>oneMax) oneMax = tmp;
                matrix[i][j] = matrix[i][j-1]+tmp;
            }
        }
        int totalSum = Integer.MIN_VALUE;

        for(int i=1;i<=N;i++) {
            int tmpSum = 0;
            for(int j=1;j<=M;j++) {
                tmpSum = 0;
                for(int l=1;j+l<=M;l++) {
                    tmpSum=0;
                    for(int k=0;i+k<=N;k++) {
                        tmpSum += (matrix[i+k][j+l] - matrix[i+k][j-1]);
                        if(tmpSum>totalSum) totalSum = tmpSum;
                    }
                }
            }
            
        }
        System.out.println(Math.max(oneMax, totalSum));
    }
}