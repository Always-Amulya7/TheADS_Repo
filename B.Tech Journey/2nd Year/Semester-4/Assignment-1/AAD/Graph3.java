import java.util.*;

class Graph3 {
    private int V;
    private LinkedList<Integer> adj[];

    Graph3(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        distance[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            for (Integer n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    distance[n] = distance[s] + 1;
                    queue.add(n);
                }
            }
        }

        System.out.println("\nDistances from source:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " : " + distance[i]);
        }
    }

    public static void main(String args[]) {
        Graph3 g = new Graph3(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Breadth First Traversal starting from vertex 2:");

        g.BFS(2);
    }
}