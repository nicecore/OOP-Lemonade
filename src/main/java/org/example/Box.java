package org.example;

public class Box <T> {

    private T obj;

    public Box (T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
