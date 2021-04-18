import java.util.Scanner;

public class regularExpressionMatching {
    public static  boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[p.length()+1][s.length()+1];
        dp[0][0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(j==0){
                    if(i>=2 && p.charAt(i-1)=='*'){
                        dp[i][j]=dp[i-2][j];
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
                else if(p.charAt(i-1)==s.charAt(j-1) || p.charAt(i-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(i-1)=='*'){
                    dp[i][j]=dp[i-2][j];
                    char ch=p.charAt(i-2);
                    if(ch=='.' || ch==s.charAt(j-1)){
                        dp[i][j]= dp[i][j] || dp[i][j-1];
                    }
                }
                else{
                    dp[i][j]=false;
                }
                
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        String pat=scn.next();
        System.out.println(isMatch(str,pat));
        scn.close();
    }
}
