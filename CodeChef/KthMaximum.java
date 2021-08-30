import java.util.Scanner;

public class KthMaximum {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                int k=scn.nextInt();
                int[] arr=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=scn.nextInt();
                    // max=Math.max(max,arr[i]);
                }
                int max=arr[0];
                for(int i=1;i<n;i++){
                    max=Math.max(max, arr[i]);
                }
                long ans=0;
                for(int i=k-1;i<n;i++){
                    if(arr[i]==max){
                        ans+=(long)(n-i);
                    }
                }
                System.out.println(ans);
            }
            scn.close();
        }catch(Exception e){

        }
    }
}
