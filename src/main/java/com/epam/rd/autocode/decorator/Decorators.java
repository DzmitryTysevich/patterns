package com.epam.rd.autocode.decorator;

import java.util.List;

public class Decorators extends ArrayListDecorator{
    public Decorators(List<String> source) {
        super(source);
    }

    public static List<String> evenIndexElementsSubList(List<String> source) {
        return new EvenListDecorator(source);
    }
}