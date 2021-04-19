import java.util.Scanner;
import java.util.stream.*;
import java.util.Formatter;

public class ProductList {
    public static void main(String[] args) {
        //declarations
        Scanner productObj = new Scanner(System.in);
        Scanner taxObj = new Scanner(System.in);
        Formatter formatProducts = new Formatter(); //To list the products and prices in proper format
        Formatter formatTotal = new Formatter(); //To get two decimals points for the total
        String products[] = new String[20]; //An array of product names
        double prices[] = new double[20]; //An array of products' prices
        int numProducts; //The number of products
        double taxRate; //Sales tax rate
        System.out.print("Enter the number of products that's being purchased: ");
        numProducts = productObj.nextInt();

        //This will stop program if user enters a negative number, zero, or more than 20 products
        if (numProducts <= 0 || numProducts > 20) {
            System.out.println("Please enter the number of products that's between 1-20");
            System.exit(1);
        }

        //get user input
        //User enters each of the products' names and prices
        System.out.println("Enter each of the products' names:");
        for (int i = 0; i <= numProducts; i++) {
            products[i] = productObj.nextLine();
        }
        System.out.println("");

        System.out.println("Enter the prices for each product:");
        for (int i = 0; i < numProducts; i++) {
            System.out.print("$");
            prices[i] = productObj.nextDouble();
        }
        System.out.println("");

        //User enters sales tax rate based on their current area
        System.out.println("Enter sales tax rate.");
        System.out.println("An example of entering sales tax rate: 1.087");
        System.out.print("Sales Tax Rate: ");
        taxRate = taxObj.nextDouble();
        System.out.println("");

        //Adds all the prices together and multiplies the sum by the sales tax rate
        double total = DoubleStream.of(prices).sum();
        total = total * taxRate;

        //Formats the products and prices as a list
        for (int i = 0; i < numProducts; i++) {
            formatProducts.format("%-40s$%.2f%n", products[i + 1], prices[i]);
        }

        //output
        System.out.println("List of products and prices:");
        System.out.printf("%-40s%s%n", "Products", "Prices");
        System.out.println(formatProducts.out()); //Displays products' name and prices
        formatProducts.close();

        formatTotal.format("Total Cost: $%.2f", total); //Displays the total price with two decimals
        System.out.println(formatTotal.out());
        formatTotal.close();
    }
}
