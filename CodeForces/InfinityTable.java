import java.util.Scanner;

public class InfinityTable {
    public static void main(String[] args) {
        try{
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                int n=scn.nextInt();
                int row=1;
                int col=1;
                while(row*col<n){
                    row++;
                    col++;
                }
                int num=n-((row-1)*(col-1));
                if((num-col)<=0){  
                    System.out.println((num)+" "+col);
                    
                }else{
                    System.out.println((row)+" "+(col-(num-row)));
                }
                
            }
            scn.close();
        }catch(Exception e){
 
        }
    }
}
