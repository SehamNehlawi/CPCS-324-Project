/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package GraphFramework;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Graph {
    
    // Attributes
    int verticesNo=0;
    int eddgNo =0;
    boolean isDigraph=false;
    
    Vertex vertices[];
    
    
    
    // Functions
    void makeGraph(int vNum, int eNum){
        this.verticesNo=vNum;
        this.eddgNo=eNum;
        this.vertices = new Vertex[vNum];
        for (int i = 0; i < vNum; i++) {
           // create vertix and add it to the list
           vertices[i]=creatVertex(String.valueOf('A'+i));
        }
        
        for (int i = 0; i < eNum; i++) {
            // choose random weight
           int w = (int)(Math.random()*100);
           
           int v1,v2;
           if(i<vNum-1){
             v1=i; v2=i+1;  
           }
           else{
            v1 = (int)(Math.random()*(vNum));
            v2 = (int)(Math.random()*(vNum));
           }
           
           // add the edge
           addEdge(vertices[v1],vertices[v2],w);
           addEdge(vertices[v2],vertices[v1],w);
        }
        
    }
    
    void readGraphFromFile(String fileName) throws FileNotFoundException{
       File g = new File(fileName);
       Scanner input = new Scanner (g);
       if(input.nextLine()=="digraph 1")
            this.isDigraph=true;

        
       // read number of vertices
       int v = input.nextInt();
       this.verticesNo=v;
       // read number of edges
       int e = input.nextInt();
       this.eddgNo=(!isDigraph?2*e:e);
       
       this.vertices = new Vertex[v];
        
        for (int i = 0; i < e; i++) {
            String s1=input.next();
            String s2=input.next();
            int w = input.nextInt();
            
            // add vertices
            vertices[(s1.charAt(0))-'A'] = creatVertex(s1);
            vertices[(s2.charAt(0))-'A'] = creatVertex(s2);
           
            // add the edge 
            addEdge( vertices[(s1.charAt(0))-'A'] , vertices[(s2.charAt(0))-'A'] ,w);
            if(!isDigraph)  addEdge( vertices[(s2.charAt(0))-'A'] , vertices[(s1.charAt(0))-'A'] ,w);
        }
    }
   
    Edge addEdge(Vertex v, Vertex u, int w){
        Edge e = createEdge(v,u,w);
        v.adjList.add(e);
        
        return e;
    }
    
    Edge createEdge(Vertex source, Vertex target, int weight){
        return new Edge(source,target,weight);
    }
    
    Vertex creatVertex(String label){
        return new Vertex(label);
    }
    
}