
import java.util.*;

public class Main {

    public static boolean isEmailTaken(List<PersonalData> personalDataList, String email) {
        for (PersonalData personal : personalDataList
        ) {
            if (personal.getEmail().equals(email)) {
                System.out.println("This email is already taken.");
                return true;
            }
        }
        return false;
    }
    public static boolean isRightFormat(String[] listOfPersonalData) {
        for (String element : listOfPersonalData
        ) {
            if (!element.matches("[0-9]+")) {
                System.out.println("Incorrect points format.");
                return false;
            } else if (element.matches("[0-9]+") && Integer.parseInt(element) < 0) {
                System.out.println("Incorrect points format.");
                return false;
            }
        }
        return true;
    }
    public static void PointAdder(String[] listOfPoints, PersonalData personalData) {

        if (listOfPoints.length != 5) {
            System.out.println("Incorrect points format.");
        } else {
            if (isRightFormat(listOfPoints)) {
                int newJava, newDsa, newDatabase, newSpring = 0;
                if (personalData.getPoints()!= null) {
                    newJava = personalData.getPoints().getJava() + Integer.parseInt(listOfPoints[1]);
                    newDsa = personalData.getPoints().getDsa() + Integer.parseInt(listOfPoints[2]);
                    newDatabase = personalData.getPoints().getDatabases() + Integer.parseInt(listOfPoints[3]);
                    newSpring = personalData.getPoints().getSpring() + Integer.parseInt(listOfPoints[4]);
                } else {
                    newJava = Integer.parseInt(listOfPoints[1]);
                    newDsa = Integer.parseInt(listOfPoints[2]);
                    newDatabase = Integer.parseInt(listOfPoints[3]);
                    newSpring = Integer.parseInt(listOfPoints[4]);
                }

                Points points = new Points(newJava, newDsa, newDatabase, newSpring);
                System.out.println("Points updated.");
                personalData.setPoints(points);
            }
        }
    }
    public static void IdShower(List<Integer> listOfIds) {
        System.out.println("Students:");
        for (int id : listOfIds
        ) {
            System.out.println(id);
        }
    }

    public static void Finder(PersonalData personalData) {
        System.out.printf("%d points: Java=%d; DSA=%d; Databases=%d; Spring=%d%n", personalData.getId(),
                personalData.getPoints().getJava(), personalData.getPoints().getDsa(),
                personalData.getPoints().getDatabases(), personalData.getPoints().getSpring());
    }
    public static boolean isAdded(List<PersonalData> personalDataList, PersonalData personalData,
                                  List<Integer> listOfIds, String email) {
        if (personalDataList.isEmpty()) {
            personalDataList.add(personalData);
            listOfIds.add(personalData.getId());
            return true;
        } else if (!isEmailTaken(personalDataList, email)) {
            personalDataList.add(personalData);
            listOfIds.add(personalData.getId());
            return true;
        }
        return false;
    }

