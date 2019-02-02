package it.sevenbits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> first = new ArrayList<>();
        List<Account> second = new LinkedList<>();
        ListOperator operator = new ListOperator();

        for (int i = 0; i < 10; i++) {
            first.add(i);
        }

        for (int i = 1; i <= 5; i++) {
            second.add(new Account(i*10));
        }

        System.out.println(operator.max(first, 2, 4));
        System.out.println(operator.max(first, 3, 7));
        System.out.println(operator.max(first, 1, 9));

        System.out.println(operator.max(second, 0, 4));
        System.out.println(operator.max(second, 1, 3));

        operator.changeElementsPosition(first, 3,4);
        operator.changeElementsPosition(first, 1,9);
        System.out.println(Arrays.toString(first.toArray()));

        operator.changeElementsPosition(second, 1,2);
        operator.changeElementsPosition(second, 0,4);
        System.out.println(Arrays.toString(second.toArray()));

        ThreadExecutor executor = new ThreadExecutor();
        executor.showAccountFilling(3000);


    }
}
