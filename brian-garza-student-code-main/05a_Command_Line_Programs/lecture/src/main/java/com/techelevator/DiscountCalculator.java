package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Discount Calculator --- Enter \"stop\" to end program");

            // Prompt the user for a discount amount
            // The answer needs to be saved as a double
            System.out.print("Enter the discount amount (w/out percentage): ");

            String initialInput = scanner.nextLine();
            if (initialInput.equals("stop")) {
                break;
            }
            double discount = Double.parseDouble(initialInput) / 100.0;


            // Prompt the user for a series of prices
            System.out.print("Please provide a series of prices (space separated): ");
            String prices = scanner.nextLine();

            System.out.println(prices);

            String[] priceArray = prices.split(" ");

            for (int i = 0; i <= priceArray.length; i++) {
                double originalPrice = Double.parseDouble(priceArray[i]);

                double amountOff = originalPrice * discount;

                double amountOff = originalPrice - amountOff;

                System.out.println("Original Price: " + originalPrice + " Sale price: " + discount);


            }


        }

    }
