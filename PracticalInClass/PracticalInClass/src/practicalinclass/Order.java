/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalinclass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Order extends Product{
    private String customerID;
    private String orderID;
    private String date;
    private String name;
    private String address;
    private String nameProduct;
    private String idProduct;
    private double price;
    private int quantity;
    
    List<Order> a = new ArrayList<Order>();
    
    Scanner sc = new Scanner(System.in);

    public Order(String customerID, String orderID, String date, String name, String address, String nameProduct, String idProduct, double price, int quantity) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.date = date;
        this.name = name;
        this.address = address;
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.price = price;
        this.quantity = quantity;
    }

    public Order() {
    }

    public Order(String customerID, String orderID, String date, String name, String address, String nameProduct, String idProduct, double price) {
        super(nameProduct, idProduct, price);
        this.customerID = customerID;
        this.orderID = orderID;
        this.date = date;
        this.name = name;
        this.address = address;
        this.nameProduct = nameProduct;
        this.idProduct = idProduct;
        this.price = price;
        //this.quantity = quantity;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    
    public boolean checkCustomerID(String customerID) {
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).getCustomerID().equals(customerID)) return true;
            
        }
        return false;
    }
    public void printInformationCustomerID(String checkOrderId) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Order ID", "Customer ID", "Name Customer", "Product ID", "Product Name", "Date", "Address","Quantity","Price");
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).customerID.equals(checkOrderId)) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15.2f\n" 
                        , a.get(i).customerID, a.get(i).name,a.get(i).idProduct,a.get(i).nameProduct
                        , a.get(i).date, a.get(i).address,a.get(i).quantity,a.get(i).price*a.get(i).quantity);
                        return;
            }
        }
    }
    
    public void inputCustomerID() {
        do{
            System.out.print("Enter Custumer id: ");
            String checkCustomerID = sc.nextLine();
            if(checkCustomerID(customerID) == false) {
                System.out.println("Not found Customer id.");
                continue;
            }
            else {
                printInformationCustomerID(checkCustomerID);
                break;
            }
            
        }while(true);
        
    }
    public void printDate(Order o2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localeDate = LocalDate.now();
        o2.setDate(dtf.format(localeDate));
        System.out.println("Order Date: " + dtf.format(localeDate));
    } 
    public void addOrder(Order  o) {
        a.add(o);
        System.out.println("Add order success!!!");
        
    } 
    public boolean checkOrderID(String orderID) {
        for (int i = 0; i < a.size(); i++) {
         if(a.get(i).getOrderID().equals(orderID)) {
             return true;
             
         }   
        }
        return false;
    }
    public void inputOrderId() {
        do{
            System.out.print("Enter order id: ");
            String checkOrderID = sc.nextLine();
            if(checkOrderID(checkOrderID) == false) {
                System.out.println("Not found Order Id");
                continue;
            }
            else {
                printInformationOrderID(checkOrderID);
            }
            
        } while(true);
    }
    public void printInformationOrderID(String checkOrderId) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Order ID", "Customer ID", "Name Customer", "Product ID", "Product Name", "Date", "Address","Quantity","Price");
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).getOrderID().equals(checkOrderId)) {
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15.2f\n" 
                        , a.get(i).orderID, a.get(i).name,a.get(i).idProduct,a.get(i).nameProduct
                        , a.get(i).date, a.get(i).address,a.get(i).quantity,a.get(i).price*a.get(i).quantity);
                        return;
            }
        }
    }
    public void printOrder() {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Order ID", "Customer ID", "Name Customer", "Product ID", "Product Name", "Date", "Address","Quantity","Price");
        for (int i = 0; i < a.size(); i++) {
            
                System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15.2f\n" 
                        , a.get(i).orderID, a.get(i).name,a.get(i).idProduct,a.get(i).nameProduct
                        , a.get(i).date, a.get(i).address,a.get(i).quantity,a.get(i).price*a.get(i).quantity);
                        return;
            
        }
    }
    public void inputOrder(Order o2, Product p) {
        Random rand = new Random();
        
        do {
            String checkCustomID = Integer.toString(rand.nextInt(10000) + 1);
            if(checkCustomerID(checkCustomID) == true) {
                continue;
            }
            else {
                o2.setCustomerID("CTM" + checkCustomID);
                System.out.println("Customer ID: " + o2.getCustomerID());
                break;
            }
            
        } while(true);
        System.out.print("Enter customer name: ");
        o2.setNameProduct(sc.nextLine());
        System.out.println("Enter customer add: ");
        o2.setAddress(sc.nextLine());
        System.out.println("Add product to order by select a product form below list ");
        
    }   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Order> getA() {
        return a;
    }

    public void setA(List<Order> a) {
        this.a = a;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    String getDate() {
       return date;
    }

    
    
    
    
}
