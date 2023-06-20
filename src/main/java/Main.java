
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
                Points points = new Points(Integer.parseInt(listOfPoints[1]), Integer.parseInt(listOfPoints[2])
                        , Integer.parseInt(listOfPoints[3]), Integer.parseInt(listOfPoints[4]));
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
                personalData.getPoints().getJava() * 2, personalData.getPoints().getDsa() * 2,
                personalData.getPoints().getDatabases() * 2, personalData.getPoints().getSpring() * 2);
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


    public static void main(String[] args) {

        System.out.println("Learning Progress Tracker");
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "^[a-zA-Z]+(?:[-'][a-zA-Z]+)*$";//?:for Groupierung
        String regexLastName = "^[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$";
        String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9]+$";
        List<PersonalData> personalDataList = new ArrayList<>();
        List<Integer> listOfIds = new ArrayList<>();
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
            } else if (input.equals("add points")) {
                System.out.println("Enter an id and points or 'back' to return");
            } else if (input.equals("find")) {
                System.out.println("Enter an id or 'back' to return:");
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


}

