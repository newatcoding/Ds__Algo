import java.util.*;

public class countPathbwTwoVertices {
    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];
     
        @SuppressWarnings("unchecked") Graph(int v)
        {
            this.V = v;
            this.adj = new LinkedList[V];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }
        void addEdge(int v, int w)
        {
            adj[v].add(w);
        }
        int countPathUtil(int st,int end,int path){
            if(st==end){
                path++;
            }
            else{
                Iterator<Integer> i=adj[st].listIterator();
                while(i.hasNext()){
                    int n=i.next();
                    path=countPathUtil(n, end, path);
                }
            }
            return path;
        }
        int countPaths(int st,int end){
            int path=0;
            path=countPathUtil(st,end,path);
            return path;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
 
        int s = 0, d = 3;
        System.out.println(g.countPaths(s, d));
    }
}
