import java.util.Collections;
import java.util.PriorityQueue;

public class MinNoOfStops {
    public static void main(String[] args) {
        int target=100;
        int curFuel=10;
        int[][] stops={{10,100}}; 
        MinNoOfStops o=new MinNoOfStops();
        System.out.println(o.getans(target,curFuel,stops));
    }   
    private int getans(int tar,int fuel,int[][] stops){
        if(fuel>=tar){
            return 0;
        }
        if(fuel<stops[0][0]){
            return -1;
        }
        int reFuel=0;
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        int dist=0;
        for(int[] stop:stops){
            while(dist+fuel<stop[0]){
                if(q.size()==0){
                    return -1;
                }
                int fuelStop=q.poll();
                fuel+=fuelStop;
                reFuel++;
            }

            fuel-=(stop[0]-dist);
            dist=stop[0];

            q.offer(stop[1]);

        }

        while(dist+fuel<tar){
            if(q.size()==0){
                return -1;
            }
            int fuelStop=q.poll();
            fuel+=fuelStop;
            reFuel++;
        }
        return reFuel;
    }
}
