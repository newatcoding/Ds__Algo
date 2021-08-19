import java.util.Arrays;

public class pairWithpowerCondition {
    
    private int count(int x,int[] y,int[] nY,int n){
        if(x==0){
            return 0;
        }
        if(x==1){
            return nY[0];
        }
        int idx=Arrays.binarySearch(y, x);
        int ans=0;
        if(idx<0){
            idx=Math.abs(idx+1);
            ans=n-idx;
        }else{
            while(idx<n && y[idx]==x){
                idx++;
            }
            ans=n-idx;
        }
        ans+=nY[0]+nY[1];
        if(x==2){
            ans-=nY[3]+nY[4];
        }
        if(x==3){
            ans+=nY[2];
        }


        return ans;
    }
    public int findPair(int[] x,int[] y,int m,int n){
        int[] nY=new int[5];
        for(int val:y){
            if(val<5){
                nY[val]++;
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            ans+=count(x[i],y,nY,n);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] x={2,1,6};
        int[] y={1,5};
        pairWithpowerCondition p=new pairWithpowerCondition();
        System.out.println(p.findPair(x, y, x.length, y.length));
    }
}
