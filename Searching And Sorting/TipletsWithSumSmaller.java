import java.util.Arrays;

public class TipletsWithSumSmaller {
    
    public int getTriplets(int[] arr,int sum){

        Arrays.sort(arr);
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]>=sum){
                    k--;
                }else{
                    ans+=(k-j);
                    j++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{5, 1, 3, 4, 7};
        TipletsWithSumSmaller s=new TipletsWithSumSmaller();
        System.out.println(s.getTriplets(arr,12));
    }
}
