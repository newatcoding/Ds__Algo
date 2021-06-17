import java.util.*;

public class nearlyKsorted {
    
    public void ksort(int[] arr,int n,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<=k;i++){
            pq.add(arr[i]);
          
        }
        int j=0;
        for(int i=k+1;i<n;i++){
            arr[j]=pq.poll();
            pq.add(arr[i]);
            j++;
        }
        while(j<n){
            arr[j]=pq.poll();

            j++;
        }
    }
    public void print(int[] arr){
        for(int val:arr){
            System.out.print(val+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int k=3;
        int[] arr={2,6,3,12,56,8};
        int n =arr.length;
        nearlyKsorted b=new nearlyKsorted();
        b.ksort(arr,n,k);
        b.print(arr);
    }
}
