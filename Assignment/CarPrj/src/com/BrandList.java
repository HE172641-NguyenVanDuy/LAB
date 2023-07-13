package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BrandList extends ArrayList<Brand> {
    private String brandID, brandName, soundBrand;
    private double price;
    private int pos;

    public BrandList() {
    }

    public boolean loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] arr;
            String line = br.readLine();
            while ((line != null)) {
                arr = line.split(",");
                brandID = arr[0].trim();
                brandName = arr[1].trim();
                soundBrand = arr[2].split(":")[0].trim();
                price = Double.parseDouble(arr[2].split(":")[1].trim());
                this.add(new Brand(brandID, brandName, soundBrand, price));
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
             System.out.println("File " + filename + " not found!");
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (Brand brand : this) {
                bw.write(brand.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public int searchID(String ID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        Menu menu = new Menu();
        return (Brand) menu.ref_getChoice(this);
    }

    public void addBrand() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                System.out.print("Enter Brand ID: ");
                brandID = br.readLine().trim();
            } while (searchID(brandID) != -1);

            System.out.print("Enter Brand Name: ");
            brandName = br.readLine().trim();

            System.out.print("Enter Sound Brand: ");
            soundBrand = br.readLine().trim();

            do {
                System.out.print("Enter Price: ");
                price = Double.parseDouble(br.readLine().trim());
            } while (price <= 0);

            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            this.add(brand);
            System.out.println("Brand added successfully!");
        } catch (IOException e) {
            System.out.println("Error reading input!");
        }
    }

    public void updateBrand() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        try {
            System.out.print("Enter Brand ID to update: ");
            brandID = br.readLine().trim();

            pos = searchID(brandID);
            if (pos == -1) {
                System.out.println("Brand not found!");
                return;
            }

            Brand brand = this.get(pos);

            System.out.print("Enter new Brand Name: ");
            brandName = br.readLine().trim();
            brand.setBrandName(brandName);

            System.out.print("Enter new Sound Brand: ");
            soundBrand = br.readLine().trim();
            brand.setSoundBrand(soundBrand);

            do {
                System.out.print("Enter new Price: ");
                price = Double.parseDouble(br.readLine().trim());
            } while (price <= 0);
            brand.setPrice(price);

            System.out.println("Brand updated successfully!");
        } catch (IOException e) {
            System.out.println("Error reading input!");
        }
    }

    public void listBrands() {
        for (Brand brand : this) {
            System.out.println(brand);
        }
    }
}
