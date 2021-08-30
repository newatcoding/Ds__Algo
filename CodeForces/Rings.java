import java.util.Scanner;

public class Rings {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                char[] ch=scn.next().trim().toCharArray();
                boolean fnd=false;
                for(int i=0;i<n;i++){
                    if(ch[i]==  '0'){
                       fnd=true;
                        if(i>=n/2){
                            System.out.println(1+" "+(i+1)+" "+1+" "+i);
                            break;
                        }else{
                            System.out.println((i+2)+" "+n+" "+(i+1)+" "+n);
                            break;
                        }
                    }
                }
                if(!fnd){
                    System.out.println(1+" "+(n-1)+" "+2+" "+n);
                }
            }
            scn.close();
        }catch(Exception e){

        }
        
    }
}
