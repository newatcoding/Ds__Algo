import java.util.*;

public class graph {
    static class reach{
        int road;
        int maxTemp;
        int daysLeft;
        public reach(int a,int b,int c){
            road=a;
            maxTemp=b;
            daysLeft=c;
        }
    }
    static class pair{
        int road;
        int wt;
        public pair(a,b){
            road=a;
            wt=b;
        }
    }
    public static int getpath(ArrayList<ArrayList<pair>> graph,int st,int d,int n,int dest){

        PriorityQueue<reach> pq=new PriorityQueue<reach>((a,b)->{
            return a.maxTemp-b.maxTemp;
        });
        int temp=Integer.MAX_VALUE;
        boolean[vis]=new boolean[n];
        pq.add(new reach(st,temp,d));
        while(pq.size()>0){
            reach r=pq.poll();
            if(r.road==dest){
                return r.maxTemp;
            }
            vis[r.road]=true;
            if(r.daysLeft==0){
                continue;
            }
            for(pair p:graph.get(r.road)){
                if(!vis[p.road]){
                    pq.add(new reach(p.road,Math.max(r.maxTemp, p.wt,r.daysLeft-1));
                }
            }
        }  
        return -1; 
    }
    public static void main(String[] args) {
        
    }
}
