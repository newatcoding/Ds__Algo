import java.util.Scanner;

public class JuryMeeting1569C {
    
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int mod=998244353;
            int sz=400005;
            long[] fact=new long[sz];
            fact[0]=1;
            for(int i=1;i<sz;i++){
                fact[i]=(fact[i-1]*i)%mod;
            }
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                int[] arr=new int[n];
                int max=0;
                int cmax=0;
                int smax=0;
                int csmax=0;
                for(int i=0;i<n;i++){
                    arr[i]=scn.nextInt();
                    max=Math.max(max, arr[i]);
                }
                for(int val:arr){
                    if(val!=max){
                        smax=Math.max(smax,val);
                    }else{
                        cmax++;
                    }
                    
                }
                for(int val:arr){
                    if(val==smax){
                        csmax++;
                    }
                }
                if(cmax>1){
                    System.out.println(fact[n]);
                    continue;
                }
                if(max-smax>1){
                    System.out.println(0);
                    continue;
                }
                

                long ans=fact[n];
                for(int i=0;i<n-csmax;i++){
                   long v=fact[csmax+i];
                   v=(v*nCr(n-csmax-1,i,mod,fact))%mod;
                   v=(v*fact[n-csmax-i-1])%mod;
                   ans=(ans-v+mod)%mod;

                }
                System.out.println(ans);
            }
            scn.close();
        }catch(Exception e){

        }
    }
    public static long nCr(int n,int r,int mod,long[] fact){
        if(n<r){
            return 0;
        }
        return fact[n]*mod_inv(fact[r]*fact[n-r]%mod,mod)%mod;
       
    }
    public static long mulmod(long a,long b,long m){
        long res=0; 
        a=a%m;
        while(b>0)
        {
          if(b%2==0)
              res=(res+a)%m;
              a=(a*2)%m;
              b/=2;
          }
          return res%m;
      }
      
      public static long mod_inv(long a,long p){
          return bigmod(a,p-2,p);
      }
      public static long bigmod(long a,long b,long m){
        if(b==0) return 1;
        long x=bigmod(a,b/2,m);
        x=(x*x)%m;
        if((b&1)==1) x=(a*x)%m;
        return x;
      }
}
