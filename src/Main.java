

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Learning Progress Tracker");
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "^[a-zA-Z]+(?:[-'][a-zA-Z]+)*$";//?:for Groupierung
        String regexLastName = "^[a-zA-Z]+(?:[-'\s][a-zA-Z]+)*$";
        String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9]+$";
        List<String> listOfPersonalData = new ArrayList<>();
        int i = 0;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            if (input.equals("exit")) {
                System.out.println("Bye!");
                return;
            } else if (input.equals("back")) {
                System.out.println("Enter 'exit' to exit the program.");
            } else if (input.equals("add students")){
                System.out.println("Enter student credentials or 'back' to return:");
                while (scanner.hasNextLine()) {
                    input = scanner.nextLine();
                    String[] array = input.split("\\s+");
                    if (input.equals("back")) {
                        if (listOfPersonalData.size() == 0) {
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
                            System.out.println("Total " + listOfPersonalData.size() + " students have been added.");
                        }
                    } else if (array.length <= 2) {
                        System.out.println("Incorrect credentials.");
                    } else {
                        String firstName = array[0];
                        String lastName = "";
                        if (array.length == 3) {
                            lastName = array[1];
                        } else {
                            for (int j = 1; j < array.length - 1; j++) {
                                lastName += array[j] + " ";
                            }
                            lastName = lastName.substring(0, lastName.length() - 1);
                        }
                        String email = array[array.length - 1];
                        int length = firstName.length();
                        if (!firstName.matches(regex) ||length == 1) {
                            System.out.println("Incorrect first name.");
                        } else if (!lastName.matches(regexLastName) || lastName.length() == 1) {
                            System.out.println("Incorrect last name.");
                        } else if (!email.matches(regexEmail)) {
                            System.out.println("Incorrect email.");
                        }else {
                            System.out.println("The student has been added.");
                            listOfPersonalData.add(input);
                        }
                    }
                }
            } else if (input.isBlank()) {
                System.out.println("\"no input\"");
            } else {
                System.out.println("Unknown command!");
            }
        }
    }
}
