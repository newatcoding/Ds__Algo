import java.util.Scanner;

//cf 117 round
public class chatban {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        while(t-->0){
            int k=scn.nextInt();
            long x=scn.nextLong();
            long val=isvalid(x);
            if(val<=k){
                System.out.println(val);
                continue;
            }
            long vv=((long)k*(long)(k+1))/(long)2;
            // long v2=((long)(k-1)*(long)(k))/(long)2;
            k--;
            long left=x-vv;
            while(left>0 && k>0){
                left-=k;
                k--;    
                val++;
              
            }
            System.out.println(val);
           
        }
        scn.close();
    }
    public static long isvalid(long s)
    {
        
        double k = (-1.0 + Math.sqrt(1 + 8 * s)) / 2;
        return (long)Math.floor(k);
      
    }   
}
