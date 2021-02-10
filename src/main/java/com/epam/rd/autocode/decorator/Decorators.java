package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Decorators {

    public static List<String> evenIndexElementsSubList(List<String> source) {
        List<String> newSource = new ArrayList<>();
        IntStream.range(0, source.size()).filter(i -> i % 2 == 0).mapToObj(source::get).forEachOrdered(newSource::add);
        return newSource;
    }
}