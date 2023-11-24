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
        int number = input.nextInt();

        System.out.println("Email?");
        String email = input.next();

        input.nextLine();

        System.out.println("Address?");
        String address = input.nextLine();

        System.out.println("Activity");
        String activity = input.next().toLowerCase();

        switch(activity){
            case "competing" -> {
                System.out.println("What is their swimming time?");
                double swimmingTime = input.nextDouble();
                member = new Member(age, name, number, email, activity, swimmingTime, address);
            }
            default -> {
                member = new Member(age, name, number, email, activity, address);
            }
        }
        return member;
    }

    public void createMemberList() throws IOException {
        memberList.add(createMember());
        FH.savePersonToCSV(memberList);
    }


    public void display(){
        if (memberList.isEmpty()) {
            System.out.println("No members to display.");
        } else {
            for (Member member : memberList) {
                System.out.println(member);
            }
        }

    }
    public ArrayList<Member> getMemberList(){
        return memberList;
    }
}
