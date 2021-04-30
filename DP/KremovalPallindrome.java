import java.util.Scanner;

public class KremovalPallindrome {
    
    public static boolean isKPalDP(String str1, String str2, int m, int n,int k)
    {
         
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){
             
                if (i == 0){
                 
                    dp[i][j] = j;
                }
                 
                else if (j == 0){
                    dp[i][j] = i;
                }
                else if (str1.charAt(i - 1) ==str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                
                else{
                    
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
        }
        // return dp[m][n];
        return (dp[m][n] <= k * 2);
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        int k=scn.nextInt();
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        String str2=sb.toString();
        scn.close();
        System.out.println(isKPalDP(str,str2,str.length(),str.length(),k));
    }
}
