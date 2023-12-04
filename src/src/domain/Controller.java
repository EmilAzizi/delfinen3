package domain;

import comparator.SwimmingTimeComparator;
import data.Database;
import ui.UserInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
public class Controller {
    boolean isRunning = true;
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    Database database = new Database(this);
    UserInterface UI = new UserInterface(this);


    public void run() {
        try {
            database.addMembersToMembersList();
            UI.welcomeToDelfin();
            while (isRunning) {
                UI.mainMenu();

                running();
            }
        } catch(IOException e){
            e.getMessage();
        }
    }

    private void running() throws IOException {
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                database.createMemberList();
                Collections.sort(getMemberList(), new SwimmingTimeComparator());
            }
            case 2 -> database.addTrainerToList();
            case 3 -> {
                UI.displayAllMembersSeniorOrYouth();
                int displayChoice = database.giveScanner();
                switch (displayChoice){
                    case 1 -> display(displayChoice);
                    case 2 -> display(displayChoice);
                    case 3 -> display(displayChoice);
                }
            }
            case 4 -> database.assignTrainer();
            case 5 -> database.displayMembersWithTrainer();
            case 6 -> database.displayTopFiveSwimmers();
            case 7 -> database.viewPrices();
            case 8 -> UI.amountOfAttributes();
            case 0 -> isRunning = false;
        }
    }

    public void display(int choice){
        for(Member member : getMemberList()){
            switch (choice){
                case 1 -> {
                    UI.printMembers(member.getName(), member.getAge(), member.getAdress(), member.getPhoneNumber(), member.getEmail(),
                            member.getActivity(),  member.getSwimmingTime(), member.getActivityForm());
                }
                case 2 -> {
                    if(member.getAge() >= 18){
                        UI.printMembers(member.getName(), member.getAge(), member.getAdress(), member.getPhoneNumber(), member.getEmail(),
                                member.getActivity(),  member.getSwimmingTime(), member.getActivityForm());
                    }
                }
                case 3 -> {
                    if(member.getAge() < 18){
                        UI.printMembers(member.getName(), member.getAge(), member.getAdress(), member.getPhoneNumber(), member.getEmail(),
                                member.getActivity(),  member.getSwimmingTime(), member.getActivityForm());
                    }
                }
            }

        }
    }

    public ArrayList<Member> getMemberList(){
        return database.getMemberList();
    }


    public void whatIsTheNameOfTheMemberFromUI() {
        UI.whatIsTheNameOfTheMember();
    }

    public void whatIsTheBirthdateMemberFromUI() {
        UI.whatIsTheBirthdateMember();
    }

    public void phoneNumberMemberFromUI() {
        UI.phoneNumberMember();
    }

    public void emailMemberFromUI() {
        UI.emailMember();
    }

    public void addressMemberFromUI() {
        UI.addressMember();
    }

    public void activityYouCanChooseTheFollowingCompetingOrMotionistFromUI() {
        UI.activityYouCanChooseTheFollowingCompetingOrMotionist();
    }

    public void whatDisciplineAreTheyCurrentlyActiveInFromUI() {
        UI.whatDisciplineAreTheyCurrentlyActiveIn();
    }

    public void whatIsTheirBestSwimmingTimeFromUI() {
        UI.whatIsTheirBestSwimmingTime();
    }

    public void whatIsTheNameOfTheTrainerFromUI() {
        UI.whatIsTheNameOfTheTrainer();
    }

    public void whatIsTheBirthdateTrainerFromUI() {
        UI.whatIsTheBirthdateTrainer();
    }

    public void phoneNumberTrainerFromUI() {
        UI.phoneNumberTrainer();
    }

    public void emailTrainerFromUI() {
        UI.emailTrainer();
    }

    public void addressTrainerFromUI() {
        UI.addressTrainer();
    }

    public void noneFromUI() {
        UI.none();
    }

    public void whichTrainerWouldYouLikeToAssignFromUI() {
        UI.whichTrainerWouldYouLikeToAssign();
    }

    public void oneSeniorFromUI() {
        UI.oneSenior();
    }

    public void secondJuniorFromUI() {
        UI.secondJunior();
    }

    public void whichTeamWouldYouLikeToAssignToFromUI(String name) {
        UI.whichTeamWouldYouLikeToAssignTo(name);
    }

    public void seniorPriceIndividualAndTotalFromUI(int seniorPrice, int seniorPriceTotal) {
        UI.seniorPriceIndividualAndTotal(seniorPrice, seniorPriceTotal);
    }

    public void subscriptionSeniorNameAndAgeFromUI(String name, int age) {
        UI.subscriptionSeniorNameAndAge(name, age);
    }

    public void juniorPriceIndividualAndTotalFromUI(int juniorPrice, int juniorPriceTotal) {
        UI.juniorPriceIndividualAndTotal(juniorPrice, juniorPriceTotal);
    }

    public void subscriptionJuniorNameAndAgeFromUI(String name, int age) {
        UI.subscriptionJuniorNameAndAge(name, age);
    }

    public void passivePriceIndividualAndTotalFromUI(int passivePrice, int passivePriceTotal) {
        UI.passivePriceIndividualAndTotal(passivePrice, passivePriceTotal);
    }

    public void subscribtionPassiveNameAndAgeFromUI(String name, int age) {
        UI.subscribtionPassiveNameAndAge(name, age);
    }

    public void getSupsciptionTotalPriceFromUI(int totalPrice){
        UI.subscriptionTotalPriceMessage(totalPrice);
    }


}

