import java.util.PriorityQueue;

public class KthSmallersPrimeFraction {
    static class Pair{
        public int x;
        public int y;
       
        public Pair(int a,int b){
            x=a;
            y=b;

        }
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,5};
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((a,b)->{
            return arr[a.x]*arr[b.y]-arr[b.x]*arr[a.y];
        });
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(i,arr.length-1));
        }
        int k=3;
        int n=0;
        int[] ans=new int[2];
        while(pq.size()>0){
            Pair q=pq.poll();
            n++;
            if(q.x<q.y-1){
                pq.add(new Pair(q.x,q.y-1));
            }
            if(n==k){
                ans[0]=arr[q.x];
                ans[1]=arr[q.y];
                break;
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
    }
}
