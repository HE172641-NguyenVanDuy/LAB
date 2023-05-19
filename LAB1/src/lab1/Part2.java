package lab1;

import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        String op;
        float num1, num2;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Input number 1: ");
        num1 = Float.parseFloat(sc.nextLine());
        System.out.printf("Input number 2: ");
        num2 = Float.parseFloat(sc.nextLine());
        System.out.printf("Input operator: ");
        op = sc.nextLine();
        switch (op) {
            case "+":
                System.out.println("The result is: " + (num1 + num2));
                break;
            case "-":
                System.out.println("The result is: " + (num1 - num2));
                break;
            case "*":
                System.out.println("The result is: " + (num1 * num2));
                break;
            case "/":
                if (num2 == 0) 
                    System.out.println("Cannot divide by 0!");
                    
                else 
                    System.out.println("The result is: " + (num1 / num2));
                break;
            default:
                System.out.println("Please input 4 operator (+ , - , * , /) ");
                break;
        }
    }
}
