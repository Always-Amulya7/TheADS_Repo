import java.util.*;

class Graph9 {
    private int V;
    private LinkedList<Integer> adj[];

    Graph9(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        for (Integer n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    Graph9 getTranspose() {
        Graph9 g = new Graph9(V);
        for (int v = 0; v < V; v++) {
            for (Integer i : adj[v]) {
                g.adj[i].add(v);
            }
        }
        return g;
    }

    boolean isSC() {
        boolean visited[] = new boolean[V];
        DFSUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }

        Graph9 gr = getTranspose();
        visited = new boolean[V];
        gr.DFSUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    public static void main(String args[]) {
        Graph9 g = new Graph9(5);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        g.addEdge(4, 2);

        if (g.isSC())
            System.out.println("Graph is Strongly Connected");
        else
            System.out.println("Graph is not Strongly Connected");
    }
}