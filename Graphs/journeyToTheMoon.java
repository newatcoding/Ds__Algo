import java.util.Scanner;
import java.util.*;
public class journeyToTheMoon {
   
        static List<Integer>[] vertices;
    
        public static void Graph(int count){   vertices = new ArrayList[count];
            
            for(int i = 0; i < count; i++){
                vertices[i] = new ArrayList<Integer>();
            }
        }
        
        public static void addEdge(int source, int destination){
            vertices[source].add(destination);
            vertices[destination].add(source);
        }
    
        public static int dfs(int source, boolean[] visited){
            visited[source] = true;
            int count = 1;
            
            for(Integer vertex: vertices[source]){
                if(!visited[vertex]){
                    count += dfs(vertex, visited);
                }
            }
            
            return count;
        }
    

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int l=scn.nextInt();

        Graph(n);
        
        for(int i = 0; i < l; i++){
            int source = scn.nextInt();
            int destination = scn.nextInt();
            
            addEdge(source,destination);
        }

        boolean[] visited = new boolean[n];
        List<Integer> countries = new ArrayList<Integer>();
        long combinations = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                countries.add(dfs(i, visited));
            }
        }

        int sum = 0;
        for(int country : countries){
            combinations += sum*country;
            sum += country;    
        } 

        System.out.println(combinations);

        scn.close();
    }   
}
