import java.util.Scanner;

public class MochaandRedandBlue {
    public static void main(String[] args) {
        try{
                Scanner scn=new Scanner(System.in);
                int t=scn.nextInt();
                while(t-->0){
                    int n=scn.nextInt();
                    String str=scn.next();
                    char[] ch=str.toCharArray();
                    int st=-1;
                    char toAvoid='R';
                    for(int i=0;i<n;i++){
                        if(str.charAt(i)!='?' && st==-1){
                            st=i;
                            toAvoid=str.charAt(i);
                            break;
                        }
                    }
                    for(int i=st-1;i>=0;i--){
                        ch[i]= ch[i+1]=='R'?'B':'R';
                    }
                    for(int i=st+1;i<n;i++){
                        if(ch[i]=='?'){
                            if(toAvoid=='R'){
                                ch[i]='B';
                                toAvoid='B';
                            }else{
                                ch[i]='R';
                                toAvoid='R';
                            }
                        }else{
                            toAvoid=ch[i];
                        }
                    }
                    System.out.println(new String(ch));
                }
                scn.close();
        }catch(Exception e){

        }
    }
}
