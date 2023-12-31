package ui;

import comparator.*;
import domain.Controller;

import java.util.ArrayList;
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
    public void printMembers(String name, int age, String address, int phoneNumber, String email, String activity, double swimmingTime, String activityForm) {
        switch (activity) {
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
                Would you like to sort by:
                1. One attribute.
                2. Two attributes.
                """);


        int userChoiseForAttributesAmount = input.nextInt();
        switch (userChoiseForAttributesAmount) {
            case 1 -> sortSwimmersByOneAttribute();
            case 2 -> {
                System.out.println("""
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
        System.out.println("The members are now sorted! Press (3) to display the sorted list.");
        if (controller.getMemberList().isEmpty()) {
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
        System.out.println("The members are now sorted! Press (3) to display the sorted list.");
    }


    public void welcomeToDelfin() {
        System.out.println("Welcome to delfinen.");
    }

    public void mainMenu() {
        System.out.println("""
                Would you like to:
                1. Add a new member.
                2. Add a new trainer.
                3. Display existing members.
                4. Assign trainer to a team.
                5. Display competing members with their trainer.
                6. Display top swimmers.
                7. View subscribtion prices.
                8. Change member's activity.
                9. Sort existing members.
                0. Exit program.""");
    }

    public void displayAllMembersSeniorOrYouth() {
        System.out.println("""
                What would you like to display?
                1. All members.
                2. Senior.
                3. Youth.
                4. Search for a member
                """);
    }


    public void whatIsTheNameOfTheMember() {
        System.out.println("What is the name of the member?");
    }

    public void whatIsTheBirthdateMember() {
        System.out.println("What is the birthdate? [dd/mm/yyyy]");
    }

    public void phoneNumberMember() {
        System.out.println("Phone number?");
    }

    public void emailMember() {
        System.out.println("Email?");
    }

    public void addressMember() {
        System.out.println("Address?");
    }

    public void activityYouCanChooseTheFollowingCompetingOrMotionist() {
        System.out.println("""
                What's the members status?
                1. Competing.
                2. Motionist.
                3. Passive
                """);
    }


    public void whatDisciplineAreTheyCurrentlyActiveIn() {
        System.out.println("""
                What dicipline are they currently active in?
                1. Butterfly
                2. Crawl.
                3. Rygcrawl.
                4. Brystsvømning
                """);
    }

    public void whatIsTheirBestSwimmingTime() {
        System.out.println("What is their best swimming time?");
    }

    public void whatIsTheNameOfTheTrainer() {
        System.out.println("What is the name of the trainer?");
    }

    public void whatIsTheBirthdateTrainer() {
        System.out.println("What is the birthdate? [dd/mm/yyyy]");
    }

    public void phoneNumberTrainer() {
        System.out.println("Phone number?");
    }

    public void emailTrainer() {
        System.out.println("Email?");
    }

    public void addressTrainer() {
        System.out.println("Address?");
    }

    public void none() {
        System.out.println("none");
    }

    public void whichTrainerWouldYouLikeToAssign() {
        System.out.println("Which trainer would you like to assign?");
    }

    public void oneSenior() {
        System.out.println("1. Senior");
    }

    public void secondJunior() {
        System.out.println("2. Junior");
    }

    public void whichTeamWouldYouLikeToAssignTo(String name) {
        System.out.println("Which team would you like to assign to: " + name);
    }


    public void teamSeniorTrainer(String trainer) {
        System.out.println(trainer);
    }

    public void teamJuniorTrainer(String trainer) {
        System.out.println(trainer);
    }

    public void memberNameAgeActivitySwimmingTime(String name, int age, String activity, double swimmingTime) {
        System.out.println(name + " , " + age + " , " + activity + " , " + swimmingTime);
    }

    public void displayTopFiveSwimmersMessage(String name, int age, String activity, double time) {
        System.out.println(name + " , " + age + " , " + activity + ", " + time);
    }

    public void noMemberIsCompetingInActivity() {
        System.out.println("No competing members in this dicipline.");
    }

    public void displayTopFiveSwimmersMessage() {
        System.out.println("""
                Which dicipline would you like to sort by?
                1. Crawl.
                2. Brystsvømning.
                3. Rygcrawl.
                4. Butterfly.
                """);
    }

    public void seniorJuniorPassivePrice(String teamName, int price, int totalPrice, int amount) {
        System.out.println(teamName + " subscription price: " + price);
        System.out.println("Total income from " + teamName + " members: " + totalPrice);
        System.out.println("(" + amount + ")" + " total " + teamName + " members" + "\n");
    }

    public void totalAnualEarning(int totalEarning) {
        System.out.println("Delfinens total anual earning is: " + totalEarning);
        System.out.println();
    }

    public void createTrainerFirstError() {
        System.out.println("You must create a trainer first before you can assign one.");
    }

    public void changeMemberMenu(boolean hasPaid, String memberName) {
        System.out.println("Which activity would you like to change to for: " + memberName);
        if (hasPaid) {
            System.out.println("""
                    1. Competing.
                    2. Motionist.
                    3. Passive.
                    4. Member has not paid.
                    """);
        } else {
            System.out.println("""
                    1. Competing.
                    2. Motionist.
                    3. Passive.
                    4. Member has paid.
                    """);
        }
    }

    public void whichMemberToChangeMessage() {
        System.out.println("Which members activity would you like to change: ");
    }

    public void memberToChange(int count, String name, int age, String activity) {
        System.out.println(count + ". Name: " + name + ". Age: " + age + ". Activity: " + activity);
    }

    public void membersWithDebt() {
        System.out.println("Members with missing payment: ");
    }

    public void allMembersWithDebt(String name, int age) {
        System.out.println("Name: " + name + ". Age: " + age);
    }

    public void totalDebt(int debt) {
        System.out.println("Delfinens total debt is: " + debt);
    }

    public void showTrainers(int count, String name) {
        System.out.println(count + ". " + name);
    }

    public void showMemberForTracking(String name, int phoneNumber, String email, String activity, double swimmingTime, String address, String activityForm, int age){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Adress: " + address);
        System.out.println("Disciplin: " + activity);
        System.out.println("Disciplin form: " + activityForm);
        System.out.println("Time: " + swimmingTime);
        System.out.println("-------------------------------------");
    }
    public void searchForMember(){
        System.out.println("Please enter the name you would like to search for: ");
    }
    public void validName(){
        System.out.println("Please enter a valid name.");
    }
    public void validDate(){
        System.out.println("Please enter a valid Date.");
    }
    public void validNumber(){
        System.out.println("Please enter a valid phone number");
    }
    public void validEmail(){
        System.out.println("Please enter a valid email");
    }

}
