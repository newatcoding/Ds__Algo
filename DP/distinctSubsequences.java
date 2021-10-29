public class distinctSubsequences {
    public static void main(String[] args) {
        String s="rabbbit";
        String b="rabbit";
        System.out.println(numDistinct(s, b));
    }
    public static  int numDistinct(String A, String B) {
        int[][] dp=new int[B.length()+1][A.length()+1];
         for(int i=0;i<=A.length();i++){
            dp[0][i]=1;
        }
        for(int i=0;i<B.length();i++){
            for(int j=0;j<A.length();j++){
                if(A.charAt(j)==B.charAt(i)){
                    dp[i+1][j+1]=dp[i][j]+dp[i+1][j];
                }else{
                    dp[i+1][j+1]=dp[i+1][j];
                }
            }
        }
        return dp[B.length()][A.length()];
    }
}
