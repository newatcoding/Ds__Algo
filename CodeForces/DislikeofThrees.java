import java.util.Scanner;

public class DislikeofThrees {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int k=scn.nextInt();
                int st=0;
                while(k>18){
                    k=k-18;
                    st+=30;
 
                }
                int ans=1;
                for(int i=1;i<30;i++){
                    if(i==3 || i==13|| i==23){
                        continue;
                    }
                    if(i%3!=0){
                        k--;
                    }
 
                    if(k==0){
                        ans=i+st;
                        break;
                    }
                }
                System.out.println(ans);
                
            }
            scn.close();
        }catch(Exception e){
 
        }
        
        
    }
}
