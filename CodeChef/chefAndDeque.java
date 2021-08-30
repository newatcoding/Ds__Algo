import java.io.*;
import java.util.HashMap;

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
                HashMap<Long,Integer> map=new HashMap<>();
                long[] presum=new long[n];
                presum[0]=arr[0];
                map.put((long)0,-1);
                map.put(presum[0]%m,0);
                for(int i=1;i<n;i++){
                    presum[i]=presum[i-1]+arr[i];
                    if(!map.containsKey(presum[i]%m)){
                        map.put(presum[i]%m,i);
                    }
                    
                }
               
                int[] getIdx=new int[n];
                for(int i=0;i<n;i++){
                    int idx=map.get(presum[i]%m);
                    if(idx<i){
                        getIdx[i]=idx;
                    }else{
                        getIdx[i]=-2;
                        
                    }
                //   System.out.print(getIdx[i]+" " );
                }
                // System.out.println(-1);
                int total=Integer.MAX_VALUE;
                for(int i=n-1;i>=0;i--){
                    if(getIdx[i]!=-2 && (getIdx[i]+1)<=(n-i-1)){
                        int leftrem=getIdx[i]+1;
                        int rightrem=n-i-1;
                        int sum=Integer.MAX_VALUE;
                        // System.out.println(leftrem+" "+i);
                        sum=countSetBits(leftrem);
                        sum+=countSetBits(rightrem-leftrem);
                        total=Math.min(total,sum);
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
