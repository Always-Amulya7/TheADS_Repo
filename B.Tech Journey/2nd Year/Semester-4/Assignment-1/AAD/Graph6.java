import java.util.*;

class Graph6 {
    private int V;
    private LinkedList<Integer> adj[];

    Graph6(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    int countPathsUtil(int u, int d, boolean visited[], int pathCount) {
        visited[u] = true;

        if (u == d) {
            pathCount++;
        } else {
            for (Integer i : adj[u]) {
                if (!visited[i]) {
                    pathCount = countPathsUtil(i, d, visited, pathCount);
                }
            }
        }

        visited[u] = false;
        return pathCount;
    }

    int countPaths(int s, int d) {
        boolean visited[] = new boolean[V];
        int pathCount = 0;
        pathCount = countPathsUtil(s, d, visited, pathCount);
        return pathCount;
    }

    public static void main(String args[]) {
        Graph6 g = new Graph6(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        System.out.println("Number of paths from " + s + " to " + d + " is " + g.countPaths(s, d));
    }
}