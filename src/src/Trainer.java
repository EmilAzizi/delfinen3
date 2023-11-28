import member.Member;

import java.util.ArrayList;

public class Trainer {

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
                } else if(memberAge < adultAge && !competingUnderAge.contains(member)){
                    competingUnderAge.add(member);
                }
            }
        }
    }

    public void displayMembersWithTrainer(){
        divideMembers();

        System.out.println("Trainer 1:");
        for(Member member : competingAboveAge){
            System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity());
        }

        System.out.println("Trainer 2:");
        for(Member member : competingUnderAge){
            System.out.println(member.getName() + " , " + member.getAge() + " , " + member.getActivity());
        }
    }
}
