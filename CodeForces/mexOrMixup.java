import java.util.Scanner;

public class mexOrMixup {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int a=scn.nextInt();
                int b=scn.nextInt();
                int ans=a;
                int mod=(a-1)%4;
                int xor=a-1;
                if(mod==1){
                    xor=1;
                }else if(mod==2){
                    xor=a;
                }else if(mod==3){
                    xor=0;
                }

                if(xor==b){
                    System.out.println(ans);
                }else if((xor^a)==b){
                    System.out.println(ans+2);
                }else{
                    System.out.println(ans+1);
                }
            }
            scn.close();
        }catch(Exception e){

        }
    }
}
