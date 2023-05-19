package lab1;

import java.util.Scanner;

public class Part3 {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of student: ");
        n = sc.nextInt();
        String[] list = new String[n];
        sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Student #" + (i + 1) + ": ");
            list[i] = sc.nextLine();
        }

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i].compareToIgnoreCase(list[j]) > 0) {
                    String tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;

                }
            }
        }
        System.out.println("The list of student after uppercase: ");
        for (int i = 0; i < n; i++) {
            char[] a = list[i].toCharArray();
            for (int j = 0; j < a.length; j++) {
                if (j == 0 || Character.isSpace(a[j - 1])) {
                    a[j] = Character.toUpperCase(a[j]);
                }
            }
            list[i] = String.valueOf(a);
            System.out.println(list[i]);
        }
    }
}
