package domain;

import comparator.SwimmingTimeComparator;
import data.Database;
import ui.UserInterface;

import java.io.IOException;
import java.util.*;

public class Controller {
    boolean isRunning = true;
    Scanner input = new Scanner(System.in).useLocale(Locale.US);
    Database database = new Database(this);
    UserInterface UI = new UserInterface(this);

    public void run() {
        while (isRunning){
            try {
                database.addMembersToMembersList();
                UI.welcomeToDelfin();
                    UI.mainMenu();

                    running();
            } catch (IOException e) {
                e.getMessage();
                input.nextLine();
            } catch (InputMismatchException a) {
                System.out.println("Please enter a number corresponding to the options listed.");
                input.nextLine();
            }
        }
    }

    private void running() throws IOException {
        int choice = input.nextInt();
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
                    case 4 -> {
                        UI.searchForMember();
                        input.nextLine();
                        String memberToFind = input.nextLine();
                        database.trackMember(memberToFind);
                    }
                }
            }
            case 4 -> database.assignTrainer();
            case 5 -> database.displayMembersWithTrainer();
            case 6 -> database.displayTopFiveSwimmers();
            case 7 -> database.viewPrices();
            case 8 -> database.changeMembersActivity();
            case 9 -> UI.amountOfAttributes();
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
    public void teamSeniorTrainerFromUI(String trainer) {
        UI.teamSeniorTrainer(trainer);
    }

    public void teamJuniorTrainerFromUI(String trainer) {
        UI.teamJuniorTrainer(trainer);
    }

    public void memberNameAgeActivitySwimmingTimeFromUI(String name, int age, String activity, double swimmingTime) {
        UI.memberNameAgeActivitySwimmingTime(name, age, activity, swimmingTime);
    }

    public void displayTopFiveSwimmersMessageFromUI(String name, int age, String activity, double time){
        UI.displayTopFiveSwimmersMessage(name, age, activity, time);
    }

    public void noMemberIsCompetingInActivityFromUI(){
        UI.noMemberIsCompetingInActivity();
    }

    public void displayTopFiveSwimmersMessageFromUI(){
        UI.displayTopFiveSwimmersMessage();
    }

    public void seniorJuniorPassivePriceFromUI(String teamName, int price, int totalPrice, int amount){
        UI.seniorJuniorPassivePrice(teamName, price, totalPrice, amount);
    }

    public void totalAnualEarningFromUI(int totalEarning){
        UI.totalAnualEarning(totalEarning);
    }

    public void createTrainerFirstErrorFromUI(){
        UI.createTrainerFirstError();
    }
    public void changeMemberMenuFromUI(boolean hasPaid, String memberName){
        UI.changeMemberMenu(hasPaid, memberName);
    }
    public void whichMemberToChangeMessageFromUI(){
        UI.whichMemberToChangeMessage();
    }

    public void memberToChange(int count ,String name, int age, String activity){
        UI.memberToChange(count, name, age, activity);
    }

    public void membersWithDebt(){
        UI.membersWithDebt();
    }

    public void allMembersWithDebt(String name, int age){
        UI.allMembersWithDebt(name, age);
    }

    public void totalDebt(int dept){
        UI.totalDebt(dept);
    }

    public void showTrainer(int count, String name){
        UI.showTrainers(count, name);
    }
    public void showMemberForTracking(String name, int phoneNumber, String email, String activity, double swimmingTime, String address, String activityForm, int age){
        UI.showMemberForTracking(name, phoneNumber, email, activity, swimmingTime, address, activityForm, age);
    }

    public void validName(){
        UI.validName();
    }
    public void validDate(){
        UI.validDate();
    }
    public void validNumber(){
        UI.validNumber();
    }
    public void validEmail(){
        UI.validEmail();
    }
}

