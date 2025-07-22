package org.example.lemonadestand.model;

public class Customer {
//    Private bc we only want Customer object after it's created should be able to access name.
//    Use a getter to expose a method for other objects to get a Customer object's name.
    private String name;
    private String phoneNumber;


    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //    Public method other objs can use on my Customer object to get the value of a customer's name
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

