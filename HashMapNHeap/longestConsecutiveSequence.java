import java.util.*;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr={0,3,7,2,5,8,4,6,0,1};
        longestConsecutiveSequence o=new longestConsecutiveSequence();
        System.out.println(o.ans(arr));
    }
    private int ans(int[] arr){
        Set<Integer> set=new HashSet<>();
        for(int val:arr){
            set.add(val);
        }
        int ans=0;
        for(int val:arr){
            int l=val-1;
            int r=val+1;
            while(set.remove(l)){
                l--;
            }
            while(set.remove(r)){
                r++;
            }
            ans=Math.max(ans,r-l-1);
            if(set.isEmpty()) return ans;
        }
        return ans;
    }
}
