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
    protected ArrayList<Edge> MSTResultList=new ArrayList<>();
    
    // Abstract method to display resulting MST
    public abstract void displayResultingMST();
}