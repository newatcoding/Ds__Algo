import java.io.*;
public class CrossingBlocks {
    public static void main(String[] args) {
        try{

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine().trim());
            while(t-->0){
                int n=Integer.parseInt(br.readLine().trim());
                String[] inp=br.readLine().trim().split(" ");
                int[] height=new int[n];
                for(int i=0;i<n;i++){
                    height[i]=Integer.parseInt(inp[i]);
                }
                int[] localMax=new int[n];
                localMax[n-1]=n;
                localMax[n-2]=n-1;
                for(int i=n-3;i>=0;i--){
                    int maxIdx=n;
                    if(height[localMax[i+1]]>=height[i+1]){
                        maxIdx=localMax[i+1];
                    }else{
                        maxIdx=i+1;
                    }
                    localMax[i]=maxIdx;
                }
                // for(int i=0;i<n;i++){
                //     System.out.print(height[localMax[i]]+" ");
                // }
                if(height[localMax[0]]>height[0]){
                    System.out.println(-1);
                    continue;
                }
                int ans=0;
                int i=0;
                while(i<n-1){
                    i=localMax[i];
                    ans++;
                }
                System.out.println(ans);
            }
        }catch(Exception e){

        }
    }
}
