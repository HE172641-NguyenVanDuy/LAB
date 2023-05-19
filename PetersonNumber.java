package petersonnumber;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class PetersonNumber {

    static int[] factorial = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (isPeterson(n) == true) {
            System.out.println(n + " is Peterson number.");
        } else {
            System.out.println(n + " is not Peterson number.");
        }
    }

    static boolean isPeterson(int n) {
        int num = n;
        int sum = 0;
        while (n > 0) {

            int digit = n % 10;
            sum += factorial[digit];
            n = n / 10;

        }

        return (sum == num);
    }
}
