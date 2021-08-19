import java.util.ArrayList;
import java.util.Scanner;

public class MakePowerOfTwo {
    public static ArrayList<Long> power;
    public static void main(String[] args) {
        try{    
            power=new ArrayList<Long>();
            for(long i=1;i<=2e18;i=i*2){
                power.add(i);
            }
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                String str=scn.next();
                long ans=str.length()+1;

                for(long val:power){
                    long v=solve(str,val+"");
                    if(v<0){
                        v=Integer.MAX_VALUE;
                    }
                    ans=Math.min(ans,v);
                    
                }
                System.out.println(ans);
            }
            scn.close();
        }catch(Exception e){

        }
       
    }
    public static int solve(String s, String t)
    {
        int tp = 0;
        int sp = 0;
        int taken = 0;
    
        while (sp < s.length() && tp < t.length())
        {
            if(s.charAt(sp) == t.charAt(tp))
            {
                taken++;
                tp++;
            }
            sp++;
        }
        // System.out.println(taken);
        return (int)s.length() - taken + (int)t.length() - taken;
    }
}