    public static boolean isMostPopular(List<PersonalData> personalDataList, String course) {
        int i = 0;
        for (PersonalData personalData : personalDataList
        ) {
            if (personalData.getPoints().decider(course) != 0) {
                i++;
            }
        }
        return i >= 2;
    }
    public static boolean isLeastPopular(List<PersonalData> personalDataList, String course) {
        int i = 0;
        for (PersonalData personalData : personalDataList
        ) {
            if (personalData.getPoints().decider(course) != 0) {
                i++;
            }
        }
        return i == 1 || i == 0;
    }
    public static boolean isLowestActivity(List<PersonalData> personalDataList, String course) {
        int i = 0;
        for (PersonalData personalData : personalDataList
        ) {
            if (personalData.getPoints().decider(course) != 0) {
                i++;
            }
        }
        return i == 0 || i == 1;
    }
    public static int EasiestHardestCourse(List<PersonalData> personalDataList, String course) {
        int i = 0;
        int point = 0;
        for (PersonalData personalData : personalDataList
        ) {
            if (personalData.getPoints().decider(course) != 0) {
                point += personalData.getPoints().decider(course);
                i++;
            }
        }
        if (i != 0) {
            return point/i;
        }
        return 0;
    }
    public static boolean isEasiestCourse(List<PersonalData> personalDataList, String course, String[] courses) {
        int actualPoint = EasiestHardestCourse(personalDataList, course);
        List<String> otherCourses = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (!courses[i].equals(course)) {
                otherCourses.add(courses[i]);
            }
        }
        return actualPoint > EasiestHardestCourse(personalDataList, otherCourses.get(0))
                && actualPoint > EasiestHardestCourse(personalDataList, otherCourses.get(1))
                && actualPoint > EasiestHardestCourse(personalDataList, otherCourses.get(2));
    }
    public static boolean isHardestCourse(List<PersonalData> personalDataList, String course, String[] courses) {
        int actualPoint = EasiestHardestCourse(personalDataList, course);
        List<String> otherCourses = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            if (!courses[i].equals(course)) {
                otherCourses.add(courses[i]);
            }
        }
        return actualPoint < EasiestHardestCourse(personalDataList, otherCourses.get(0))
                && actualPoint < EasiestHardestCourse(personalDataList, otherCourses.get(1))
                && actualPoint < EasiestHardestCourse(personalDataList, otherCourses.get(2));
    }
    public static boolean isHighestActivity(List<PersonalData> personalDataList, String course) {
        int i = 0;
        for (PersonalData personalData : personalDataList
        ) {
            if (personalData.getPoints().decider(course) != 0) {
                i++;
            }
        }
        return i >= 2;
    }
    public static void StatisticsPrinter(String[] courses, List<PersonalData> personalDataList) {
        boolean isLeastPopular = false;
        boolean isMostPopular = false;
        boolean isHighestActivity = false;
        boolean isLowestActivity = false;
        boolean isHardestCourse = false;
        boolean isEasiestCourse = false;
        int howMany = 0;
        String calculate = "";

        System.out.print("Most popular: ");
        for (String course : courses
        ) {
            if (isMostPopular(personalDataList, course)) {
                calculate += course + ", ";
                isMostPopular = true;
            }
        }
        if (!isMostPopular) {
            System.out.print("n/a");
        } else {
            System.out.print(calculate.substring(0, calculate.length() - 2));
        }
        calculate = "";
        System.out.println();
        System.out.print("Least popular: ");
        for (String course : courses
        ) {
            if (isLeastPopular(personalDataList, course)) {
                calculate += course + ", ";
                isLeastPopular = true;
                howMany ++;
            }
        }
        if (!isLeastPopular || howMany == 4) {
            System.out.print("n/a");
        } else {
            System.out.print(calculate.substring(0, calculate.length() - 2));
        }
        howMany = 0;
        calculate = "";
        System.out.println();
        System.out.print("Highest activity: ");
        for (String course : courses
        ) {
            if (isHighestActivity(personalDataList, course)) {
                calculate += course + ", ";
                isHighestActivity = true;
            }
        }
        if (!isHighestActivity) {
            System.out.print("n/a");
        } else {
            System.out.print(calculate.substring(0, calculate.length() - 2));
        }
        calculate = "";
        System.out.println();
        System.out.print("Lowest activity: ");
        for (String course : courses
        ) {
            if (isLowestActivity(personalDataList, course)) {
                calculate += course + ", ";
                isLowestActivity = true;
                howMany++;
            }
        }
        if (!isLowestActivity || howMany == 4) {
            System.out.print("n/a");
        } else {
            System.out.print(calculate.substring(0, calculate.length() - 2));
        }
        calculate = "";
        System.out.println();
        System.out.print("Easiest course: ");
        for (String course : courses
        ) {
            if (isEasiestCourse(personalDataList, course, courses)) {
                calculate += course + ", ";
                isEasiestCourse = true;
            }
        }
        if (!isEasiestCourse) {
            System.out.print("n/a");
        } else {
            System.out.print(calculate.substring(0, calculate.length() - 2));
        }
        calculate = "";
        System.out.println();
        System.out.print("Hardest course: ");
        for (String course : courses
        ) {
            if (isHardestCourse(personalDataList, course, courses)) {
                calculate += course + ", ";
                isHardestCourse = true;
            }
        }
        if (!isHardestCourse) {
            System.out.print("n/a");
        } else {
            System.out.print(calculate.substring(0, calculate.length() - 2));
        }
    }
    public static void CoursePrinter(String course, List<PersonalData> personalDataList) {
        int mustEarned;
        switch (course) {
            case "JAVA" -> mustEarned = 600;
            case "DSA" -> mustEarned = 400;
            case "DATABASES" -> mustEarned = 480;
            default -> mustEarned = 550;
        }

        String progress = String.format(course+"%n"+"id points completed%n");
        Map<Integer, Integer> mapOfStudent = new TreeMap<>();
        for (PersonalData personalData : personalDataList
        ) {
            if (course.equals("JAVA") && personalData.getPoints().getJava() != 0) {
                mapOfStudent.put(personalData.getId(), personalData.getPoints().getJava());
            } else if (course.equals("DSA") && personalData.getPoints().getDsa() != 0) {
                mapOfStudent.put(personalData.getId(), personalData.getPoints().getDsa());
            } else if (course.equals("DATABASES") && personalData.getPoints().getDatabases() != 0) {
                mapOfStudent.put(personalData.getId(), personalData.getPoints().getDatabases());
            } else if (course.equals("SPRING") && personalData.getPoints().getSpring() != 0) {
                mapOfStudent.put(personalData.getId(), personalData.getPoints().getSpring());
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mapOfStudent.entrySet());
        list.sort(new ValueThenKeyComparator<>());
        System.out.print(progress);
        for (Map.Entry<Integer, Integer> map : list
        ) {
            double devision = map.getValue() * 100.0 / mustEarned;
            System.out.printf("%d %d %.1f%%%n", map.getKey(), map.getValue(), map.getValue() * 100.0/ mustEarned);
        }

    }
    public static void PrintNotification(String firstName, String lastName,
                                         String email, String course) {
        System.out.printf("To: %s%n\n" +
                        "Re: Your Learning Progress%n\n" +
                        "Hello, %s %s! You have accomplished our %s course!",
                email, firstName, lastName, course);
    }
    public static void Notifier(List<PersonalData> personalDataList) {
        int counterOfStudents = 0;
        int counter = 0;
        for (PersonalData personalData : personalDataList
        ) {
            if (personalData.getPoints().getJava() == 600) {
                PrintNotification(personalData.getFirstName(),
                        personalData.getLastName(), personalData.getEmail(), "Java");
                counter ++;
            }
            if (personalData.getPoints().getDsa() == 400) {
                PrintNotification(personalData.getFirstName(),
                        personalData.getLastName(), personalData.getEmail(), "DSA");
                if (counter == 0) {
                    counter++;
                }
            }
            if (personalData.getPoints().getDatabases() == 480) {
                PrintNotification(personalData.getFirstName(),
                        personalData.getLastName(), personalData.getEmail(), "Databases");
                if (counter == 0) {
                    counter++;
                }
            }
            if (personalData.getPoints().getSpring() == 550) {
                PrintNotification(personalData.getFirstName(),
                        personalData.getLastName(), personalData.getEmail(), "Spring");
                if (counter == 0) {
                    counter++;
                }
            }
            counterOfStudents += counter;
            counter = 0;
        }
        System.out.printf("Total %d students have been notified.", counterOfStudents);
    }
    public static void main(String[] args) {

        System.out.println("Learning Progress Tracker");
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "^[a-zA-Z]+(?:[-'][a-zA-Z]+)*$";//?:for Groupierung
        String regexLastName = "^[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$";
        String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9]+$";
        List<PersonalData> personalDataList = new ArrayList<>();
        List<Integer> listOfIds = new ArrayList<>();
        int iNotifier = 0;
        int i = 0;
        int idNew = 100;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equals("back")) {
                System.out.println("Enter 'exit' to exit the program.");
            } else if (input.equals("add students")){
                System.out.println("Enter student credentials or 'back' to return:");
                while (scanner.hasNextLine()) {
                    input = scanner.nextLine();
                    String[] arrayOfData = input.split("\\s+");
                    if (input.equals("add points")) {
                        System.out.println("Enter an id and points or 'back' to return");
                        while (scanner.hasNextLine()) {
                            input = scanner.nextLine();
                            if (input.equals("back")) {
                                break;
                            } else {
                                String[] arrayOfPoints = input.split("\\s+");
                                try  {
                                    int id = Integer.parseInt(arrayOfPoints[0]);
                                    if (listOfIds.contains(id)) {
                                        for (PersonalData personalData : personalDataList
                                        ) {
                                            if (personalData.getId() == id) {
                                                PointAdder(arrayOfPoints, personalData);
                                            }
                                        }
                                    } else {
                                        System.out.printf("No student is found for id=%d.%n", id);
                                    }
                                } catch (Exception e) {
                                    System.out.printf("No student is found for id=%s.%n", input);
                                }
                            }
                        }
                    } else if (input.equals("statistics")) {
                        System.out.println("Type the name of a course to see details or 'back' to quit:");
                        String[] courses = {"Java", "DSA", "Databases", "Spring"};
                        StatisticsPrinter(courses, personalDataList);
                        String whichCourse;
                        while (scanner.hasNextLine()) {
                            whichCourse = scanner.nextLine();
                            if (whichCourse.equals("back")) {
                                break;
                            } else {
                                CoursePrinter(whichCourse.toUpperCase(), personalDataList);
                            }
                        }
                    } else if (input.equals("notify")) {
                        if (iNotifier == 0) {
                            Notifier(personalDataList);
                            iNotifier++;
                        } else {
                            System.out.println("Total 0 students have been notified.");
                        }
                    } else if (input.equals("list")) {
                        if (listOfIds.isEmpty()) {
                            System.out.println("No students found");
                        } else {
                            IdShower(listOfIds);
                        }
                    } else if (input.equals("find")) {
                        System.out.println("Enter an id or 'back' to return:");
                        while (scanner.hasNextLine()) {
                            input = scanner.nextLine();
                            if (input.equals("back")) {
                                break;
                            } else {
                                try {
                                    int id = Integer.parseInt(input);
                                    if (listOfIds.contains(id)) {
                                        for (PersonalData personalData : personalDataList
                                        ) {
                                            if (personalData.getId() == id) {
                                                Finder(personalData);
                                            }
                                        }

                                    } else {
                                        System.out.printf("No student is found for id=%d.%n", id);
                                    }
                                } catch (Exception e) {
                                    System.out.printf("No student is found for id=%s.%n", input);
                                }
                            }
                        }
                    } else if (input.equals("back")) {
                        if (personalDataList.size() == 0) {
                            if (i == 0) {
                                System.out.println("Total " + 0 + " students have been added.");
                                i++;
                            } else {
                                System.out.println("Enter 'exit' to exit the program.");
                                input = scanner.nextLine();
                                if (input.equals("exit")) {
                                    System.out.println("Bye!");
                                    return;
                                }
                            }
                        } else {
                            System.out.println("Total " + personalDataList.size() + " students have been added.");
                        }
                    } else if (arrayOfData.length <= 2) {
                        System.out.println("Incorrect credentials.");
                    } else {
                        String firstName = arrayOfData[0];
                        String lastName = "";
                        if (arrayOfData.length == 3) {
                            lastName = arrayOfData[1];
                        } else {
                            for (int j = 1; j < arrayOfData.length - 1; j++) {
                                lastName += arrayOfData[j] + " ";
                            }
                            lastName = lastName.substring(0, lastName.length() - 1);
                        }
                        String email = arrayOfData[arrayOfData.length - 1];
                        int length = firstName.length();
                        if (!firstName.matches(regex) ||length == 1) {
                            System.out.println("Incorrect first name.");
                        } else if (!lastName.matches(regexLastName) || lastName.length() == 1) {
                            System.out.println("Incorrect last name.");
                        } else if (!email.matches(regexEmail)) {
                            System.out.println("Incorrect email.");
                        }else {
                            PersonalData personalData = new PersonalData(idNew, email, firstName, lastName);
                            if (isAdded(personalDataList, personalData, listOfIds, email)) {
                                System.out.println("The student has been added.");
                                idNew ++;
                            }
                        }
                    }
                }
            } else if (input.isBlank()) {
                System.out.println("no input");
            } else if (input.equals("exit")) {
                System.out.println("Bye!");
                return;
            } else if (input.equals("notify")) {
                System.out.println("Total 0 students have been notified.");
            } else if (input.equals("add points")) {
                System.out.println("Enter an id and points or 'back' to return");
            } else if (input.equals("find")) {
                System.out.println("Enter an id or 'back' to return:");
            } else if (input.equals("statistics")) {
                System.out.println("Type the name of a course to see details or 'back' to quit:");
                String[] courses = {"Java", "DSA", "Databases", "Spring"};
                StatisticsPrinter(courses, personalDataList);
                String whichCourse;
                while (scanner.hasNextLine()) {
                    whichCourse = scanner.nextLine();
                    if (whichCourse.equals("back")) {
                        break;
                    } else {
                        if (Arrays.stream(courses).map(String::toUpperCase).toList().contains(whichCourse.toUpperCase())) {
                            CoursePrinter(whichCourse.toUpperCase(), personalDataList);
                        } else {
                            System.out.println("Unknown course.");
                        }                    }
                }
            } else {
                System.out.println("Unknown command!");
            }
        }


    }
}
class PersonalData {
    private int id;
    private String email;
    private String firstName;
    private String lastName;

    private Points points;

    public Points getPoints() {
        return points;
    }

    public void setPoints(Points points) {
        this.points = points;
    }

    public PersonalData(int id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
class Points {
    private int java;
    private int dsa;
    private int databases;
    private int spring;

    public Points(int java, int dsa, int databases, int spring) {
        this.java = java;
        this.dsa = dsa;
        this.databases = databases;
        this.spring = spring;
    }

    public int getJava() {
        return java;
    }

    public int getDsa() {
        return dsa;
    }

    public int getDatabases() {
        return databases;
    }

    public int getSpring() {
        return spring;
    }

    public int decider(String course) {
        return switch (course) {
            case "Java" -> getJava();
            case "DSA" -> getDsa();
            case "Databases" -> getDatabases();
            default -> getSpring();
        };
    }
}
class ValueThenKeyComparator<K extends Comparable<? super K>,
        V extends Comparable<? super V>>
        implements Comparator<Map.Entry<K, V>> {

    public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
        int cmp1 = b.getValue().compareTo(a.getValue());
        if (cmp1 != 0) {
            return cmp1;
        } else {
            return a.getKey().compareTo(b.getKey());
        }
    }

}



