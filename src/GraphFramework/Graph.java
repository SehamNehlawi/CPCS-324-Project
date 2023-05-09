/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package GraphFramework;

public class Graph {
    private int verticesNO;
    private int edgeNO;
    private Boolean isDigraph;
    private Vertex [] vertices; 
    
    
    // Getters & Setters
    public int getVerticesNO() {
        return verticesNO;
    }

    public void setVerticesNO(int verticesNO) {
        this.verticesNO = verticesNO;
    }

    public int getEdgeNO() {
        return edgeNO;
    }

    public void setEdgeNO(int edgeNO) {
        this.edgeNO = edgeNO;
    }

    public Boolean getIsDigraph() {
        return isDigraph;
    }

    public void setIsDigraph(Boolean isDigraph) {
        this.isDigraph = isDigraph;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertex[] vertices) {
        this.vertices = vertices;
    }
    
}
