import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Data>[] rooms;
    static boolean[] visited;
    static long answer = 0;
    public static class Data {
        int d;
        long weight;
        Data(int d, long weight){
            this.d = d;
            this.weight = weight;
        }
    }

    public static void dfs(int start, long w) {
        visited[start] = true;
        if(answer < w) answer = w;
        for(int i=0;i<rooms[start].size();i++) {
            Data tmp = rooms[start].get(i);
            
            if(visited[tmp.d]) continue;
            dfs(tmp.d,w+tmp.weight);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N;
        
        N = sc.nextInt();
        rooms = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=0;i<=N;i++) {
            rooms[i] = new ArrayList<Data>();
        }
        for(int i=0;i<N-1;i++) {
            int A,B,C;
            A = sc.nextInt();
            B = sc.nextInt();
            C = sc.nextInt();

            rooms[A].add(new Data(B,C));
            rooms[B].add(new Data(A,C));
        }
        dfs(1,0);
        
        System.out.println(answer);

    }
}