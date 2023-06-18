
package data;


public class FPTUniversity extends University implements Role{
    String address;

    public FPTUniversity() {
    }

    public FPTUniversity( int size, String name, String address) {
        super(size, name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    @Override
    public String toString() {
        return "FPTU has for campus Hanoi, HCM, Danang, CanTho, QuyNhon.";
    }
    
    
    
    
    @Override
    public void createWorker() {
        System.out.println("providing human resources. ");; //To change body of generated methods, choose Tools | Templates.
    }
    
}
