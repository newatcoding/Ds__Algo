import java.util.Scanner;

public class PolycarpandStringTransformation {
    public static void main(String[] args) {
        try{    
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                String str=scn.next();
                int ans=decript(str);
                int v=encript(ans);

                System.out.println(ans);
            }
            scn.close();
        }catch(Exception e){

        }
    }
}
