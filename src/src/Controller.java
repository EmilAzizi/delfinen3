import member.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class Controller {
    boolean isRunning = true;
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    Chairman chairman = new Chairman();
    UserInterface UI = new UserInterface(this);


    public void run() {
        System.out.println("Welcome to delfinen.");
        while(isRunning) {
            System.out.println("""
                Would you like to:
                1. Add a new member?
                2. Display existing members?
                3. Sort existing members?
                4. Display competing members with their trainer?
                5. Display top swimmers?
                0. Exit program.""");

            running();
        }
    }

    private void running() {
        try {
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    chairman.createMemberList();
                }
                case 2 -> display();
                case 3 -> System.out.println("blih");
                case 4 -> System.out.println("blah");
                case 5 -> System.out.println("bluh");
                case 0 -> isRunning = false;
            }
        } catch (IOException e){
            e.getMessage();
        }
    }

    public void display(){
        for(Member member : getMemberList()){
            UI.printMembers(member.getName(), member.getAge(), member.getAdress(), member.getPhoneNumber(), member.getEmail(),  member.getActivity(),  member.getSwimmingTime());

        }
    }

    public ArrayList<Member> getMemberList(){
        return chairman.getMemberList();
    }

}

