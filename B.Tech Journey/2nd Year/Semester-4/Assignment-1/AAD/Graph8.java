import java.util.*;

class Graph8 {
    private int V;
    private LinkedList<Integer> adj[];

    Graph8(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Since the graph is undirected
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;

        for (Integer n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    boolean isConnected() {
        boolean visited[] = new boolean[V];
        DFSUtil(0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }

        return true;
    }

    public static void main(String args[]) {
        Graph8 g = new Graph8(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(3, 4);

        if (g.isConnected())
            System.out.println("Graph is connected");
        else
            System.out.println("Graph is not connected");
    }
}