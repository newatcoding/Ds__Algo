public class add1Multiply2 {
    public static void main(String[] args) {
        int n=5;  
        int ans=getans(n);
        System.out.println(ans);
    }
    public static int getans(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            if(i%2==0){
                dp[i]=Math.min(dp[i-1],dp[i/2])+1;
            }else{
                dp[i]=dp[i-1]+1;
            }
        }
        return dp[n];
    }
}
