import java.util.Arrays;

public class MergertwoSortedArray {
    
    public void print(int[] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println(" ");
    }
    public void merge(int[] ar1,int[] ar2){
        int m=ar1.length;
        int n=ar2.length;
        for (int i = n - 1; i >= 0; i--){
            int j, last = ar1[m - 1];
            for (j = m - 2; j >= 0 && ar1[j] > ar2[i]; j--)
                ar1[j + 1] = ar1[j];
            if (j != m - 2 || last > ar2[i]){
                ar1[j + 1] = ar2[i];
                ar2[i] = last;
            }
        }
    }
    
    public void mergeOptimised(int[] arr1,int[] arr2){
        int m=arr1.length;
        int n=arr2.length;
        int k=m-1;
        int j=0;
        int i=0;
        while(i<k && j<n){
            if(arr1[i]<arr2[j]){
                i++;
            }else{
                int temp=arr2[j];
                arr2[j]=arr1[k];
                arr1[k]=temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
    }
    public static void main(String[] args) {
        int[] arr=new int[]{ 1, 5, 9, 10, 15, 20};
        int[] arr2=new int[]{ 2, 3, 8, 13};
        
        MergertwoSortedArray b=new MergertwoSortedArray();
        b.print(arr);
        b.print(arr2);

        b.mergeOptimised(arr, arr2);

        b.print(arr);
        b.print(arr2);
    }
}
