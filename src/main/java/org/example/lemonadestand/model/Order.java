package org.example.lemonadestand.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// implement Serializable interface for i/o stream
public class Order implements Serializable {

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

    private Customer customer;
    private List<Lemonade> lemonades;

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


    public List<Lemonade> getLemonades() {
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

