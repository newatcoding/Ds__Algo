public class reverseSubarrayToSort {
    
    public boolean reverseSub(int[] arr){
        int n=arr.length;
        int i=0;
        for( i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                break;
            }
        }
        int j=i+1;
        for(;j<n;j++){
            if(j==n-1 || arr[j]<arr[j+1]){
                break;
            }
        }
        int jR=j==n-1?Integer.MAX_VALUE:arr[j+1];
        int iL=i==0?Integer.MIN_VALUE:arr[i-1];
        if(arr[i]>jR || arr[j]<iL){
            return false;
        }
        for(int k=j+1;k<n-1;k++){
            if(arr[k]>arr[k+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,5,3};
        reverseSubarrayToSort b=new reverseSubarrayToSort();
        System.out.println(b.reverseSub(arr));
    }
}
