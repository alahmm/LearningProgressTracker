package linkedArrayList;

import java.util.ArrayList;
import java.util.LinkedList;

class ListOperations {
    public static void changeHeadsAndTails(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        // write your code here
        String firstOfLinked = linkedList.getFirst();
        String lastOfLinked = linkedList.getLast();
        linkedList.set(0, arrayList.get(0));
        linkedList.set(linkedList.size() - 1, arrayList.get(linkedList.size() - 1));
        arrayList.set(0, firstOfLinked);
        arrayList.set(arrayList.size() - 1, lastOfLinked);
    }

    public static void mergeLists(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        linkedList.addAll(arrayList);
        System.out.println("The new size of LinkedList is" + linkedList.size());
    }

    public static void removeTheSame(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            if (linkedList.get(i).equals(arrayList.get(i))) {
                linkedList.remove(linkedList.get(i));
                arrayList.remove(arrayList.get(i));
            }
        }
    }
}
