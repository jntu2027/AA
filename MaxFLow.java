import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxFLow {

    static int[][] capacity;
    static int source,sink,n;
    static List<Integer> path;

    private static boolean dfs(int cur,boolean[] visited){
        path.add(cur);
        visited[cur] = true;

        if (cur == sink) {
            return true;
        }

        for (int neighbours = 0;neighbours < n; neighbours++){
            if (!visited[neighbours] && (capacity[cur][neighbours] > 0)){
                if (dfs(neighbours, visited)){
                    return true;
                }
            }
        }
        path.remove(path.size()-1);
        return false;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        capacity = new int[n][n];

        System.out.println("Enter capacity matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                capacity[i][j] = sc.nextInt();
            }
        }

        // Source and Sink
        System.out.print("Enter source node (0 to " + (n-1) + "): ");
        source = sc.nextInt();

        System.out.print("Enter sink node (0 to " + (n-1) + "): ");
        sink = sc.nextInt();

        // Print input (for verification)
        System.out.println("\nCapacity Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(capacity[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Source: " + source);
        System.out.println("Sink: " + sink);

        int maxFLow = 0;

        while (true) {
            path = new ArrayList<>();
            boolean[] v = new boolean[n];
            if (!dfs(source, v)){
                break;
            }

            int pathMin = Integer.MAX_VALUE;
            for (int i = 0; i < path.size()-1;i++) pathMin = Math.min(pathMin, capacity[path.get(i)][path.get(i+1)]);

            for (int i = 0; i <  path.size()-1;i++) {
                capacity[path.get(i)][path.get(i+1)] -= pathMin;
                capacity[path.get(i+1)][path.get(i)] += pathMin;
            }

            for (int i = 0; i <  path.size();i++) {
                System.out.print(path.get(i) + " ");
            }

            System.out.println("\t-> Max FLow : " + pathMin);
            

            maxFLow  += pathMin;
        }

        System.out.println("Max FLow :- " + maxFLow);

        sc.close();
    }   
}
