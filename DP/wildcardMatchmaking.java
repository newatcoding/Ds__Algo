import java.util.Scanner;

public class wildcardMatchmaking {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()]=true;
        for(int i=p.length()-1;i>=0;i--){
             if(p.charAt(i)!='*')
                break;
            else
                dp[s.length()][i]=true;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=p.length()-1;j>=0;j--){
                if(p.charAt(j)==s.charAt(i) || p.charAt(j)=='?'){
                    dp[i][j]=dp[i+1][j+1];
                }
                else if(p.charAt(j)=='*'){
                    dp[i][j]=dp[i][j+1] || dp[i+1][j];
                }
                else{
                    dp[i][j]=false;
                }
            }
        }
        
        return dp[0][0];
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        String pat=scn.next();
        System.out.println(isMatch(str,pat));
        scn.close();
    }   
}
