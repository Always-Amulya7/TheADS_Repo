import java.util.*;

class Graph7 {
    private int V;
    private LinkedList<Integer> adj[];

    Graph7(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isCyclicUtil(int i, boolean visited[], boolean recStack[]) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;
        recStack[i] = true;

        for (Integer c : adj[i]) {
            if (isCyclicUtil(c, visited, recStack))
                return true;
        }

        recStack[i] = false;
        return false;
    }

    boolean isCyclic() {
        boolean visited[] = new boolean[V];
        boolean recStack[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack))
                return true;
        }

        return false;
    }

    public static void main(String args[]) {
        Graph7 g = new Graph7(4);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        if (g.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain cycle");
    }
}