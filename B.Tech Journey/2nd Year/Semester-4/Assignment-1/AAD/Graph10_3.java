import java.util.*;

public class Graph10_3 {
    static class Edge {
        int target;
        int weight;
        
        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;
        
        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    
    public static void dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            
            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        
        // Print the shortest distances from source to all vertices
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Vertex " + i + " is unreachable from source.");
            } else {
                System.out.println("Distance from source to vertex " + i + " is " + dist[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        int V = 6; // Number of vertices in the graph
        List<List<Edge>> graph = new ArrayList<>(V);
        
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Adding edges to the graph
        graph.get(0).add(new Edge(1, 5));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));
        graph.get(4).add(new Edge(5, 1));
        
        // Running Dijkstra's algorithm from source vertex 0
        dijkstra(graph, 0);
    }
}
