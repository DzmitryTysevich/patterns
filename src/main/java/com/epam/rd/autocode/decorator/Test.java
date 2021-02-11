package com.epam.rd.autocode.decorator;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("q,w,e,r,t,y,u,i,o,p".split(","));
        ListElements arrayListElement = new ArrayListElements(list);
        System.out.println(arrayListElement.get(1));
        System.out.println(arrayListElement.size());
        arrayListElement.iterator();
        System.out.println();

        Decorators.evenIndexElementsSubList(list);
        ListElements decorators = new Decorators(new ArrayListElements(list));
        System.out.println(decorators.get(1));
        System.out.println(decorators.size());
        decorators.iterator();
    }
}