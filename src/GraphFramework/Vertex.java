/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package GraphFramework;

import java.util.LinkedList;

public class Vertex {
    private int label;
    private boolean isVisited;
    private LinkedList<Edge> adjList;

    public Vertex(int label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new LinkedList<Edge>();
    }

    public int getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public LinkedList<Edge> getAdjList() {
        return adjList;
    }

    public void addEdge(Edge edge) {
        adjList.add(edge);
    }

    public void displayInfo() {
        System.out.println("Label: " + label+" Visited: " + isVisited +" Adjacency List: " + adjList);
    }
}


