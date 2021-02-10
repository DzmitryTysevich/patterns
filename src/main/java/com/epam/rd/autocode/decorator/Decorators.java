package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.List;

public abstract class Decorators implements Elements<String> {
    private final Elements<String> elements;
    private final List<String> source;

    public Decorators(Elements<String> elements, List<String> source) {
        this.elements = elements;
        this.source = source;
    }

    public Elements<String> getElements() {
        return elements;
    }

    public static List<String> evenIndexElementsSubList(List<String> source) {
        List<String> newSource = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if (i % 2 == 0) newSource.add(source.get(i));
        }
        return newSource;
    }

    @Override
    public String get(int element) {
        return source.get(element);
    }

    @Override
    public String size() {
        return String.valueOf(source.size());
    }

    @Override
    public void iterator() {
        for (String element : source) System.out.printf("%s ", element);
    }
}