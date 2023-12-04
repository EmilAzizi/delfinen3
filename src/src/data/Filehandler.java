package data;

import domain.Member;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    private final File f;

    private Member loadMember;

    public Filehandler(String fileName){
        f = new File(fileName);
    }

    public void savePersonToCSV(ArrayList<Member> memberList) throws IOException {
        PrintStream output = new PrintStream(f);
        for (Member member : memberList) {
            String line =
                    member.getName() + " , " +
                            member.getDay() + " , " +
                            member.getMonth() + " , " +
                            member.getYear() + " , " +
                            member.getPhoneNumber() + " , " +
                            member.getEmail() + " , " +
                            member.getActivity() + " , " +
                            member.getAdress() + " , " +
                            member.getSwimmingTime() + " , " +
                            member.getActivityForm();
            output.println(line);
        }
        output.close();
    }

    public ArrayList<Member> loadMembers() throws IOException {
        ArrayList<Member> members = new ArrayList<>();
        Scanner sc = new Scanner(f);

        while(sc.hasNextLine()){
            String line = sc.nextLine();

            String[] attributes = line.split(" , ");

            String name = attributes[0];
            int day = Integer.parseInt(attributes[1]);
            int month = Integer.parseInt(attributes[2]);
            int year = Integer.parseInt(attributes[3]);
            int phoneNumber  = Integer.parseInt(attributes[4]);
            String email = attributes[5];
            String activity = attributes[6];
            String address = attributes[7];
            double swimmingTime = Double.parseDouble(attributes[8]);
            String activityForm = attributes[9];

            switch(activity){
                case "competing" -> loadMember = new Member(name, phoneNumber, email, activity, swimmingTime, address, activityForm, day, month, year);
                default -> loadMember = new Member(name, phoneNumber, email, activity, address, day, month, year);
            }

            members.add(loadMember);
        }
        sc.close();
        return members;
    }
}