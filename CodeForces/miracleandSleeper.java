import java.util.Scanner;

public class miracleandSleeper {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int l=scn.nextInt();
                int r=scn.nextInt();
                int half=r/2;
                // System.out.println(half);
                if(half>=l){
                    System.out.println(r%(half+1));
                }else{
                    System.out.println(r%l);
                }
            }
            scn.close();
        }catch(Exception e){

        }
        
    }
}
