import java.util.Arrays;
import java.util.Random;

public class DijkstraAlgorithm {

    static final int INF = Integer.MAX_VALUE;

    // Method to find the vertex with the minimum distance value
    public static int findMinDistance(int[] dist, boolean[] visited) {
        int min = INF;
        int minIndex = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public static void dijkstra(int[][] graph, int src, boolean silent) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        long comparisons = 0;
        long operations = 0;

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = findMinDistance(dist, visited);
            if (u == -1) break; // All reachable nodes visited
            DIJKSTRA’S ALGORITHM ASSIGNMENT (JAVA IMPLEMENTATION)

INTRODUCTION
Dijkstra’s algorithm is used to find the shortest path from a source node to all other nodes in a graph. It works for graphs with non-negative edge weights and is commonly applied in areas such as network routing and navigation systems.

DESCRIPTION OF THE ALGORITHM
The algorithm begins by assigning a distance of zero to the source node and infinity to all other nodes. It then repeatedly selects the node with the smallest distance that has not yet been visited.
Once a node is selected, the algorithm checks all its neighboring nodes and updates their distances if a shorter path is found. This process continues until all nodes have been visited.

PROGRAM IMPLEMENTATION (JAVA)
Java
import java.util.Random;

public class DijkstraAlgorithm {

static final int INF = Integer.MAX_VALUE;  

public static int minDistance(int[] dist, boolean[] visited, int n) {  
    int min = INF;  
    int index = -1;  

    for (int i = 0; i < n; i++) {  
        if (!visited[i] && dist[i] < min) {  
            min = dist[i];  
            index = i;  
        }  
    }  
    return index;  
}  

public static void dijkstra(int[][] graph, int src) {  
    int n = graph.length;  

    int[] dist = new int[n];  
    boolean[] visited = new boolean[n];  

    int comparisons = 0;  
    int operations = 0;  

    for (int i = 0; i < n; i++) {  
        dist[i] = INF;  
        visited[i] = false;  
    }  

    dist[src] = 0;  

    for (int i = 0; i < n; i++) {  
        int u = minDistance(dist, visited, n);  
        visited[u] = true;  

        for (int v = 0; v < n; v++) {  
            comparisons++;  
            if (graph[u][v] > 0 && !visited[v]) {  
                if (dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {  
                    dist[v] = dist[u] + graph[u][v];  
                    operations++;  
                }  
            }  
        }  
    }  

    System.out.println("Shortest distances from source:");  
    for (int i = 0; i < n; i++) {  
        System.out.println("Node " + i + ": " + dist[i]);  
    }  

    System.out.println("Comparisons: " + comparisons);  
    System.out.println("Operations: " + operations);  
}  

public static int[][] generateGraph(int n) {  
    Random rand = new Random();  
    int[][] graph = new int[n][n];  

    for (int i = 0; i < n; i++) {  
        for (int j = 0; j < n; j++) {  
            if (i != j) {  
                graph[i][j] = rand.nextInt(20) + 1;  
            }  
        }  
    }  
    return graph;  
}  

public static void main(String[] args) {  

    int[][] graph = {  
        {0, 4, 0, 0, 0, 0},  
        {4, 0, 8, 0, 0, 0},  
        {0, 8, 0, 7, 0, 4},  
        {0, 0, 7, 0, 9, 14},  
        {0, 0, 0, 9, 0, 10},  
        {0, 0, 4, 14, 10, 0}  
    };  

    dijkstra(graph, 0);  

    int[] sizes = {1, 2, 3, 4, 5, 10, 250};  

    for (int size : sizes) {  
        int[][] g = generateGraph(size);  
        System.out.println("\nGraph size: " + size);  
        dijkstra(g, 0);  
    }  
}

}

STEP BY STEP ILLUSTRATION
Using node 0 as the source:
Initial state: dist = [0, ∞, ∞, ∞]
Step 1: Visit node 0 → update node 1 → dist = [0, 4, ∞, ∞]
Step 2: Visit node 1 → update node 2 → dist = [0, 4, 12, ∞]
Step 3: Visit node 2 → update node 3 → dist = [0, 4, 12, 19]
Step 4: Visit node 3 → final shortest distances obtained.

TIME COMPLEXITY
The time complexity of this implementation is:
Best Case: O(V²)
Average Case: O(V²)
Worst Case: O(V²)
This is because the algorithm uses an adjacency matrix and repeatedly scans all vertices regardless of the input.

SPACE COMPLEXITY
The algorithm uses:
A distance array
A visited array
Therefore, the space complexity is O(V).

RESULTS AND OBSERVATIONS
After testing the algorithm with different input sizes:
The number of comparisons increases as the number of nodes increases
The number of operations also increases significantly
This confirms the quadratic growth in time complexity

CONCLUSION
Dijkstra’s algorithm is an effective method for finding shortest paths in graphs with non-negative weights. Although it is simple to implement, its efficiency decreases as the graph size increases. Using advanced data structures such as priority queues can improve performance.

PLEASE CONVERT THIS TO A PDF
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                comparisons++;
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF 
                    && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    operations++;
                }
            }
        }

        if (!silent) {
            System.out.println("Vertex \t Distance from Source " + src);
            for (int i = 0; i < V; i++) {
                System.out.println(i + " \t\t " + (dist[i] == INF ? "INF" : dist[i]));
            }
        }
        System.out.println("Nodes: " + V + " | Comparisons: " + comparisons + " | Relaxations: " + operations);
    }

    // Helper to generate a random adjacency matrix
    public static int[][] generateGraph(int n) {
        Random rand = new Random();
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && rand.nextDouble() > 0.5) { // 50% chance of an edge
                    graph[i][j] = rand.nextInt(20) + 1;
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        // Test with the sizes required by the instructions
        int[] sizes = {1, 2, 3, 4, 5, 10, 250, 999, 9999};

        System.out.println("--- DIJKSTRA ALGORITHM PERFORMANCE TEST ---");
        for (int size : sizes) {
            int[][] g = generateGraph(size);
            // We use 'true' for larger sizes to avoid flooding the console with distances
            dijkstra(g, 0, size > 10); 
        }
    }
}
