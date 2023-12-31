package data;

import comparator.SwimmingTimeComparator;
import domain.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Database {
    private ArrayList<Member> memberList = new ArrayList<>();
    private ArrayList<Member> trainerList = new ArrayList<>();
    Team teamSenior = new Team();
    Team teamJunior = new Team();
    private Scanner input = new Scanner(System.in).useLocale(Locale.US);
    Filehandler FH = new Filehandler("members.csv", this);
    private Member member;

    private Controller controller;

    private final int adultAge = 18;
    ArrayList<Member> competingUnderAge = new ArrayList<>();
    ArrayList<Member> competingAboveAge = new ArrayList<>();
    private Subscribtion subscribtion = new Subscribtion(memberList);

    public Database(Controller controller) {
        this.controller = controller;
    }

    public Member createMember() {
        input.nextLine();

        controller.whatIsTheNameOfTheMemberFromUI();
        boolean nameIsValid = false;
        String name = input.nextLine();
        while(!nameIsValid){
            if(name.chars().anyMatch(Character::isDigit)){
                nameIsValid = false;
                controller.validName();
                name = input.nextLine();
            } else {
                nameIsValid = true;
            }
        }


        controller.whatIsTheBirthdateMemberFromUI();
        boolean validDate = false;
        String date = input.next();
        while(!validDate){
            if(date.chars().anyMatch(Character::isLetter)){
                validDate = false;
                controller.validDate();
                date = input.next();
            } else {
                validDate = true;
            }
        }
        String[] birthdate = date.split("/");
        String[] checkForZeroDay = birthdate[0].split("");
        String[] checkForZeroMonth = birthdate[1].split("");

        int day;
        if (checkForZeroDay[0].equals("0")) {
            day = Integer.parseInt(checkForZeroDay[1]);
        } else {
            day = Integer.parseInt(birthdate[0]);
        }

        int month;
        if (checkForZeroMonth[0].equals("0")) {
            month = Integer.parseInt(checkForZeroMonth[1]);
        } else {
            month = Integer.parseInt(birthdate[1]);
        }

        int year = Integer.parseInt(birthdate[2]);

        controller.phoneNumberMemberFromUI();
        while (!input.hasNextInt()) {
            controller.validNumber();
            input.next();
        }
        int number = input.nextInt();

        controller.emailMemberFromUI();
        String email = input.next();
        while(!email.contains("@")){
            controller.validEmail();
            email = input.next();
        }

        input.nextLine();

        controller.addressMemberFromUI();
        String address = input.nextLine();

        controller.activityYouCanChooseTheFollowingCompetingOrMotionistFromUI();
        int activityChoice = input.nextInt();
        String activity = null;
        switch (activityChoice) {
            case 1 -> activity = "competing";
            case 2 -> activity = "motionist";
            case 3 -> activity = "passive";
        }

        switch (activity) {
            case "competing" -> {
                controller.whatDisciplineAreTheyCurrentlyActiveInFromUI();
                int formChoice = input.nextInt();
                String activityForm = null;
                switch (formChoice) {
                    case 1 -> activityForm = "butterfly";
                    case 2 -> activityForm = "crawl";
                    case 3 -> activityForm = "rygcrawl";
                    case 4 -> activityForm = "brystsvømning";
                }

                controller.whatIsTheirBestSwimmingTimeFromUI();
                Double swimmingTime = input.nextDouble();
                member = new Member(name, number, email, activity, swimmingTime, address, activityForm, day, month, year);
                member.setIsCompeting();
            }
            default -> member = new Member(name, number, email, activity, address, day, month, year);
        }
        return member;
    }

    public Trainer createTrainer() {
        input.nextLine();

        controller.whatIsTheNameOfTheTrainerFromUI();
        boolean nameIsValid = false;
        String name = input.nextLine();
        while(!nameIsValid){
            if(name.chars().anyMatch(Character::isDigit)){
                nameIsValid = false;
                controller.validName();
                name = input.nextLine();
            } else {
                nameIsValid = true;
            }
        }

        controller.whatIsTheBirthdateTrainerFromUI();
        boolean validDate = false;
        String date = input.next();
        while(!validDate){
            if(date.chars().anyMatch(Character::isLetter)){
                validDate = false;
                controller.validDate();
                date = input.next();
            } else {
                validDate = true;
            }
        }
        String[] birthdate = date.split("/");
        String[] checkForZero = birthdate[0].split("");

        int day;
        if (checkForZero[0].equals("0")) {
            day = Integer.parseInt(checkForZero[1]);
        } else {
            day = Integer.parseInt(birthdate[0]);
        }

        int month;
        if (checkForZero[0].equals("0")) {
            month = Integer.parseInt(checkForZero[1]);
        } else {
            month = Integer.parseInt(birthdate[0]);
        }

        int year = Integer.parseInt(birthdate[2]);

        controller.phoneNumberTrainerFromUI();
        while (!input.hasNextInt()) {
            controller.validNumber();
            input.next();
        }
        int number = input.nextInt();

        controller.emailTrainerFromUI();
        String email = input.next();
        while(!email.contains("@")){
            controller.validEmail();
            email = input.next();
        }

        input.nextLine();

        controller.addressTrainerFromUI();
        String address = input.nextLine();

        String activity = "Training";

        Trainer trainer = new Trainer(name, number, email, activity, address, day, month, year, "Trainer");
        return trainer;
    }

    public void createMemberList() throws IOException {
        Member member = createMember();
        memberList.add(member);
        FH.savePersonToCSV(memberList);
    }

    public void addTrainerToList() throws IOException {
        Trainer trainer = createTrainer();
        memberList.add(trainer);
        trainerList.add(trainer);
        FH.savePersonToCSV(memberList);
    }

    public void addMembersToMembersList() throws IOException {
        for (Member member : FH.loadMembers()) {
            memberList.add(member);
            if (member.getActivity().equals("Training")) {
                trainerList.add(member);
            }
        }
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public int giveScanner() {
        Scanner choice = new Scanner(System.in);
        return choice.nextInt();
    }

    public void divideMembers() {
        ArrayList<Member> allMembers = controller.getMemberList();

        for (Member member : allMembers) {
            int memberAge = member.getAge();

            if (member.getIsCompeting() || member.getActivity().equals("competing")) {
                if (memberAge >= adultAge && !competingAboveAge.contains(member)) {
                    competingAboveAge.add(member);
                    Collections.sort(competingAboveAge, new SwimmingTimeComparator());
                } else if (memberAge < adultAge && !competingUnderAge.contains(member)) {
                    competingUnderAge.add(member);
                    Collections.sort(competingUnderAge, new SwimmingTimeComparator());
                }
            }
        }
    }

    public void displayMembersWithTrainer() {
        divideMembers();


        if(teamSenior.getAssignment()){
            controller.teamSeniorTrainerFromUI(teamSenior.getTrainer());
            for (Member member : teamSenior.getTeam()) {
                controller.memberNameAgeActivitySwimmingTimeFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
            }
        } else {
            controller.noneFromUI();
            for (Member member : competingAboveAge) {
                controller.memberNameAgeActivitySwimmingTimeFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
            }
        }


        if(teamJunior.getAssignment()){
            controller.teamJuniorTrainerFromUI(teamJunior.getTrainer());
            for (Member member : teamJunior.getTeam()) {
                controller.memberNameAgeActivitySwimmingTimeFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
            }
        } else {
            controller.noneFromUI();
            for (Member member : competingUnderAge) {
                controller.memberNameAgeActivitySwimmingTimeFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
            }
        }
    }

    public void assignTrainer() {
        controller.whichTrainerWouldYouLikeToAssignFromUI();
        Member trainer = null;
        int count = 0;
        if(!trainerList.isEmpty()) {
            for (Member member : trainerList) {
                count++;
                controller.showTrainer(count, member.getName());
            }
            int choice = input.nextInt();
            trainer = trainerList.get(choice - 1);
            controller.whichTeamWouldYouLikeToAssignToFromUI(trainer.getName());
            controller.oneSeniorFromUI();
            controller.secondJuniorFromUI();
            int choice2 = input.nextInt();
            switch (choice2) {
                case 1 -> teamSenior = new Team(trainer, competingAboveAge);
                case 2 -> teamJunior = new Team(trainer, competingUnderAge);
            }
        } else {
            controller.createTrainerFirstErrorFromUI();
        }
    }

    public void trackMember(String memberToSearch){
        for(Member member : memberList){
            if(member.getName().contains(memberToSearch)){
                controller.showMemberForTracking(member.getName(), member.getPhoneNumber(), member.getEmail(), member.getActivity(), member.getSwimmingTime(), member.getAdress(), member.getActivityForm(), member.getAge());
            }
        }
    }

    public void displayTopFiveSwimmers() {
        int count = -1;
            controller.displayTopFiveSwimmersMessageFromUI();
            int whichDiciplineToSortBy = input.nextInt();
        Collections.sort(controller.getMemberList(), new SwimmingTimeComparator());
        for (Member member : controller.getMemberList()) {
            if (member.getActivity().equals("competing")) {
                count++;
                if (count >= 6) {
                    break;
                }
            switch (whichDiciplineToSortBy) {
                case 1 -> {
                    if (member.getActivityForm().toLowerCase().equals("crawl"))
                        controller.displayTopFiveSwimmersMessageFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
                }
                case 2 -> {
                    if (member.getActivityForm().toLowerCase().equals("brystsvømning"))
                        controller.displayTopFiveSwimmersMessageFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
                }
                case 3 -> {
                    if (member.getActivityForm().toLowerCase().equals("rygcrawl"))
                        controller.displayTopFiveSwimmersMessageFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
                }
                case 4 -> {
                    if (member.getActivityForm().toLowerCase().equals("butterfly"))
                        controller.displayTopFiveSwimmersMessageFromUI(member.getName(), member.getAge(), member.getActivity(), member.getSwimmingTime());
                }
                default -> controller.noMemberIsCompetingInActivityFromUI();
            }
            }
        }
    }

    public void calculatePrice() {
        subscribtion.resetPrice();
        subscribtion.assignSubscribtion();
        subscribtion.assignPriceToSubscribtion();
    }

    public void viewPrices() {
        calculatePrice();
        controller.seniorJuniorPassivePriceFromUI("Senior", subscribtion.getSeniorPrice(), subscribtion.getSeniorPriceTotal(), subscribtion.getSenior().size());
        controller.seniorJuniorPassivePriceFromUI("Junior", subscribtion.getJuniorPrice(), subscribtion.getJuniorPriceTotal(),subscribtion.getJunior().size());
        controller.seniorJuniorPassivePriceFromUI("Passive", subscribtion.getPassivePrice(), subscribtion.getPassivePriceTotal(), subscribtion.getPassive().size());
        controller.membersWithDebt();
        if (subscribtion.getNotActive().isEmpty()){
            System.out.println("none");
        }
        for(Member member : subscribtion.getNotActive()){
            controller.allMembersWithDebt(member.getName(), member.getAge());
        }
        int totalPriceAll = subscribtion.getJuniorPriceTotal() + subscribtion.getPassivePriceTotal() + subscribtion.getSeniorPriceTotal();
        totalPriceAll = totalPriceAll + subscribtion.getDebtTotal();
        controller.totalDebt(subscribtion.getDebtTotal());

        controller.totalAnualEarningFromUI(totalPriceAll);
    }

    public void changeMembersActivity() throws IOException{
        int count = 0;
        controller.whichMemberToChangeMessageFromUI();
        Member originalMember = null;
        for(Member member : memberList){
            count++;
            controller.memberToChange(count, member.getName(), member.getAge(), member.getActivity());
        }
        int choice = input.nextInt();

        originalMember = memberList.get(choice-1);
        controller.changeMemberMenuFromUI(originalMember.getHasPaid(), originalMember.getName());
        int activityChoice = input.nextInt();
        switch(activityChoice){
            case 1 -> {
                originalMember.setActivity(activityChoice);
                controller.whatDisciplineAreTheyCurrentlyActiveInFromUI();
                int activityForm = input.nextInt();
                originalMember.setActivityForm(activityForm);
                controller.whatIsTheirBestSwimmingTimeFromUI();
                double swimmingTime = input.nextDouble();
                originalMember.setSwimmingTime(swimmingTime);
            }
            default -> originalMember.setActivity(activityChoice);
        }
        FH.changeMember();
    }
}