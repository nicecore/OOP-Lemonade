package org.example.lemonadestand.model;

public class Lemonade {
    private double lemonJuice;
    private double water;
    private double sugar;
    private int iceCubes;
    private final int CUP = 1;
    private double price;

    public Lemonade(double lemonJuice, double water, double sugar, int iceCubes) {
//        no super method was auto generated, why's that...
        this.lemonJuice = lemonJuice;
        this.water = water;
        this.sugar = sugar;
        this.iceCubes = iceCubes;
        calculatePrice();
    }

//    Calculate price method - an internal method that doesn't need to be exposed
    private void calculatePrice() {
        price = (lemonJuice * .3) + (sugar * .15) + (CUP * .50);
    }

    public double getLemonJuice() {
        return lemonJuice;
    }

    public double getWater() {
        return water;
    }

    public double getSugar() {
        return sugar;
    }

    public int getIceCubes() {
        return iceCubes;
    }

    public int getCUP() {
        return CUP;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Lemonade{" +
                "lemonJuice=" + lemonJuice +
                ", water=" + water +
                ", sugar=" + sugar +
                ", iceCubes=" + iceCubes +
                ", CUP=" + CUP +
                ", price=" + price +
                '}';
    }
}
