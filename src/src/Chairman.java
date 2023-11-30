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

        System.out.println("Activity" +
                "You can choose the following:" +
                "1. Competing." +
                "2. Motionist.");
        int activityChoice = input.nextInt();
        String activity = null;
        switch(activityChoice){
            case 1 -> activity = "competing";
            case 2 -> activity = "motionist";
        }

        switch(activity){
            case "competing" -> {
                System.out.println("What discipline are they currently active in?" +
                        "You can only choose the following disciplines:" +
                        "1. Butterfly." +
                        "2. Crawl." +
                        "3. Rygcrawl" +
                        "4. Brystsvømning.");
                int formChoice = input.nextInt();
                String activityForm = null;
                switch(formChoice){
                    case 1 -> activityForm = "butterfly";
                    case 2 -> activityForm = "crawl";
                    case 3 -> activityForm = "rygcrawl";
                    case 4 -> activityForm = "brystsvømning";
                }

                System.out.println("What is their best swimming time?");
                Double swimmingTime = input.nextDouble();
                member = new Member(age, name, number, email, activity, swimmingTime, address, activityForm);
                member.setIsCompeting();
            }
            default -> member = new Member(age, name, number, email, activity, address);
        }
        return member;
    }

    public void createMemberList() throws IOException {
        memberList.add(createMember());
        FH.savePersonToCSV(memberList);
    }

    public void addMembersToMembersList() throws IOException{
        for(Member member : FH.loadMembers()){
            memberList.add(member);
        }
    }

    public ArrayList<Member> getMemberList(){
        return memberList;
    }
    public int giveScanner(){
        Scanner choice = new Scanner(System.in);
        return choice.nextInt();
    }
}