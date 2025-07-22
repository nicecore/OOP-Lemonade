package org.example.lemonadestand.model;

import java.util.ArrayList;
import java.util.Objects;

public class Order {


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(total, order.total) == 0 && Objects.equals(customer, order.customer) && Objects.equals(lemonades, order.lemonades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, lemonades.hashCode());
    }

    //    private field of type "Customer" which we defined elsewhere"
    private Customer customer;
//    private collection/array of Lemonade (previously defined by us) objects
    private ArrayList<Lemonade> lemonades;

    private double total;

    public Order(Customer customer) {
//    again no super() method was automatically generated here
        this.customer = customer;
//    initialize lemonades array in constructor
        lemonades = new ArrayList<>();
//    ensure price starts at 0
    }

    public Customer getCustomer() {
        return customer;
    }


    public ArrayList<Lemonade> getLemonades() {
        return lemonades;
    }

    public double getTotal() {
        return total;
    }


    public void addLemonade(Lemonade lemonade) {
        lemonades.add(lemonade);
        total += lemonade.getPrice();
    }

//    @Override
//    public String toString() {
//        return "Order{" +
//                "customer=" + customer +
//                ", lemonades=" + Arrays.toString(lemonades) +
//                ", total=" + total +
//                '}';
//    }


    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", lemonades=" + lemonades +
                ", total=" + total +
                '}';
    }
}

