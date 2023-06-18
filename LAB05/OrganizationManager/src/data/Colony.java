
package data;


public class Colony extends Organization{
    protected String place;
    
    public Colony() {
    }


    public Colony(String place, int size) {
        super(size);
        this.place = place;
    }
    
    

    @Override
    public void communicateByTool() {
        System.out.println("The colony communicate by sound.");; //To change body of generated methods, choose Tools | Templates.
    }
     
    public void grow() {
        System.out.println("an anual cycle of growth that begins in spring.");
    }
    public void procedure() {
        System.out.println("Colony can reprocedure itself through a process ");
    }
    
    @Override
    public String toString() {
        return "the colony size is " + this.size + ", the colony's place is " + this.place;
    }
    
    
    
    
    
            
    
}
