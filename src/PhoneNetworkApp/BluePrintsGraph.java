/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package PhoneNetworkApp;

import GraphFramework.Edge;
import GraphFramework.Vertex;

public class BluePrintsGraph extends GraphFramework.Graph {

    // CONSTRUCTOR
    public BluePrintsGraph(){
        super();
    } 
    
    // METHODS
    @Override
    public Edge createEdge(Vertex source, Vertex target, int weight){
        return new Line(source,target,weight);
    }

    @Override
    public Vertex createVertex(String label){
        return new Office(label);
    } 
}
