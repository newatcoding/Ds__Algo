import java.util.*;
// import java.io.*;

public class friendsPairing {
    static int countFriendsPairings(int n)
    {
        int dp[] = new int[n + 1];
 
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
 
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        System.out.println(countFriendsPairings(n));
        scn.close();
    }
}
