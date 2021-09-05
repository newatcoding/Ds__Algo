import java.util.*;

public class scenesFromAMemory {
    public static void main(String[] args) {
        try{
            int[] prime=new int[]{2,	3	,5,	7,	11,	13,	17,	19,	23,29,	31	,37	,41,	43,	47,	53,	59,	61,	67,
                71,	73,	79,	83,	89,	97};
            HashSet<Integer> set=new HashSet<>();
            for(int val:prime){
                set.add(val);
            }
            Scanner scn=new Scanner(System.in);
            int t=scn.nextInt();
            while(t-->0){
                // int k=scn.nextInt();
                String num=scn.next();
                boolean fnd=false;
                
                for(char ch:num.toCharArray()){
                    if((ch!='2' && ch!='3' && ch!='5' && ch!='7') || ( ch!='2' && (ch-'0')%2==0) ){
                        System.out.println("1");
                        System.out.println(ch);
                        fnd=true;
                        break;
                    }
                }
                if(fnd){
                    continue;
                }
                for(int i=0;i<num.length()-1;i++){
                    for(int j=i+1;j<num.length();j++){
                        String n=""+num.charAt(i)+num.charAt(j);
                        int numb=Integer.parseInt(n);
                        if(!set.contains(numb)){
                            System.out.println("2");
                            System.out.println(numb);
                            fnd=true;
                            break;
                        }
                    }
                    if(fnd){
                        break;
                    }
                }
               

            }
            scn.close();
        }catch(Exception e){

        }
    }  
}
