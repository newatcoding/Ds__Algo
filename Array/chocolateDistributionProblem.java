public class chocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr={1, 2, 10, 7, 6, 4, 5, 5, 5, 6};
        //3 cases 
        //increasing  ,, flat, decreasing (for which we will create best case and sum function)
        int i=0;int j=0;int val=1;
        int n=arr.length;
        int ans=0;
        while(j<n-1){
            //decreasing
            if(arr[j]>arr[j+1]){
                j++;
                continue;
            }
            //adding conditions
            if(i==j){
                ans+=val;
            }else{
                ans+=getsum(val,i,j);
                val=1;
            }
            //increasing
            if(arr[j]<arr[j+1]){
                val++; //because now next child needs 1  larger candy than this jth child
            }else{
                //flat case
                val=1;  // least amount of candy for next if you and next one are equal
            }
            j++;
            i=j;
        }
        if(i==j){
            ans+=val;
        }else{
            ans+=getsum(val, i, j);
        }
        System.out.println(ans);
    }
    public static int getsum(int peak,int start,int end){
        int count = end - start + 1;
        peak = (peak > count) ? peak : count;
        int s = peak + (((count - 1) * count) >> 1);
  
        return s;
    }
}
