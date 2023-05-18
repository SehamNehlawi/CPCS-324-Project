/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package GraphFramework;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MHPrimAlg extends MSTAlgorithm{

    // CONSTRUCTOR
    public MHPrimAlg(Graph graph) {
        super(graph);
    }

    // METHODS
    @Override
    public void displayResultingMST() {
        
        //-------------------------- Generate MST ------------------------------    
        // Initialize set of visitid vertices with a single vertex
        graph.vertices[0].isVisited = true;
        
        // Needed variables
        int cost = 0;
        Vertex vertex;
        Edge minEdge;
        
        // Create a min-heap priority queue to store the edges
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight)); // Create Comparator object
        minHeap.addAll(graph.vertices[0].adjList);
        
        while (!minHeap.isEmpty()) {

            // Extract Minimum-weight edge
            minEdge = minHeap.poll();
            vertex = minEdge.target;

            // Check if the vertex is already visited 
            if (vertex.isVisited) {
                continue;
            }

            // Mark the vertex as visited
            vertex.isVisited = true;

            // Add the new edge to the set of result edges
            MSTResultList.add(minEdge);
            cost += minEdge.weight;

            // Add the adjacent edges of the newly visited vertex to the min-heap
            minHeap.addAll(vertex.adjList);
        } // End loop
        

        //-------------------------- Display MST -------------------------------
        System.out.println("The phone network (minimum spanning tree) "
                            + "generated by min-heap based Prim algorithm is as follows:");  
        for (Edge obj : MSTResultList)
            obj.displayInfo();
        System.out.println("The cost of designed phone network: " + cost);
  
    }
    
}
