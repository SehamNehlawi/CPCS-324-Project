/*
CPCS324 Group Project | Phase1 | Section B9B
- Reem Saleh Almalki            2005439
- Roaa Hatim Altunsi            1914946
- Shahad Maher Magram           2010332
- Seham Khaldoun Nahlawi        1915762
 */

package PhoneNetworkApp;

public class Office extends GraphFramework.Vertex {
<<<<<<< HEAD
=======
    
    public Office(String L){
       
        super(L);
    }
    
    void setLable(String L){
        super.label= "O"+L;
    }
    
    @Override
    public void displayInfo() {
       super.displayInfo();
    }
>>>>>>> 205d37a85a6638370ee0b02f88569046472449dc
    
    // CONSTRUCTOR
    public Office(String L){
        super(L);
    }
    
    // METHODS
    void setLable(String L){
        super.label= "O"+L;
    }
    
    @Override
    public void displayInfo() {
       super.displayInfo();
    } 
}
