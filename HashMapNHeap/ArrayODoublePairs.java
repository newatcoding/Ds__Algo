import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayODoublePairs {
    public static void main(String[] args) {
        int[] arr={4,-2,2,-4};
        ArrayODoublePairs o=new ArrayODoublePairs();
        System.out.println(o.reorder(arr));
    }
    private boolean reorder(int[] arr){
        Arrays.sort(arr);
        Map<Integer,Integer> map=new HashMap<>();
        for(int val:arr){
            map.put(val,map.getOrDefault(val, 0)+1);
        }
        Arrays.sort(arr);

        for(int val:arr){
            // int freq=map.get(val);
            if(val!=0 && map.get(val)>0){
                int tar=val*2;
                if(val<0){
                    if(val%2==1){
                        return false;
                    }else{
                        tar=val/2;
                    }
                }
                if(map.getOrDefault(tar, 0)<map.get(val)){
                    return false;
                }else{
                    map.put(tar,map.get(tar)-map.get(val));
                    map.put(val,0);
                }
            }
        }

        return true;
    }
}
