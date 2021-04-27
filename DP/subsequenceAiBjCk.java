import java.util.*;

public class subsequenceAiBjCk {
    
    public static int countSubsequences(String  str){
        int a=0;
        int b=0;
        int c=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a')
                a=1+2*a;
            else if(str.charAt(i)=='b')
                b=a+2*b;
            else if(str.charAt(i)=='c')
                c=b+2*c;
        }

        return c;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        System.out.println(countSubsequences(str));
        scn.close();
    }
}
