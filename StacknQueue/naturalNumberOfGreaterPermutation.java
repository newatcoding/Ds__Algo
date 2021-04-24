import java.util.Scanner;
import java.util.Stack;

public class naturalNumberOfGreaterPermutation{

    public static int getpermu(int n){
        Stack<Integer> s=new Stack<>();
        int ans=0;
        for(int i=1;i<=9;i++){
            if(i<=n){
                s.push(i);
                ans++;
            }

            while(!s.empty()){
                int tp=s.peek();
                s.pop();
                for(int j=tp%10;j<=9;j++){
                    int x=tp*10+j;
                    if(x<=n){
                        s.push(x);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        System.out.println(getpermu(n));
        scn.close();

    }
}
