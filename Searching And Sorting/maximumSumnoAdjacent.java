public class maximumSumnoAdjacent {
    public int findSum(int[] arr){
        int inc=arr[0];
        int exc=0;
        int exc_new=0;
        int n=arr.length;
        for(int i=1;i<n;i++){
             exc_new=inc>exc?inc:exc;
             inc=exc+arr[i];
             exc=exc_new;
        }

        return Math.max(inc,exc);
    }
    public static void main(String[] args) {
        int[] arr=new int[]{5,5,10,100,10,5,11,23,21,2,23,3};
        maximumSumnoAdjacent a=new maximumSumnoAdjacent();
        System.out.println(a.findSum(arr));
    }
}
