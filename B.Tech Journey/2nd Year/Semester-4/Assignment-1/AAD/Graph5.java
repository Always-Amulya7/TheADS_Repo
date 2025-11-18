import java.util.*;

class Graph5 {
    private int V;
    private LinkedList<Integer> adj[];

    Graph5(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    boolean isReachable(int s, int d) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        Iterator<Integer> i;
        while (!queue.isEmpty()) {
            s = queue.poll();
            int n;
            i = adj[s].listIterator();

            while (i.hasNext()) {
                n = i.next();
                if (n == d) {
                    return true;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Graph5 g = new Graph5(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int u = 1;
        int v = 3;
        if (g.isReachable(u, v))
            System.out.println("There is a path from " + u + " to " + v);
        else
            System.out.println("There is no path from " + u + " to " + v);
    }
}