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
            
            int vNum, eNum, choice;
            
            do{    
                // Apply makeGraph() method
                System.out.println("\n\n--------------------- Choose From 1 to 7 ------------------");
                System.out.println("*** where n = number of vertices and m = number of edges ***");
                System.out.println("*** These are the available cases: ***");
                System.out.println("    1) n=1,000  ***  m=10,000  "
                + "\n    2) n=1,000  ***  m=15,000  " 
                + "\n    3) n=1,000  ***  m=25,000  "
                + "\n    4) n=5,000  ***  m=15,000  "
                + "\n    5) n=5,000  ***  m=25,000  "
                + "\n    6) n=10,000 ***  m=15,000  "
                + "\n    7) n=10,000 ***  m=25,000  "
                + "\n-------------------------------");
                System.out.print("\nYour choice: ");

                choice = input.nextInt();

                switch(choice){
                    case 1:
                        vNum = 1000; eNum = 10000; break;
                    case 2: 
                        vNum = 1000; eNum = 15000; break;
                    case 3: 
                        vNum = 1000; eNum = 25000; break;
                    case 4:
                        vNum = 5000; eNum = 15000; break;
                    case 5:
                        vNum = 5000; eNum = 25000; break;
                    case 6:
                        vNum = 10000; eNum = 15000; break;
                    case 7:
                        vNum = 10000; eNum = 25000; break;
                    default: 
                        System.out.print("Error! Please choose from 1 to 7: "); continue;
                }

                bluePrintsGraph.makeGraph(vNum, eNum);


            }while(!(choice>=1 && choice<=7));
            
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

        System.out.println("\n");
           
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
