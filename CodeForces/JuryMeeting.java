import java.util.Scanner;

public class JuryMeeting {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int mod=998244353;
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                int[] arr=new int[n];
                int max=0;
                int smax=0;
                for(int i=0;i<n;i++){
                    arr[i]=scn.nextInt();
                    max=Math.max(max, arr[i]);
                }
                for(int val:arr){
                    if(val!=max){
                        smax=Math.max(smax,val);
                    }
                }
                if(max-smax>1){
                    System.out.println(0);
                    continue;
                }
                if(smax==-1){
                    System.out.println(fact(n,mod));
                    continue;
                }


                long ans=0;
                for(int i=0;i<n/2;i++){
                    // ans=(ans+(fact))%mod;

                }
            }
            scn.close();
        }catch(Exception e){

        }
    }
    public static long fact(int n,int mod){
        long ans=1;
        for(long i=1;i<=n;i++){
            ans=(ans*i)%mod;
        }
        return ans;
    }
}
