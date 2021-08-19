import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class sortWRTsetBits {
    public static class comp implements Comparator<Integer>{
        @Override
        public int compare(Integer a,Integer b){
            int s=Integer.bitCount(a);
            int t=Integer.bitCount(b);
            return t-s;
        }
    }
    public static  void main(String[] args) {
        Integer arr[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
        sortWRTsetBits s=new sortWRTsetBits();

        Arrays.sort(arr,new comp());
      
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
