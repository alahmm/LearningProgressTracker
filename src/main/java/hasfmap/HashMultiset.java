package hasfmap;


import java.util.*;

interface Multiset<E> {

    /**
     * Add an element to the multiset.
     * It increases the multiplicity of the element by 1.
     */
    void add(E elem);

    /**
     * Remove an element from the multiset.
     * It decreases the multiplicity of the element by 1.
     */
    void remove(E elem);

    /**
     * Unite this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in at least one of the initial multisets.
     * The multiplicity of each element is equal to the maximum multiplicity of
     * the corresponding elements in both multisets.
     */
    void union(Multiset<E> other);

    /**
     * Intersect this multiset with another one. The result is the modified multiset (this).
     * It will contain all elements that are present in the both multisets.
     * The multiplicity of each element is equal to the minimum multiplicity of
     * the corresponding elements in the intersecting multisets.
     */
    void intersect(Multiset<E> other);

    /**
     * Returns multiplicity of the given element.
     * If the set doesn't contain it, the multiplicity is 0
     */
    int getMultiplicity(E elem);

    /**
     * Check if the multiset contains an element,
     * i.e. the multiplicity > 0
     */
    boolean contains(E elem);

    /**
     * The number of unique elements,
     * that is how many different elements there are in a multiset.
     */
    int numberOfUniqueElements();

    /**
     * The size of the multiset, including repeated elements
     */
    int size();

    /**
     * The set of unique elements (without repeating)
     */
    Set<E> toSet();
}

class HashMultiset<E> implements Multiset<E> {

    private Map<E, Integer> map = new HashMap<>();

    @Override
    public void add(E elem) {

        if (!map.containsKey(elem)) {
            map.put(elem, 1);
        } else {
            int value = map.get(elem);
            map.replace(elem, value, value + 1);
        }
        // implement the method
    }

    @Override
    public void remove(E elem) {
        int value = map.get(elem);
        if (value == 1) {
            map.remove(elem);
        } else if (value > 1) {
            map.replace(elem, value, value - 1);
        }
    }

    @Override
    public void union(Multiset<E> other) {

        for (Map.Entry<E, Integer> mapNew : map.entrySet()
        ) {
            if (other.contains(mapNew.getKey())) {
                map.replace(mapNew.getKey(), map.get(mapNew.getKey()),
                        Math.max(getMultiplicity(mapNew.getKey()), other.getMultiplicity(mapNew.getKey())));
            }
        }
    }

    @Override
    public void intersect(Multiset<E> other) {
        if (other.size() == 0) {
            map.clear();
        } else {
            Iterator<Map.Entry<E, Integer>> iterator = map.entrySet().iterator();

            // Iterate over the HashMap
            while (iterator.hasNext()) {
                // Get the entry at this iteration
                Map.Entry<E, Integer>
                        entry
                        = iterator.next();
                E key = entry.getKey();

                if (other.contains(key)) {
                    map.replace(key, map.get(key),
                            Math.min(getMultiplicity(key), other.getMultiplicity(key)));
                } else {
                    remove(key);
                }
            }
            iterator = map.entrySet().iterator();
            if (map.size() == 1) {
                E element = iterator.next().getKey();
                if (!other.contains(element)) {
                    map.remove(element);
                }
            }
        }
        for (Map.Entry<E, Integer> mapNew : map.entrySet()
        ) {
            System.out.println(mapNew.getKey() + ":" + mapNew.getValue());
        }

    }

    @Override
    public int getMultiplicity(E elem) {
        return map.getOrDefault(elem, 0);
    }

    @Override
    public boolean contains(E elem) {
        return map.containsKey(elem);
    }

    @Override
    public int numberOfUniqueElements() {
        if (map.keySet().isEmpty() ){ return 0;}
        else {
            int numberOfUniqueElements = 0;
            for (Map.Entry<E, Integer> mapNew : map.entrySet()
            ) {
                if (mapNew.getValue() >= 1) {
                    numberOfUniqueElements++;
                }
            }

            return numberOfUniqueElements;
        }
    }

    @Override
    public int size() {
        int size = 0;
        for (Map.Entry<E, Integer> mapNew: map.entrySet()
        ) {
            size += mapNew.getValue();
        }
        return size;
    }

    @Override
    public Set<E> toSet() {
        // Creating a new HashSet<> object helps us avoid ConcurrentModificationException.
        // It is thrown when we try to iterate over elements of Map and modify them at the same time
        return new HashSet<>(map.keySet());
    }
}

class Main3 {
    public static void main(String[] args) {
        HashMultiset<Integer> hash = new HashMultiset<>();
        hash.add(5);
        hash.add(5);
        hash.add(6);
        HashMultiset<Integer> other = new HashMultiset<>();
        other.add(5);
        hash.intersect(other);
    }
}
