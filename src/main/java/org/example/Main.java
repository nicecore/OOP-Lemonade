package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import org.example.lemonadestand.model.Customer;
import org.example.lemonadestand.model.Lemonade;
import org.example.lemonadestand.model.Order;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Working directory: " + new File(".").getCanonicalPath());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to LemonadeStand's Order Application!");
        System.out.println("To complete your order, we'll need some information.");
        System.out.println("Let's get started with your name:");

        String name = scanner.nextLine();
        System.out.println("Hi " + name + ", nice to meet you! \n Next we need your phone number so we can call you when your order is ready:");
        
        String phoneNumber = scanner.nextLine();
        System.out.println("Awesome! We have your phone number as: " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
        System.out.println("Is that correct? (Y for Yes | N for No)");
        
        String validation = "";

        do {
            if (validation.equals("N")) {
                System.out.println("Please re-enter your phone number:");
                validation = scanner.nextLine();
                System.out.println("Now we have: " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
                System.out.println("Is that correct?");
            }
            System.out.println("Please enter Y for Yes or N for No");
            validation = scanner.nextLine();
            
        } while (!validation.equals("Y"));

        System.out.println("Great! Let's get to your order now...");

        Customer customer = new Customer(name, phoneNumber);
        Order order = new Order(customer);

        System.out.println("How many lemonades would you like today?");
        
        
        for (int numberOfLemonades = scanner.nextInt(), i = 1; numberOfLemonades > 0; numberOfLemonades--, i++) {
            System.out.println("How much lemon juice do you want for lemonade " + i + "? (in cups)");
            double lemonJuice = scanner.nextDouble();
            System.out.println("How much water do you want? (in cups)");
            double water = scanner.nextDouble();
            System.out.println("How much sugar do you want? (in cups)");
            double sugar = scanner.nextDouble();
            System.out.println("How many ice cubes do you want? (in cubes)");
            int iceCubes = scanner.nextInt();
            order.addLemonade(new Lemonade(lemonJuice, water, sugar, iceCubes));
            System.out.println(order);
        }

        // Save the order somewhere

        File file = new File("./orders");

        System.out.println(file.isDirectory());

        File[] files = file.listFiles();

        FileOutputStream fileOutputStream = new FileOutputStream(file + "/order" + (files.length + 1) + ".txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(order);

        System.out.println("Successfully placed order! :D");
        System.out.println("Your order total is: " + order.getTotal());



    }

}