package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import org.example.lemonadestand.model.Order;

public class ViewOrder {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        File file = new File("./orders");

        while (true) {
            System.out.println("Which order would you like to view?");
            int orderNumber = scanner.nextInt();
            FileInputStream fileInputStream;
            ObjectInputStream objectInputStream = null;

            try {
                fileInputStream = new FileInputStream(file + "/order" + orderNumber + ".txt");
                objectInputStream = new ObjectInputStream(fileInputStream);
                // casting
                Order order = (Order) objectInputStream.readObject();
                System.out.println(order.getLemonades());
                System.out.println("Total: " + order.getTotal());
            } catch (FileNotFoundException e) {
                System.out.println("Order number " + orderNumber + " does not exist.");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
