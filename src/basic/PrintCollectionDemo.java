package basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PrintCollectionDemo {

    /**
     * print collection with old Java style before JDK 1.5
     */
    @SuppressWarnings("rawtypes")
    public static void printColl(Collection c) {
        Iterator i = c.iterator();
        while (i.hasNext()) {
            Object e = i.next();
            System.out.print(e);
            System.out.println(" (" + e.getClass().getName() + ")");
        }
    }

    /**
     * 2. version with new style using JDK 1.5 syntax (generics)
     */
    public static void printCollGenerics(Collection<?> coll) {
        for (Object e : coll) {
            System.out.print(e);
            System.out.println(" (" + e.getClass().getName() + ")");
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String args[]) {

        Collection list = new ArrayList();
        list.add("uno");
        list.add("due");
        list.add("tre");
        list.add("quattro");
        list.add(5);

        printColl(list);
        printCollGenerics(list);

        Collection<String> c2 = new ArrayList<>();
        c2.addAll(list);
        printColl(c2);
        printCollGenerics(c2);

    }
}
