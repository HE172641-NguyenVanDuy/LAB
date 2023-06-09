package DTO;

import java.util.Scanner;
import validation.check;

public class Painting extends Item {

    private int height;
    private int width;
    private boolean isWatercolor;
    private boolean isFrame;

    public Painting(int height, int width, boolean isWatercolor, boolean isFrame) {
        this.height = height;
        this.width = width;
        this.isWatercolor = isWatercolor;
        this.isFrame = isFrame;
    }

    public Painting() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolor() {
        return isWatercolor;
    }

    public void setIsWatercolor(boolean isWatercolor) {
        this.isWatercolor = isWatercolor;
    }

    public boolean isIsFrame() {
        return isFrame;
    }

    public void setIsFrame(boolean isFrame) {
        this.isFrame = isFrame;
    }

    @Override
    public String toString() {
        return "Painting{" + "height=" + height + ", width=" + width + ", isWatercolor=" + isWatercolor + ", isFrame=" + isFrame + '}';
    }

    public void outputPainting() {
       super.output();
        System.out.printf("|%-12s:%-4d " ,"Height" , height);
        System.out.printf("|%-12s:%-4d " ,"Width", width);
        System.out.printf("|%-12s:%-10s " ,"isWaterColor", isWatercolor);
        System.out.printf("|%-12s:%-10s \n" ,"isFrame", isFrame);
        
    }

    public void inputPainting() {
        super.input();
        System.out.printf("Enter height: ");
        this.height = check.checkInput(height);

        System.out.printf("Enter width: ");
        this.width = check.checkInput(width);

        System.out.printf("Enter isWatercolour: ");
        this.isWatercolor = check.getBoolean();

        System.out.printf("Enter isFramed: ");
        this.isFrame = check.getBoolean();

    }

}
