import java.util.Scanner;

public class carryconundrum1567C {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                String s=scn.next().trim();
                String s1="0";
                String s2="0";
                for(int i=0;i<s.length();i++){
                    if(i%2==0){
                        s1+=s.charAt(i);
                    }else{
                        s2+=s.charAt(i);
                    }
                }
                int n1=Integer.parseInt(s1);
                int n2=Integer.parseInt(s2);

                long ans=((long)(n1+1)*(long)(n2+1))-2;
                System.out.println(ans);
            }
            
            
            
            scn.close();
        }catch(Exception e){

        }
    }
}
