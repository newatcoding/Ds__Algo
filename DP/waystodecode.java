public class waystodecode {
    public static void main(String[] args) {
        String A="5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190";
        if(A.charAt(0)=='0'){
            System.out.println(0); 
        }
        int[] ans=new int[A.length()+1];
        ans[0]=1;
        for(int i=0;i<A.length();i++){
            if(Character.getNumericValue(A.charAt(i))==0){
                System.out.println("x");
                if(Character.getNumericValue(A.charAt(i))<1 || Character.getNumericValue(A.charAt(i))>2 ){
                    System.out.println(0); 
                    return ;
                }
                ans[i+1]=ans[i-1];
            }else{
                 int v1=0;int v2=0;
                if(i>0 && A.charAt(i-1)>='1' && A.charAt(i)<='2'){
                    if(A.charAt(i-1)=='1') {
                        v1=ans[i-1];
                    }else if(A.charAt(i)<='6'){
                        v2=ans[i-1];
                    }
                }
                ans[i+1]=ans[i]+v1+v2;
            }
        }
        System.out.println(ans[A.length()]);
        for(int i=0;i<=A.length();i++){
            System.out.print(ans[i]);
        }
    }
}
