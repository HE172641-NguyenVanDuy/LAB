
package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    int response;
    
public int int_getChoice(ArrayList<String> options) {
        int N = options.size();
        for (int i = 0; i < N; i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("Please choose an option 1.." + N + ": ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            response = Integer.parseInt(br.readLine());
            if (response < 1 || response > N) {
                response = -1;
            }
        } catch (IOException e) {
            response = -1;
        }
        return response;
    }
    
        public int int_getChoice (BrandList brand) {
        int n = brand.size();
        for (int i = 0; i < n; i++) {
            System.out.println("" + (i+1) + ". " + brand.get(i));
        }
        System.out.print("Please choose an option 1 - 12: ");
        response = sc.nextInt();
        return response;
    }

    public Brand ref_getChoice (BrandList options) {
        int N = options.size();
        System.out.println("Brand ID List:");
        do {
            response = int_getChoice(options);
        } while ((response < 0) || (response > N));
        return options.get(response - 1);
    }
}
