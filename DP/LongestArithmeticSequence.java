public class LongestArithmeticSequence {
    public static void main(String[] args) {
        int[] arr={1, 7, 10, 15, 27, 29};
        System.out.println(LAP(arr));
    }
    public static  int LAP(int[] arr){
        int[][] dp=new int[arr.length][arr.length];
        int n=arr.length;
        int max=2;
        for(int i=0;i<n;i++){
            dp[i][n-1]=2;
        }
        for(int j=n-2;j>=1;j--){
            int i=j-1;
            int k=j+1;
            while(i>=0 && k<n){
                if(arr[i]+arr[k]<2*arr[j]){
                    k++;
                }else if(arr[i]+arr[k]>2*arr[j]){
                    dp[i][j]=2;      //because i is now changing and  we found no extra pairs
                    i--;
                }else{
                    dp[i][j]=dp[j][k]+1  ;    // i j k l m   is an ap then to get size of  (i, j) , we get size till (j,k) +1
                    // moving backward and forming an ap
                    max=Math.max(max,dp[i][j]);
                    i--;
                    k++;
                }
            }
            while (i >= 0)
            {
                dp[i][j] = 2;
                i--;
            }
        }
        return max;
    }
}
