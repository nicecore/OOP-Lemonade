package org.example;

import java.util.Scanner;

import org.example.lemonadestand.model.Customer;
import org.example.lemonadestand.model.Lemonade;
import org.example.lemonadestand.model.Order;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to LemonadeStand's Order Application!");
        System.out.println("To complete your order, we'll need some information.");
        System.out.println("Let's get started with your name:");

        String name = scanner.nextLine();
        System.out.println("Hi " + name + ", nice to meet you! \n Next we need your phone number so we can call you when your order is ready:");
        
        String phoneNumber = scanner.nextLine();
        System.out.println("Awesome! We have your phone number as: " + phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
        System.out.println("Is that correct? (Y for Yes | N for No)");
        
        String validation;

        do {
            System.out.println("Please enter Y for Yes or N for No");
            validation = scanner.nextLine();            
        } while (validation.equals("Y") && validation.equals("N"));

        if (validation.equals("Y")) {
            System.out.println("Great! Let's get to your order now...");
        } else {
            System.out.println("Please re-enter your phone number:");
            validation = scanner.nextLine();
        }
    }
}