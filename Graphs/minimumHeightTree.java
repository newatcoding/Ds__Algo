import java.util.*;

public class minimumHeightTree {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] edgeList = new List[n];
        for (int i = 0; i < n; i++){
            edgeList[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }

        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int p0 = bfs(edgeList, 0, prev);

        prev = new int[n];
        Arrays.fill(prev, -1);
        int p1 = bfs(edgeList, p0, prev);

        List<Integer> path = new ArrayList<>();
        int i = p1;
        while (i != p0) {
            path.add(i);
            i = prev[i];
        }
        path.add(p0);

        List<Integer> res = new ArrayList<>();
        res.add(path.get(path.size() / 2));
        if (path.size() % 2 == 0) res.add(path.get(path.size() / 2 - 1));
        return res;
    }
    private static int bfs(List<Integer>[] edgeList, int start, int[] prev) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        prev[start] = start;
        int ret = start;
        while (!q.isEmpty()) {
            ret = q.poll();
            for (int i : edgeList[ret]) {
                if (prev[i] == -1) {
                    q.add(i);
                    prev[i] = ret;
                } 
            }
        }
        return ret;
    }

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int v=scn.nextInt();
        int e=scn.nextInt();
        int[][] arr=new int[v][2];

        for(int i=0;i<e;i++){
            arr[i][0]=scn.nextInt();
            arr[i][1]=scn.nextInt();
        }
        List<Integer> s=findMinHeightTrees(v,arr);
        for(int val:s){
            System.out.print(val+" ");
        }
        scn.close();
    }
}
