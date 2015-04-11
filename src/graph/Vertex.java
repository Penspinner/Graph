
package graph;

import java.util.ArrayList;

public class Vertex 
{
    int value;
    boolean visited;
    ArrayList<Vertex> connectedVertices;
    
    Vertex(int value)
    {
        this.value = value;
        visited = false;
        connectedVertices = new ArrayList<Vertex>(); 
    }
}
