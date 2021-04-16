import java.util.Scanner;

public class coinChange {
    
    public static  int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
       dp[0] = 1;
       for (int coin : coins) {
           for (int i = coin; i <= amount; i++) {
               dp[i] += dp[i-coin];
           }
       }
       return dp[amount];
   }

   public static  int changePermu(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int amt=scn.nextInt();
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[n]=scn.nextInt();
        }

        //combination  no. of ways to get amount
        System.out.println(change(amt,arr));

        // permutation no. of different ways to get amount
        System.out.println(changePermu(amt,arr));

        scn.close();
    }
}
