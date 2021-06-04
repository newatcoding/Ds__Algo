import java.util.*;

public class Burstbaloon {

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        Burstbaloon b=new Burstbaloon();
        System.out.println(b.getmaxProd(arr));
        scn.close();
    }
    public int getmaxProd(int[] nums) {
        int[] arr=new int [nums.length+2];
        arr[0]=arr[arr.length-1]=1;
        for(int i=1;i<arr.length-1;i++){
            arr[i]=nums[i-1];
        }
        int[][] dp=new int[arr.length][arr.length];
        for (int[] row : dp) 
            Arrays.fill(row, -1); 
        return burst(arr,dp,0,arr.length-1);
    }
    
    public int burst(int[] arr,int[][] dp,int left,int right){
        if(left+1==right){
            return 0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int ans=0;
        for(int i=left+1;i<right;i++){
            int temp1=burst(arr,dp,left,i);
            int temp2=burst(arr,dp,i,right);
            int tempans=arr[left]*arr[right]*arr[i];
            ans=Math.max(ans,temp1+temp2+tempans);
        }
        dp[left][right]=ans;
        return ans;
    }
}
