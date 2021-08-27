import java.util.Arrays;
import java.util.Scanner;

public class simplestrangesort {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                int[] arr=new int[n];
                int[] tobe=new int[n];
                for(int i=0;i<n;i++){
                    arr[i]=scn.nextInt();
                    tobe[i]=arr[i];
                }
                Arrays.sort(tobe);
                int ans=0;


                // System.out.print(arr.equals(tobe));
                while(!sorted(arr)){
                    for(int i=ans%2;i<n-1;i+=2){
                        if(arr[i]>arr[i+1]){
                            int temp=arr[i];
                            arr[i]=arr[i+1];
                            arr[i+1]=temp;
                        }
                     }
                     ans++;
                }
    
                System.out.println(ans);
            }

            scn.close();
        }catch(Exception e){

        }
    }
    public static boolean  sorted(int[] arr){
        boolean isSorted=true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=i+1){
                isSorted=false;
                break;
            }
        }
        return isSorted;
    }
   
}
