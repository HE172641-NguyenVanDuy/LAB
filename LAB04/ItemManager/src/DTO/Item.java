/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Scanner;
import validation.check;

public abstract class Item {

    protected int value;
    protected String creator;

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public Item() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Item{" + "value=" + value + ", creator=" + creator + '}';
    }

    public void output() {
        System.out.printf("|%-12s:%-4d "  ,"Value" ,value);
        System.out.printf("|%-12s:%-10s " ,"Creator" , creator);
       
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
     
        System.out.printf("Enter value: ");
        this.value = check.checkInput(value);

        System.out.printf("Enter the creator: ");
        this.creator = sc.nextLine();
      
    }
}
