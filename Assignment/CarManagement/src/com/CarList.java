package com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarList extends ArrayList<Car> {

    Scanner sc = new Scanner(System.in);
    private BrandList brandList;
    Menu menu = new Menu();

    public CarList(BrandList bList) {
        brandList = bList;
    }

    public boolean loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String carID = parts[0].trim();
                String brandID = parts[1].trim();
                String color = parts[2].trim();
                String frameID = parts[3].trim();
                String engineID = parts[4].trim();
                int pos = brandList.searchID(brandID);
                if (pos != -1) {
                    Brand brand = brandList.get(pos);
                    Car car = new Car(carID, brand, color, frameID, engineID);
                    this.add(car);
                }
            }
            br.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (Car car : this) {
                bw.write(car.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public int searchID(String carID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(fID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equals(eID)) {
                return i;
            }
        }
        return -1;
    }

    public void addCar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carID;
        String color;
        String frameID;
        String engineID;
        boolean checkCarID = false;
        try {
            do {
                System.out.print("Input car ID: ");
                carID = sc.nextLine();
                for (int i = 0; i < this.size(); i++) {
                    if (carID.equals(this.get(i).getCarID())) {
                        checkCarID = true;
                        System.out.println("This car ID is existed. Try another one!");
                        break;
                    } else {
                        checkCarID = false;
                    }
                }
            } while (checkCarID == true);

            Brand brand = menu.ref_getChoice(brandList);

            do {
                System.out.print("Input color: ");
                color = sc.nextLine();
                if (color.equals("") != true) {
                    break;
                }
                System.out.println("The color must not be null. Try again!");
            } while (true);

            do {
                System.out.print("Enter Frame ID: ");
                frameID = br.readLine().trim();
            } while (searchFrame(frameID) != -1 || !frameID.matches("F\\d{5}"));

            do {
                System.out.print("Enter Engine ID: ");
                engineID = br.readLine().trim();
            } while (searchEngine(engineID) != -1 || !engineID.matches("E\\d{5}"));

            Car car = new Car(carID, brand, color, frameID, engineID);
            this.add(car);
            System.out.println("Car added successfully!");
        } catch (IOException e) {
            System.out.println("Error reading input!");
        }
    }

    public void printBasedBrandName() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a part of Brand Name: ");
        String partOfBrandName;
        try {
            partOfBrandName = br.readLine().trim();
            int count = 0;
            for (Car car : this) {
                if (car.getBrand().getBrandName().contains(partOfBrandName)) {
                    System.out.println(car.screenString());
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No car is detected!");
            }
        } catch (IOException e) {
            System.out.println("Error reading input!");
        }
    }

    public boolean removeCar() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Car ID to remove: ");
        String removedID;
        try {
            removedID = br.readLine().trim();
            int pos = searchID(removedID);
            if (pos == -1) {
                System.out.println("Car not found!");
                return false;
            } else {
                this.remove(pos);
                System.out.println("Car removed successfully!");
                return true;
            }
        } catch (IOException e) {
            System.out.println("Error reading input!");
            return false;
        }
    }

    public boolean updateCar() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Car ID to update: ");
        String updatedID;
        try {
            updatedID = br.readLine().trim();
            int pos = searchID(updatedID);
            if (pos == -1) {
                System.out.println("Car not found!");
                return false;
            } else {
                System.out.println("Choose a Brand: ");
                Brand brand = brandList.getUserChoice();

                System.out.print("Enter new Color: ");
                String color = br.readLine().trim();

                String frameID;
                do {
                    System.out.print("Enter new Frame ID: ");
                    frameID = br.readLine().trim();
                } while (searchFrame(frameID) != -1 || !frameID.matches("F\\d{5}"));

                String engineID;
                do {
                    System.out.print("Enter new Engine ID: ");
                    engineID = br.readLine().trim();
                } while (searchEngine(engineID) != -1 || !engineID.matches("E\\d{5}"));

                Car car = this.get(pos);
                car.setBrand(brand);
                car.setColor(color);
                car.setFrameID(frameID);
                car.setEngineID(engineID);

                System.out.println("Car updated successfully!");
                return true;
            }
        } catch (IOException e) {
            System.out.println("Error reading input!");
            return false;
        }
    }

    public void listCars() {
        Collections.sort(this.subList(modCount, modCount));
        for (Car car : this) {
            System.out.println(car.screenString());
        }
    }
}
