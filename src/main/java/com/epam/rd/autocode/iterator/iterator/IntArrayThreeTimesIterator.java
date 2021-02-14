package com.epam.rd.autocode.iterator.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArrayThreeTimesIterator implements Iterator<Integer> {
    private final int[] array;
    private int index;
    private int indexCounter;

    public IntArrayThreeTimesIterator(int[] array) {
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
            return array[getTripleIndex()];
        }
    }

    private Integer getTripleIndex() {
        int value = index;
        if (indexCounter == 3) {
            index++;
            resetIndexCounter();
        }
        return value;
    }

    private void resetIndexCounter() {
        indexCounter = 0;
    }
}