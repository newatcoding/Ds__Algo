public class DungenMonster {
    public static void main(String[] args) {
        
    }
    public static  int check(int n,int m,int[][] p,int[][] c){
        int[] arr=new int[n];
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++){
            int min=0;
            for(int j=1;j<m;j++){
                if(p[i][j]< p[i][min]){
                    min=j;
                }
              
            }
            sum+=p[i][min];
            arr[i]=min;
            max=Math.max(max, p[i][min]);
        }
        int lo=max;
        int hi=sum;
        while(lo<=hi){
            int mid=lo+((hi-lo)/2);
            if(getans(mid,arr,p,c)){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
    public static boolean getans(int val,int[] arr,int[][] p,int[][] c){

        for(int i=0;i<arr.length;i++){
            if(p[i][arr[i]]>val){
                return false;
            }else{
                val=val-p[i][arr[i]]+c[i][arr[i]];
            }
        }

        return true;
    }
}
