package com.paigeruppel.udemy.designpatterns.structural.composite;

import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {
    public static void main(String[] args) {
        SingleValue two = new SingleValue(2);
        SingleValue three = new SingleValue(3);
        SingleValue four = new SingleValue(4);

        ManyValues twoFourTen = new ManyValues();
        twoFourTen.add(2);
        twoFourTen.add(4);
        twoFourTen.add(10);

        ArrayList<ValueContainer> valueContainers = new ArrayList<>();
        valueContainers.add(two);
        valueContainers.add(three);
        valueContainers.add(four);
        valueContainers.add(twoFourTen);

        MyList myList = new MyList(valueContainers);
        System.out.println(myList.sum());
    }

}

public class CompositeCodeExercise {
}

class SingleValue implements ValueContainer {
    public int value;

    public SingleValue(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(this.value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
}

class MyList extends ArrayList<ValueContainer> {

    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        int result = 0;
        for (ValueContainer c : this) {
            for (int i : c) {
                result += i;
            }
        }
        return result;
    }

}
