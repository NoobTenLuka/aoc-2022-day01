package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calories {
    public static void main(String[] args) throws FileNotFoundException {
        partOne();
        partTwo();
    }

    private static void partOne() throws FileNotFoundException {
        String filePath = "src/main/resources/input.txt";
        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter("\n");

        int caloriesOnElf = 0;
        int maxCaloriesOnElf = 0;
        while(scanner.hasNext()) {
            String currentLine = scanner.next();

            if(currentLine.equals("")) {
                // Ab hier, neuer Elf
                if(caloriesOnElf > maxCaloriesOnElf) {
                    maxCaloriesOnElf = caloriesOnElf;
                }
                caloriesOnElf = 0;
                continue;
            }

            int itemCalories = Integer.parseInt(currentLine);

            caloriesOnElf += itemCalories;
        }
        System.out.println("max Calories: " + maxCaloriesOnElf);

        scanner.close();
    }

    private static void partTwo() throws FileNotFoundException {
        String filePath = "src/main/resources/input.txt";
        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter("\n");

        int caloriesOnElf = 0;
        int maxCaloriesOnElf = 0;
        int secondMaxCaloriesOnElf = 0;
        int thirdMaxCaloriesOnElf = 0;
        while(scanner.hasNext()) {
            String currentLine = scanner.next();

            if(currentLine.equals("")) {
                // Ab hier, neuer Elf
                if(caloriesOnElf > maxCaloriesOnElf) {
                    thirdMaxCaloriesOnElf = secondMaxCaloriesOnElf;
                    secondMaxCaloriesOnElf = maxCaloriesOnElf;
                    maxCaloriesOnElf = caloriesOnElf;
                } else if(caloriesOnElf > secondMaxCaloriesOnElf) {
                    thirdMaxCaloriesOnElf = secondMaxCaloriesOnElf;
                    secondMaxCaloriesOnElf = caloriesOnElf;
                } else if(caloriesOnElf > thirdMaxCaloriesOnElf) {
                    thirdMaxCaloriesOnElf = caloriesOnElf;
                }

                caloriesOnElf = 0;
                continue;
            }

            int itemCalories = Integer.parseInt(currentLine);

            caloriesOnElf += itemCalories;
        }
        System.out.println("max Calories: " + (maxCaloriesOnElf + secondMaxCaloriesOnElf + thirdMaxCaloriesOnElf));

        scanner.close();
    }
}
