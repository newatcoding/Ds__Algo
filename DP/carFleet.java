import java.util.Arrays;

public class carFleet {
    public static class Pair{
        int pos;
        double time;
        public Pair(int a,double b){
            pos=a;
            time=b;
        }
    }
    public static void main(String[] args) {
        int[] position=new int[]{};
        int[] speed=new int[]{};
        int target=0;
        Pair[] details=new Pair[speed.length];
        for(int i=0;i<speed.length;i++){
            details[i]=new Pair(position[i],(double)(target-position[i])/speed[i]);
        }
        Arrays.sort(details,(a,b)->{
            return a.pos-b.pos;
        });
        double curr=0;
        int ans=0;
        for(int i=details.length-1;i>=0;i--){
            if(details[i].time>curr){
                curr=details[i].time;
                ans++;
            }
        }
        System.out.println(ans);

    }
}
