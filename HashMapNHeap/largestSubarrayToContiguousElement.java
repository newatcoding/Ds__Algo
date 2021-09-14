import java.util.*;

public class largestSubarrayToContiguousElement {
    public static void main(String[] args) {
        int[] arr={15,13,14,15,16,17,19};
        int n=arr.length;
        int maxLen=1;

        for(int i=0;i<n-1;i++){
            Set<Integer> set=new HashSet<>();
            int max=arr[i];
            int min=arr[i];
            for(int j=i+1;j<n;j++){
                if(!set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
                max=Math.max(arr[j], max);
                min=Math.max(arr[j], min);

                if(max-min==j-i){
                    maxLen=Math.max(maxLen, max-min+1);
                }
            }
        }
        System.out.println(maxLen);
    }
}
