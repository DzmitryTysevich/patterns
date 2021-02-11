package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.List;

public class Decorators implements ListElements {
    private final ListElements elements;
    private static List<String> source;

    public Decorators(ListElements elements) {
        this.elements = elements;
    }

    public static List<String> evenIndexElementsSubList(List<String> source) {
        Decorators.source = source;
        List<String> newSource = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            if (i % 2 == 0) newSource.add(source.get(i));
        }
        return newSource;
    }

    @Override
    public String get(int element) {
        return evenIndexElementsSubList(source).get(element);
    }

    @Override
    public String size() {
        return String.valueOf(evenIndexElementsSubList(source).size());
    }

    @Override
    public void iterator() {
        for (String element : evenIndexElementsSubList(source)) System.out.printf("%s ", element);
    }

    public ListElements getElements() {
        return elements;
    }
}