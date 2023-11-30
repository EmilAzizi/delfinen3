package domain;

import comparator.SwimmingTimeComparator;
import domain.Member;

import java.util.ArrayList;
import java.util.Collections;

public class Trainer {

    // TODO refactorer til database klasse

    ArrayList<Member> competingUnderAge = new ArrayList<>();
    ArrayList<Member> competingAboveAge = new ArrayList<>();
    private final int adultAge = 18;

    private Controller controller;

    public Trainer(Controller controller){
        this.controller = controller;
    }

    public void divideMembers(){
        ArrayList<Member> allMembers = controller.getMemberList();

        for(Member member : allMembers){
            int memberAge = member.getAge();

            if(member.getIsCompeting() || member.getActivity().equals("competing")) {
                if (memberAge >= adultAge && !competingAboveAge.contains(member)) {
                    competingAboveAge.add(member);
                    Collections.sort(competingAboveAge, new SwimmingTimeComparator());
                } else if(memberAge < adultAge && !competingUnderAge.contains(member)){
                    competingUnderAge.add(member);
                    Collections.sort(competingUnderAge, new SwimmingTimeComparator());
                }
            }
        }
    }

    public void displayMembersWithTrainer(){
        divideMembers();

        System.out.println("Senior:");
        for(Member member : competingAboveAge){
            System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity() + " , " + member.getSwimmingTime());
        }

        System.out.println("Junior:");
        for(Member member : competingUnderAge){
            System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity() + " , " + member.getSwimmingTime());
        }
    }

    public void displayTopFiveSwimmers(){
        int count = 0;
        Collections.sort(controller.getMemberList(), new SwimmingTimeComparator());
        for(Member member : controller.getMemberList()){
            count++;
            System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getSwimmingTime());
            if(count >= 5){
                break;
            }
        }
    }
}
