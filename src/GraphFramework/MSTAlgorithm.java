/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package GraphFramework;

import java.util.ArrayList;

public abstract class MSTAlgorithm {
    
    // ATRIBUTES
    Graph graph;
    protected ArrayList<Edge> MSTResultList;
    
    // CONSTRUCTOR
    MSTAlgorithm(Graph graph){
        this.graph = graph;
        this.MSTResultList = new ArrayList<>(graph.verticesNo-1);
    }
    
    // METHODS
    // Abstract method to display resulting MST
    /* We add the boolean parameter to print all paths 
       only if it called by readGraphFromFile() method
    */
    public abstract void displayResultingMST(boolean flag);
    
}