package ui;

import java.util.ArrayList;

import comparator.*;
import domain.Controller;

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
        System.out.println("The members are now sorted! Press (3) to display the sorted list.");
    }


    public void welcomeToDelfin(){
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
                        6. Display top swimmers?
                        7. View subscribtion prices
                        8. Sort existing members?
                        0. Exit program.""");
    }

    public void displayAllMembersSeniorOrYouth() {
        System.out.println("Display: All members, senior or youth");
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

    public void seniorPriceIndividualAndTotal(int seniorPrice, int seniorPriceTotal) {
        System.out.println("Senior price individual: " + seniorPrice + ", Total senior price: " + seniorPriceTotal);
    }

    public void subscriptionSeniorNameAndAge(String name, int age) {
        System.out.println("Name: " + name + ". Age: " + age);
    }

    public void juniorPriceIndividualAndTotal(int juniorPrice, int juniorPriceTotal) {
        System.out.println("Junior price individual: " + juniorPrice + ", Total junior price: " + juniorPriceTotal);
    }

    public void subscriptionJuniorNameAndAge(String name, int age) {
        System.out.println("Name: " + name + ". Age: " + age);
    }

    public void passivePriceIndividualAndTotal(int passivePrice, int passivePriceTotal) {
        System.out.println("Passive price individual: " + passivePrice + ", Total passive price: " + passivePriceTotal);
    }

    public void subscribtionPassiveNameAndAge(String name, int age) {
        System.out.println("Name: " + name + ". Age: " + age);
    }

    public void subscriptionTotalPriceMessage(int totalPrice){
        System.out.println("Delfinens total annual income: " + totalPrice);
    }







}
