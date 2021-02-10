package com.epam.rd.autocode.decorator;

public interface Elements<T> {
    T get(int element);

    String size();

    void iterator();
}