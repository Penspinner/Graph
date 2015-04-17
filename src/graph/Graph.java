
package graph;

import java.util.ArrayList;
import java.util.Collections;

public class Graph 
{
    int minimumBandwidth;
    
    ArrayList<Edge> edges;
    ArrayList<Vertex> vertices;
    ArrayList<Vertex> minBandwidthPermutation;
    
    public Graph()
    {
        minimumBandwidth = Integer.MAX_VALUE;
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
        computeMinBandwidthPermutation(new ArrayList(vertices), 0);
        
        return minBandwidthPermutation;
    }
    
    /**
     * Computes every permutation, stores the minimum bandwidth and the permutation
     * in a global variable.
     * @param a
     * @param index 
     */
    public void computeMinBandwidthPermutation(ArrayList<Vertex> a, int index)
    {
        
        if (index == a.size() - 1)
        {
//            for (int i = 0; i < a.size(); i++)
//            {
//                if (i == a.size() - 1) System.out.println(a.get(i).value);
//                else System.out.print(a.get(i).value + ", ");
//            }
            int min = getMinimumBandwidth(a);
            if (minimumBandwidth > min)
            {
                minimumBandwidth = min;
                minBandwidthPermutation = new ArrayList(a);
            }
            
        } else
        {
            for (int i = index; i < a.size(); i++)
            {
                Collections.swap(a, i, index);
                computeMinBandwidthPermutation(a, index + 1);
                Collections.swap(a, index, i);
            }
        }
    }
    
    /**
     * Gets the minimum bandwidth of the current permutation.
     * @param a
     * @return minimum bandwidth (int)
     */
    public int getMinimumBandwidth(ArrayList<Vertex> a)
    {
        int minBandwidth = 0;
        int currentBandwidth;
        Edge e;

        for (int x = 0; x < edges.size(); x++)
        {
            e = edges.get(x);
            currentBandwidth = Math.abs(getIndex(a, e.v1) - getIndex(a, e.v2));
            if (currentBandwidth > minBandwidth) minBandwidth = currentBandwidth;
        }
        
        return minBandwidth;
    }
    
    /**
     * Gets the index of the Vertex in the ArrayList
     * @param a
     * @param v
     * @return index (int)
     */
    public int getIndex(ArrayList<Vertex> a, Vertex v)
    {
        for (int i = 0; i < a.size(); i++)
        {
            if (a.get(i).value == v.value) return i;
        }
        return -1;
    }
    
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
}
