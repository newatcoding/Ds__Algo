public class aa {
    public static void main(String[] args) {
        Integer a=10,b=25,c=15;
        Integer res=0;
        while(b>0){
            res+=(a%c)+(c%a);
            b-=(a%c);

            int temp=a;
            a=c;
            c=temp;
        }
        System.out.println(res);
    }
}
