// Implementation of Dijkstra's Algorithm  
// using Priority Queue 
import java.util.*; 
public class DPQ { 
    private Integer dist[]; 
    private Set<Integer> settled; 
    private PriorityQueue<T> pq; 
    private Integer V; // Number of vertices 
    List<List<T> > adj; 
  
    public DPQ(Integer V) 
    { 
        this.V = V; 
        dist = new Integer[V]; 
        settled = new HashSet<>(); 
        pq = new PriorityQueue<>(V, new T()); 
    } 
  
    // Function for Dijkstra's Algorithm 
    public void dijkstra(List<List<T>> adj, Integer src) 
    {
        try
        {
            this.adj = adj; 

            for (Integer i = 0; i < V; i++) 
                dist[i] = null; 

            // Add source node to the priority queue 
            pq.add(new T(src, 0)); 

            // Distance to the source is 0 
            dist[src] = 0; 
            while (settled.size() != V)
            { 
                // remove the minimum distance node  
                // from the priority queue  
                Integer u = pq.remove().node; 

                // adding the node whose distance is 
                // finalized 
                settled.add(u); 

                e_Neighbours(u); 
            } 
        }
        catch (Exception e)
        {}
    } 
  
    // Function to process all the neighbours  
    // of the passed node 
    private void e_Neighbours(Integer u) 
    {
        try
        {
            Integer edgeDistance; 
            Integer newDistance; 

            // All the neighbors of v 
            for (Integer i = 0; i < adj.get(u).size(); i++) { 
                T v = adj.get(u).get(i);

                // If current node hasn't already been processed 
                if (!settled.contains(v.node) && v.cost != null) {
                    edgeDistance = v.cost; 
                    newDistance = dist[u] + edgeDistance; 

                    // If new distance is cheaper in cost 
                    if (newDistance < dist[v.node] || dist[v.node] == null) 
                        dist[v.node] = newDistance; 

                    // Add the current node to the queue 
                    pq.add(new T(v.node, dist[v.node])); 
                } 
            }
        }
        catch (Exception e)
        {}
    }
  
    // Driver code 
    public static void main(String arg[]) 
    {
        String Chrs = "abcdefghijklmnopqrstuvwxyz";
        Integer V = 10;      //create an array of vertices and edges from vertices
        Integer root = 0;     // get value from vertice source
        Integer max = 999999;    //get max of array
        
        // Adjacency list representation of the  
        // connected edges 
        List<List<T>> adj = new ArrayList<>();
        Graph g = new Graph();
  
        // Initialize list for every node and setup graph
        g.setup(adj, V);
        
        g.print(adj);
        // Calculate the single source shortest path 
        DPQ dpq = new DPQ(V); 
        dpq.dijkstra(adj, root); 
  
        // Print the shortest path to all the nodes 
        // from the source node 
        System.out.println("The shorted path from node :"); 
        for (Integer i = 0; i < dpq.dist.length; i++)
        {
            if (dpq.dist[i] == null)
                System.out.println(Chrs.charAt(root) + " to " + Chrs.charAt(i) + " is <no link>");
            else
                System.out.println(Chrs.charAt(root) + " to " + Chrs.charAt(i) + " is " + dpq.dist[i]);
        }
    } 
}

/******************************************************************************/

// Class to represent a node in the graph 
class T implements Comparator<T> { 
    public Integer node; 
    public Integer cost; 
  
    public T() 
    {} 
  
    public T(Integer node, Integer cost) 
    { 
        this.node = node; 
        this.cost = cost; 
    } 
  
    @Override
    public int compare(T node1, T node2) 
    { 
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    } 
}

/******************************************************************************/

// Class to setup and print Graph
class Graph {
    String Chrs = "abcdefghijklmnopqrstuvwxyz";
    public void setup(List<List<T> > adj, int V) {
        // Initialize list for every node 
        for (int i = 0; i < V; i++)         //Init for each row
        {
            List<T> item = new ArrayList<>(); 
            adj.add(item);
            
            for (int j = 0; j < V; j++)     //Init for each node of rows
            {
                T node = new T(j, null);
                adj.get(i).add(node);
            }
        }
        
        //From a
        adj.get(Chrs.indexOf('a')).set(Chrs.indexOf('e'), 
                                        new T(Chrs.indexOf('e'), 1));
        adj.get(Chrs.indexOf('a')).set(Chrs.indexOf('h'), 
                                        new T(Chrs.indexOf('h'), 10));
        //From b
        adj.get(Chrs.indexOf('b')).set(Chrs.indexOf('c'), 
                                        new T(Chrs.indexOf('c'), 2));
        //From c
            /*no path*/
        //From d
        adj.get(Chrs.indexOf('d')).set(Chrs.indexOf('a'), 
                                        new T(Chrs.indexOf('a'), 4));
        adj.get(Chrs.indexOf('d')).set(Chrs.indexOf('h'), 
                                        new T(Chrs.indexOf('h'), 1));
        //From e
        adj.get(Chrs.indexOf('e')).set(Chrs.indexOf('f'), 
                                        new T(Chrs.indexOf('f'), 3));
        //From f
        adj.get(Chrs.indexOf('f')).set(Chrs.indexOf('b'), 
                                        new T(Chrs.indexOf('b'), 1));
        adj.get(Chrs.indexOf('f')).set(Chrs.indexOf('c'), 
                                        new T(Chrs.indexOf('c'), 3));
        adj.get(Chrs.indexOf('f')).set(Chrs.indexOf('g'), 
                                        new T(Chrs.indexOf('g'), 7));
        adj.get(Chrs.indexOf('f')).set(Chrs.indexOf('i'), 
                                        new T(Chrs.indexOf('i'), 1));
        //From g
            /*no path*/
        //From h
        //adj.get(Chrs.indexOf('h')).set(Chrs.indexOf('e'), 
                                        //new T(Chrs.indexOf('e'), 5));
        adj.get(Chrs.indexOf('h')).set(Chrs.indexOf('i'), 
                                        new T(Chrs.indexOf('i'), 9));
        //From i
        adj.get(Chrs.indexOf('i')).set(Chrs.indexOf('j'), 
                                        new T(Chrs.indexOf('j'), 2));
        //From j
        adj.get(Chrs.indexOf('j')).set(Chrs.indexOf('g'), 
                                        new T(Chrs.indexOf('g'), 1));
        //Done//
    }
    
    public boolean nodeSetup(List<List<T> > adj, ArrayList<String> relations)
    {
        for (String s : relations) {
            String[] sArray = s.split("-");
            int start = 0, end = 0;
        }
        return false;
    }
    private int converter(String num)
    {
        switch (num) {
            case "a":
                return 0;
            case "b":
                return 1;
            case "c":
                return 2;
            case "d":
                return 3;
            case "e":
                return 4;
            case "f":
                return 5;
            case "g":
                return 6;
            case "h":
                return 7;
            case "i":
                return 8;
            case "j":
                return 9;
            case "k":
                return 10;
            case "l":
                return 11;
            case "m":
                return 12;
            case "n":
                return 13;
            case "o":
                return 14;
            case "p":
                return 15;
            case "q":
                return 16;
            case "r":
                return 17;
            case "s":
                return 18;
            case "t":
                return 19;
            case "u":
                return 20;
            case "v":
                return 21;
            case "w":
                return 22;
            case "x":
                return 23;
            case "y":
                return 24;
            case "z":
                return 25;
        }
        return -1;
    }
    
    public void print(List<List<T> > adj) {
        for (List<T> list : adj) {
            for (T t : list) {
                if (t.cost != null)
                    System.out.print(t.cost + " ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
    }
}