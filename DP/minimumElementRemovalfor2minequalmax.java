import java.util.Scanner;

public class minimumElementRemovalfor2minequalmax {
    //subsequence
    public static int minimumremoval(int[] arr,int n){
        int longest_start = -1, longest_end = 0;
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for(int j=i;j<n;j++){
                int val=arr[i];
                if(val>max){
                    max=val;
                }
                if(val<min){
                    min=val;
                }

                if(2*min<=max){
                    break;
                }
                if (j - i > longest_end - longest_start
                        || longest_start == -1) {
                    longest_start = i;
                    longest_end = j;
                }
            }
        }
        if (longest_start == -1) {
            return n;
        }
 
        // Return the number of elements to be removed
        return (n - (longest_end - longest_start + 1));
    }   

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        System.out.println(minimumremoval(arr,n));
        scn.close();
    }
}
