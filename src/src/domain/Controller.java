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
            System.out.println("Welcome to delfinen.");
            while (isRunning) {
                System.out.println("""
                        Would you like to:
                        1. Add a new member.
                        2. Add a new trainer.
                        3. Display existing members.
                        4. Assign trainer to a team.
                        5. Display competing members with their trainer.
                        6. Display top swimmers?
                        7. Sort existing members?
                        0. Exit program.""");

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
                System.out.println("Display: All members, senior or youth");
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
            case 7 -> UI.amountOfAttributes();
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
}

