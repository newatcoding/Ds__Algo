import java.util.*;

public class chefAndReversing {
    static class Pair implements Comparable<Pair> {
        int ver;
        int wt;
        Pair(int ver,int wt) {
            this.ver=ver;
            this.wt=wt;
        }
        @Override
        public int compareTo(Pair o) {
            return this.wt-o.wt;
        }
      }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int e=s.nextInt();
		ArrayList<Pair> al[]=new ArrayList[v+1];
		for(int i=0;i<=v;i++) al[i]=new ArrayList<>();
		for(int i=0;i<e;i++) {
		    int x=s.nextInt();
		    int y=s.nextInt();
		    al[x].add(new Pair(y,0));
		    al[y].add(new Pair(x,1));
		}
	//	dijkstra algo
		PriorityQueue<Pair> pq=new PriorityQueue<>();
		pq.add(new Pair(1,0));
	    int vis[]=new int[v+1];
	    Arrays.fill(vis,-1);
	    while(!pq.isEmpty()) {
	        Pair p=pq.poll();
	        int vertex=p.ver;
	        int weight=p.wt;
	        if(vis[vertex]!=-1) continue;
	        vis[vertex]=weight;
	        ArrayList<Pair> li=al[vertex];
	        for(Pair p1:li) {
	            if(vis[p1.ver]==-1){
	                pq.add(new Pair(p1.ver,p1.wt+weight));
	            }
	        }
	    }
	    if(vis[v]==-1) System.out.println("-1");
	    else System.out.println(vis[v]);
    }
}
