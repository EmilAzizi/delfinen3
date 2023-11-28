import member.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Chairman {
    private ArrayList<Member> memberList = new ArrayList<>();
    private Scanner input = new Scanner(System.in).useLocale(Locale.US);
    Filehandler FH = new Filehandler("members.csv");
    private Member member;
    public Member createMember(){
        input.nextLine();

        System.out.println("What is the name of the member?");
        String name = input.nextLine();

        System.out.println("What is the age?");
        int age = input.nextInt();

        System.out.println("Phone number?");
        int phoneNumber = input.nextInt();

        System.out.println("Email?");
        String email = input.next();

        input.nextLine();

        System.out.println("Address?");
        String address = input.nextLine();

        System.out.println("Competing?");
        String competing = input.next().toLowerCase();

        switch(competing){
            case "yes", "y" -> {
                System.out.println("Which dicipline?");
                String activity = input.next();

                System.out.println("What is the members best swimming time in " + activity.toLowerCase() + "?");
                double swimmingTime = input.nextDouble();
                member = new Member(age, name, phoneNumber, email, activity, swimmingTime, address);

                System.out.println("Have the member ever been in a competition?");
                String haveBeenInCompetition = input.next();

                switch(haveBeenInCompetition) {
                    case "yes", "y" -> {
                        System.out.println("Where was the competition?");
                        String competitionPlace = input.next();

                        System.out.println("What place did the member rank in the race?");
                        String competitionPlacement = input.next();

                        System.out.println("When was this competition?");
                        String competitionTime = input.next();

                        member = new Member(age, name, phoneNumber, email, competing, activity, address, competitionPlace, competitionPlacement, competitionTime);
                    }
                    default -> member = new Member(age, name, phoneNumber, email, competing, activity, swimmingTime, address);

                }
            }
            default -> {
                member = new Member(age, name, phoneNumber, email, competing, address);
            }
        }
        return member;
    }

    public void createMemberList() throws IOException {
        memberList.add(createMember());
        FH.savePersonToCSV(memberList);
    }

    public void addMembersToMembersList() throws IOException {
        for (Member member : FH.loadMembers()) {
            memberList.add(member);
        }
    }





    public ArrayList<Member> getMemberList(){
        return memberList;
    }

    public void loadMembers() throws IOException{
        FH.loadMembers();
    }
}
