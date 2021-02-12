package com.epam.rd.autocode.decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("q,w,e,r,t,y,u,i,o,p".split(","));

        ArrayListDecorator arrayListDecorator = new ArrayListDecorator(new ArrayList<>(list));
        System.out.println(arrayListDecorator.get(1));
        System.out.println(arrayListDecorator.size());
        arrayListDecorator.printIterator();
    }
}