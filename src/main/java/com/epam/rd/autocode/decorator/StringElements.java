package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringElements extends ListDecorator<String> {
    private final List<String> values;

    public StringElements(List<String> values) {
        super(values);
        this.values = values;
    }

    public List<String> evenIndexElementsSubList() {
        List<String> newSource = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (i % 2 == 0) newSource.add(values.get(i));
        }
        return newSource;
    }

    @Override
    public String get(int element) {
        return evenIndexElementsSubList().get(element);
    }

    @Override
    public int size() {
        return evenIndexElementsSubList().size();
    }

    @Override
    public Iterator<String> iterator() {
        return evenIndexElementsSubList().iterator();
    }
}