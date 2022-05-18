package JavaCollection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //khai bao mang su dung array list
        ArrayList<String> list = new ArrayList<>();

        // them phan tu
        list.add("A1");
        list.add("A2");
        list.add("A3");

        //xoa phan tu
//        list.remove(0);

        // duyet qua mang
        for (int i = 0; i < list.size(); i++ ){
            System.out.println(list.get(i));

        }
//        for (String item: list  ) {
//            System.out.println(item);
//        }
//
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext())  {
//                String item = iterator.next();
//        }

        // Vector
        Vector<String> list1 = new Vector<>();
        list1.add("hello");
        list1.add("he");

        for (String item: list1) {
            System.out.println(item);
        }
//        linked
        LinkedList<String> linkedList = new LinkedList<>();
        for (String newItem: linkedList ) {
            System.out.println(linkedList);
        }
    }
    // hash map
        PriorityQueue<String> queue = new PriorityQueue<>();



}
