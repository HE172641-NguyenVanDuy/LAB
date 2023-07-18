/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalinclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Product implements Comparable<Product> {

    protected String nameProduct;
    protected String idProduct;
    protected double price;

    List<Product> a = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Product() {
    }

    public void addProduct(Product p) {
        a.add(p);
        System.out.println("Add a product success !!");
    }

    public boolean checkProductId(String productID) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getIdProduct().equals(productID)) {
                return true;
            }
        }
        return false;
    }

    public Product(String nameProduct, String idProduct, double price) {
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product o) {
        return Double.toString(price).compareTo(Double.toString(o.price));
    }

    public void sortByPrice() {
        Collections.sort(a);
    }

    public void printProductId(Product p2) {
        Random rand = new Random();
        do {
            String checkProductID = Integer.toString(rand.nextInt(1000));
            if (checkProductId(checkProductID) == true) {
                continue;
            } else {
                p2.setIdProduct(checkProductID);
                System.out.println("Product ID: " + checkProductID);
                break;
            }
        } while (true);

    }

    public void inputProduct(Product p2) {
        Random rand = new Random();
        System.out.println("Enter name: ");
        p2.setNameProduct(sc.nextLine());
        System.out.println("Enter price: ");
        p2.setPrice(Double.parseDouble(sc.nextLine()));
    }

    public void inputProductId(Product p2) {
        System.out.println("Enter product ID : ");
        String productId = sc.nextLine();
        if (p2.checkProductId(productId) == false) {
            System.out.println("Not found product ID ");
            return;
        }
        System.out.println("Enter new price : ");
        double newPrice = Double.parseDouble(sc.nextLine());
        p2.updatePrice(productId, newPrice);
    }

    public String getNameProduct(String productId) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getIdProduct().equals(productId)) {
                return a.get(i).getNameProduct();
            }

        }
        return null;
    }

    public double getPriceProduct(String productId) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getIdProduct().equals(productId)) {
                return a.get(i).price;

            }
        }
        return 0;
    }

    public double updatePrice(String ProductId, double newPrice) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getIdProduct().equals(ProductId)) {
                return a.get(i).getPrice();

            }

        }
        return 0;
    }

    public void printProduct() {
        System.out.printf("%-15s-%15s-%15s\n", getIdProduct(), getNameProduct(), getPrice());
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-15s%-15s%-15.2f\n", a.get(i).getIdProduct(), a.get(i).getNameProduct(), a.get(i).getPrice());
        }
    }

}
