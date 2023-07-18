package practicalinclass;

import java.util.Scanner;

public class PracticalInClass {

    public static void main(String[] args) {

        Product p = new Product();
        Order o = new Order();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("1.Add a new product to the store.");
            System.out.println("2.Update price for a particular product ");
            System.out.println("3.A list of all availble products in the store");
            System.out.println("4.Create a new Order.");
            System.out.println("5.Printf information of an Order by OrderID");
            System.out.println("6.Sort all products by products price as ascending");
            System.out.println("7.Print information of all Orders by a specific CustomerID");
            System.out.println("8.Print information of all Orders");
            System.out.println("9.Exit");
            System.out.println("Select your choice");
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 1:
                    Product p2 = new Product();
                    p.printProductId(p2);
                    p.inputProduct(p2);
                    p.addProduct(p2);
                    break;
                case 2:
                    p.inputProductId(p);
                    break;
                case 3:
                    p.printProduct();
                    break;
                case 4:
                    Order o2 = new Order();
                    o2.printDate(o2);
                    o2.inputOrder(o2, p);
                    o.addOrder(o2);
                    char check;
                    do {
                        System.out.println("Add more product(y/n): ");
                        check = in.nextLine().charAt(0);
                        if (check == 'n' || check == 'y') {
                            break;
                        }
                    } while (true);
                     {
                        if (check == 'n') {
                            break;

                        } else {
                            Order o3 = new Order();
                            o3.setCustomerID(o2.getCustomerID());
                            o3.setDate(o2.getDate());
                            o3.setAddress(o2.getAddress());
                            o3.setName(o2.getName());
                            o.getQuantity();
                            o.addOrder(o3);

                        }
                    }
                    while (true);
                    

                case 5:
                    o.inputOrderId();
                    break;
                case 6:
                    p.sortByPrice();
                    p.printProduct();
                    break;
                case 7:
                    o.inputCustomerID();
                    break;
                case 8:
                    o.printOrder();
                    break;
                case 9:
                    return;
            }
        } while (true);
    }
}
