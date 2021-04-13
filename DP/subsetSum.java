
import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class subsetSum {

    static boolean isSubsetSumdp(int set[],
                               int n, int sum)
    {
      
        boolean subset[][] = new boolean[sum + 1][n + 1];
 
        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = true;
 
   
        for (int i = 1; i <= sum; i++)
            subset[i][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j] = subset[i][j]
                                   || subset[i - set[j - 1]][j - 1];
            }
        }
        return subset[sum][n];
    }
    static boolean isSubsetSum(int set[],
                               int n, int sum)
    {
        
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
 
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        return isSubsetSum(set, n - 1, sum)
            || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().trim().split(" ");
        int sum=Integer.parseInt(br.readLine().trim());
        int[] sets=new int[str.length];
        for(int i=0;i<sets.length;i++){
            sets[i]=Integer.parseInt(str[i]);
        }
        //recursion 
        Instant t1 = Instant.now();

        System.out.print(isSubsetSum(sets,sets.length,sum)+"  ");

        Instant t2 = Instant.now();
        Duration timeElapsed = Duration.between(t1, t2);
        Instant t4 = Instant.now();
        
        System.out.println(timeElapsed.toNanos() +" ns");

        //dp
        System.out.print(isSubsetSumdp(sets,sets.length,sum)+"  ");

        Instant t3 = Instant.now();
        Duration timeElapsed1 = Duration.between(t4, t3);

        System.out.println(timeElapsed1.toNanos() +" ns");
    }
}
