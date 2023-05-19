package bai2;

import static java.lang.Math.abs;
import java.util.Scanner;

public class Bai2 {

    public static void main(String[] args) {
        double avg, sum = 0, min;
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < arr.length; i++) {
            
            while (true) {
                System.out.printf("Phan tu #" + (i + 1) + ":");
                try {
                    
                    arr[i] = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    
                    System.out.println("Can you enter the integer number ?");
                   
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        avg = sum / (arr.length);
        min = Math.abs(arr[0] - avg);
        for (int i = 1; i < arr.length; i++) {

            if ((Math.abs(arr[i] - avg)) < min) {
                min = Math.abs(arr[i] - avg);
                
            }

        }
        System.out.println("Min: " + min);

    }

}
