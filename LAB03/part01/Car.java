
package Part01;


public class Car {
    private String color;
    private int enginePower;
    private boolean convertible;
    private boolean parkingBrake;

    public Car() {
    }
    

    public Car(String color, int enginePower, boolean convertible, boolean parkingBrake) {
        this.color = color;
        this.enginePower = enginePower;
        this.convertible = convertible;
        this.parkingBrake = parkingBrake;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setConvertible(boolean covertible) {
        this.convertible = covertible;
    }

    public boolean isParkingBrake() {
        return parkingBrake;
    }

    public void setParkingBrake(boolean parkingBrake) {
        this.parkingBrake = parkingBrake;
    }
    public void pressStartButton() {
        System.out.println("You have the start button.");
    }
    public void pressAccelerationButton() {
        System.out.println("You have pressed the Accesleration button.");
    }

    public void output() {
        System.out.println("Color: " + color);
        System.out.println("EnginePower: " + enginePower);
        System.out.println("Convertible: " + convertible);
        System.out.println("ParkingBrake: " + parkingBrake);
    }
    
}
