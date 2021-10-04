import java.io.*;

public class longestAndSubarray {
    public static void main(String[] args) {
        try{    
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter output = new BufferedWriter( new OutputStreamWriter(System.out));
            int t=Integer.parseInt(br.readLine());
            int[] str=new int[t];
            while(t-->0){
                str[t]=Integer.parseInt(br.readLine());
            }
            int j=str.length-1;
            while(j>=0){
                
                output.write(getans(str[j])+"\n");
                j--;
            }
            output.flush();
        }catch(Exception e){
        }
    }
    public static long getans(int n){
        if(n==1){
            return 1;
        }
        long ans=1;
        while(ans*2<=n){
            ans*=2;
        }
        long a=n-ans+1;
        if(n==ans){
            return ans/2;
        }else{
            return Math.max(a, ans/2);
        }
    }
}
