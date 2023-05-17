/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package PhoneNetworkApp;

import GraphFramework.Vertex;

public class Line extends GraphFramework.Edge {
<<<<<<< HEAD
=======
    int Length= super.weight*5;
    public Line(Vertex source, Vertex target, int weight){
        super(source, target, weight);
    }
    @Override
    public void displayInfo() {
        System.out.println(" Office No."   + source.label+" – Office No. "+target.label+" : line length: "+Length);
    }
>>>>>>> 205d37a85a6638370ee0b02f88569046472449dc
    
    // ATRIBUTES
    int Length;
    
    // CONSTRUCTOR
    public Line(Vertex source, Vertex target, int weight){
        super(source, target, weight);
        this.Length = super.weight * 5;
    }
    
    // METHODS
    @Override
    public void displayInfo() {
        System.out.println(" Office No." + source.label + " – Office No. " + target.label + " : line length: " + Length);
    } 
}
