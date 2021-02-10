package com.epam.rd.autocode.decorator;

import java.util.Iterator;
import java.util.List;

public abstract class ListDecorator<T> {
    private final List<T> values;

    public ListDecorator(List<T> values) {
        this.values = values;
    }

    public T get(int element) {
        return values.get(element);
    }

    public int size() {
        return values.size();
    }

    public Iterator<T> iterator() {
        return values.iterator();
    }
}