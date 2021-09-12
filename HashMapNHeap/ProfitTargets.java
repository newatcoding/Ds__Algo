import java.util.HashMap;
// import java.util.HashSet;
import java.util.HashSet;

public class ProfitTargets {
    public static void main(String[] args) {
        int[] sp={5,7,9,13,11,6,6,3,3};
        int tar=12;
        HashMap<Integer,Integer> map=new HashMap<>();
        int pairs=0;
        for(int num:sp){
           
                map.put(num, map.getOrDefault(num, 0)+1);
            
        }
        HashSet<Integer> done=new HashSet<>();
        for(int val:map.keySet()){

            int find=tar-val;
            
            if(done.contains(find)){
                continue;
            }
            done.add(find);
            done.add(val);

            if(find ==val){
                pairs+=((map.get(val)-1)*(map.get(val)-1));
                continue;
            }
            // System.out.println(val+" "+find);
            pairs+=(map.get(val)*map.getOrDefault(find  , 0));
            
        }
        System.out.println(pairs);
    }
}
