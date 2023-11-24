import member.Member;

import java.io.File;
import java.io.FileNotFoundException;
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
                            member.getAge() + " , " +
                            member.getPhoneNumber() + " , " +
                            member.getEmail() + " , " +
                            member.getActivity() + " , " +
                            member.getAdress() + " , " +
                            member.getSwimmingTime();
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
            int age = Integer.parseInt(attributes[1]);
            int phoneNumber  = Integer.parseInt(attributes[2]);
            String email = attributes[3];
            String activity = attributes[4];
            String address = attributes[5];
            double swimmingTime = Double.parseDouble(attributes[6]);

            switch(activity){
                case "competing" -> loadMember = new Member(age, name, phoneNumber, email, activity, swimmingTime, address);
                default -> loadMember = new Member(age, name, phoneNumber, email, activity, address);
            }

            members.add(loadMember);
        }
        sc.close();
        return members;
    }
}