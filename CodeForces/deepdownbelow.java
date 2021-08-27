
import java.util.*;

public class deepdownbelow {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                ArrayList<int[]> arr=new ArrayList<int[]>(n);
                int min=Integer.MAX_VALUE;
                int overallMax=Integer.MIN_VALUE;
                for(int i=0;i<n;i++){
                    
                    int k=scn.nextInt();
                    int[] arr1=new int[k+1];
                    arr.add(arr1);
                    int max=Integer.MIN_VALUE;
                    int j=0;
                    while(j<k){
                        int val=scn.nextInt();
                        max=Math.max(max,val-j);
                       
                        arr.get(i)[j]=val;
                        min=Math.min(min, val);
                        
                        j++;
                    }
                    arr.get(i)[j]=max;
                  
                    overallMax=Math.max(max, overallMax);
                }
                // Collections.sort
                Collections.sort(arr,(a,b)->{
                    return a[a.length-1]-b[b.length-1];
                });
                int lo=min;
                int hi=overallMax;
                // System.out.println(hi);
                while(lo<hi){
                    //  System.out.println(lo);
                    int mid=lo +(hi-lo)/2;
                    if(notEnough(arr,mid,arr.size())){
                        lo=mid+1;
                    }else{ //
                        hi=mid;
                    }
                }
                System.out.println((lo+1));
            }    
            
            scn.close();
        }catch(Exception e){

        }
        
    }   
    public static boolean notEnough(ArrayList<int[]> arr,int power,int size){
        // System.out.println(arr.size());
        for(int i=0;i<size;i++){
            int[] arr1=arr.get(i);
            // System.out.println(arr1[0]+" "+arr1[1]);
            for(int j=0;j<arr1.length-1;j++){
              
                if(power<arr1[j]){
                    return true;
                }
                power++;
            }
          
        }
        return false;
    }
}
