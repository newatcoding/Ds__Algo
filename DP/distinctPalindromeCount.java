import java.util.*;

public class distinctPalindromeCount {
    public static void main(String[] args) {
        String s="abaaa";
        System.out.println(palindromeSubStrs(s));
    }
    static int palindromeSubStrs(String s){
        int[][] dp = new int[s.length()][s.length()];
        int st, end, i, len;
        HashMap<String,Boolean> m = new HashMap<>();
 
        for (i = 0; i < s.length(); i++)
        {
            dp[i][i] = 1;
            m.put(s.substring(i, i + 1), true);
        }
 
        for (i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = 1;
                m.put(s.substring(i, i + 2), true);
            }
            else
                dp[i][i + 1] = 0;
        }
 
        for (len = 3; len <= s.length(); len++){
            for (st = 0; st <= s.length() - len; st++){
                end = st + len - 1;
                if (s.charAt(st) == s.charAt(end) &&
                    dp[st + 1][end - 1] == 1){
                    dp[st][end] = 1;
                    m.put(s.substring(st, end + 1), true);
                }
                else
                    dp[st][end] = 0;
            }
        }
 
        // Return the count of distinct palindromes
        return m.size();
    }
}
