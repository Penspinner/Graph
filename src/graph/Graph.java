
package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph 
{
    int numEdges;
    int numVertices;
    int minimumBandwidth;
    int totalBandwidth;
    
    ArrayList<Edge> edges;
    ArrayList<Vertex> vertices;
    ArrayList<Vertex> minBandwidthPermutation;
    
    public Graph()
    {
        this(0, 0);
    }
    
    public Graph(int numEdges, int numVertices)
    {
        this.numEdges = numEdges;
        this.numVertices = numVertices;
        minimumBandwidth = Integer.MAX_VALUE;
        totalBandwidth = Integer.MAX_VALUE;
        edges = new ArrayList();
        vertices = new ArrayList();
        minBandwidthPermutation = new ArrayList(vertices);
    }
    
    // TRY TO MINIMIZE THE MAXIMUM LENGTH TO EACH CONNECTED VERTICES
    public int getMinimumBandwith()
    {
        return minimumBandwidth;
    }
    
    public ArrayList<Vertex> getMinBandwidthPermutation()
    {
        computeMinBandwidthPermutation(new ArrayList(vertices), new ArrayList());
        
        return minBandwidthPermutation;
    }
    
    public void computeMinBandwidthPermutation(ArrayList<Vertex> a1, ArrayList<Vertex> a2)
    {
        
        if (a1.isEmpty())
        {
            int min = getMinimumBandwidth(a2);
            if (minimumBandwidth > min)
            {
                minimumBandwidth = min;
            }
            
        } else
        {
            
        }
    }
    
    public int getMinimumBandwidth(ArrayList<Vertex> a)
    {
        int minBandwidth = 0;
        
        for (int i = 0; i < a.size(); i++)
        {
            
        }
        
        return minBandwidth;
    }
    
//    public void print(Vertex v1, Vertex v2)
//    {
//        System.out.print(v1.value + " - " + v2.value + "\n");
//    }
//
//    public void depthFirstSearch(Vertex v)
//    {
//        if (v == null) return;
//        
//        ArrayList<Vertex> neighbors = getNeighbors(v);
//        
//        for (Vertex neighbor: neighbors)
//        {
//            if (!neighbor.visited)
//            {
//                neighbor.visited = true;
//                print(v, neighbor);
//                depthFirstSearch(neighbor);
//            }
//        }
//    }
//    
//    public ArrayList<Vertex> getNeighbors(Vertex v)
//    {
//        ArrayList<Vertex> neighbors = new ArrayList();
//        for (Edge e: edges)
//        {
//            if (e.v1.value == v.value)
//                neighbors.add(e.v2);
//            else if (e.v2.value == v.value)
//                neighbors.add(e.v1);
//        }
//        return neighbors;
//    }
//    
//    public void printConnectedComponents()
//    {
//        for (Vertex v: vertices)
//        {
//            if (!v.visited)
//            {
//                v.visited = true;
//                depthFirstSearch(v);
//            }
//        }
//    }
    
    public void addVertex(Vertex v)
    {
        vertices.add(v);
    }
    
    public void addEdge(Edge e)
    {
        edges.add(e);
    }
    
    public boolean containsVertex(Vertex v)
    {
        for (Vertex vx : vertices)
        {
            if (v.value == vx.value) return true;
        }
        return false;
    }
    
    public boolean containsEdge(Edge e)
    {
        for (Edge ed : edges)
        {
            if ((e.v1.value == ed.v1.value &&
                e.v2.value == ed.v2.value) ||
                (e.v2.value == ed.v1.value &&
                e.v1.value == ed.v2.value))
                return true;
        }
        return false;
    }
}
