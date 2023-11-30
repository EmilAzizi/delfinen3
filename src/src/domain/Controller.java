package domain;

import comparator.SwimmingTimeComparator;
import domain.Chairman;
import domain.Member;
import domain.Trainer;
import ui.UserInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;
public class Controller {
    boolean isRunning = true;
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    Chairman chairman = new Chairman();
    Trainer trainer = new Trainer(this);
    UserInterface UI = new UserInterface(this);


    public void run() {
        try {
            chairman.addMembersToMembersList();
            System.out.println("Welcome to delfinen.");
            while (isRunning) {
                System.out.println("""
                        Would you like to:
                        1. Add a new member?
                        2. Display existing members?
                        3. Display competing members with their trainer?
                        4. Display top swimmers?
                        5. Sort existing members?
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
                chairman.createMemberList();
                Collections.sort(getMemberList(), new SwimmingTimeComparator());
            }
            case 2 -> {
                System.out.println("Display: All members, senior or youth");
                int displayChoice = chairman.giveScanner();
                switch (displayChoice){
                    case 1 -> display(displayChoice);
                    case 2 -> display(displayChoice);
                    case 3 -> display(displayChoice);
                }
            }
            case 3 -> trainer.displayMembersWithTrainer();
            case 4 -> trainer.displayTopFiveSwimmers();
            case 5 -> UI.amountOfAttributes();
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
        return chairman.getMemberList();
    }
}

