import java.util.ArrayList;

public class totalnonconsecOnes {
    public static void main(String[] args) {
        int n=3;
        ArrayList<String> ans=recur(n);
        for(String val: ans){
            System.out.println(val);
        }   
    }
    public static ArrayList<String> recur(int n){
        if(n==1){
            ArrayList<String> a =new ArrayList<>();
            a.add("0");
            a.add("1");
            return a;
        }
        ArrayList<String> ans=recur(n-1);
        ArrayList<String> v=new ArrayList<>();
        for(String val:ans){
            if(val.charAt(n-2)=='0'){
                v.add(val+"0");
                v.add(val+"1");
            }else{
                v.add(val+"0");
            }
        }
        return v;
    }
}
