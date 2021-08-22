
import java.util.*;

public class baloonArrow {
    public static void main(String[] args) {
        int[] arr=new int[]{5,5,3,3,1,2};
        System.out.println(getans(arr));
    }   
    // public static int recur(int[] arr,int st,int level,int[][] dp){
    //     if(st==arr.length){
    //         return 0;
    //     }
    //     if(dp[st][level]>0){
    //         return dp[st][level];
    //     }
    //     for(int i=st;i<arr.length;i++){
    //         int max=0;
    //         if(level==arr[i]){
    //             dp[i][level]=recur(arr,i+1,level-1,dp);
    //         }
    //     }
    // }
    public static int getans(int[] arr){
        HashMap<Integer,Deque<Integer>> map=new HashMap<>();
        int i=0;
        for(int val:arr){
            if(!map.containsKey(val)){
                map.put(val,new ArrayDeque<>());
            }
            map.get(val).add(i);

            i++;
        }
        HashSet<Integer> set=new HashSet<>();
        int ans=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=-1 && !set.contains(arr[j])){
                
                int height=arr[j]-1;
                arr[j]=-1;
                int max=1;
                set.add(j);
                int previdx=j;
                while(map.containsKey(height)){
                    while(map.get(height).size()>0 && map.get(height).peek()<previdx){
                        map.get(height).pollFirst();
                    }
                    if(map.get(height).size()==0){
                        map.remove(height);
                        break;
                    }
                    int idx=map.get(height).peek();
                    height--;
                    arr[idx]=-1;
                    previdx=idx;
                    max++;
                }

                ans=Math.max(ans,max);
            }
        }
        return ans;
        
    }
}