import java.lang.Math;

public class BulbSwitcherAllVariation {
    public static void main(String[] args) {
        int n=3;          //number of bulbs
        int m=1;
        int[] arr={2,1,3,5,4};
        String str="10010110111";
        BulbSwitcherAllVariation o=new BulbSwitcherAllVariation();
        System.out.println(o.bulbSwitcher1(n));
        System.out.println(o.bulbSwitcher2(n,m));
        System.out.println(o.bulbSwitcher3(arr));
        System.out.println(o.bulbSwitcher4(str));
    }
    private int bulbSwitcher1(int n){
        return (int)Math.sqrt(n);
    }
    private int bulbSwitcher2(int n, int m){
        //total 8 possiblity 
        //total different possiblity from 4 switches are  all on , 1,2,3,4,1-4,2-4,3-4
        //we need to just see condition of n<3 and m<3
        if(m==0) return 1;                 // no different possiblity  All On
        if(n==1) return 2;                 //   [On , Off]
        if(n==2&&m==1) return 3;        //[Off, On] , [On, Off] , [Off, Off]
        if(n==2) return 4;            // [On, On],[Off, On] , [On, Off] , [Off, Off]
        if(m==1) return 4;             
        if(m==2) return 7;
        if(m>=3) return 8;
        return 8;
    }
    private int bulbSwitcher3(int[] light){
        // to find if you opened all bulb from 1 to n
        int max=0;
        int res=0;
        for(int i=0;i<light.length;i++){
            max=Math.max(max,light[i]);
            if(i+1==max)
                ++res;
        }
        return res;
    }
    private int bulbSwitcher4(String target){
        int i=0;
        int ans=0;
        while(i<target.length() && target.charAt(i)=='0'){
            i++;
        }
        if(i==target.length()){
            return ans;
        }
        ans++;
        char curr='1';
        for(;i<target.length();i++){
            if(target.charAt(i)!=curr){
                curr=curr=='1'?'0':'1';
                ans++;
            }
        }
        return ans;
    }
}
