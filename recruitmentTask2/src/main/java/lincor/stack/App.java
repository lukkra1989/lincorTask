package lincor.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Stack ourStack = new Stack(3);
        ourStack.push(2);
        ourStack.push(3);
        ourStack.push(1);

        for (int i = 0; i <= ourStack.hashCode(); i++) {
           // ourStack.get(i);
            System.out.println(i);
            System.out.println(ourStack);
        }

        Set<Integer> ourSet = new HashSet<>();
        ourSet.add(2);
        ourSet.add(222);
        ourSet.add(12);
        ourSet.add(01);
        ourSet.add(222);

        for (int n = 0; n <= ourSet.size(); n++)

            System.out.println(ourSet);
        //System.out.println(n);
    }
}
