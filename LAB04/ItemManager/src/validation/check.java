
package validation;

import java.util.Scanner;


public class check {
    private static final Scanner sc = new Scanner(System.in);

    public static int checkInput(int value) {
        

        while (true) {
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value < 0) {
                    throw new IllegalArgumentException();
                }
                
                break;
            } catch (IllegalArgumentException e) {
                System.err.println("Please input positive integer !");
            }

            
        }

        return value;
    }
    
    public static boolean getBoolean() {
        boolean value = false;
        
        while (true) {
            try {
                value = Boolean.parseBoolean(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please enter again");
            }
        }
        
        return value;
    }
}
