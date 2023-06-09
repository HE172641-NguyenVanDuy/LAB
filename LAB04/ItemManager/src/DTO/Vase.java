package DTO;

import java.util.Scanner;
import validation.check;

public class Vase extends Item {

    private String material;
    private int height;

    public Vase(String material, int height, int value, String creator) {
        super(value, creator);
        this.material = material;
        this.height = height;
    }

    public Vase() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Vase{" + "material=" + material + ", height=" + height + '}';
    }

    public void outputVase() {
        super.output();
        System.out.printf("|%-12s:%-4d "  ,"Height" ,height);
        System.out.printf("|%-12s:%-10s| \n" ,"Material" , material);
    }

    public void inputVase() {
      
        super.input();
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter height: ");
        this.height = check.checkInput(height);

        System.out.printf("Enter marterial: ");
        this.material = sc.nextLine();
     
    }

}
