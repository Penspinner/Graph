
package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Steven Liao
 * 108607000
 */
public class Main
{
    public static void main(String[] args)
    {
        Graph graph = createGraphFromFile();

        print(graph.getMinBandwidthPermutation());
        System.out.println("Minimum bandwidth: " + graph.getMinimumBandwith());
    }

    /**
     * Declares and initializes a new graph with information from a text file.
     * @return graph
     */
    public static Graph createGraphFromFile()
    {
        Graph graph = new Graph();
        try
        {
            File f = new File("g-bt-12-11.txt");
            Scanner file = new Scanner(f);

            int v = Integer.parseInt(file.next());
            int e = Integer.parseInt(file.next());

            Vertex vertex1, vertex2;
            Edge edge;
            for (int x = 0; x < e; x++)
            {
                vertex1 = new Vertex(Integer.parseInt(file.next()));
                vertex2 = new Vertex(Integer.parseInt(file.next()));

                if (!graph.containsVertex(vertex1))
                    graph.addVertex(vertex1);

                if (!graph.containsVertex(vertex2))
                    graph.addVertex(vertex2);

                edge = new Edge(vertex1, vertex2);

                graph.addEdge(edge);
            }
        } catch (FileNotFoundException e)
        {
            
        }
        return graph;
    }
    
    public static void print(ArrayList<Vertex> a)
    {
        for (int i = 0; i < a.size(); i++)
        {
            if (i == a.size() - 1)
                System.out.println(a.get(i).value);
            else
                System.out.print(a.get(i).value + " ");
        }
    }
    
//    public static void createGraphFromInput()
//    {
//        Scanner input = new Scanner(System.in);
//        
//        // PROMPT FOR NUMBER OF EDGES AND VERTICES
//        System.out.print("Enter the number of edges: ");
//        int e = Integer.parseInt(input.nextLine());
//        System.out.print("Enter the number of vertices: ");
//        int v = Integer.parseInt(input.nextLine());
//                
//        // INIT Graph g
//        Graph g = new Graph(e, v);
//        
//        // PROMPT FOR EDGES AND STORE INTO Graph
//        String[] edgeBetween;
//        Vertex vertex1, vertex2;
//        Edge newEdge;
//        for (int i = 0; i < e; i++)
//        {
//            edgeBetween = input.nextLine().split(" ");
//            vertex1 = new Vertex(Integer.parseInt(edgeBetween[0]));
//            vertex2 = new Vertex(Integer.parseInt(edgeBetween[1]));
//            vertex1.connectedVertices.add(vertex2);
//            vertex2.connectedVertices.add(vertex1);
//            newEdge = new Edge(vertex1, vertex2);
//            
//            if (!g.containsVertex(vertex1))
//                g.vertices.add(vertex1);
//            if (!g.containsVertex(vertex2))
//                g.vertices.add(vertex2);
//            if (!g.containsEdge(newEdge))
//                g.edges.add(newEdge);
//        }
//    }
}
