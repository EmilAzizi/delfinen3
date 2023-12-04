package data;

import comparator.SwimmingTimeComparator;
import data.Filehandler;
import domain.Controller;
import domain.Member;
import domain.Team;
import domain.Trainer;

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
    Filehandler FH = new Filehandler("members.csv");
    private Member member;

    private Controller controller;

    private final int adultAge = 18;
    ArrayList<Member> competingUnderAge = new ArrayList<>();
    ArrayList<Member> competingAboveAge = new ArrayList<>();

    public Database(Controller controller) {
        this.controller = controller;
    }

    public Member createMember() {
        input.nextLine();

        controller.whatIsTheNameOfTheMemberFromUI();
        String name = input.nextLine();

        controller.whatIsTheBirthdateMemberFromUI();
        String date = input.next();
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

        controller.phoneNumberMemberFromUI();
        int number = input.nextInt();

        controller.emailMemberFromUI();
        String email = input.next();

        input.nextLine();

        controller.addressMemberFromUI();
        String address = input.nextLine();

        controller.activityYouCanChooseTheFollowingCompetingOrMotionistFromUI();
        int activityChoice = input.nextInt();
        String activity = null;
        switch (activityChoice) {
            case 1 -> activity = "competing";
            case 2 -> activity = "motionist";
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
        String name = input.nextLine();

        controller.whatIsTheBirthdateTrainerFromUI();
        String date = input.next();
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
        int number = input.nextInt();

        controller.emailTrainerFromUI();
        String email = input.next();

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

    public void addTrainerToList() throws IOException{
        Trainer trainer = createTrainer();
        memberList.add(trainer);
        trainerList.add(trainer);
        FH.savePersonToCSV(memberList);
    }

    public void addMembersToMembersList() throws IOException {
        for (Member member : FH.loadMembers()) {
            memberList.add(member);
            if(member.getActivity().equals("Training")){
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
            System.out.println(teamSenior.getTrainer());
            for (Member member : teamSenior.getTeam()) {
                System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity() + " , " + member.getSwimmingTime());
            }
        } else{
            controller.noneFromUI();
            for (Member member : competingAboveAge) {
                System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity() + " , " + member.getSwimmingTime());
            }
        }

        if(teamJunior.getAssignment()){
            System.out.println(teamJunior.getTrainer());
            for (Member member : teamJunior.getTeam()) {
                System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity() + " , " + member.getSwimmingTime());
            }
        } else {
            controller.noneFromUI();
            for (Member member : competingUnderAge) {
                System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity() + " , " + member.getSwimmingTime());
            }
        }
    }

    public void assignTrainer () {
        controller.whichTrainerWouldYouLikeToAssignFromUI();
        Member trainer = null;
        int count = 0;
        System.out.println(trainerList);
        for (Member member : trainerList) {
            count++;
            System.out.println(count + ". " + member.getName());
        }
        int choice = input.nextInt();
        trainer = trainerList.get(choice-1);
        controller.whichTeamWouldYouLikeToAssignToFromUI(trainer.getName());
        controller.oneSeniorFromUI();
        controller.secondJuniorFromUI();
        int choice2 = input.nextInt();
        switch (choice2) {
            case 1 -> teamSenior = new Team(trainer, competingAboveAge);
            case 2 -> teamJunior = new Team(trainer, competingUnderAge);
        }
    }

    // TODO trænere skal ikke være inkluderet
    public void displayTopFiveSwimmers () {
        int count = 0;
        Collections.sort(controller.getMemberList(), new SwimmingTimeComparator());
        for (Member member : controller.getMemberList()) {
            count++;
            System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getSwimmingTime());
            if (count >= 5) {
                break;
            }
        }
    }
}