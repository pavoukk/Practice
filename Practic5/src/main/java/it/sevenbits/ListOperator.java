package it.sevenbits;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListOperator {

    public <W extends Comparable<W>> W max(List<W> elements, int start, int end) throws Exception {
        if(start < 0 || start > elements.size() || end < 0 || end > elements.size()) {
            throw new Exception("Incorrect position's value");
        }
            W max = elements.get(start);
        for (int i = start + 1; i <= end; i++) {
            W element = elements.get(i);
            if(element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }

    public <W> void changeElementsPosition(List<W> list, int firstPosition, int secondPosition) throws Exception {
        if(firstPosition < 0 || firstPosition > list.size() || secondPosition < 0 || secondPosition > list.size()) {
            throw new Exception("Incorrect position's value");
        }
        W first = list.get(firstPosition);
        list.set(firstPosition, list.get(secondPosition));
        list.set(secondPosition, first);
    }


}
