import java.io.*;
import java.util.*;

public class chefAndDeque {
    public static void main(String[] args) {
        try{

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine().trim());
            while(t-->0){
                String[] s=br.readLine().trim().split(" ");
                String[] inp=br.readLine().trim().split(" ");
                int n=Integer.parseInt(s[0]);
                int m=Integer.parseInt(s[1]);
                if(m==1){
                    System.out.println(0); 
                    continue;
                }
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=Integer.parseInt(inp[i]);
                }
                HashMap<Long,ArrayList<Integer>> map=new HashMap<>();
                long[] presum=new long[n];
                presum[0]=arr[0];
                ArrayList<Integer> empt=new ArrayList<>();
                ArrayList<Integer> empt1=new ArrayList<>();
                empt.add(-1);
                empt1.add(0);
                map.put((long)0,empt);
                map.put(presum[0]%m,empt1);
                for(int i=1;i<n;i++){
                    presum[i]=presum[i-1]+arr[i];
                    if(!map.containsKey(presum[i]%m)){
                        map.put(presum[i]%m,new ArrayList<>());
                      
                    }
                      map.get(presum[i]%m).add(i);
                    
                }
            
                int total=Integer.MAX_VALUE;
                for(int i=n-1;i>=0;i--){
                    ArrayList<Integer> idxAL=map.get(presum[i]%m);
                    for(int idx:idxAL){
                         if(idx>=i && (idx+1)>(n-i-1)){
                              break;
                         }
                         int leftRm=idx+1;
                         int right=n-i-1;
                         if(leftRm+right>=n){
                              break;
                         }
                         if((leftRm|right)==right){
                              total=Math.min(total,countSetBits(right));
                         }
                      
                    }
                 
                }
                if(total==Integer.MAX_VALUE){
                    System.out.println(-1);
                }else{
                    System.out.println(total);
                }
            }
        }catch(Exception e){

        }

    }
    public static int countSetBits(int n)
    {
 
        // base case
        if (n == 0)
            return 0;
        else
            return 1 + countSetBits(n & (n - 1));
    }
}
