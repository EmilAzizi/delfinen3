package data;

import domain.Member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {

    private final File f;

    private Member loadMember;

    Database database;
    public Filehandler(String fileName, Database database){
        f = new File(fileName);
        this.database = database;
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
                            member.getActivityForm() + " , " + member.getHasPaid();
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
            boolean hasPaid = Boolean.parseBoolean(attributes[10]);

            switch(activity){
                case "competing" -> {
                    loadMember = new Member(name, phoneNumber, email, activity, swimmingTime, address, activityForm, day, month, year);
                    loadMember.setHasPaid(hasPaid);
                }
                default -> {
                    loadMember = new Member(name, phoneNumber, email, activity, address, day, month, year);
                    loadMember.setHasPaid(hasPaid);
                }
            }

            members.add(loadMember);
        }
        sc.close();
        return members;
    }

    public void changeMember() throws IOException{

        ArrayList<Member> membersToEdit = database.getMemberList();

        new FileOutputStream(f).close();

        PrintStream output = new PrintStream(f);
        for (Member member : membersToEdit) {
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
                            member.getActivityForm() + " , " + member.getHasPaid();
            output.println(line);
        }
        output.close();
    }
}