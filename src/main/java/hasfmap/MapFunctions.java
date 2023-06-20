package hasfmap;

import java.util.*;


/*class MapFunctions {

    public static void printWithSameLetter(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()
             ) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.startsWith(String.valueOf(value.charAt(0)))) {
                System.out.println(key + " " + value);
            }
        }

    }
}

*//* Do not change code below *//*
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(" ");
            map.put(pair[0], pair[1]);
        }

        MapFunctions.printWithSameLetter(map);
    }
}*/
import java.util.*;


/*
class MapFunctions {

    public static void putThreeCountries(Map<String, String> map) {
        map.put("mariam", "sahd");
        map.put("hafsa", "mustafa");
        map.put("sali", "belle");
    }
}

*/
/* Do not change code below *//*

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(" ");
            map.put(pair[0], pair[1]);
        }

        MapFunctions.putThreeCountries(map);

        System.out.println(map.size());
    }
}*/
import java.util.*;


class MapFunctions {

    public static void removeLongNames(Map<String, String> map) {
        // Get the iterator over the HashMap
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        // Iterate over the HashMap
        while (iterator.hasNext()) {

            // Get the entry at this iteration
            Map.Entry<String, String>
                    entry
                    = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.length() > 7 || value.length() > 7) {
                iterator.remove();
            }
        }
    }
}

/* Do not change code below */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(" ");
            map.put(pair[0], pair[1]);
        }

        MapFunctions.removeLongNames(map);

        System.out.println(map.size());
    }
}