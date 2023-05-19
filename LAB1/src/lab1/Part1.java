/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        int row, column;
        float sum = 0, avg;
        Scanner sc = new Scanner(System.in);

        System.out.printf("Enter number of rows: ");
        row = Integer.parseInt(sc.nextLine());
        System.out.printf("Enter number of column: ");
        column = Integer.parseInt(sc.nextLine());

        int arr[][] = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("arr[%d][%d] = ", i, j);
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.format("%3d", arr[i][j]);
                sum += arr[i][j];
            }
            System.out.println("\n");
        }
        avg = sum / (row * column);
        System.out.println("Sum = " + sum);
        System.out.println("Avg = " + avg);
    }
}
