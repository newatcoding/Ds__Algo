import java.time.Duration;
import java.time.Instant;

public class partitionKSubsets {
    
    public static int countP(int n, int k)    {

       if (n == 0 || k == 0 || k > n)
          return 0;
       if (k == 1 || k == n)
          return 1;
 
       return (k * countP(n - 1, k)
              + countP(n - 1, k - 1));
    }
    static int countPDP(int n, int k)    {
    
        int[][] dp = new int[n+1][k+1];
        
        // Base cases
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= k; i++)
            dp[0][k] = 0;
        
    
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++)
                if (j == 1 || i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];
            
            return dp[n][k];
        
    }
    public static void main(String args[])
    {
        //Recursion O(2^N) space O(N) call stack
       Instant t1 = Instant.now();
        
       System.out.print(countP(3, 2)+"  ");

       //DO

       Instant t2 = Instant.now();
        Duration timeElapsed = Duration.between(t1, t2);
        Instant t4 = Instant.now();
        
        System.out.println(timeElapsed.toNanos() +" ns");

       System.out.print(countPDP(3, 2)+"  ");

       Instant t3 = Instant.now();
        Duration timeElapsed1 = Duration.between(t4, t3);

        System.out.println(timeElapsed1.toNanos() +" ns");
 
    }
}
