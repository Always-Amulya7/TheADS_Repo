import java.util.*;

class Graph1 {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency List

    Graph1(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUsingStack(int v) {
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            v = stack.pop();
            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;
            }
            for (int i = adj[v].size() - 1; i >= 0; i--) {
                int n = adj[v].get(i);
                if (!visited[n]) {
                    stack.push(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph1 g = new Graph1(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Depth First Traversal using Stack starting from vertex 2:");

        g.DFSUsingStack(2);
    }
}