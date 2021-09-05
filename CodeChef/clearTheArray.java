import java.io.*;
import java.util.Arrays;

public class clearTheArray {
   public static void main(String[] args) {
    try{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String[] s=br.readLine().trim().split(" ");
            String[] inp=br.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            int m=Integer.parseInt(s[2]);
            int[] arr=new int[n];
            long ans=0;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(inp[i]);
                ans+=arr[i];
            }
            Arrays.sort(arr);
            for(int i=0, p=n-1; i<k && i<n/2 ;i++,p-=2){
                int l=arr[p];
                int r=arr[p-1];
                if(l+r>m){
                    ans+=m;
                    ans-=l;
                    ans-=r;
                }
            }
            System.out.println(ans);
        }
    }catch(Exception e){

    }
   } 
}
