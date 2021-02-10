package com.epam.rd.autocode.decorator;

import java.util.List;

public class AllElements implements Elements<String> {
    private final List<String> source;

    public AllElements(List<String> source) {
        this.source = source;
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