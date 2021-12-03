import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class countNumberOfNodesAtLevel {
    static class Graph{
        int V;
        ArrayList<ArrayList<Integer>> adj;
        Graph(int v){
            this.V=v;
            this.adj=new ArrayList<>(V);
            for(int i=0;i<V;i++){
                adj.add(new ArrayList<>(V));
            }
        }
        void addEdge(int a,int b){
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int BFS(int v,int level){
            boolean[] vis=new boolean[V];
            int[] lev=new int[V];

            Queue<Integer> pq=new LinkedList<>();
            int count=0;
            vis[v]=true;
            lev[v]=0;
            pq.add(v);
            while(pq.size()>0){
                int ver=pq.poll();
                ArrayList<Integer> ad=adj.get(ver);
                for(int nv:ad){
                    if(!vis[nv]){
                        vis[nv]=true;
                        lev[nv]=lev[ver]+1;
                        pq.add(nv);
                    }
                }
                count = 0;
                for (int i = 0; i < V; i++)
                  if (lev[i] == level)
                    count++;
            }
            return count;
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        int level = 2;
        System.out.print(g.BFS(0, level));
    }
}
