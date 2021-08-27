public class maximumSumSmallestnSecondSmallest {
    public static void main(String[] args) {
        int[] arr=new int[]{4, 3, 1, 5, 6};
        int res=0;
        for(int i=0;i<arr.length-1;i++){
            res=Math.max(res,arr[i]+arr[i+1]);
        }
        System.out.println(res);
    }
}
