
package Part01;


public class Tester {

    
    public static void main(String[] args) {
        Car c = new Car();
        c.pressStartButton();
        c.pressAccelerationButton();
        c.output();
        
        Car c2 = new Car("RED", 100, true, true);
        c2.pressAccelerationButton();
        c2.setColor("BLACK");
        System.out.println("Color of c2: " + c2.getColor());
        c2.output();
    }
    
}
