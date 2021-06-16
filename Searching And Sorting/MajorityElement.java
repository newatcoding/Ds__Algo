public class MajorityElement {
    // Moor's Voting Algorithm
    public int findMajor(int[] arr){
        int n=arr.length;
        int freq=1;
        int val=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]==val){
                freq++;
            }else{
                freq--;
                if(freq==0){
                    val=arr[i];
                    freq++;
                }
            }
        }
        return val;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,1,2,3,4,1,1,4,1,5,1};
        MajorityElement b=new MajorityElement();
        
        System.out.println(b.findMajor(arr));
    }
}
