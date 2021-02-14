package com.epam.rd.autocode.iterator.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArrayFiveTimesIterator implements Iterator<Integer> {
    private final int[] array;
    private int index;
    private int indexCounter;

    public IntArrayFiveTimesIterator(int[] array) {
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
            return array[getFivefoldIndex()];
        }
    }

    private Integer getFivefoldIndex() {
        int value = index;
        if (indexCounter == 5) {
            index++;
            resetIndexCounter();
        }
        return value;
    }

    private void resetIndexCounter() {
        indexCounter = 0;
    }
}