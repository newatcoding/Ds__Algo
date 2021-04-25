import java.util.*;
// import java.io.*;
// import java.lang.*;

public class monkandtheIslands {
    static ArrayList<Integer> adj[];

    static class Graph{
        public static int v ;
        Graph(int v)
        {
            this.v = v;
            adj = new ArrayList[v+1];
            for(int i = 1 ; i < v+1 ; i++){
                adj[i] = new ArrayList<Integer>();
            }
        }

        static void bfs(int[] visited ,int[] dist , int i ){
            visited[i] = 1 ;
            Queue<Integer> q = new LinkedList<>();
            dist[i] = 0;
            q.add(i);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int child : adj[curr]){
                    if(visited[child] == 0 ){
                        visited[child] = 1 ;
                        q.add(child);
                        dist[child] = dist[curr ] + 1 ;
                    }
                }
            }
        }
    }
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt(); // Reading input from STDIN
        Graph g = new Graph(10001);
        int visited[] = new int[10001];
        int dist[] = new int[10001]; 
        while(test-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            for(int i = 1 ; i <= n ; i++)
            {
                adj[i].clear();
                visited[i] = 0;
            }
            for(int i = 1 ; i < m+1 ; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }
            Graph.bfs(visited ,dist ,1);
            System.out.println(dist[n] );
            sc.close();
        }
    }
}
