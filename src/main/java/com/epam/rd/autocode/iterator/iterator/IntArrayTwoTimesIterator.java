package com.epam.rd.autocode.iterator.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArrayTwoTimesIterator implements Iterator<Integer> {
    private final int[] array;
    private int index;
    private int indexCounter;

    public IntArrayTwoTimesIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            indexCounter++;
            return array[getDoubleIndex()];
        }
    }

    private Integer getDoubleIndex() {
        int value = index;
        if (indexCounter == 2) {
            index++;
            resetIndexCounter();
        }
        return value;
    }

    private void resetIndexCounter() {
        indexCounter = 0;
    }
}