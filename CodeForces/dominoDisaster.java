import java.util.*;

public class dominoDisaster {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                String s=scn.next();
                StringBuilder sb=new StringBuilder();
                for(int i=0;i<n;i++){
                    char ch=s.charAt(i);
                    if(ch=='U'){
                        sb.append('D');

                    }
                    else if(ch=='D'){
                        sb.append('U');
                    }else{
                        sb.append(ch);
                    }

                }
                System.out.println(sb.toString());
            }
            scn.close();
        }catch(Exception e){

        }
    }   
}
