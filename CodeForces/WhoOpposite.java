import java.util.Scanner;

public class WhoOpposite {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int a=scn.nextInt();
                int b=scn.nextInt();
                int c=scn.nextInt();
                
 
                int diff=Math.abs(a-b);
                int total=2*diff;
                // int min=Math.min(a,b);
                int max=Math.max(a,b);
                if(total<max){
                    System.out.println(-1);
                    continue;
                }
                int p1=c+diff;
                int p2=c-diff;
                if(p1<=total && c>=1){
                    System.out.println(p1);
                }else if(p2>=1 && c<=total){
                    System.out.println(p2);
                }else{
                    System.out.println(-1);
                }
 
               
                
            }
            scn.close();
        }catch(Exception e){
 
        }
        
        
    }
}
