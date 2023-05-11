/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package GraphFramework;
public class Edge {
    private Vertex source;
    private Vertex target;
    private Vertex parent;
    private int weight;

    public Edge(Vertex source, Vertex target, Vertex parent, int weight) {
        this.source = source;
        this.target = target;
        this.parent = parent;
        this.weight = weight;
    }
    
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getTarget() {
        return target;
    }

    public Vertex getParent() {
        return parent;
    }

    public int getWeight() {
        return weight;
    }

    public void displayInfo() {
        System.out.println(" Office No."   + source.getLabel()+" – Office No. "+target.getLabel()+" : line length: "+weight);
    }
}