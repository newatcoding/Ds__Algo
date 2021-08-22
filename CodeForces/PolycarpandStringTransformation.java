import java.util.Scanner;

public class PolycarpandStringTransformation {
    static class Pair{
        String s1;
        String s2;
        public Pair(String a,String b){
            s1=a;
            s2=b;
        }
    }
    public static int cnt[];
    public static void main(String[] args) {
        try{    
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                cnt=new int[26];
                String str=scn.next();
                str=str.trim();
                Pair ans=decript(str);
                String v=encript(ans);

                // System.out.println(v);
                if(v.compareTo(str)==0){
                    System.out.println(ans.s1+" "+ans.s2);
                }else{
                    System.out.println(-1);
                }
               
            }
            scn.close();
        }catch(Exception e){

        }
    }
    public static Pair decript(String str){
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        String order="";
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(cnt[ch-'a']==0){
                order+=ch;
            }
            cnt[ch-'a']++;
        }
        // System.out.println(order+"    1");
        int m=order.length();
        int originalLength=0;
        for(int i=0;i<m;i++){
            char ch=order.charAt(i);
            originalLength+=cnt[ch-'a']/(m-i);
        }
        // System.out.println(str+"    1");
        sb.reverse();
        String original=sb.toString().substring(0,originalLength);
        
        StringBuilder sb1=new StringBuilder(order);
        sb1.reverse();
        order=sb1.toString();

        return new Pair(original,order);
    }
    public static String encript(Pair p){
        String result=new String(p.s1);
        // System.out.println(p.s2+" "+p.s1);
        for(char ch:p.s2.toCharArray()){
            String temp="";
            String s1=new String(p.s1);
            for(char c2:s1.toCharArray()){
                if(c2-ch!=0){
                    // System.out.println(c2+" "+ch);
                    temp+=c2;
                    result+=c2;
                }
            }
            // System.out.println(temp);
            p.s1=temp;
        }

        return result;
    }
}
