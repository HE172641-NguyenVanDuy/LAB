/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;

import validation.check;

public class Statue extends Item {

    private int weight;
    private String color;

    public Statue(int weight, String color, int value, String creator) {
        super(value, creator);
        this.weight = weight;
        this.color = color;
    }

    public Statue() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Statue{" + "weight=" + weight + ", color=" + color + '}';
    }

    public void inputStatue() {
        super.input();
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter weight: ");
        this.weight = check.checkInput(weight);


        System.out.printf("Enter the color: ");
        this.color = sc.nextLine();
    }

    public void outputStatue() {
        super.output();
        System.out.printf("|%-12s:%-4d " ,"Weight" , weight);
        System.out.printf("|%-12s:%-10s| \n" ,"Color" , color);
        
        
    }
}
