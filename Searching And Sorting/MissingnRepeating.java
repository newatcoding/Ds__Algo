public class MissingnRepeating {

    //O1 space in place & On time
    public String missingnRepeating(int[] arr){
        int n=arr.length;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int val=Math.abs(arr[i]);
            if(arr[val -1]>0){
                arr[val-1]=-arr[val-1];
            }else{
                sb.append(val+" ");
            }
        }

        for(int i=0;i<n;i++){
            if(arr[i]>0){
                sb.append(i+1);
            }
        }


        return sb.toString();
    }


    //Using XOR
    private String  missingnRepeatingXOR(int[] arr){
        int xor=arr[0];
        int n=arr.length;
        //getting XOR of just missing numners
        for(int i=1;i<n;i++){
            xor^=arr[i];
        }
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        int x=0;
        int y=0;

        //Getting MSB aka criterion for our 2 sets 1 for on one for off
        int setBit=xor & ~(xor-1);

        //dividing in 2 setts
        for(int i=0;i<n;i++){
            if((arr[i] & setBit)!=0){
                x^=arr[i];
            }else{
                y^=arr[i];
            }
        }

        for(int i=1;i<=n;i++){
            if((i & setBit)!=0){
                x^=i;
            }else{
                y^=i;
            }
        }
        //
        return x+" "+y;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{4,3,6,2,1,1};
        MissingnRepeating b=new MissingnRepeating();
        System.out.println(b.missingnRepeating(arr));
        System.out.println(b.missingnRepeatingXOR(arr));
        
    }
}
