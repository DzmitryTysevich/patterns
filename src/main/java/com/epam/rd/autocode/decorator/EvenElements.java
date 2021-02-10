package com.epam.rd.autocode.decorator;

import java.util.List;

public class EvenElements extends Decorators {
    private final List<String> source;

    public EvenElements(Elements<String> elements, List<String> source) {
        super(elements, source);
        this.source = source;
    }

    @Override
    public Elements<String> getElements() {
        return super.getElements();
    }

    @Override
    public String get(int element) {
        return "Element from old list: " +
                super.get(element) +
                "\nElement from new list: " +
                evenIndexElementsSubList(source).get(element);
    }

    @Override
    public String size() {
        return "Old size: " + super.size() +
                "\nNew size: " + evenIndexElementsSubList(source).size();
    }

    @Override
    public void iterator() {
        for (String element : evenIndexElementsSubList(source)) System.out.printf("%s ", element);
        System.out.println();
        for (String element : source) System.out.printf("%s ", element);
    }
}