public class CeilnFloor {
   public int ceil(int[] arr,int l,int r,int key){
        
        while(l<r){
            int m=l+(r-l)/2;
            if(arr[m]>=key){
                r=m;
            }else{
                l=m+1;
            }
        }
        return r;
        
   }
   public int floor(int[] arr,int l,int r,int key){    
        while(l+1<r){
            int m=l+(r-l)/2;
            if(arr[m]<=key){
                l=m;
            }else{
                r=m-1;
            }
        }
        return l; 
        // System.out.println("adawdd");
        // return 1;
    }          
   public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,5,6,8,9,10};
        CeilnFloor b=new CeilnFloor();
        System.out.println(b.ceil(arr, 0, arr.length, 5));
        System.out.println(b.floor(arr, 0, arr.length, 2));
    }
}
