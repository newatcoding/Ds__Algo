import java.io.*;

// import jdk.internal.org.jline.utils.InputStreamReader;

public class ATMQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n=Integer.parseInt(br.readLine().trim());
            String[] str=br.readLine().trim().split(" ");
            int[] arr=new int[n-1];
            for(int i=0;i<n-1;i++){
                arr[i]=Integer.parseInt(str[i]);
            }
            int mod=1000000007;
            System.out.println(getans(arr,n-1,mod));
        }

    }
    public static long getans(int[] arr,int n , int mod){
        long ans=1;
        if(arr[0]>arr[1]){
            ans=((ans*100000)%mod-arr[0]+1);
        }
        for(int i=0;i<n-2;i++){
            int max=Math.max(arr[i],arr[i+1]);
            if(arr[i+1]>arr[i+2]){
                ans=((ans*100000)%mod-max+1);
            }
        }

        if(arr[n-1]>arr[n-2]){
            ans=((ans*100000)%mod-arr[n-1]*+1);
        }
        return ans;
    }
}
