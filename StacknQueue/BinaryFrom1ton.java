import java.util.LinkedList;
import java.util.*;

public class BinaryFrom1ton {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        Queue<String> str=new LinkedList<>();
        str.add("1");
        while(n-->0){
            String s=str.remove();
            System.out.print(s+" ");
            str.add(s+"0");
            str.add(s+"1");
        }
        System.out.println();
        scn.close();
    }
}
