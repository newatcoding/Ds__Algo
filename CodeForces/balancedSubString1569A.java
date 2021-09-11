import java.util.Scanner;

public class balancedSubString1569A {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                String s=scn.next();
                int[] a=new int[n];
                int[] b=new int[n];
                int ca=-1;
                int cb=-1;
                boolean fnd=false;
                for(int i=0;i<s.length();i++){
                    char ch=s.charAt(i);
                    if(ch=='a'){
                        ca++;
                    }else{
                        cb++;
                    }
                    a[i]=ca;
                    b[i]=cb;
                  
                }
                if(a[s.length()-1]==b[s.length()-1]){
                    System.out.println("1 "+s.length());
                    continue;
                }
                for(int i=n-1;i>0;i--){
                    for(int j=-1;j<i;j++){
                        if(j==-1){
                            if(b[i]==a[i]){
                                System.out.println((j+2)+" "+(i+1));
                                fnd=true;
                                break;
                            }
                            continue;
                        }
                        if((b[i]-b[j])==(a[i]-a[j])){
                            System.out.println((j+2)+" "+(i+1));
                            fnd=true;
                            break;
                        }
                    }
                    if(fnd){
                        break;
                    }
                }

                if(!fnd){
                    System.out.println("-1 -1");
                }   
                
            }
            scn.close();
        }catch(Exception e){

        }
    }
}
