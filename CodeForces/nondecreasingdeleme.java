import java.util.*;

public class nondecreasingdeleme {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            int n=scn.nextInt();
            
            int[] A=new int[t+1];
            for(int i=0;i<t;i++) A[i]=scn.nextInt();
            A[t]=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                int type=scn.nextInt();
                int n1=scn.nextInt();
                int n2=scn.nextInt();
                
                if(type==1)
                {
                    A[n1-1]=n2;
                }
                if(type==2)
                {
                    // System.out.println("sup");
                    int r= n2-1,l=n1-1;
                    long ans=0, anchor=l;
                        for(int j=l;j<=r;j++)
                        {
                            if(A[j]>A[j+1] || j==r)
                            { 
                                
                                ans+=find(j-anchor+1);
                                ans+=(j-anchor+1);
                                anchor=j+1;
                            }
                        }
                    System.out.println(ans);
                }
        
            }
            
            
            scn.close();
        }catch(Exception e){

        }
        
    }
     
    public static long find(long n)
    {
        if(n<2)return 0;
        if(n==2)return 1;
        long comb = ((long)(n*(n-1))/2);
        return comb;
    }
}
