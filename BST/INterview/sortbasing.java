import java.util.*;

public class sortbasing {
    class pair implements Comparable{
        int val;
        int freq;
        public pair(a,b){
            val=a;
            freq=b;
        }
        public int compareTo(pair a){
            if(a.freq==this.freq)
                return this.val-a.val;
            else
                return a.freq-this.freq;
        }
    }
    public static void main(String[] args) {
        int[] arr={4,4,4,2,2,1,3,31,5};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val, 0)+1);
        }
        pair[] p=new int[map.size()];
        int i=0;
        for(int key:map.keySet()){
            p[i]=new pair(key,map.get(key));
            i++;
        }
        Arrays.sort[p];
        for(pair p1:p){
            System.out.print(p1.val+" ");
        }
    }
}
