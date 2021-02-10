package com.epam.rd.autocode.decorator;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("q,w,e,r,t,y,u,i,o,p".split(","));
        Decorators evenElements = new EvenElements(new AllElements(list), list);
        evenElements.iterator();
    }
}