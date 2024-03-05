package me.caua.aula03;

import java.util.ArrayList;
import java.util.List;

public class Array<T> {

    private final List<T> elements = new ArrayList<>();

    public List<T> getArray() {
        return elements;
    }

    public void add(T obj) {
        elements.add(obj);
    }

}
