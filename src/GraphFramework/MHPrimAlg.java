/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package GraphFramework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class MHPrimAlg extends MSTAlgorithm{
    
    /*/////////////////////////// MinHeap Class //////////////////////////////*/
    
    public class MinHeap <Edge>{
        
        // ATRIBUTES
        ArrayList<Edge> minHeap;
        int currentIndex = -1;
        Comparator<Edge> comparator;
        
        // CONSTRUCTOR
        public MinHeap(Comparator<Edge> comparator){
            minHeap = new ArrayList<>();
            this.comparator = comparator;
        }
        
        // METHODS
        //----------------------- Is minHeap Empty? ----------------------------
        public boolean isEmpty(){
            return minHeap.isEmpty();
        }
        
        //----------------------- Add Edge in MinHeap --------------------------
        public void insert(LinkedList<Edge> edges){
            for(Edge obj : edges){  
                minHeap.add(obj);
                shiftUp(++currentIndex);
            }
        }
        
        //--------------------- PercolateUp in MinHeap -------------------------
        public void shiftUp(int index){
            int parentIndex = (index - 1) / 2;
            while(index > 0 &&
                  comparator.compare(minHeap.get(index), minHeap.get(parentIndex)) < 0){
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = (index - 1) / 2;
            }
        }
        
        //------------------------- Swap Two Edges -----------------------------
        public void swap(int childIndex, int parentIndex){
            Edge temp = minHeap.get(childIndex);
            minHeap.set(childIndex, minHeap.get(parentIndex));
            minHeap.set(parentIndex, temp);
        }
        
        //-------------------- Remove Edge from MinHeap  -----------------------
        public Edge removeMin(){
            // 1) Replace root (min) by the last element
            // 2) Remove the last element and return it
            // 3) Check for shift down
            Edge root = minHeap.get(0);
            Edge lastElement = minHeap.get(currentIndex);
            minHeap.remove(currentIndex--); // Remove last element
            
            if(!minHeap.isEmpty()){ // If the minHeap not empty
                minHeap.set(0, lastElement);
                shiftDown(0);
            }
            
            return root;
        }
        
        //-------------------- PercolateDown in MinHeap ------------------------
        public void shiftDown(int index){
            
            int indexOfMin = index;
            while(true){
                
                int leftIndex = 2 * index + 1; 
                int rightIndex = 2 * index + 2;
                
                // Check the edge's children at each level
                if(leftIndex <= currentIndex &&
                        comparator.compare(minHeap.get(leftIndex), minHeap.get(indexOfMin)) < 0)
                    indexOfMin = leftIndex;

                if(rightIndex <= currentIndex &&
                        comparator.compare(minHeap.get(rightIndex), minHeap.get(indexOfMin)) < 0)
                    indexOfMin = rightIndex;

                if(indexOfMin == index)
                    break;
                 
                swap(indexOfMin, index);
                index = indexOfMin;
                
            }      
        }
    } // End of min heap class

    
    /*////////////////////////// MHPrimAlg Class /////////////////////////////*/
    

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
        
        // Create a min-heap to store the edges
        MinHeap<Edge> minHeap = new MinHeap<>(Comparator.comparingInt(e -> e.weight));
        minHeap.insert(graph.vertices[0].adjList);
        
        while (!minHeap.isEmpty()) {

            // Extract Minimum-weight edge
            minEdge = minHeap.removeMin();
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
            minHeap.insert(vertex.adjList);
            
        } // End loop
        
        //-------------------------- Display MST -------------------------------
        System.out.println("The phone network (minimum spanning tree) "
                            + "generated by min-heap based Prim algorithm is as follows:");  
        for (Edge obj : MSTResultList)
            obj.displayInfo();
        System.out.println("The cost of designed phone network: " + cost);
  
    }
    
}
