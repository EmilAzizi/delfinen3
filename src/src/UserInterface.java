import java.util.ArrayList;

import comparator.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
public class UserInterface {
    Scanner input = new Scanner(System.in);
    Controller controller;

    public UserInterface(Controller controller) {
        this.controller = controller;
    }



// Work on progress
    public void printMembers(String name, int age, String address, int phoneNumber, String email, String activity, double swimmingTime, String activityForm){
        switch(activity){
            case "competing" -> {
                System.out.println("Name: " + name + ", " + "Age: " + age + ", " +
                        "Address: " + address + ", " + "PhoneNumber: " + phoneNumber + ", " +
                        "Email: " + email + ", " + "Activity: " + activity + ", " + "Activity form: " + activityForm + ", " + "SwimmingTime: " + swimmingTime);
            }
            default -> System.out.println("Name: " + name + ", " + "Age: " + age + ", " +
                    "Address: " + address + ", " + "PhoneNumber: " + phoneNumber + ", " +
                    "Email: " + email + ", " + "Activity: " + activity + ", " + "SwimmingTime: " + swimmingTime);
        }
    }

    public void amountOfAttributes() {
        System.out.println("""
                    Would you like to sort by one or two attributes?
                """);


        int userChoiseForAttributesAmount = input.nextInt();
        switch (userChoiseForAttributesAmount) {
            case 1 -> sortSwimmersByOneAttribute();
            case 2 -> { System.out.println("""
                What would you like to sort by?
                1. Name
                2. Age
                3. Swimming time
                4. Activity
                """);
                int firstChoise = input.nextInt();
                int secondChoise = input.nextInt();
                sortSwimmersByTwoAttributes(firstChoise, secondChoise);
            }
        }
    }

    public void sortSwimmersByOneAttribute() {
        System.out.println("""
                    What would you like to sort by?
                    1. Name
                    2. Age
                    3. Swimming time
                    4. Activity
                """);
        int userChoise = input.nextInt();
        switch (userChoise) {
            case 1 -> Collections.sort(controller.getMemberList(), new NameComparator());
            case 2 -> Collections.sort(controller.getMemberList(), new AgeComparator());
            case 3 -> Collections.sort(controller.getMemberList(), new SwimmingTimeComparator());
            case 4 -> Collections.sort(controller.getMemberList(), new ActivityComparator());
        }
        System.out.println("The members are now sorted! Press (X) to display the sorted list.");
        if (controller.getMemberList().isEmpty()){
            System.out.println("Empty");
        }

    }

    public void sortSwimmersByTwoAttributes(int userChoice1, int userChoice2) {
        Comparator comparator1 = null;
        Comparator comparator2 = null;

        switch (userChoice1) {
            case 1 -> comparator1 = new NameComparator();
            case 2 -> comparator1 = new AgeComparator();
            case 3 -> comparator1 = new SwimmingTimeComparator();
            case 4 -> comparator1 = new ActivityComparator();
        }

        switch (userChoice2) {
            case 1 -> comparator2 = new NameComparator();
            case 2 -> comparator2 = new AgeComparator();
            case 3 -> comparator2 = new SwimmingTimeComparator();
            case 4 -> comparator2 = new ActivityComparator();
        }
        Collections.sort(controller.getMemberList(), comparator1.thenComparing(comparator2));
        System.out.println("The members are now sorted! Press (X) to display the sorted list.");
    }
}
