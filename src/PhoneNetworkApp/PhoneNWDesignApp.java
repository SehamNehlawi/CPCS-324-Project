/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package PhoneNetworkApp;

import GraphFramework.KruskalAlg;
import GraphFramework.MHPrimAlg;
import GraphFramework.MSTAlgorithm;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNWDesignApp {
    public static void main(String[] args) throws FileNotFoundException{
        // Create objects
        Scanner input = new Scanner(System.in);
        BluePrintsGraph bluePrintsGraph = new BluePrintsGraph();
        
        // Make user choose 
        System.out.println("(((( Efficient Phone Network Design: Powered by Kruskal and Prim Algorithms ))))\n\n");
        System.out.print("Type 1 to Upload a File or Any Other Number to Generate a Random Graph: ");
        int option = input.nextInt();
        if(option != 1){
            // Generate graph randomly
            System.out.print("Please specify the number of vertices: ");
            int vNum = input.nextInt();
            System.out.print("Please specify the number of edges: ");
            int eNum = input.nextInt();
            bluePrintsGraph.makeGraph(vNum, eNum);
        }else{
            // Read graph from file
            System.out.print("Please enter the file name you wish to use, including the '.txt' extension: ");
            String fileName = input.next();
            bluePrintsGraph.readGraphFromFile(fileName);
        }
        
        System.out.println("");
        
        // Disply MST (Minimum Spanning Tree) By Kruskal Algorithm and caluclate elapsed time  
        long startTime =  System.nanoTime();
        MSTAlgorithm kruskal = new KruskalAlg(bluePrintsGraph);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        kruskal.displayResultingMST();
        System.out.println("------------------------------------------------\nTotal time elapsed (Kruskal Algorithm) : " + elapsedTime);
        
        System.out.println("\n\n");
        
        // Disply MST (Minimum Spanning Tree) By Prim Algorithm and caluclate elapsed time
        long beginTime = System.nanoTime();
        MSTAlgorithm prim = new MHPrimAlg(bluePrintsGraph);
        long finalTime = System.nanoTime();
        long timeElapsed = finalTime - beginTime;
        prim.displayResultingMST();
        System.out.println("------------------------------------------------\nTotal time elapsed (Prim Algorithm) : " + timeElapsed);
        System.out.println("\nThank you for being a part of our Phone Network Design App community. :)");
    }
}
